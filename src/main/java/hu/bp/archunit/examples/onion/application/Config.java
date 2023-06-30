package hu.bp.archunit.examples.onion.application;

import hu.bp.archunit.examples.onion.domain.service.O1UseCase;
import hu.bp.archunit.examples.onion.domain.service.O1UseCaseDBOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class Config {
    @Bean
    O1UseCase getO1UseCase(O1UseCaseDBOutputPort port) {
        return new O1UseCase(port);
    }
}
