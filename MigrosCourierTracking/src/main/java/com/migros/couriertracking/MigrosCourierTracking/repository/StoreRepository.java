package com.migros.couriertracking.MigrosCourierTracking.repository;

import com.migros.couriertracking.MigrosCourierTracking.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {
}
