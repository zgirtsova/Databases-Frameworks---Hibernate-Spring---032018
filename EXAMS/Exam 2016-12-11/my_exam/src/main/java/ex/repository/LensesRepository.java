package ex.repository;

import ex.model.entities.Lens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface LensesRepository extends JpaRepository<Lens, Long> {
    Set<Lens> findByIdIn(List<Long> ids);
}
