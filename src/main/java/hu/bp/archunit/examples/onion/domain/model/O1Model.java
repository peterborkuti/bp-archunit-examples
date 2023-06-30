package hu.bp.archunit.examples.onion.domain.model;

import lombok.Value;

@Value
public class O1Model {
    Integer id;
    String o1Value;

    public O1Model businessLogic() {
        return this;
    }
}
