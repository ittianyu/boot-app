pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}
rootProject.name = "boot-app-server-spring-cloud"

include("common", "discover", "config", "gateway", "account", "account-api", "dashboard", "dashboard-api")
