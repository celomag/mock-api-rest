package com.magtechologies.mockapirest.core.usecase;

import com.magtechologies.mockapirest.core.domain.MockData;
import com.magtechologies.mockapirest.core.ports.MockDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdateMockDataUseCase {

    private final MockDataRepository repository;

    public MockData execute(MockData mockData) {
        return repository.save(mockData);
    }
}