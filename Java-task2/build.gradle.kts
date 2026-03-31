plugins {
    id("java")
    id("application")
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(18)
    }
}

sourceSets {
    main {
        java {
            srcDirs("src")
        }
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

application {
    mainClass = "com.exercises.PetInfo"
}