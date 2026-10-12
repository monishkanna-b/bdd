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

        publishHTML(target: [
            allowMissing: false,
            alwaysLinkToLastBuild: true,
            keepAll: true,
            reportDir: 'Reports',
            reportFiles: 'ExtentReport.html',
            reportName: 'Extent Report'
        ])

        archiveArtifacts artifacts: 'Reports/ExtentReport.html'
    }
}
}