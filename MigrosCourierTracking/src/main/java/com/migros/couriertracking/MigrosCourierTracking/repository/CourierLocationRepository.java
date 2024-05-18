package com.migros.couriertracking.MigrosCourierTracking.repository;

import com.migros.couriertracking.MigrosCourierTracking.entity.CourierLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourierLocationRepository extends JpaRepository<CourierLocation, Long> {

    List<CourierLocation> findByCourierIdOrderByTimestampAsc(String courierId);
}
