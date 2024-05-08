package ru.edu.springdata.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link ru.edu.springdata.entity.Author} entity
 */
public record AuthorDto(String firstName, String lastName, String phone, AddressDto address) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorDto entity = (AuthorDto) o;
        return Objects.equals(this.firstName, entity.firstName) &&
                Objects.equals(this.lastName, entity.lastName) &&
                Objects.equals(this.phone, entity.phone) &&
                Objects.equals(this.address, entity.address);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "firstName = " + firstName + ", " +
                "lastName = " + lastName + ", " +
                "phone = " + phone + ", " +
                "address = " + address + ")";
    }
}