package com.migros.couriertracking.MigrosCourierTracking.controller;

import com.migros.couriertracking.MigrosCourierTracking.model.CourierLocationDTO;
import com.migros.couriertracking.MigrosCourierTracking.service.CourierTrackingService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CourierTrackingControllerTest {

    @Mock
    private CourierTrackingService courierTrackingService;

    @InjectMocks
    private CourierTrackingController courierTrackingController;

    public CourierTrackingControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveCourierLocation() {
        CourierLocationDTO dto = new CourierLocationDTO(null, "courier1", 40.0, 29.0, null);
        doNothing().when(courierTrackingService).saveCourierLocation(dto);

        ResponseEntity<Void> response = courierTrackingController.saveCourierLocation(dto);
        assertEquals(ResponseEntity.ok().build(), response);
        verify(courierTrackingService, times(1)).saveCourierLocation(dto);
    }

    @Test
    void testGetTotalTravelDistance() {
        when(courierTrackingService.getTotalTravelDistance("courier1"))
                .thenReturn(15725.33334093644);

        ResponseEntity<Double> response = courierTrackingController.getTotalTravelDistance("courier1");
        assertEquals(15725.33334093644, response.getBody());
        verify(courierTrackingService, times(1)).getTotalTravelDistance("courier1");
    }
}
