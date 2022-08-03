import dependencies.AnnotationProcessorsDependencies
import dependencies.Dependencies
import extensions.kapt

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
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