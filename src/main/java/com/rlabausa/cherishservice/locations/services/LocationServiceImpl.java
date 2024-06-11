package com.rlabausa.cherishservice.locations.services;

import com.rlabausa.cherishservice.locations.models.Location;
import com.rlabausa.cherishservice.locations.repositories.LocationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Collection;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }


    @Override
    public Location getLocationByLatLong(BigDecimal latitude, BigDecimal longitude) {
        return locationRepository.findByLatitudeAndLongitude(latitude, longitude);
    }

    @Override
    @Transactional
    public Collection<Location> getLocationNearLatLong(BigDecimal latitude, BigDecimal longitude) {
        return locationRepository.findLocationsNearLatitudeAndLongitude(latitude, longitude);
    }
}
