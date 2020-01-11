
dependencies {
    // module
    implementation(project(Modules.common))
    implementation(project(Modules.common_web))
    implementation(project(Modules.account_api))
    implementation(project(Modules.dashboard_api))

    // runtime
    implementation(Libs.`kotlin-reflect`)
    implementation(Libs.`kotlin-stdlib`)
    implementation(Libs.`jackson-module-kotlin`)

    // boot start
    implementation(Libs.`spring-boot-starter`)
    testImplementation(Libs.`spring-boot-starter-test`)

    // web
    implementation(Libs.`spring-boot-starter-web`)
    // dao
    implementation(Libs.`spring-boot-starter-data-jpa`)
    runtimeOnly(Libs.`mysql-connector-java`)
    // nosql
    implementation(Libs.`spring-boot-starter-data-redis`)

    // cloud start
    implementation(Libs.`spring-cloud-starter`)
    // discover client
    implementation(Libs.`spring-cloud-starter-netflix-eureka-client`)

    // config client
    implementation(Libs.`spring-cloud-config-client`)

    // call
    implementation(Libs.`spring-cloud-starter-openfeign`)
    implementation(Libs.`spring-cloud-starter-netflix-hystrix`)
    // email
    implementation(Libs.`spring-boot-starter-mail`)

    // auth
//    implementation(Libs.`spring-cloud-starter-oauth2`)
}
