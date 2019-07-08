
dependencies {
    // runtime
    implementation(Libs.`kotlin-reflect`)
    implementation(Libs.`kotlin-stdlib-jdk8`)
    implementation(Libs.`jackson-module-kotlin`)

    // boot start
    implementation(Libs.`spring-boot-starter`)
    testImplementation(Libs.`spring-boot-starter-test`)

    // cloud start
    implementation(Libs.`spring-cloud-starter`)
    // discover client
    implementation(Libs.`spring-cloud-starter-netflix-eureka-client`)
    // call
    implementation(Libs.`spring-cloud-starter-openfeign`)
    implementation(Libs.`spring-cloud-starter-netflix-hystrix`)
    // zuul
    implementation(Libs.`spring-cloud-starter-netflix-zuul`)
    // hystrix-dashboard
    implementation(Libs.`spring-cloud-starter-netflix-hystrix-dashboard`)

}
