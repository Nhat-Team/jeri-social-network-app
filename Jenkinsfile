pipeline {
	
	agent any
	
	stages {
		
		stage('Checkout Code') {
			steps {
				checkout scm
			}
		}

		stage('Detect Changed Services') {

			when {
				branch 'develop'
			}

			steps {
				sh '''
					chmod +x gradlew
					./gradlew clean bootJar -x test
				'''
			}
		}

		stage('Build All Docker Images') {

			when {
				branch 'develop'
			}

			steps {
				sh '''
					docker-compose up -d --build
				'''
			}
		}

		stage('Docker Cleanup') {
			when {
				branch 'main'
			}

			steps {
				sh '''
					docker system prune -af
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