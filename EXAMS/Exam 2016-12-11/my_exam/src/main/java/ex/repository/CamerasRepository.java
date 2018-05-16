package ex.repository;

import ex.model.entities.BasicCamera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CamerasRepository extends JpaRepository<BasicCamera, Long>{

    BasicCamera findFirstById(long id);
}
