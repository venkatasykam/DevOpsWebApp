/*
1. Setup Maven path in Manage Jenkins >>  Global Tool Configuration >> under Maven >> 
	Name: maven-3.8.1
	Value: maven home path (ex: /usr/lib/maven/apache-maven-3.8.1)
2. Setup Git path in Manage Jenkins >>  Global Tool Configuration >> under Git >> 
	Name: Default
	Value: Git home path (ex: /usr/bin/git )
3. Make sure jenkins master or node have the lable - build. (OR) update the lable name you want in the below code.
4. Setup ssh connection with the help of doc- https://github.com/DevOpsOnlineTraining-2021/Linux/blob/master/Practice-2/Practice-2.3.md
*/


node any {
	stage('checkout'){
		git branch: '${BRANCH_NAME}',
    credentialsId: 'venkat0007',
    url: 'https://github.com/venkat0007/DevOpsWebApp-1.git'
	}
	stage('compile'){
		
		sh"${tool 'maven-3.8.1'}/bin/mvn -V clean compile -DreleaseVersion=1.0.${BUILD_NUMBER}"
	}
	stage('junit test'){
		sh"${tool 'maven-3.8.1'}/bin/mvn -V clean test -DreleaseVersion=1.0.${BUILD_NUMBER}"
	}
	stage('deploy-to-nexus'){
    		println 'deploy the package to nexus'
		sh"${tool 'maven-3.8.1'}/bin/mvn -V clean install -DreleaseVersion=1.0.${BUILD_NUMBER}" //this command is not deploying to nexus, install nexus and update the command to deploy
		//sh '"/root/apache-maven-3.5.4/bin/mvn" -V clean deploy'
	}
	stage('deploy-to-tomcat'){
		
		println 'deploy the package to tomcat server to run application'
		
		sh'''
			echo "Removing the existing package from tomcat server"
			#ssh deploy@65.0.107.66 rm -rf /usr/bin/apache-tomcat-9.0.53/webapps/DevOpsWebApp*
			
			echo "Deploy(copy) war to tomcat server"
			#scp target/DevOpsWebApp*.war deploy@65.0.107.66:/usr/bin/apache-tomcat-9.0.53/webapps/

		'''
		
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
