package com.magtechologies.mockapirest.infrastructure.persistence.mapper;

import com.magtechologies.mockapirest.core.domain.MockData;
import com.magtechologies.mockapirest.infrastructure.persistence.entity.MockDataEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MockDataMapper {
    MockDataEntity toEntity(MockData domain);
    MockData toDomain(MockDataEntity entity);
}
