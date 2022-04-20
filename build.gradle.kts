import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.30"
    application
}

group = "me.joach"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven { url = uri("https://dl.bintray.com/jetbrains/markdown") }
}

dependencies {
    implementation("com.github.ajalt.mordant:mordant:2.0.0-alpha2")
    implementation("org.jetbrains:markdown:0.2.0.pre-55")
    implementation("com.github.ajalt.colormath:colormath:2.0.0")
}


tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "MainKt"
}