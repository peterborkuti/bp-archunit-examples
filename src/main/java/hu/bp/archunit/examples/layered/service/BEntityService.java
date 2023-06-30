package hu.bp.archunit.examples.layered.service;

import hu.bp.archunit.examples.layered.persistence.BEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BEntityService {
    private final BEntityRepository repository;
}
