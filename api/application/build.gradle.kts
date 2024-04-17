dependencies {
    implementation(libs.spring.boot.starter.webflux)
    implementation(libs.spring.boot.starter.actuator)
    implementation(libs.micrometer.registry.prometheus)
    implementation(project(":common"))
    implementation(project(":adapters:page-meta-web"))
    implementation(project(":adapters:query-persistence"))
}