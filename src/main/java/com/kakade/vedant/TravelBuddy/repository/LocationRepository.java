package com.kakade.vedant.TravelBuddy.repository;

import com.kakade.vedant.TravelBuddy.models.DBEntity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<LocationEntity, String> {

}
