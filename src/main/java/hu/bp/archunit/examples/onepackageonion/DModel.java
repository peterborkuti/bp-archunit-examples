package hu.bp.archunit.examples.onepackageonion;

import lombok.Value;

@Value
class DModel {
    Integer id;
    String value;

    public DModel(Integer id, String value) {
        this.id = id;
        this.value = value;
        validate();
    }

    public DModel businessLogic() {
        return this;
    }

    private void validate() {
        //throw new IllegalArgumentException();
    }
}
