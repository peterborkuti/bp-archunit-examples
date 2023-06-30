package hu.bp.archunit.examples.onion.domain.service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class O1UseCase {
    private final O1UseCaseDBOutputPort dbOutputPort;

}
