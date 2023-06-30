package hu.bp.archunit.examples.layered.controller;

import hu.bp.archunit.examples.layered.persistence.AEntityRepository;
import hu.bp.archunit.examples.layered.service.AEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("layered")
@RequiredArgsConstructor
public class ControllerA {
    private final AEntityService aEntityService;
}
