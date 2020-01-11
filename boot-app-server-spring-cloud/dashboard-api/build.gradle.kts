
dependencies {
    // runtime
    implementation(Libs.`kotlin-reflect`)
    implementation(Libs.`kotlin-stdlib`)
    implementation(Libs.`jackson-module-kotlin`)

    // boot start
    implementation(Libs.`spring-boot-starter`)
    testImplementation(Libs.`spring-boot-starter-test`)

    // call
    implementation(Libs.`spring-cloud-starter-openfeign`)

    // module
    implementation(project(Modules.common))
    implementation(project(Modules.common_web))
}

