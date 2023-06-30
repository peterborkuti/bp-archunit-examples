package hu.bp.archunit.examples.onepackagelayered;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CApi {
    private final CEntityService service;
    public CDto getC() {
        return null;
    }
}
