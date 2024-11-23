package com.magtechologies.mockapirest.entrypoint.mapper;

import com.magtechologies.mockapirest.core.domain.MockData;
import com.magtechologies.mockapirest.entrypoint.dto.MockDataRequest;
import com.magtechologies.mockapirest.entrypoint.dto.MockDataResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MockDataDtoMapper {
    MockData toDomain(MockDataRequest request);
    MockDataResponse toResponse(MockData domain);
}