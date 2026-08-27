package com.kakade.vedant.TravelBuddy.service;

import com.kakade.vedant.TravelBuddy.exception.IdModificationException;
import com.kakade.vedant.TravelBuddy.exception.ItemNotFoundException;
import com.kakade.vedant.TravelBuddy.models.DBEntity.LocationEntity;
import com.kakade.vedant.TravelBuddy.models.RequestEntity.LocationRequest;
import com.kakade.vedant.TravelBuddy.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    LocationRepository repository;

    @Autowired
    UtilitiesService utilitiesService;

    public LocationEntity saveLocation(LocationRequest request) throws IdModificationException {
        LocationEntity locationEntity = new LocationEntity();

        locationEntity.setId(utilitiesService.generateUUID().toString());
        locationEntity.setLatitude(request.getLatitude());
        locationEntity.setLatitude(request.getLatitude());

        repository.save(locationEntity);

        return locationEntity;
    }

    public List<LocationEntity> getAllLocation() {
        return repository.findAll();
    }

    public LocationEntity getLocation(String id) throws ItemNotFoundException {
        LocationEntity location = findLocation(id);

        if (location == null) {
            throw new ItemNotFoundException();
        }

        return location;
    }

    public LocationEntity findLocation(String id) {
        return repository.findById(id).orElse(null);
    }
}
