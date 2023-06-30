package hu.bp.archunit.examples.onion.adapter.rest;

import hu.bp.archunit.examples.onion.domain.service.O1UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("o1")
@RequiredArgsConstructor
class O1Controller {
    private final O1UseCase o1UseCase;
}
