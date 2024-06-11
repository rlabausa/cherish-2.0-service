package com.rlabausa.cherishservice.locations.repositories;

import com.rlabausa.cherishservice.locations.models.Location;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

public class LocationRepositoryCustomImpl implements LocationRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Location> findLocationsNearLatLong(BigDecimal latitude, BigDecimal longitude) {
        var results = entityManager
                .createStoredProcedureQuery("cherish.GET_LOCATION_BY_DISTANCE_FROM_LAT_LONG")
                .registerStoredProcedureParameter("lat", BigDecimal.class, ParameterMode.IN)
                .registerStoredProcedureParameter("long", BigDecimal.class, ParameterMode.IN)
                .setParameter("lat", latitude)
                .setParameter("long", longitude)
                .getResultList();

        return null;
    }
}
