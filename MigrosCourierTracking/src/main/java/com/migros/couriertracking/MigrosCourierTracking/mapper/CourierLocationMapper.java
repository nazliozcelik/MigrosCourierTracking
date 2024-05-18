package com.migros.couriertracking.MigrosCourierTracking.mapper;

import com.migros.couriertracking.MigrosCourierTracking.entity.CourierLocation;
import com.migros.couriertracking.MigrosCourierTracking.model.CourierLocationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CourierLocationMapper {

    CourierLocationMapper INSTANCE = Mappers.getMapper(CourierLocationMapper.class);

    CourierLocation toEntity(CourierLocationDTO dto);
    CourierLocationDTO toDTO(CourierLocation entity);
}
