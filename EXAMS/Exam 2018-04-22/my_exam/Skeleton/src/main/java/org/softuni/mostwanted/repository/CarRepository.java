package org.softuni.mostwanted.repository;

import org.softuni.mostwanted.domain.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    Car findFirstById(int id);
}
