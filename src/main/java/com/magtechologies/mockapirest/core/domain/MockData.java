package com.magtechologies.mockapirest.core.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MockData {
    private Long id;
    private String name;
    private String description;
    private String value;
}
