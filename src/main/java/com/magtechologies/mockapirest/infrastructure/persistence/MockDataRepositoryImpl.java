package com.magtechologies.mockapirest.infrastructure.persistence;

import com.magtechologies.mockapirest.core.domain.MockData;
import com.magtechologies.mockapirest.core.ports.MockDataRepository;
import com.magtechologies.mockapirest.infrastructure.persistence.mapper.MockDataMapper;
import com.magtechologies.mockapirest.infrastructure.persistence.repository.MockDataJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class MockDataRepositoryImpl implements MockDataRepository {

    private final MockDataJpaRepository jpaRepository;
    private final MockDataMapper mapper;

    @Override
    public MockData save(MockData mockData) {
        var entity = mapper.toEntity(mockData);
        var savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<MockData> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<MockData> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}