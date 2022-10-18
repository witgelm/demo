plugins {
    id("org.jetbrains.compose") version ("1.2.0") apply false
    id("org.jetbrains.kotlin.jvm") version ("1.7.20") apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}
