package org.softuni.mostwanted.repository;

import org.softuni.mostwanted.domain.entities.RaceEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceEntryRepository extends JpaRepository<RaceEntry, Integer> {

    RaceEntry findFirstById(int id);
}
