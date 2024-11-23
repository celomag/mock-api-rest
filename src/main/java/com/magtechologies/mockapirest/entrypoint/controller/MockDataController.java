package com.magtechologies.mockapirest.entrypoint.controller;

import com.magtechologies.mockapirest.core.domain.MockData;
import com.magtechologies.mockapirest.core.usecase.CreateMockDataUseCase;
import com.magtechologies.mockapirest.core.usecase.DeleteMockDataUseCase;
import com.magtechologies.mockapirest.core.usecase.GetMockDataUseCase;
import com.magtechologies.mockapirest.core.usecase.UpdateMockDataUseCase;
import com.magtechologies.mockapirest.entrypoint.dto.MockDataRequest;
import com.magtechologies.mockapirest.entrypoint.dto.MockDataResponse;
import com.magtechologies.mockapirest.entrypoint.mapper.MockDataDtoMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/mock-data")
@RequiredArgsConstructor
@Tag(name = "Mock Data", description = "Mock Data API endpoints")
public class MockDataController {

    private final CreateMockDataUseCase createMockDataUseCase;
    private final GetMockDataUseCase getMockDataUseCase;
    private final UpdateMockDataUseCase updateMockDataUseCase;
    private final DeleteMockDataUseCase deleteMockDataUseCase;
    private final MockDataDtoMapper mapper;

    @PostMapping
    @Operation(summary = "Create mock data", description = "Creates a new mock data entry")
    @ApiResponse(responseCode = "201", description = "Mock data created successfully")
    public ResponseEntity<MockDataResponse> createMockData(@Valid @RequestBody MockDataRequest request) {
        MockData domain = mapper.toDomain(request);
        MockData created = createMockDataUseCase.execute(domain);
        return new ResponseEntity<>(mapper.toResponse(created), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get mock data by ID", description = "Retrieves mock data by its ID")
    @ApiResponse(responseCode = "200", description = "Mock data retrieved successfully")
    @ApiResponse(responseCode = "404", description = "Mock data not found")
    public ResponseEntity<MockDataResponse> getMockData(
            @Parameter(description = "Mock data ID") @PathVariable Long id) {
        return getMockDataUseCase.getById(id)
                .map(mockData -> ResponseEntity.ok(mapper.toResponse(mockData)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "List all mock data", description = "Retrieves all mock data entries")
    @ApiResponse(responseCode = "200", description = "Mock data list retrieved successfully")
    public ResponseEntity<List<MockDataResponse>> getAllMockData() {
        List<MockDataResponse> responses = getMockDataUseCase.getAll().stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update mock data", description = "Updates an existing mock data entry")
    @ApiResponse(responseCode = "200", description = "Mock data updated successfully")
    @ApiResponse(responseCode = "404", description = "Mock data not found")
    public ResponseEntity<MockDataResponse> updateMockData(
            @Parameter(description = "Mock data ID") @PathVariable Long id,
            @Valid @RequestBody MockDataRequest request) {
        return getMockDataUseCase.getById(id)
                .map(existing -> {
                    MockData domain = mapper.toDomain(request);
                    domain.setId(id);
                    MockData updated = updateMockDataUseCase.execute(domain);
                    return ResponseEntity.ok(mapper.toResponse(updated));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete mock data", description = "Deletes a mock data entry")
    @ApiResponse(responseCode = "204", description = "Mock data deleted successfully")
    public ResponseEntity<Void> deleteMockData(
            @Parameter(description = "Mock data ID") @PathVariable Long id) {
        deleteMockDataUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }
}