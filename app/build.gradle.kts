import BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER
import dependencies.AnnotationProcessorsDependencies
import dependencies.Dependencies
import extensions.addTestsDependencies
import extensions.implementation
import extensions.kapt
plugins {
    id(BuildPlugins.ANDROID_APPLICATION)
    id(BuildPlugins.KOTLIN_ANDROID)
    id(BuildPlugins.KOTLIN_PARCELIZE)
    id(BuildPlugins.KOTLIN_KAPT)
    id(BuildPlugins.NAVIGATION)
    id(BuildPlugins.HILT)
}

android {
    signingConfigs {
        create("release") {
            storeFile =
                file("./release.keystore")
            storePassword = "android"
            keyAlias = "Android"
            keyPassword = "android"
        }
    }
    compileSdk = BuildAndroidConfig.COMPILE_SDK_VERSION
    defaultConfig {
        applicationId = BuildAndroidConfig.APPLICATION_ID
        minSdk = BuildAndroidConfig.MIN_SDK_VERSION
        targetSdk = BuildAndroidConfig.TARGET_SDK_VERSION

        versionCode = BuildAndroidConfig.VERSION_CODE
        versionName = BuildAndroidConfig.VERSION_NAME

        testInstrumentationRunner = TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        getByName("debug") {
        }
        getByName("release") {
            isMinifyEnabled = false
            signingConfig  = signingConfigs.getByName("release")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    flavorDimensions += "environment"
    productFlavors {
        create("production") {
            dimension = "environment"
            versionNameSuffix = ""
        }
        create("staging") {
            dimension = "environment"
            versionNameSuffix = "-staging"
        }
        create("dev") {
            dimension = "environment"
            versionNameSuffix = "-dev"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = BuildDependenciesVersions.COMPOSE
    }
}

dependencies {

    api(project(BuildModules.COMMON))
    api(project(BuildModules.CORE))
    implementation(Dependencies.NAVIGATION_FRAGMENT)
    implementation(Dependencies.NAVIGATION_UI)
    implementation(Dependencies.NAVIGATION_COMPOSE)
    implementation(Dependencies.HILT)
    implementation(Dependencies.ACTIVITY_COMPOSE)
    implementation(Dependencies.COMPOSE_MATERIAL)
    implementation(Dependencies.COMPOSE_MATERIAL_ICON)
    implementation(Dependencies.COMPOSE_CONSTRAIN_LAYOUT)
    implementation(Dependencies.COMPOSE_UI)
    implementation(Dependencies.COMPOSE_UI_TOOLING)
    implementation(Dependencies.COMPOSE_MATERIAL_3)
    implementation(Dependencies.ACC_UI_CONTROLLER)
    kapt(AnnotationProcessorsDependencies.HILT)
    kapt(Dependencies.HILT)
    kapt(AnnotationProcessorsDependencies.ROOM)

    implementation(Dependencies.COIL)
    implementation(Dependencies.ACC_SWIPE_REFRESH)
    implementation(Dependencies.ACC_PLACEHOLDER)
    implementation(Dependencies.SKYDOVES)
    implementation(Dependencies.IMG_COIL)
    implementation(Dependencies.CHROME_CUSTOM_TAB)

    implementation(Dependencies.STARTUP)

    addTestsDependencies()
}