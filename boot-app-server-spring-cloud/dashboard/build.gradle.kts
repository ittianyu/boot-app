
dependencies {
    // runtime
    implementation(Libs.`kotlin-reflect`)
    implementation(Libs.`kotlin-stdlib`)
    implementation(Libs.`jackson-module-kotlin`)

    // boot start
    implementation(Libs.`spring-boot-starter`)
    testImplementation(Libs.`spring-boot-starter-test`)

    // web
    implementation(Libs.`spring-boot-starter-web`)

    // cloud start
    implementation(Libs.`spring-cloud-starter`)
    // discover client
    implementation(Libs.`spring-cloud-starter-netflix-eureka-client`)

    // config client
    implementation(Libs.`spring-cloud-config-client`)

    // call
    implementation(Libs.`spring-cloud-starter-openfeign`)
    implementation(Libs.`spring-cloud-starter-netflix-hystrix`)

}
