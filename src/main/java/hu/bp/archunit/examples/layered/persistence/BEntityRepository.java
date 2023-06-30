package hu.bp.archunit.examples.layered.persistence;

import hu.bp.archunit.examples.layered.entities.BEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BEntityRepository extends JpaRepository<BEntity, Integer> {
}
