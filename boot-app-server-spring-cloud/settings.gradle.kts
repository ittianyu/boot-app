pluginManagement {
    repositories {
        gradlePluginPortal()
    }
}
rootProject.name = "boot-app-server-spring-cloud"

include("discover", "gateway", "account", "dashboard")
