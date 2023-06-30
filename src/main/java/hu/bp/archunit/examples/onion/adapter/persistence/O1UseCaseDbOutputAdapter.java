package hu.bp.archunit.examples.onion.adapter.persistence;

import hu.bp.archunit.examples.onion.domain.service.O1UseCaseDBOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class O1UseCaseDbOutputAdapter implements O1UseCaseDBOutputPort {
    private final O1Repository o1Repository;
}
