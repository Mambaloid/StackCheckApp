pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven {
            url = uri("http://developer.huawei.com/repo/")
            isAllowInsecureProtocol = true
        }
        maven { url = uri("https://pushsdk.org") }
        maven { url = uri("https://artifactory-external.vkpartner.ru/artifactory/maven") }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("http://developer.huawei.com/repo/")
            isAllowInsecureProtocol = true
        }
        maven { url = uri("https://pushsdk.org") }
        maven { url = uri("https://artifactory-external.vkpartner.ru/artifactory/maven") }
    }
}

rootProject.name = "StackCheckApp"
include(":app")
 