package com.kakade.vedant.TravelBuddy.service;

import com.kakade.vedant.TravelBuddy.exception.IdModificationException;
import com.kakade.vedant.TravelBuddy.exception.ItemNotFoundException;
import com.kakade.vedant.TravelBuddy.models.DBEntity.RouteEntity;
import com.kakade.vedant.TravelBuddy.models.DBEntity.StopEntity;
import com.kakade.vedant.TravelBuddy.models.RequestEntity.RouteRequest;
import com.kakade.vedant.TravelBuddy.models.RequestEntity.StopRequest;
import com.kakade.vedant.TravelBuddy.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    @Autowired
    RouteRepository repository;

    @Autowired
    StopService stopService;

    public RouteEntity createRoute(RouteRequest requestRoute) throws IdModificationException, ItemNotFoundException {
        RouteEntity routeEntity = new RouteEntity();

        routeEntity.setId(requestRoute.getId());
        routeEntity.setName(requestRoute.getName());
        routeEntity.setDescription(requestRoute.getDescription());
        routeEntity.setRouteUrl(requestRoute.getRouteUrl());
        routeEntity.setCompleted(requestRoute.isCompleted());

        try {
            for (StopRequest stop : requestRoute.getStops()) {
                StopEntity stopEntity = stopService.saveStop(stop);

                routeEntity.getStopsId().add(stopEntity.getId());
            }
        } catch (IdModificationException idModificationException) {
            for (String stop : routeEntity.getStopsId()) {
                stopService.deleteStop(stop);
            }
            throw idModificationException;
        }

        repository.save(routeEntity);

        return routeEntity;
    }

    public List<RouteEntity> getAllRoutes() {
        return repository.findAll();
    }

    public RouteEntity findRoute(String id) {
        return repository.findById(id).orElse(null);
    }

    public RouteEntity getRoute(String id) throws ItemNotFoundException {
        RouteEntity routeEntity = findRoute(id);

        if (routeEntity == null) {
            throw new ItemNotFoundException("Route");
        }

        return routeEntity;
    }

    public RouteEntity updateRoute(RouteRequest routeRequest) throws IdModificationException, ItemNotFoundException {
        RouteEntity routeEntity = getRoute(routeRequest.getId());

        routeEntity.setName(routeRequest.getName());
        routeEntity.setRouteUrl(routeRequest.getRouteUrl());
        routeEntity.setDescription(routeRequest.getDescription());
        routeEntity.setCompleted(routeRequest.isCompleted());

        try {
            for (StopRequest stop : routeRequest.getStops()) {
                StopEntity stopEntity = stopService.saveStop(stop);

                routeEntity.getStopsId().add(stopEntity.getId());
            }
        } catch (IdModificationException idModificationException) {
            for (String stop : routeEntity.getStopsId()) {
                stopService.deleteStop(stop);
            }
            throw idModificationException;
        }

        repository.save(routeEntity);

        return routeEntity;
    }

    public void deleteRoute(RouteRequest routeRequest) throws ItemNotFoundException {
        RouteEntity routeEntity = getRoute(routeRequest.getId());

        for (String stopId : routeEntity.getStopsId()) {
            stopService.deleteStop(stopId);
        }

        repository.deleteById(routeRequest.getId());
    }
}
