import dependencies.AnnotationProcessorsDependencies
import dependencies.Dependencies

plugins {
    id("commons.android-library")
}

android {
    defaultConfig {
        buildConfigField("String", "DATABASE_NAME", "\"news-data\"")
        buildConfigField("int", "DATABASE_VERSION", "1")
        buildConfigField("boolean", "DATABASE_EXPORT_SCHEMA", "false")
        buildConfigField(
            type = "String",
            name = "API_KEY",
            value = com.android.build.gradle.internal.cxx.configure.gradleLocalProperties(rootDir).getProperty("api_key") as? String ?: throw Exception("api_key is not set at local.properties")
        )
    }

    flavorDimensions += "environment"
    productFlavors {
        create("production") {
            dimension = "environment"
            buildConfigField("String", "API_BASE_URL", "\"https://newsapi.org/\"")
        }
        create("staging") {
            dimension = "environment"
            buildConfigField("String", "API_BASE_URL", "\"https://newsapi.org/\"")
        }
        create("dev") {
            dimension = "environment"
            buildConfigField("String", "API_BASE_URL", "\"https://newsapi.org/\"")
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("com.google.android.material:material:1.6.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    api(project(BuildModules.COMMON))

    api(Dependencies.RETROFIT)
    api(Dependencies.MOSHI)
    implementation(Dependencies.ROOM_KTX)
    implementation(Dependencies.ROOM_RUNTIME)
    implementation(Dependencies.RETROFIT_GSON)
    implementation(Dependencies.RETROFIT_MOSHI)
    implementation(Dependencies.LOGGING)
    implementation(Dependencies.MOSHI_KTX)
    implementation(Dependencies.COROUTINES)
    implementation(Dependencies.SKYDOVES)
    implementation(Dependencies.IMG_COIL)
    implementation(Dependencies.STARTUP)

    kapt(AnnotationProcessorsDependencies.HILT)
    kapt(AnnotationProcessorsDependencies.ROOM)
}