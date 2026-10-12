pipeline {
    agent any

    stages {

        stage('Automation Testing') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {

        success {
            echo 'Automation PASSED'
        }

        failure {
            echo 'Automation FAILED'
        }
    }
}