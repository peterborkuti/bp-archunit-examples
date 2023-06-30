package hu.bp.archunit.examples.layered.persistence;

import hu.bp.archunit.examples.layered.entities.AEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AEntityRepository extends JpaRepository<AEntity, Integer> {
}
