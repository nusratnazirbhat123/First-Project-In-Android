plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.mha"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.mha"
        minSdk = 24
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    // Add these dependencies in your app's build.gradle file
    implementation ("androidx.core:core-ktx:1.7.0")


    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

// ViewModel and LiveData
    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-livedata:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")


// Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")

// Gson (for JSON parsing)
    implementation ("com.google.code.gson:gson:2.8.9")

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")



}