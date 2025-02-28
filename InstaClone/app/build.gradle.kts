plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.instaclone"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.instaclone"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("release") {
            storeFile = file("/home/al-shaye5h/Dev/kotlin/InstaClone/app/key.jks") // Replace with your keystore path
            storePassword = "aaaaaa" // Replace with your keystore password
            keyAlias = "key_alias" // Replace with your key alias
            keyPassword = "aaaaaa" // Replace with your key password
        }
    }

    buildTypes {
        /*release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        },
        */
        buildTypes {
            getByName("release") {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
                signingConfig = signingConfigs.getByName("release")
            }
        }

    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    dependencies {
        // Lifecycle components
        implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
        implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
        implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
        implementation("androidx.lifecycle:lifecycle-common-java8:2.6.2")
        implementation("androidx.activity:activity-ktx:1.8.0")

        // Firebase Firestore
        implementation("com.google.firebase:firebase-firestore-ktx:24.9.1")

        // Firebase Auth
        implementation("com.google.firebase:firebase-auth-ktx:22.2.0")

        // Navigation components
        implementation("androidx.navigation:navigation-fragment-ktx:2.7.4")
        implementation("androidx.navigation:navigation-ui-ktx:2.7.4")

        // Glide
        implementation("com.github.bumptech.glide:glide:4.16.0")
        annotationProcessor("com.github.bumptech.glide:compiler:4.16.0")

        // CircleImageView
        implementation("de.hdodenhof:circleimageview:3.1.0")

        // Firebase Storage
        implementation("com.google.firebase:firebase-storage-ktx:20.3.0")

        // Kotlin components
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.10")

        // Coroutines
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")

        // MaterialEditText (if still needed)
        implementation("com.rengwuxian.materialedittext:library:2.1.4")
    }

}