package hu.bp.archunit.examples.onepackageonion;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
class D1UseCase {
    private final D1DBOutputPort dbOutputPort;

    public DModel doSomethingImportant(String value) {
        DModel model = new DModel(null, value).businessLogic();
        return dbOutputPort.save(model);
    }
}

interface D1DBOutputPort {
    DModel save(DModel model);
    Optional<DModel> load(Integer id);
}