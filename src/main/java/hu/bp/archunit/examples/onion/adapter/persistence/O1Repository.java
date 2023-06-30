package hu.bp.archunit.examples.onion.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

interface O1Repository extends JpaRepository<O1Repository, Integer> {
}
