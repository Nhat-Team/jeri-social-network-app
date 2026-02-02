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
					def services = ['library-common-core', 'user-service', 'gateway-service']

					services.each {
						service -> {
							dir("backend/${service}") {
								if(service == 'library-common-core') {
									sh '''
										./gradlew build -x test
										./gradlew publishToMavenLocal
									'''
								} else {
									sh '''
										./gradlew build -x test
										./gradlew bootJar
									'''
								}
							}
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