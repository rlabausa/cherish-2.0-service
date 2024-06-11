package com.rlabausa.cherishservice.locations.repositories;

import com.rlabausa.cherishservice.locations.models.Location;

import java.math.BigDecimal;
import java.util.List;

public interface LocationRepositoryCustom {
    List<Location> findLocationsNearLatLong(BigDecimal latitude, BigDecimal longitude);
}
