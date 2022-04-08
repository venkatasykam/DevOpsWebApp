/*
1. Setup Maven path in Manage Jenkins >>  Global Tool Configuration >> under Maven >> 
	Name: maven-3.8.1
	Value: maven home path (ex: /usr/lib/maven/apache-maven-3.8.1)
2. Setup Git path in Manage Jenkins >>  Global Tool Configuration >> under Git >> 
	Name: Default
	Value: Git home path (ex: /usr/bin/git )
3. Make sure jenkins master or node have the lable - build. (OR) update the lable name you want in the below code.
*/


node {
	stage('checkout'){
		checkout scm
	}
	stage('compile'){
		
		sh"mvn -V clean compile"
	}
	stage('junit test'){
		sh"mvn -V clean test"
	}
	stage('create a package'){
    		sh "mvn -V clean package"
	}
	
	stage('deploy-to-tomcat'){
		print 'deploy the package to tomcat server to run application'
		/*
		sh'''
			echo "Removing the existing package from tomcat server"
			ssh ec2-user@3.89.232.247 rm -rf $HOME/tomcat9/webapps/DevOpsWebApp*
			
			echo "Deploy(copy) war to tomcat server"
			scp target/DevOpsWebApp*.war ec2-user@3.89.232.247:$HOME/tomcat9/webapps/

		'''
		*/
		sh '''
			echo Deploy the war to tomcat server.

			echo Step-1: Removing the existing package
			rm -rf /root/apache-tomcat-9.0.62/webapps/DevOpsWebApp-*.war
			rm -rf /root/apache-tomcat-9.0.62/webapps/DevOpsWebApp-*

			echo Step-2: Staging the new package to tomcat server.
			cp ${WORKSPACE}/target/DevOpsWebApp-*.war /root/apache-tomcat-9.0.62/webapps '''
		
	}
}
