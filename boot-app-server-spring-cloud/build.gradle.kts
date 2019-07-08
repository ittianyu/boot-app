import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

java.sourceCompatibility = JavaVersion.VERSION_1_8

// root project plugins
plugins {
    id(Plugins.springBoot) version Versions.springBoot
    id(Plugins.springDependencyManagement) version Versions.springDependencyManagement
    id(Plugins.jvm) version Versions.jvm
    id(Plugins.pluginSpring) version Versions.pluginSpring
    id(Plugins.pluginJpa) version Versions.pluginJpa
}

allprojects {
    group = "com.ittianyu"
    version = "0.0.1"

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }

    repositories {
        jcenter()
        mavenCentral()
    }

    // apply common plugins for all project
    apply(plugin = Plugins.springBoot)
    apply(plugin = Plugins.springDependencyManagement)
    apply(plugin = Plugins.jvm)
    apply(plugin = Plugins.pluginSpring)
    apply(plugin = Plugins.pluginJpa)
    // custom plugin
    apply(plugin = Plugins.commonConfig)

    // must behind the "apply plugin springDependencyManagement"
    dependencyManagement {
        imports {
            mavenBom(Libs.`spring-cloud-dependencies`)
        }
    }
}

val developmentOnly by configurations.creating
configurations {
    runtimeClasspath {
        extendsFrom(developmentOnly)
    }
}

// common dependencies
dependencies {
    developmentOnly(Libs.`spring-boot-devtools`)

    subprojects.forEach {
        archives(it)
    }
}
