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
					def services = ['user-service', 'api-gateway']

					services.each { service ->
							dir("backend/${service}") {
									bat '''
										call echo --------- Install Service --------- 
										call gradlew.bat build -x test
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