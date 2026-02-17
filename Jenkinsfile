pipeline {
    agent any
    tools {
        maven 'mavenTool'
    }
    stages{
        stage('Checkout'){
            steps{
                git branch: 'main', url: 'https://github.com/msabale001/Java-Springboot.git'
            }
        }
        stage('maven test'){
            mvn clean test
        }
    }
}
