package com.magtechologies.mockapirest.entrypoint.dto;

import lombok.Data;

@Data
public class MockDataResponse {
    private Long id;
    private String name;
    private String description;
    private String value;
}