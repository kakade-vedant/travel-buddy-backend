package com.kakade.vedant.TravelBuddy.models.DBEntity;

import com.kakade.vedant.TravelBuddy.exception.IdModificationException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@Entity
public class LocationEntity {

    @Setter(AccessLevel.NONE)
    @Id
    String id;

    @NotNull
    @DecimalMin("-90.0")
    @DecimalMax("90.0")
    private double latitude;

    @NotNull
    @DecimalMin("-180.0")
    @DecimalMax("180.0")
    private double longitude;

    public void setId(String id) throws IdModificationException {
        if (this.id == null)
            this.id = id;
        else
            throw new IdModificationException();
    }

}
