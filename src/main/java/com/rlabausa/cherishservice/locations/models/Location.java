package com.rlabausa.cherishservice.locations.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "LOCATION")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal latitude;

    private BigDecimal longitude;

    @Column(name = "location_name")
    private String locationName;

    public Location() {
    }


    public Location(Long id, BigDecimal latitude, BigDecimal longitude, String locationName) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationName = locationName;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
