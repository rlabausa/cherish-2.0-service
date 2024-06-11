package com.rlabausa.cherishservice.locations.repositories;

import com.rlabausa.cherishservice.locations.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collection;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findByLatitudeAndLongitude(BigDecimal latitude, BigDecimal longitude);

    @Transactional
    @Procedure(procedureName = "GET_LOCATION_BY_DISTANCE_FROM_LAT_LONG")
    Collection<Location> findLocationsNearLatitudeAndLongitude(
            @Param("lat") BigDecimal latitude,
            @Param("long") BigDecimal longitude
    );
}
