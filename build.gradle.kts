plugins {
    kotlin("jvm") version "1.6.0"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "io.github.blugon09"
version = "1.0.0-SNAPSHOT"


java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}


repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.6.0")
}



tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
    }

    shadowJar {
        from(sourceSets["main"].output)
        archiveBaseName.set(project.name)
        archiveVersion.set("${project.version}")
        archiveFileName.set("${project.name}.jar")

        doLast {
            copy {
                from(archiveFile)
                val plugins = File("C:/Users/blugo/Desktop")
                into(plugins)
            }
        }

        manifest {
            attributes["Main-Class"] = "${project.group}.${project.name.toLowerCase()}.${project.name}"
        }
    }
}