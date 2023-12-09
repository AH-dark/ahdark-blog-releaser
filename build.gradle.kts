import org.jreleaser.model.Active
import org.jreleaser.model.Distribution.DistributionType
import org.jreleaser.model.Stereotype

val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val exposed_version: String by project
val h2_version: String by project
val koin_version: String by project
val telegram_bot_version: String by project

plugins {
    kotlin("jvm") version "1.9.21"
    java
    id("io.ktor.plugin") version "2.3.7"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.21"
    id("org.jreleaser") version "1.9.0"
}

group = "com.ahdark.code"
version = "1.0.4"

application {
    mainClass.set("com.ahdark.code.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

ktor {
    fatJar {
        archiveFileName = "ahdark-blog-releaser-all.jar"
    }
}

jreleaser {
    project {
        name = "ahdark-blog-releaser"
        stereotype = Stereotype.WEB
        description = "AHdark Blog Release Notification Service"
        longDescription = """
        This project is a Kotlin-based HTTP server designed to handle GitHub Webhooks. It automatically forwards push notifications from the main branch of a GitHub repository to a specified Telegram chat, facilitating real-time updates.
        """.trimIndent()
        license = "MIT"
        authors = listOf("AHdark")
        maintainers = listOf("AH-dark")
        inceptionYear = "2023"
        website = "https://github.com/AH-dark/ahdark-blog-releaser"
        docsUrl = "https://github.com/AH-dark/ahdark-blog-releaser/wiki"

        java {
            version = "17"
            artifactId = "ahdark-blog-releaser"
            mainClass = "com.ahdark.code.ApplicationKt"
        }
    }

    release {
        github {
            enabled = true
            repoOwner = "ah-dark"
            overwrite = true
            draft = true
            issues {
                enabled = true
            }

            update {
                enabled = true
                section("ASSETS")
            }

            changelog {
                formatted = Active.ALWAYS
                preset = "conventional-commits"
                contributors {
                    format = "- {{contributorName}}{{#contributorUsernameAsLink}} ({{.}}){{/contributorUsernameAsLink}}"
                }
            }
        }
    }

    checksum {
        name = "{{projectName}}-{{projectVersion}}_checksums.txt"

        algorithm("SHA-256")

        individual = true
        artifacts = true
        files = true
    }

    platform {
        replacements.put("osx-x86_64", "mac")
        replacements.put("aarch_64", "aarch64")
        replacements.put("x86_64", "amd64")
        replacements.put("linux_musl", "alpine")
    }

    distributions {
        create("ahdark-blog-releaser") {
            active = Active.ALWAYS
            distributionType = DistributionType.SINGLE_JAR

            artifacts {
                artifact {
                    path = File("build/libs/{{distributionName}}-all.jar")
                }
            }

            upload {
                enabled = true
            }
        }
    }

    packagers {
        docker {
            active = Active.RELEASE

            buildx {
                enabled = true

                platform("linux/amd64")
                platform("linux/arm64")
            }

            repository {
                name = "ahdark-blog-releaser"
            }

            imageName("ah-dark/{{distributionName}}:{{tagName}}")

            registries {
                create("ghcr") {
                    server = "ghcr.io"
                    imageName("ah-dark/{{distributionName}}:{{tagName}}")
                }
            }
        }
    }
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-resources")
    implementation("io.ktor:ktor-server-auto-head-response-jvm")
    implementation("io.ktor:ktor-server-call-logging-jvm")
    implementation("io.ktor:ktor-server-content-negotiation-jvm")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm")
    implementation("org.jetbrains.exposed:exposed-core:$exposed_version")
    implementation("org.jetbrains.exposed:exposed-jdbc:$exposed_version")
    implementation("io.ktor:ktor-server-netty-jvm")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.insert-koin:koin-ktor:$koin_version")
    implementation("io.github.kotlin-telegram-bot.kotlin-telegram-bot:telegram:$telegram_bot_version")
    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
    testImplementation("io.insert-koin:koin-test:$koin_version")
}
