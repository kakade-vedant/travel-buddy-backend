package com.kakade.vedant.TravelBuddy.service;

import com.kakade.vedant.TravelBuddy.exception.IdModificationException;
import com.kakade.vedant.TravelBuddy.exception.ItemNotFoundException;
import com.kakade.vedant.TravelBuddy.models.DBEntity.LocationEntity;
import com.kakade.vedant.TravelBuddy.models.RequestResponse.Location;
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

    public LocationEntity saveLocation(Location request) throws IdModificationException {
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
            throw new ItemNotFoundException("Location");
        }

        return location;
    }

    public LocationEntity findLocation(String id) {
        return repository.findById(id).orElse(null);
    }

    public LocationEntity updateLocation(Location request) throws ItemNotFoundException {
        LocationEntity savedLocation = getLocation(request.getId());

        savedLocation.setLatitude(request.getLatitude());
        savedLocation.setLongitude(request.getLongitude());

        repository.save(savedLocation);

        return savedLocation;
    }

    public void deleteLocation(LocationEntity location) {
        repository.deleteById(location.getId());

    }

    public void deleteLocation(String id) throws ItemNotFoundException{
        LocationEntity savedLocation = getLocation(id);
        deleteLocation(savedLocation);
    }
}
