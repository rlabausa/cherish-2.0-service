package com.rlabausa.cherishservice.locations.models;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

public class LocationRequestParam {
    private BigDecimal latitude;
    private BigDecimal longitude;

    public LocationRequestParam(BigDecimal latitude, BigDecimal longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
}
