pipeline {
    agent any

    environment {
        USERNAME = credentials('github-username')
        TOKEN = credentials('github-token')
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'ssh://git@git.jetbrains.space/rcmentorship/zmaev-daniil/common-lib.git',
                branch: 'main'
            }
        }

stage('Get Last Commit Message') {
            steps {
                script {
                    def lastCommitMessage = sh(script: 'git log -1 --pretty=%B', returnStdout: true).trim()
                    echo "Last commit message: ${lastCommitMessage}"

                    if (!lastCommitMessage) {
                        error "Could not retrieve last commit message."
                    }

                    env.LAST_COMMIT_MESSAGE = lastCommitMessage
                }
            }
        }

        stage('Extract Version from Commit Message') {
            steps {
                script {
                    def commitMessage = env.LAST_COMMIT_MESSAGE
                    if (!commitMessage) {
                        error "LAST_COMMIT_MESSAGE is not set."
                    }

                    def versionMatch = commitMessage =~ /ZMAEV-DANIIL-T-(\d+)/
                    if (versionMatch) {
                        def version = versionMatch[0][1]
                        env.VERSION = version
                        echo "Version extracted from commit message: ${version}"
                    } else {
                        error "Could not determine version from commit message: ${commitMessage}"
                    }
                }
            }
        }

        stage('Build and Publish to GitHub Packages') {
            steps {
                sh './gradlew publishAllPublicationsToGitHubPackagesRepository'
            }
        }
    }

    post {
        success {
            echo 'Publish completed successfully!'
        }
        failure {
            echo 'Publish failed.'
        }
    }
}