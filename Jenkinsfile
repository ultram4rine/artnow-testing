pipeline {
    agent any

    triggers { cron('H/30 * * * *') }

    tools { 
        maven 'maven 3.9.1'
        allure 'allure 2.21.0'
    }

    stages {
        stage("Run tests") {
            steps {
                git 'https://github.com/ultram4rine/artnow-testing.git'
                // 'bat' on Windows, 'sh' on Unix.
                bat 'mvn clean test'
            }
        }

        stage("Make report") {
            steps {
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'target/allure-results']]
                ])
            }
        }
    }
}