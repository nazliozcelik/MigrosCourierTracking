package com.migros.couriertracking.MigrosCourierTracking.service;

import com.migros.couriertracking.MigrosCourierTracking.entity.CourierLocation;
import com.migros.couriertracking.MigrosCourierTracking.model.CourierLocationDTO;
import com.migros.couriertracking.MigrosCourierTracking.repository.CourierLocationRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class CourierTrackingServiceTest {

    @Mock
    private CourierLocationRepository courierLocationRepository;

    @InjectMocks
    private CourierTrackingService courierTrackingService;

    public CourierTrackingServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetTotalTravelDistance() {
        List<CourierLocation> locations = Arrays.asList(
                new CourierLocation(1L, "courier1", 40.0, 29.0, null),
                new CourierLocation(2L, "courier1", 40.1, 29.1, null)
        );

        when(courierLocationRepository.findByCourierIdOrderByTimestampAsc("courier1"))
                .thenReturn(locations);

        double distance = courierTrackingService.getTotalTravelDistance("courier1");
        assertEquals(14003.340159457022, distance, 0.1);
    }

    @Test
    void testSaveCourierLocation() {
        CourierLocationDTO dto = new CourierLocationDTO(null, "courier1", 40.0, 29.0, null);
        courierTrackingService.saveCourierLocation(dto);
    }
}
