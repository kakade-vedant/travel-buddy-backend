package com.kakade.vedant.TravelBuddy.models.DBEntity;

import com.kakade.vedant.TravelBuddy.exception.IdModificationException;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class RouteEntity {

    @Setter(AccessLevel.NONE)
    @Id
    String id;

    @NotNull
    String name;

    @Nullable
    String description;

    @Setter(AccessLevel.NONE)
    List<String> stopsId = new ArrayList<>();

    boolean completed = false;

    String routeUrl;

    public void setId(String id) throws IdModificationException {
        if (this.id == null) {
            this.id = id;
        } else {
            throw new IdModificationException();
        }
    }
}
