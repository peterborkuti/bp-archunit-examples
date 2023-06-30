package hu.bp.archunit.examples.onepackagelayered;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class CEntityService {
    private final CEntityRepository repository;
}
