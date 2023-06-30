package hu.bp.archunit.examples.onion.adapter.persistence;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
class O1Entity {
    @Id
    @GeneratedValue
    private Integer id;
    private String o1Value;
}
