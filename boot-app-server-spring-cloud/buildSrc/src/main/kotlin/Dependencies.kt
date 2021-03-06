object Versions {
    const val springCloud = "Greenwich.SR1"
    const val springBoot = "2.1.6.RELEASE"
    const val springDependencyManagement = "1.0.7.RELEASE"
    const val jvm = "1.2.71"
    const val pluginSpring = "1.2.71"
    const val pluginJpa = "1.2.71"
}

private fun kotlin(module: String): String {
    return "org.jetbrains.kotlin.${module}"
}

object Plugins {
//    const val commonConfig = "common-config";// custom plugin build by "buildSrc"
    const val springBoot = "org.springframework.boot";
    const val springDependencyManagement = "io.spring.dependency-management";
    val jvm = kotlin("jvm");
    val pluginSpring = kotlin("plugin.spring");
    val pluginJpa = kotlin("plugin.jpa");
}

object Libs {
    const val `spring-cloud-dependencies` = "org.springframework.cloud:spring-cloud-dependencies:${Versions.springCloud}"
    const val `kotlin-stdlib` = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"
    const val `kotlin-reflect` = "org.jetbrains.kotlin:kotlin-reflect"
    const val `jackson-module-kotlin` = "com.fasterxml.jackson.module:jackson-module-kotlin"
    const val `mysql-connector-java` = "mysql:mysql-connector-java"
    const val `spring-boot-starter` = "org.springframework.boot:spring-boot-starter"
    const val `spring-boot-starter-test` = "org.springframework.boot:spring-boot-starter-test"
    const val `spring-boot-devtools` = "org.springframework.boot:spring-boot-devtools"
    const val `spring-boot-starter-data-jpa` = "org.springframework.boot:spring-boot-starter-data-jpa"
    const val `spring-boot-starter-data-redis` = "org.springframework.boot:spring-boot-starter-data-redis"
    const val `spring-boot-starter-web` = "org.springframework.boot:spring-boot-starter-web"
    const val `spring-cloud-starter` = "org.springframework.cloud:spring-cloud-starter"
    const val `spring-cloud-starter-netflix-eureka-client` = "org.springframework.cloud:spring-cloud-starter-netflix-eureka-client"
    const val `spring-cloud-starter-netflix-eureka-server` = "org.springframework.cloud:spring-cloud-starter-netflix-eureka-server"
    const val `spring-cloud-starter-netflix-hystrix` = "org.springframework.cloud:spring-cloud-starter-netflix-hystrix"
    const val `spring-cloud-starter-netflix-hystrix-dashboard` = "org.springframework.cloud:spring-cloud-starter-netflix-hystrix-dashboard"
    const val `spring-cloud-starter-netflix-zuul` = "org.springframework.cloud:spring-cloud-starter-netflix-zuul"
    const val `spring-cloud-starter-oauth2` = "org.springframework.cloud:spring-cloud-starter-oauth2"
    const val `spring-cloud-starter-openfeign` = "org.springframework.cloud:spring-cloud-starter-openfeign"
    const val `spring-cloud-config-server` = "org.springframework.cloud:spring-cloud-config-server"
    const val `spring-cloud-config-client` = "org.springframework.cloud:spring-cloud-config-client"
    const val `validation-api` = "javax.validation:validation-api:2.0.1.Final"
    const val `spring-boot-starter-mail` = "org.springframework.boot:spring-boot-starter-mail"

}

object Modules {
    const val common = ":common"
    const val common_web = ":common-web"
    const val account_api = ":account-api"
    const val dashboard_api = ":dashboard-api"
}
