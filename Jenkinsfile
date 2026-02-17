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
                    --prettyPrint''', odcInstallation: 'OWASP-depcheck'
            }
        }
    }
}
