package hu.bp.archunit.examples.layered.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class AEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String value2;
}
