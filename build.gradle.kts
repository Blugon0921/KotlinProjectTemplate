plugins {
    kotlin("jvm") version "1.5.31"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "io.github.blugon09"
version = "1.0.0"



repositories {
    mavenCentral()
    maven("https://jcenter.bintray.com/")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.31")
}



tasks {
    shadowJar {
        from(sourceSets["main"].output)
        archiveBaseName.set(project.name)
        archiveVersion.set("")
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