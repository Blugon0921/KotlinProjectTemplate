plugins {
    kotlin("jvm") version "1.5.31"
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
    register<Jar>("buildJar") {
        archiveVersion.set("")
        archiveBaseName.set(project.name)
        archiveFileName.set("${project.name}.jar")
        from(sourceSets["main"].output)

        doLast {
            copy {
                from(archiveFile)

                //Build Location
                val plugins = File("C:/Users/blugo/Desktop")
                into(plugins)
            }
        }
    }
}