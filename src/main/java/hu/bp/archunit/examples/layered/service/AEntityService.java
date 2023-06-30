package hu.bp.archunit.examples.layered.service;

import hu.bp.archunit.examples.layered.persistence.AEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AEntityService {
    private final AEntityRepository repository;
}
