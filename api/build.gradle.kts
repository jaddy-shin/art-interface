import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    alias(libs.plugins.jvm)
    alias(libs.plugins.plugin.spring)
    alias(libs.plugins.spring.framework.boot)
    alias(libs.plugins.spring.dependency.management)
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

allprojects {
    repositories {
        mavenCentral()
    }
}

val versionCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")


subprojects {

    group = "me.jaddy"
    version = "0.0.1-SNAPSHOT"

    // plugins 에 선언된 플러그인 모두 apply
    versionCatalog.pluginAliases.asSequence()
        .map(versionCatalog::findPlugin)
        .filter { it.isPresent }
        .map { it.get() }
        .map { it.get() }
        .map { it.pluginId }
        .forEach { apply(plugin = it) }

    dependencies {
        implementation(rootProject.libs.jackson.module.kotlin)
        implementation(rootProject.libs.reactor.kotlin.extensions)
        implementation(rootProject.libs.kotlin.relect)
        implementation(rootProject.libs.kotlinx.coroutines.reactor)
        implementation(rootProject.libs.kotlinx.coroutines.reactive)
        implementation(rootProject.libs.kotlinx.coroutines.core)
    }

    java {
        toolchain {
            languageVersion = JavaLanguageVersion.of(21)
        }

        tasks.withType<KotlinCompile> {
            kotlinOptions {
                freeCompilerArgs += "-Xjsr305=strict"
                jvmTarget = "21"
            }
        }

        tasks.withType<Test> {
            useJUnitPlatform()
        }
    }
}




