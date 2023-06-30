package hu.bp.archunit.examples.onepackagelayered;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
class CEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String someValue;
}
