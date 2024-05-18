package com.migros.couriertracking.MigrosCourierTracking.api;

import com.migros.couriertracking.MigrosCourierTracking.model.CourierLocationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/couriers")
public interface CourierTrackingApi {

    @PostMapping("/locations")
    ResponseEntity<Void> saveCourierLocation(@RequestBody CourierLocationDTO courierLocationDTO);

    @GetMapping("/{courierId}/total-distance")
    ResponseEntity<Double> getTotalTravelDistance(@PathVariable String courierId);
}
