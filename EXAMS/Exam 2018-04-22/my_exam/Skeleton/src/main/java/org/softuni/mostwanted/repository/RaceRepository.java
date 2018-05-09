package org.softuni.mostwanted.repository;

import org.softuni.mostwanted.domain.entities.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepository extends JpaRepository<Race, Integer > {
    Race findFirstById(int id);
}
