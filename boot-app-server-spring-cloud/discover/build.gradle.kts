
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
    // discover server
    implementation(Libs.`spring-cloud-starter-netflix-eureka-server`)
}
