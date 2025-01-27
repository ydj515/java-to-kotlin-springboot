plugins {
    val springBootVersion = "2.7.18"
    val kotlinVersion = "1.9.20"
    java
    id("org.springframework.boot") version springBootVersion
    id("io.spring.dependency-management") version "1.1.4"
	// kotlin jvm 플러그인
    kotlin("jvm") version kotlinVersion
	// kotlin spring 호환성(open class) 플러그인
    kotlin("plugin.spring") version kotlinVersion
	// Kotlin Annotation Processing Tool
    kotlin("kapt") version kotlinVersion
	// kotlin jpa 호환성(entity class에 매개변수 없는 기본 생성자 생성)
    kotlin("plugin.jpa") version kotlinVersion
	// kotlin에서 lombok 사용이 가능해지게 만들어주는 플러그인
    kotlin("plugin.lombok") version kotlinVersion
    id("io.freefair.lombok") version "8.1.0"
}
group = "com.makers"
version = "0.0.1-SNAPSHOT"
java {
    sourceCompatibility = JavaVersion.VERSION_11
}
repositories {
    mavenCentral()
}
dependencies {
    // spring
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // kotlin
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    // db
    runtimeOnly("com.h2database:h2")

    // querydsl
    val querydslVersion = "5.0.0"
    implementation("com.querydsl:querydsl-jpa:$querydslVersion")
    kapt("com.querydsl:querydsl-apt:$querydslVersion:jpa")
}
kapt {
    keepJavacAnnotationProcessors = true
}
tasks {
    test {
        useJUnitPlatform()
    }
    compileKotlin {
        kotlinOptions {
            freeCompilerArgs += "-Xjsr305=strict"
            jvmTarget = "11"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}