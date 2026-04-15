plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.prova.template_cadastro_produtos"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.prova.template_cadastro_produtos"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    val room_version = "2.6.1" // Versão estável atual

    implementation("androidx.room:room-runtime:$room_version")

    // ATENÇÃO: O annotationProcessor é obrigatório porque o projeto é em Java!
    annotationProcessor("androidx.room:room-compiler:$room_version")
}