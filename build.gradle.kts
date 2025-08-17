plugins {
    kotlin("jvm") version "2.1.10"
    kotlin("plugin.spring") version "2.1.10"
    id("org.springframework.boot") version "3.5.4"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("plugin.jpa") version "2.1.10"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
description = "kafka-guide"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://packages.confluent.io/maven/")
    }
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")      // 웹 애플리케이션 개발을 위한 스타터 패키지
    implementation("org.springframework.boot:spring-boot-starter-data-jpa") // JPA == ORM

    implementation("org.springframework.kafka:spring-kafka")                // Kafka를 활용하기 위한 라이브러리
    implementation("org.apache.kafka:kafka-streams")                        // Kafka의 메시지 및 스트림 처리

    implementation("org.apache.avro:avro:1.11.3")                           // 데이터 직렬화를 위한 Avro 라이브러리
    implementation("io.confluent:kafka-avro-serializer:7.5.0")              // Avro 데이터 다루기 위한 역/직렬화
    implementation("io.confluent:kafka-streams-avro-serde:7.5.0")           // SerDE 지원을 위한 라이브러리
    implementation("io.confluent:kafka-schema-registry-client:7.5.0")       // 스키마를 저장하는 저장소

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")    // 기본적인 역/직렬화

    // spring, java 언어를 kotlin으로 맵핑해주는 라이브러리
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // 애플리케이션 모니터링 라이브러리
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    runtimeOnly("com.h2database:h2")
    runtimeOnly("org.postgresql:postgresql")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.kafka:spring-kafka-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
