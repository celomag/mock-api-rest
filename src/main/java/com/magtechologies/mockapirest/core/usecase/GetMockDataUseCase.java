package com.magtechologies.mockapirest.core.usecase;

import com.magtechologies.mockapirest.core.domain.MockData;
import com.magtechologies.mockapirest.core.ports.MockDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GetMockDataUseCase {

    private final MockDataRepository repository;

    public Optional<MockData> getById(Long id) {
        return repository.findById(id);
    }

    public List<MockData> getAll() {
        return repository.findAll();
    }
}