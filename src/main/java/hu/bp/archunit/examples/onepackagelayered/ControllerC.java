package hu.bp.archunit.examples.onepackagelayered;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("java8module")
@RequiredArgsConstructor
class ControllerC {
    private final CEntityService service;

    @GetMapping
    public CDto getC() {
        return null;
    }
}
