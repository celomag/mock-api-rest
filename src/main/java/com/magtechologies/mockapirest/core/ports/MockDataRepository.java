package com.magtechologies.mockapirest.core.ports;

import com.magtechologies.mockapirest.core.domain.MockData;

import java.util.List;
import java.util.Optional;


public interface MockDataRepository {
    MockData save(MockData mockData);
    Optional<MockData> findById(Long id);
    List<MockData> findAll();
    void deleteById(Long id);
}