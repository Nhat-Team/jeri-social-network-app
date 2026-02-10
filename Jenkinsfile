pipeline {
	
	agent any

    environment {
        DOCKER_BUILDKIT = '1'
        COMPOSE_DOCKER_CLI_BUILD = '1'
    }

	stages {
		
		stage('Checkout Code') {
			steps {
				checkout scm
			}
		}

        stage('Detect Changed Services') {
            steps {
                script {
                    def changedFiles = bat(
                        script: "git diff --name-only HEAD~1",
                        returnStdout: true
                    ).trim()

                    env.BUILD_FRONTEND = changedFiles.contains("frontend/") ? "true" : "false"
                    env.BUILD_USER = changedFiles.contains("backend/user-service/") ? "true" : "false"
                    env.BUILD_GATEWAY = changedFiles.contains("backend/api-gateway/") ? "true" : "false"
                }
            }
        }

		stage('Build All Docker Images') {
			steps {
                script {
                    if (env.BUILD_FRONTEND == "true")
                        bat 'docker-compose build frontend'

                    if (env.BUILD_USER == "true")
                        bat 'docker-compose build user-service'

                    if (env.BUILD_GATEWAY == "true")
                        bat 'docker-compose build api-gateway'
                }
			}
		}
	}

	post {
		always {
			cleanWs()
		}

		success {
			echo "All services has built and deployed"
		}

		failure {
			echo "Build and deployment have failed"
		}
	}
}