package org.windsurfers.service.dto;

import lombok.Data;

import java.util.Map;
@Data
public class LocationResponse {
    private String city_name;
    private String country_code;
    private Map<Object, Object> data;
}
