plugins {
    kotlin("jvm") version "1.8.0"
    id("com.github.johnrengelman.shadow") version "7.1.1"
}

group = "kr.blugon"
version = "1.0.0-SNAPSHOT"
val buildPath = File("C:/Users/blugo/Desktop")


java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}


repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.8.0")
    implementation("im.kimcore:Josa.kt:1.6")
    implementation("com.github.kwhat:jnativehook:2.2.2")
}



tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    jar {
        from(sourceSets["main"].output)
        archiveBaseName.set(project.name)
        archiveVersion.set("${project.version}")
        archiveFileName.set("${project.name}.jar")

        doLast {
            copy {
                from(archiveFile)
                into(buildPath)
            }
        }

        manifest {
            attributes["Main-Class"] = "${project.group}.${project.name.toLowerCase()}.${project.name}"
        }
    }

    shadowJar {
        from(sourceSets["main"].output)
        archiveBaseName.set(project.name)
        archiveVersion.set("${project.version}")
        archiveFileName.set("${project.name}.jar")

        doLast {
            copy {
                from(archiveFile)
                into(buildPath)
            }
        }

        manifest {
            attributes["Main-Class"] = "${project.group}.${project.name.toLowerCase()}.${project.name}"
        }
    }
}