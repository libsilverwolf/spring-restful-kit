plugins {
    id("java")
}

group = "io.github.libsilverwolf"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.springBootStarterWeb)
    implementation(project(":polyfill-spring3x-webmvc"))
}