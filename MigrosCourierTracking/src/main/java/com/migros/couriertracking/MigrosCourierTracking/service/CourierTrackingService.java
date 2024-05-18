package com.migros.couriertracking.MigrosCourierTracking.service;

import com.migros.couriertracking.MigrosCourierTracking.entity.CourierLocation;
import com.migros.couriertracking.MigrosCourierTracking.mapper.CourierLocationMapper;
import com.migros.couriertracking.MigrosCourierTracking.model.CourierLocationDTO;
import com.migros.couriertracking.MigrosCourierTracking.repository.CourierLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourierTrackingService {

    @Autowired
    private CourierLocationRepository repository;

    public void saveCourierLocation(CourierLocationDTO dto) {
        CourierLocation courierLocation = CourierLocationMapper.INSTANCE.toEntity(dto);
        repository.save(courierLocation);
    }

    public Double getTotalTravelDistance(String courierId) {
        List<CourierLocation> locations = repository.findByCourierIdOrderByTimestampAsc(courierId);
        if (locations.isEmpty()) {
            return 0.0;
        }

        double totalDistance = 0.0;
        CourierLocation previousLocation = null;

        for (CourierLocation location : locations) {
            if (previousLocation != null) {
                totalDistance += calculateDistance(previousLocation, location);
            }
            previousLocation = location;
        }

        return totalDistance;
    }

    private double calculateDistance(CourierLocation loc1, CourierLocation loc2) {
        double lat1 = Math.toRadians(loc1.getLatitude());
        double lon1 = Math.toRadians(loc1.getLongitude());
        double lat2 = Math.toRadians(loc2.getLatitude());
        double lon2 = Math.toRadians(loc2.getLongitude());

        double earthRadius = 6371e3; // earth radius in meters
        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return earthRadius * c; // distance in meters
    }
}
