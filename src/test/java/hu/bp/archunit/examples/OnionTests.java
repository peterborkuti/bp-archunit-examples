package hu.bp.archunit.examples;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;

@AnalyzeClasses(packages = OnionTests.ONION)
public class OnionTests {
    public static final String ROOT = "hu.bp.archunit.examples";
    public static final String ONION = ROOT + ".onion";
    private static final String DOMAIN_MODEL = ONION + ".domain.model..";
    private static final String DOMAIN_SERVICE = ONION + ".domain.service..";
    private static final String APP_SERVICE = ONION + ".application..";
    private static final String ADAPTER = ONION + ".adapter";

    @ArchTest
    static final ArchRule layer_dependencies_are_respected = onionArchitecture()
        .domainModels(DOMAIN_MODEL)
        .domainServices(DOMAIN_SERVICE)
        .applicationServices(APP_SERVICE)
        .adapter("rest", ADAPTER + ".rest..")
        //.adapter("internal", ADAPTER + ".internal..")
        .adapter("persistence", ADAPTER + ".persistence..");
}
