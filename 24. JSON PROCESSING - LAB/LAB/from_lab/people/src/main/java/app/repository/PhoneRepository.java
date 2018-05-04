package app.repository;

import app.domain.model.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<PhoneNumber, Long> {
}
