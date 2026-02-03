pipeline {
	
	agent any
	
	stages {
		
		stage('Checkout Code') {
			steps {
				checkout scm
			}
		}

		stage('Build Backend Services') {
			steps {
				script {
					def services = ['user-service', 'gateway-service']

					services.each { service ->
							dir("backend/${service}") {
									sh '''
										echo --------- Install Service --------- 
										./gradlew.bat build -x test
										./gradlew.bat bootJar
									'''
						}	
					}	
				}
			}
		}

		stage('Build All Docker Images') {
			steps {
				sh '''
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