/*
Find more info - https://github.com/DevOpsOnlineTraining-2021/Docker/blob/main/Jenkins_with_docker/Example-1.md
*/

pipeline {
    agent {
		docker {
			image 'maven:3.8.1-adoptopenjdk-11'
			args '-v $HOME/.m2:/root/.m2'
		}
	}
    stages {
        stage('Build') {

            steps {
		    sh 'mvn -V -B clean install -DreleaseVersion=1.0.${BUILD_NUMBER}'
            }
        }
    }
}
