package hu.bp.archunit.examples.onepackagelayered;

import org.springframework.data.jpa.repository.JpaRepository;

interface CEntityRepository extends JpaRepository<CEntity, Integer> {
}
