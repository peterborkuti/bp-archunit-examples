package hu.bp.archunit.examples.onepackageonion;

import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("d1")
@RequiredArgsConstructor
class D1Controller {
    private final D1UseCase d1UseCase;

    @GetMapping
    DDto doSomeBusinessStuff(String value) {
        return DDto.from(d1UseCase.doSomethingImportant(value));
    }

}

@Value
class DDto {
    Integer id;
    String value;

    public static DDto from(DModel model) {
        return new DDto(model.getId(), model.getValue());
    }

    public DModel to() {
        return new DModel(id, value);
    }
}
