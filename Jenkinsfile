/*
Find more info - https://github.com/DevOpsOnlineTraining-2021/Docker/blob/main/Jenkins_with_docker/Example-3.md
*/


node {
	
	
		checkout scm


		docker.image("maven:3.8.1-adoptopenjdk-11").inside { c ->
								     
			
			sh 'mvn -V -B clean install -DreleaseVersion=1.0.${BUILD_NUMBER}'
								     
			
		    }
	
}
