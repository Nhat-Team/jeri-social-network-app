pipeline {
	
	agent any
	
	stages {
		
		stage('Checkout Code') {
			steps {
				checkout scm
			}
		}

		stage('Detect Changed Services') {
			steps {
				def servies = ["user-service"]

				for (svc in services) {
					dir("backend/${svc}") {
						bat '''
							gradlew.bat clean bootJar -x test
						'''
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