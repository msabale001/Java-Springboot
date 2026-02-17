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
                    --scan \'./\'
                    --out \'./\'
                    --format \'ALL\'
                    --data /var/owasp-data
                    --noupdate
                    --prettyPrint''', odcInstallation: 'OWASP-depcheck'
                dependencyCheckPublisher failedTotalCritical: 1, pattern: 'dependency-check-report.xml'
                publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: './', reportFiles: 'dependency-check-jenkins.html',reportName: 'Dependency Check HTML Report', reportTitles: '',  useWrapperFileDirectly: true])
            }
        }
    }
}
