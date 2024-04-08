plugins {
	alias(libs.plugins.androidApplication)
	alias(libs.plugins.jetbrainsKotlinAndroid)
	id ("kotlin-kapt")
	id ("kotlin-parcelize")
}


android {
	namespace = "com.shishkin.spacex"
	compileSdk = 34

	defaultConfig {
		applicationId = "com.shishkin.spacex"
		minSdk = 26
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
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = "1.8"
	}
	buildFeatures {
		viewBinding = true
	}

}

dependencies {

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)
	implementation(libs.material)
	implementation(libs.androidx.activity)
	implementation(libs.androidx.constraintlayout)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)

	/** Зависимости должны быть в libs.versions.toml **/
	
	//Navigation
	val nav_version = "2.7.7"
	implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
	implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

	//Kotlin Coroutines
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")

	//Retrofit
	val retrofit_version = "2.11.0"
	implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
	implementation("com.squareup.retrofit2:converter-gson:$retrofit_version")

	//OkHttp
	implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

	//GSON
	implementation("com.google.code.gson:gson:2.10.1")

	//Dagger
	val dagger_android_support_version = "2.51.1"
	implementation ("com.google.dagger:dagger:2.51.1")
	kapt ("com.google.dagger:dagger-compiler:2.51.1")
	implementation ("com.google.dagger:dagger-android-support:$dagger_android_support_version")
	kapt ("com.google.dagger:dagger-android-processor:$dagger_android_support_version")
	implementation ("com.google.dagger:dagger-android:2.51.1")

	//Glide
	implementation ("com.github.bumptech.glide:glide:4.15.1")

	//Viewpager Implementation
	implementation ("androidx.viewpager2:viewpager2:1.0.0")

	//CircleIndicator
	implementation ("me.relex:circleindicator:2.1.6")

	//Pagination
	val paging_version = "3.2.1"
	implementation("androidx.paging:paging-runtime:$paging_version")
}