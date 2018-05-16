package ex.repository;

import ex.model.entities.Accessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessoriesRepository extends JpaRepository<Accessory, Long> {
}
