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
    always {

        publishHTML([
            reportDir: 'Reports',
            reportFiles: 'ExtentReport.html',
            reportName: 'Extent Report'
        ])

        archiveArtifacts artifacts: 'Reports/ExtentReport.html'
    }
}
}