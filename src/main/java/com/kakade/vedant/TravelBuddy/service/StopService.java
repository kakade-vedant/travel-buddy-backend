package com.kakade.vedant.TravelBuddy.service;

import com.kakade.vedant.TravelBuddy.exception.IdModificationException;
import com.kakade.vedant.TravelBuddy.exception.ItemNotFoundException;
import com.kakade.vedant.TravelBuddy.models.DBEntity.LocationEntity;
import com.kakade.vedant.TravelBuddy.models.DBEntity.StopEntity;
import com.kakade.vedant.TravelBuddy.models.RequestEntity.StopRequest;
import com.kakade.vedant.TravelBuddy.repository.StopRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StopService {
    @Autowired
    StopRepository stopRepository;

    @Autowired
    LocationService locationService;

    @Autowired
    UtilitiesService utilitiesService;

    public StopEntity saveStop(StopRequest request) throws IdModificationException {
        StopEntity stopEntity = new StopEntity();

        stopEntity.setId(utilitiesService.generateUUID().toString());
        stopEntity.setName(request.getName());
        stopEntity.setUrl(request.getUrl());

        LocationEntity savedLocation = locationService.saveLocation(request.getLocation());

        stopEntity.setLocationId(savedLocation.getId());

        stopRepository.save(stopEntity);

        return stopEntity;
    }

    public List<StopEntity> getAllStops() {
        return stopRepository.findAll();
    }

    public StopEntity getStop(String id) throws ItemNotFoundException {
        StopEntity stopEntity = findStop(id);

        if (stopEntity == null) {
            throw new ItemNotFoundException("Stop");
        }

        return stopEntity;
    }

    public StopEntity findStop(String id) {
        return stopRepository.findById(id).orElse(null);
    }

    public StopEntity updateStop(StopRequest request) throws ItemNotFoundException {
        StopEntity savedStop = getStop(request.getId());

        savedStop.setName(request.getName());
        savedStop.setUrl(request.getUrl());

        stopRepository.save(savedStop);

        return savedStop;
    }

    public void deleteStop(StopRequest request) throws ItemNotFoundException {
        StopEntity savedStop = getStop(request.getId());

        stopRepository.deleteById(savedStop.getId());
    }
}
