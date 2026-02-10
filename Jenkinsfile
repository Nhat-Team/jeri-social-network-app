pipeline {
	
	agent any


	stages {
		
		stage('Checkout Code') {
			steps {
				checkout scm
			}
		}

		stage('Pull All Images') {
			steps {
				bat '''
					call docker pull node:20-slim
					call docker pull nginx:alpine
					calldocker pull eclipse-temurin:21-jdk
				'''
			}
		}

		stage('Build Backend Services') {
			steps {
				script {
					def services = ['user-service', 'api-gateway']

					services.each { service ->
							dir("backend/${service}") {
									bat '''
										call gradlew.bat bootJar
									'''
						}	
					}	
				}
			}
		}

		stage('Build All Docker Images') {
			steps {
				bat '''
					docker-compose up -d --build
				'''
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