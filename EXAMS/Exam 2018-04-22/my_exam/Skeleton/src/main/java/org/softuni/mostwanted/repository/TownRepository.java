package org.softuni.mostwanted.repository;

import org.softuni.mostwanted.domain.entities.Town;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownRepository extends CrudRepository<Town, Integer> {

    Town findFirstByName(String name);
}
