/*
Find more info - https://github.com/DevOpsOnlineTraining-2021/Docker/blob/main/Jenkins_with_docker/Example-5.md
*/


node {
	stage("code checkout"){
		
		checkout scm
	}
	stage("Build"){
		docker.image("maven:3.8.1-adoptopenjdk-11").inside('-v /root/.m2:/root/.m2') { c ->

			sh 'mvn -V -B clean deploy -DreleaseVersion=1.0.${BUILD_NUMBER}'

		}
	}
}


/*    OR

node {
	stage("code checkout"){
		
		checkout scm
	}
	stage("Build"){
	
		def mavenImage = docker.image("maven:3.8.1-adoptopenjdk-11")
		
		mavenImage.inside {

			sh 'mvn -V -B clean install -DreleaseVersion=1.0.${BUILD_NUMBER}'

		}
	}
}

*/
