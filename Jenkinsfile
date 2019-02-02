node{
	stage('checkout'){
		checkout scm
	}
	stage('compile'){
		sh '"/root/apache-maven-3.5.4/bin/mvn" -V clean compile'
	}
	stage('junit test'){
		sh '"/root/apache-maven-3.5.4/bin/mvn" -V clean test'
	}
	stage('deploy-to-nexus'){
    		print 'deploy the package to nexus'
		sh '"/root/apache-maven-3.5.4/bin/mvn" -V clean package' //this command is not deploying
		//sh '"/root/apache-maven-3.5.4/bin/mvn" -V clean deploy'
	}
	stage('deploy-to-tomcat'){
		sh '''
		echo Deploy the war to tomcat server.

		echo Step-1: Removing the existing package
		rm -rf /root/tomcat7/webapps/WebApp-*.war
		rm -rf /root/tomcat7/webapps/WebApp-*

		echo Step-2: Staging the new package to tomcat server.
		cp ${WORKSPACE}/target/DevOpsWebApp-1.0.0-SNAPSHOT.war /root/tomcat7/webapps
		'''
	}
}
