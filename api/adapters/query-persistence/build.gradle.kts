dependencies {
    implementation(project(":common"))
    implementation(project(":query:application-service"))
    implementation(project(":query:domain"))
    implementation(libs.spring.boot.starter.webflux)
    implementation(libs.spring.boot.starter.validation)
    implementation(libs.spring.boot.starter.data.r2dbc)
    implementation(libs.r2dbc.mysql)
}