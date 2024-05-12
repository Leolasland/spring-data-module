package ru.edu.springdata.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link ru.edu.springdata.entity.Address} entity
 */
public record AddressDto(String city, String street) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDto entity = (AddressDto) o;
        return Objects.equals(this.city, entity.city) &&
                Objects.equals(this.street, entity.street);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "city = " + city + ", " +
                "street = " + street + ")";
    }
}