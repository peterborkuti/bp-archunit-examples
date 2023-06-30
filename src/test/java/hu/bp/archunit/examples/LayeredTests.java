package hu.bp.archunit.examples;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
import static hu.bp.archunit.examples.LayeredArchUtils.useOnlyItsOwnRepository;

@AnalyzeClasses(packages = LayeredTests.LAYERED)
@Slf4j
public class LayeredTests {
    public static final String ROOT = "hu.bp.archunit.examples";
    public static final String LAYERED = ROOT + ".layered";
    @ArchTest
    static final ArchRule layer_dependencies_are_respected =
            layeredArchitecture().consideringAllDependencies()

                    .layer("Controllers").definedBy(LAYERED + ".controller..")
                    .layer("Services").definedBy(LAYERED + ".service..")
                    .layer("Persistence").definedBy(LAYERED + ".persistence..")

                    .whereLayer("Controllers").mayNotBeAccessedByAnyLayer()
                    .whereLayer("Services").mayOnlyBeAccessedByLayers("Controllers")
                    .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Services");

    @ArchTest
    static ArchRule services_should_be_suffixed =
            classes()
                    .that().resideInAPackage("..service..")
                    .and().areAnnotatedWith(Service.class)
                    .should().haveSimpleNameEndingWith("Service");

    @ArchTest
    static ArchRule business_services_should_not_depend_on_repositories =
            classes()
                    .that().resideInAPackage("..service..")
                    .and().areAnnotatedWith(Service.class)
                    .and().haveSimpleNameNotContaining("Entity")
                    .should().onlyDependOnClassesThat()
                    .resideOutsideOfPackage("..persistence..");

    @ArchTest
    static ArchRule entity_services_should_use_only_own_repository =
            classes()
                    .that().resideInAPackage("..service..")
                    .and().areAnnotatedWith(Service.class)
                    .and().haveSimpleNameContaining("Entity")
                    .should(useOnlyItsOwnRepository);
}
