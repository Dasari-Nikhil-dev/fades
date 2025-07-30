plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
    alias(libs.plugins.ksp)
}
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
}
dependencies {

    api(libs.retrofit)
    implementation(libs.converter.moshi)
    implementation(libs.moshi)

    // Unit testing
    testImplementation(libs.junit)

    // coroutines for api calls
    implementation(libs.kotlinx.coroutines.core)

    // New
    ksp(libs.moshi.kotlin.codegen)


}
