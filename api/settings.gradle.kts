rootProject.name = "api"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

include("application")
include("common")
include("page-meta:application-service")
include("adapters:page-meta-web")
include("adapters:page-meta-internal")
include("query:application-service")
include("adapters:query-persistence")
include("query:domain")
