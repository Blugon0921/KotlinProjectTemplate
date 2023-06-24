plugins {
    kotlin("jvm") version "1.8.21"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(11))
    }
}

val kotlinVersion = kotlin.coreLibrariesVersion
val buildPath = File("C:/Users/blugo/Desktop")


repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${kotlinVersion}")
    implementation("im.kimcore:Josa.kt:1.6")
    implementation("com.github.kwhat:jnativehook:2.2.2")
}



tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
    }

    jar { this.build() }
    shadowJar { this.build() }
}

fun Jar.build() {
    from(sourceSets["main"].output)
    archiveBaseName.set(project.name) //Project Name
    archiveFileName.set("${project.name}.jar") //Build File Name
    archiveVersion.set(project.version.toString()) //Version

    doLast {
        copy {
            from(archiveFile) //Copy from
            into(buildPath) //Copy to
        }
    }

    manifest {
        attributes["Main-Class"] = "${project.group}.${project.name.toLowerCase()}.${project.name}Kt" //Main File
    }
}