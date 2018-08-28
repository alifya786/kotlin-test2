import jetbrains.buildServer.configs.kotlin.v2018_1.*
import jetbrains.buildServer.configs.kotlin.v2018_1.triggers.vcs
import jetbrains.buildServer.configs.kotlin.v2018_1.buildSteps.script
import jetbrains.buildServer.configs.kotlin.v2018_1.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2018.1"

project {

    vcsRoot(Kotlin)

    buildType(KotlinTestingConfig)
}

object KotlinTestingConfig : BuildType({
    name = "kotlin testing config"

    steps {
        script {
            scriptContent = """echo "TeamCity""""
        }
    }
    triggers {
        vcs {

        }
    }
})

object Kotlin : GitVcsRoot({
    name = "kotlin"
    url = "https://github.com/alifya786/kotlin-test.git"
    authMethod = password {
        userName = "alifya786"
        password = "credentialsJSON:d1f1bf5d-e2ac-4c34-8c47-3d3adecfb0de"
    }
})
