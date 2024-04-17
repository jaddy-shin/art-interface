dependencies {
    implementation(project(":query:domain"))
    implementation(project(":common"))
    implementation(libs.spring.boot.starter.webflux)
    implementation(libs.spring.tx)
}