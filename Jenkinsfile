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

        stage('Build All Services') {
            dir('backend') {
                steps {
                    sh '''
                        ./gradlew clean build -x test
                    '''
                }
            }
        }

		stage('Build All Docker Images') {
			steps {
                sh '''
                    docker compose build
                '''
			}
		}

        stage('Deploying Services') {
            steps {
                sh '''
                    docker compose up -d
                '''
            }
        }
	}

	post {
		always {
			cleanWs()
		}

		success {
			echo "All services have been built and deployed"
		}

		failure {
			echo "Build and deployment have failed"
		}
	}
}