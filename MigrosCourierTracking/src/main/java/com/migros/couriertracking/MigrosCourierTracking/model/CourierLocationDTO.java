package com.migros.couriertracking.MigrosCourierTracking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourierLocationDTO {

    private Long id;
    private String courierId;
    private Double latitude;
    private Double longitude;
    private LocalDateTime timestamp;
}
