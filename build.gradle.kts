import io.kotless.plugin.gradle.dsl.kotless

group = "io.kotless.examples"
version = "0.1.0"

plugins {
    id("io.kotless") version "0.1.6" apply true
    id("tanvd.kosogor") version "1.0.9" apply true
    kotlin("jvm") version "1.3.72" apply false
}

repositories {
    jcenter()
}

dependencies {
    implementation("commons-validator", "commons-validator", "1.6")
    implementation("com.amazonaws", "aws-java-sdk-dynamodb", "1.11.650")

    implementation("io.kotless", "spring-boot-lang", "0.1.6")
    implementation("io.ktor", "ktor-html-builder", "1.3.2")
}

tasks {
    withType<org.jetbrains.kotlin.gradle.dsl.KotlinJvmCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf(
                "-Xopt-in=kotlin.RequiresOptIn"
            )
        }
    }
}


kotless {
    config {
        bucket = "eu.spring-short.s3.ktls.aws.intellij.net"
        prefix = "spring-short-kong"

        terraform {
            profile = "sancheag"
            region = "ap-northeast-2"
        }
    }
    extensions {
        local {
            useAWSEmulation = true
        }

        terraform {
            files {
                add(file("src/main/tf/extensions.tf"))
            }
        }
    }
}

