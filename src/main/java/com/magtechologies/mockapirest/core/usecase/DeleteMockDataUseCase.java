package com.magtechologies.mockapirest.core.usecase;

import com.magtechologies.mockapirest.core.ports.MockDataRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteMockDataUseCase {

    private final MockDataRepository repository;

    public void execute(Long id) {
        repository.deleteById(id);
    }
}