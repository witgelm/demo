pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
    plugins {
        id("org.jetbrains.compose") version ("1.2.0")
        id ("org.jetbrains.kotlin.jvm") version "1.7.20"
    }
}
rootProject.name = "DesktopDemo"

include(":app")