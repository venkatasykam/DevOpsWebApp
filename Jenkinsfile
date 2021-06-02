/*
1. Setup Maven path in Manage Jenkins >>  Global Tool Configuration >> under Maven >> 
	Name: maven-3.8.1
	Value: maven home path (ex: /usr/lib/maven/apache-maven-3.8.1)
2. Setup Git path in Manage Jenkins >>  Global Tool Configuration >> under Git >> 
	Name: Default
	Value: Git home path (ex: /usr/bin/git )
3. Make sure jenkins master or node have the lable - build. (OR) update the lable name you want in the below code.
*/

pipeline{
	agent{
		label 'build'
	}
	options{
		disableConcurrentBuilds()
	}
	parameters{
		string(name: 'buildVersion', defaultValue: '1.0.${BUILD_NUMBER}', description: '')
		string(name: 'ServerIP', defaultValue: '', description: '')
	}
	tools{
		maven 'maven-3.8.1' //Make sure this is already configured in Manage Jenkins >> Global Tool Configuration
	}
	environment{
		
		BUILD_VERSION = "${params.buildVersion}"
		
		SERVER_IP = "${params.ServerIP}"
		
	}
	stages {
		stage('Build') {
			steps{
				println scmUrl
				bat"mvn -V -B clean install -DreleaseVersion=${BUILD_VERSION}"
			}
		}
		stage('Deploy') {
			steps{
				println "deploy the package to tomcat server ${SERVER_IP} to run application"
				bat"""
					echo deploy the package to tomcat server ${SERVER_IP} to run application
				"""
				/*
				sh"""
					echo "Removing the existing package from tomcat server"
					ssh ec2-user@$SERVER_IP rm -rf $HOME/tomcat9/webapps/DevOpsWebApp*

					echo "Deploy(copy) war to tomcat server"
					scp target/DevOpsWebApp*.war ec2-user@$SERVER_IP:$HOME/tomcat9/webapps/

				"""
				*/
			}
		}
		
	}
	post {
		failure {
			println 'Sending an email notification about build failures'
			//emailext 
		}
	}
}
