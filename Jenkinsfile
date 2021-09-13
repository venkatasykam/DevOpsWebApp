/*
Find more info - https://github.com/DevOpsOnlineTraining-2021/Docker/blob/main/Jenkins_with_docker/Example-3.md
*/


pipeline {
    agent { dockerfile true }
    stages {
        stage('Test') {
            steps {
		    sh 'mvn -V -B clean install -DreleaseVersion=1.0.${BUILD_NUMBER}'
            }
        }
    }
}
