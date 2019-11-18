pipeline {
    agent any

    tools {
        jdk 'jdk13'
    }

    stages {
        stage('Prepare') {
            steps {
                git 'https://github.com/poponuki/arakawa-api.git'
            }
        }

        stage('Build with unit testing') {
            steps {
                sh 'sh gradlew build'
            }
        }

        stage('Sonar scan execution') {
            steps {
                sh 'sh gradlew -Dsonar.host.url=http://localhost:9000 sonarqube'
            }
        }
    }
}
