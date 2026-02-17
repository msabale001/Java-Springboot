pipeline {
    agent any
    tools {
        maven 'mavenTool'
        jdk 'jdk17'
    }
    stages{
        stage('Checkout'){
            steps{
                git branch: 'main', url: 'https://github.com/msabale001/Java-Springboot.git'
            }
        }
        stage('maven test'){
            steps{
                sh 'mvn clean test'
            }
        }
        stage('OWASP Dependency Check'){
    steps{
        dependencyCheck additionalArguments: '''
            --scan ./
            --out ./
            --format ALL
            --data $JENKINS_HOME/owasp-data
            --noupdate
            --prettyPrint
        ''',
        odcInstallation: 'OWASP-depcheck'

        dependencyCheckPublisher(
            failedTotalCritical: 1,
            pattern: 'dependency-check-report/dependency-check-report.xml'
        )

        publishHTML([
            allowMissing: false,
            alwaysLinkToLastBuild: true,
            keepAll: true,
            reportDir: 'dependency-check-report',
            reportFiles: 'dependency-check-report.html',
            reportName: 'Dependency Check HTML Report'
        ])
    }
}

    }
}
