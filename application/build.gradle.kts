plugins {
    id("java")
}

group = "ru.vk.mistressfilth"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.eclipse.jetty:jetty-server:9.4.33.v20201020")
    implementation("org.eclipse.jetty:jetty-servlet:9.4.33.v20201020")
    implementation("org.eclipse.jetty:jetty-client:9.4.33.v20201020")

    implementation(project(":jooq-generated"))

    implementation("com.google.code.gson:gson:2.10")

}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}