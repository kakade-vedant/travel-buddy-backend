package com.kakade.vedant.TravelBuddy.service;

import com.kakade.vedant.TravelBuddy.exception.IdModificationException;
import com.kakade.vedant.TravelBuddy.exception.ItemNotFoundException;
import com.kakade.vedant.TravelBuddy.models.DBEntity.RouteEntity;
import com.kakade.vedant.TravelBuddy.models.DBEntity.StopEntity;
import com.kakade.vedant.TravelBuddy.models.MetaData.RouteMetaData;
import com.kakade.vedant.TravelBuddy.models.RequestResponse.Route;
import com.kakade.vedant.TravelBuddy.models.RequestResponse.Stop;
import com.kakade.vedant.TravelBuddy.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
public class RouteService {
    @Autowired
    RouteRepository routeRepository;

    @Autowired
    StopService stopService;

    @Autowired
    UtilitiesService utilitiesService;

    public RouteEntity createRoute(Route requestRoute) throws IdModificationException, ItemNotFoundException {
        RouteEntity routeEntity = new RouteEntity();

        routeEntity.setId(utilitiesService.generateUUID().toString());
        routeEntity.setName(requestRoute.getName());
        routeEntity.setDescription(requestRoute.getDescription());
        routeEntity.setRouteUrl(requestRoute.getRouteUrl());
        routeEntity.setCompleted(requestRoute.isCompleted());

        if (!requestRoute.getStops().isEmpty()) {
            try {
                for (Stop stop : requestRoute.getStops()) {
                    StopEntity stopEntity = stopService.saveStop(stop);

                    routeEntity.getStopsId().add(stopEntity.getId());
                }
            } catch (IdModificationException idModificationException) {
                for (String stop : routeEntity.getStopsId()) {
                    stopService.deleteStop(stop);
                }
                throw idModificationException;
            }
        }

        routeRepository.save(routeEntity);

        return routeEntity;
    }

    public List<RouteEntity> getAllRoutes() {
        return routeRepository.findAll();
    }

    public List<RouteMetaData> getAllRoutesMetaData() {
        return getAllRoutes().stream().map(route -> {
            RouteMetaData metaData = new RouteMetaData();

            metaData.setId(route.getId());
            metaData.setName(route.getName());
            metaData.setDescription(route.getDescription());
            metaData.setCompleted(route.isCompleted());

            return metaData;
        }).toList();
    }

    public RouteEntity findRoute(String id) {
        return routeRepository.findById(id).orElse(null);
    }

    public RouteEntity getRoute(String id) throws ItemNotFoundException {
        RouteEntity routeEntity = findRoute(id);

        if (routeEntity == null) {
            throw new ItemNotFoundException("Route");
        }

        return routeEntity;
    }

    public RouteEntity updateRoute(Route route) throws IdModificationException, ItemNotFoundException {
        RouteEntity routeEntity = getRoute(route.getId());

        routeEntity.setName(route.getName());
        routeEntity.setRouteUrl(route.getRouteUrl());
        routeEntity.setDescription(route.getDescription());
        routeEntity.setCompleted(route.isCompleted());

        try {
            for (Stop stop : route.getStops()) {
                StopEntity stopEntity = stopService.saveStop(stop);

                routeEntity.getStopsId().add(stopEntity.getId());
            }
        } catch (IdModificationException idModificationException) {
            for (String stop : routeEntity.getStopsId()) {
                stopService.deleteStop(stop);
            }
            throw idModificationException;
        }

        routeRepository.save(routeEntity);

        return routeEntity;
    }

    public void deleteRoute(Route route) throws ItemNotFoundException {
        RouteEntity routeEntity = getRoute(route.getId());

        for (String stopId : routeEntity.getStopsId()) {
            stopService.deleteStop(stopId);
        }

        routeRepository.deleteById(route.getId());
    }

    public URI getURI(RouteEntity routeEntity) {
        String location = "/route/" + routeEntity;

        return URI.create(location);
    }
}
