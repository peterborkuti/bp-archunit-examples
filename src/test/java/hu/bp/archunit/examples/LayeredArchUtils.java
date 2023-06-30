package hu.bp.archunit.examples;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaField;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.stream.Collectors;

public class LayeredArchUtils {
    static ArchCondition<JavaClass> useOnlyItsOwnRepository =
            new ArchCondition<JavaClass>("Repository services should use only its own repositories") {
                @Override
                public void check(JavaClass repositoryService, ConditionEvents events) {
                    String badRepositoryFields = getBadRepositoryFieldNames(repositoryService);
                    boolean ok = badRepositoryFields.isEmpty();
                    SimpleConditionEvent event =
                            new SimpleConditionEvent(repositoryService, ok, describe(repositoryService, badRepositoryFields));
                    events.add(event);
                }

                private String getBadRepositoryFieldNames(JavaClass repositoryService) {
                    String fieldType = repositoryService.getSimpleName().split("Entity", 2)[0] + "EntityRepository";
                    Set<JavaField> fields = repositoryService.getAllFields();
                    JavaField[] fieldsArr = fields.toArray(new JavaField[0]);

                    return repositoryService.getAllFields().stream()
                            .map(JavaField::getType)
                            .map(type -> ((JavaClass)type).getSimpleName())
                            .filter(name -> !fieldType.equals(name))
                            .collect(Collectors.joining(", "));
                }

                private String describe(JavaClass repositoryService, String fieldNames) {
                    return String.format("%s repository service uses foreign repositories: %s",
                            repositoryService.getSimpleName(),
                            fieldNames);
                }
            };
}
