package com.migros.couriertracking.MigrosCourierTracking.controller;

import com.migros.couriertracking.MigrosCourierTracking.api.CourierTrackingApi;
import com.migros.couriertracking.MigrosCourierTracking.model.CourierLocationDTO;
import com.migros.couriertracking.MigrosCourierTracking.service.CourierTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourierTrackingController implements CourierTrackingApi {

    @Autowired
    private CourierTrackingService service;

    @Override
    public ResponseEntity<Void> saveCourierLocation(CourierLocationDTO courierLocationDTO) {
        service.saveCourierLocation(courierLocationDTO);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Double> getTotalTravelDistance(String courierId) {
        Double totalDistance = service.getTotalTravelDistance(courierId);
        return ResponseEntity.ok(totalDistance);
    }
}
