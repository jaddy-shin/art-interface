# Art-Interface

## Gradle 설명

### Version Catalog

[/gradle/libs.versions.toml](./gradle/libs.versions.toml) 에 version, plugin, library 를 정리할수 있습니다. 멀티 모듈을 구성할때 version catalog 를 사용하면 dependency 등을 쉽게 작성 할수 있습니다.

```toml
# gradle/libs.versions.toml

[versions]
kotlin-jvm = "1.9.23"

[plugins]
jvm = { id = "org.jetbrains.kotlin.jvm", version.ref = "kotlin-jvm" }


```

사용시 libs 로 접근할 수 있습니다.

```kotlin
// build.gradle.kts

plugins {
  alias(libs.plugins.jvm)
}
```

### Composite Build

composite build 를 사용하면 하위 모듈 전체가 include 되어 빌드됩니다. 하위 프로젝트를 독립적으로 빌드할수 있습니다. 프로젝트 에서는 api 모듈이  composite build 로 구성 되었습니다.

```
art-interface
├── README.md
├── api
│   ├── adapters
│   ├── application
│   ├── build.gradle.kts
│   ├── buildSrc
│   ├── common
│   ├── page-meta
│   ├── query
│   └── settings.gradle.kts
├── gradle
│   ├── libs.versions.toml
│   └── wrapper
├── gradlew
├── gradlew.bat
└── settings.gradle.kts

```

설정은 art-interface 의 [settings.gradle.kts](./settings.gradle.kts)에 `includeBuild` 를 추가합니다

```kotlin
// ./settings.gradle.kts
includeBuild("api")
```

### Multi-Project Builds

하위 폴더에 build.gradle.kts 를 추가하고 root project 에 `include` 를 하면 multi-project build 를 할 수 있습니다.

```
api
├── application
│   ├── build
│   ├── build.gradle.kts
│   ├── out
│   └── src
└── settings.gradle.kts
```

[api/settings.gradle.kts](./api/settings.gradle.kts) 에 `include` 를 추가해  `application` 을 subproject 로 설정했습니다.

```kotlin
// api/settings.gradle.kts
include("application")
```

### BuildSrc

BuildSrc 를 사용하면 subproject 간 빌드 로직을 공유할수 있습니다. 프로젝트에서는 api 안에 `buildSrc` 가 있어 root 에 선언된 versionCatagory 를 subProject 에도 접근 할 수 있게 설정했습니다.

```kotlin
// ./api/buildSrc/setting.gradle.kts

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../../gradle/libs.versions.toml"))
        }
    }
}
```





