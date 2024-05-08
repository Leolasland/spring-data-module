package ru.edu.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.edu.springdata.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}