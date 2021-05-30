echo "jenkins parameter: ${params.releaseVersion}"

def mvnHome = tool 'maven-3.8.1'

node("build"){
	stage('checkout'){
		checkout scm
	}
	stage('compile'){
		//sh '"/root/apache-maven-3.5.4/bin/mvn" -V clean compile'
		
		sh"${mvnHome}/bin/mvn -V clean compile"
	}
	stage('junit test'){
		sh"${mvnHome}/bin/mvn -V clean test"
	}
	stage('deploy-to-nexus'){
    		print 'deploy the package to nexus'
		sh"${mvnHome}/bin/mvn -V clean package" //this command is not deploying to nexus, install nexus and update the command to deploy
		//sh '"/root/apache-maven-3.5.4/bin/mvn" -V clean deploy'
	}
	stage('deploy-to-tomcat'){
		print 'deploy the package to tomcat server to run application'
		/*
		sh '''
			echo Deploy the war to tomcat server.

			echo Step-1: Removing the existing package
			rm -rf /root/tomcat7/webapps/DevOpsWebApp-*.war
			rm -rf /root/tomcat7/webapps/DevOpsWebApp-*

			echo Step-2: Staging the new package to tomcat server.
			cp ${WORKSPACE}/target/DevOpsWebApp-*.war /root/tomcat7/webapps
		'''
		*/
	}
}
