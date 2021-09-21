plugins {
    kotlin("jvm") version "1.5.30"
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "io.github.blugon0921"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://jcenter.bintray.com/")
}

dependencies {
    implementation(kotlin("stdlib"))


}



tasks {
    processResources {
        filesMatching("*.yml") {
            expand(project.properties)
        }
    }

    shadowJar {
        from(sourceSets["main"].output)
        archiveBaseName.set(project.name)
        archiveVersion.set("")
        archiveFileName.set("${project.name}.jar")

        doLast {
            copy {
                from(archiveFile)
                val plugins = File("C:/Users/blugo/바탕화면")
                into(plugins)
            }
        }

        manifest {
            attributes["Main-Class"] = "${project.group}.${project.name.toLowerCase()}.${project.name}"
        }
    }
}