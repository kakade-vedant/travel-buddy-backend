package com.kakade.vedant.TravelBuddy.models.DBEntity;

import com.kakade.vedant.TravelBuddy.exception.IdModificationException;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class StopEntity {

    @Setter(AccessLevel.NONE)
    @Id
    String id;

    @NotNull
    String name;

    String locationId;

    String url;

    public void setId(String id) throws IdModificationException{
        if (id == null) {
            this.id = id;
        } else {
            throw new IdModificationException();
        }
    }
}
