package hu.bp.archunit.examples.onepackageonion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Optional;

@Service
@RequiredArgsConstructor
class DBService implements D1DBOutputPort {
    private final DEntityRepository repository;
    @Override
    public DModel save(DModel model) {
        return repository.save(DEntity.from(model)).to();
    }

    @Override
    public Optional<DModel> load(Integer id) {
        return repository.findById(id).map(DEntity::to);
    }
}

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
class DEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String someValue;

    public DModel to() {
        return new DModel(id, someValue);
    }

    public static DEntity from(DModel model) {
        return new DEntity(model.getId(), model.getValue());
    }
}

interface DEntityRepository extends JpaRepository<DEntity, Integer> {
}

