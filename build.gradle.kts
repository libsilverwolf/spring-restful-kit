plugins {
    id("java")
}

group = "io.github.libsilverwolf"
version = "1.0-SNAPSHOT"

subprojects {
    val libs = rootProject.libs

    repositories {
        mavenCentral()
    }

    apply {
        plugin("java")
        libs.plugins.springDependencyManagement
        libs.plugins.springBoot
    }

    dependencies {
        // lombok support for java
        // https://projectlombok.org/setup/gradle

        compileOnly(libs.lombok)
        annotationProcessor(libs.lombok)
        testCompileOnly(libs.lombok)
        testAnnotationProcessor(libs.lombok)

        // spring essentials

        // spring boot (bom)
        implementation(platform(libs.springBootDependencies))
    }

}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}