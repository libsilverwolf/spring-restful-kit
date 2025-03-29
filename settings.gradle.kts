rootProject.name = "spring-restful-polyfill"

include("restful-kit-spring3x-webmvc")
include("restful-kit-spring3x-webmvc-example")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            version("springBootVersion", "3.0.0")
            version("lombokVersion", "1.18.32")
            version("springDependencyManagementVersion", "1.1.4")


            /**
             * spring-boot related
             */
            library("springBootDependencies", "org.springframework.boot", "spring-boot-dependencies")
                .versionRef("springBootVersion")

            library("springBootStarterWeb", "org.springframework.boot", "spring-boot-starter-web")
                .withoutVersion()
//            library("springBootStarterWebTest", "org.springframework.boot", "spring-boot-starter-test")
//                .withoutVersion()
            library("springBootStarterTest", "org.springframework.boot", "spring-boot-starter-test")
                .withoutVersion()

            library("lombok", "org.projectlombok", "lombok")
                .versionRef("lombokVersion")

            plugin("springBoot", "org.springframework.boot")
                .versionRef("springBootVersion")
            plugin("springDependencyManagement", "io.spring.dependency-management")
                .versionRef("springDependencyManagementVersion")
        }
    }
}


