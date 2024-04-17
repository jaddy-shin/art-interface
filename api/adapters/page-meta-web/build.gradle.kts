dependencies {
    implementation(project(":common"))
    implementation(project(":page-meta:application-service"))
    implementation(libs.spring.boot.starter.webflux)
    implementation(libs.spring.boot.starter.validation)
}