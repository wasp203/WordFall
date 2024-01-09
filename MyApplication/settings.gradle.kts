import java.net.URI
import java.net.URL

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        maven { url = URI("https://jitpack.io/") }
        mavenCentral()
    }
}

rootProject.name = "My Application"
include(":app")
 