package org.softuni.mostwanted.repository;


import org.softuni.mostwanted.domain.entities.Racer;
import org.softuni.mostwanted.domain.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacerRepository extends JpaRepository<Racer, Integer > {

    Racer findFirstByName(String name);
}
