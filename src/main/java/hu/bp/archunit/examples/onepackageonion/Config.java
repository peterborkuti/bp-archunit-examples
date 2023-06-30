package hu.bp.archunit.examples.onepackageonion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class Config {
    @Bean
    D1UseCase getD1UseCase(D1DBOutputPort port) {
        return new D1UseCase(port);
    }
}
