package com.migros.couriertracking.MigrosCourierTracking.repository;

import com.migros.couriertracking.MigrosCourierTracking.entity.CourierLocation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class CourierLocationRepositoryTest {

    @Autowired
    private CourierLocationRepository courierLocationRepository;

    @Test
    void testFindByCourierIdOrderByTimestampAsc() {
        CourierLocation loc1 = new CourierLocation(null, "courier1", 40.0, 29.0, null);
        CourierLocation loc2 = new CourierLocation(null, "courier1", 40.1, 29.1, null);
        courierLocationRepository.save(loc1);
        courierLocationRepository.save(loc2);

        List<CourierLocation> locations = courierLocationRepository.findByCourierIdOrderByTimestampAsc("courier1");
        assertEquals(2, locations.size());
        assertEquals(loc1.getLatitude(), locations.get(0).getLatitude());
        assertEquals(loc2.getLatitude(), locations.get(1).getLatitude());
    }

}
