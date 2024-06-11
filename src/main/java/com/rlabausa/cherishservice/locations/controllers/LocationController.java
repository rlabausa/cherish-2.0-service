package com.rlabausa.cherishservice.locations.controllers;

import com.rlabausa.cherishservice.locations.models.Location;
import com.rlabausa.cherishservice.locations.models.LocationRequestParam;
import com.rlabausa.cherishservice.locations.services.LocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {
    private LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }


    @GetMapping
    public Location getLocationByLatLong(final LocationRequestParam param) {
        return locationService.getLocationByLatLong(
                param.getLatitude(),
                param.getLongitude()
        );
    }

    @GetMapping("/nearest")
    public Collection<Location> getLocationNearLatLong(final LocationRequestParam param) {
        return locationService.getLocationNearLatLong(
                param.getLatitude(),
                param.getLongitude()
        );
    }
}
