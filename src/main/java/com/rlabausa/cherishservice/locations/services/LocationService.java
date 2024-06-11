package com.rlabausa.cherishservice.locations.services;

import com.rlabausa.cherishservice.locations.models.Location;

import java.math.BigDecimal;
import java.util.Collection;

public interface LocationService {
    public Collection<Location> getLocationNearLatLong(BigDecimal latitude, BigDecimal longitude);
    public Location getLocationByLatLong(BigDecimal latitude, BigDecimal longitude);
}
