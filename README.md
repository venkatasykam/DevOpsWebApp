# DevOpsWebApp : Only a webapp

mvn -V clean package

mvn clean verify

mvn clean test

mvn clean install

mvn tomcat7:deploy (Make sure tomcat server is online)

mvn checkstyle:checkstyle checkstyle:check

mvn checkstyle:checkstyle checkstyle:check -Dcheckstyle.failOnViolation=false

mvn checkstyle:checkstyle checkstyle:check -Dcheckstyle.failOnError=false

mvn clean install -Pjacoco

clean verify sonar:sonar -Psonar

clean verify sonar:sonar -Psonar,jacoco


Increase Heap size: -Xmx512m -XX:MaxPermSize=512m

### plugins

 mvn clean org.apache.maven.plugins:maven-compiler-plugin:3.1:compile

 mvn clean compile org.apache.maven.plugins:maven-checkstyle-plugin:3.0.0:checkstyle
 
 mvn clean compile org.apache.maven.plugins:maven-checkstyle-plugin:3.0.0:checkstyle org.apache.maven.plugins:maven-checkstyle-plugin:3.0.0:check
 
 mvn clean compile checkstyle:checkstyle checkstyle:check
 
 mvn clean checkstyle:checkstyle checkstyle:check install
 
 jacoco - java code coverage
 
	 class wise
	 
	 method wise
	 
	 line wise
	 
	 block wise

# testing git push - jenkins poll scm

# -------------- Verioning and  Release Process ------ #

	snapshot

	release

	pom - 1.0.0-SNAPSHOT

	DevOpsWebApp-1.0.0-SNAPSHOT.war - Dev
	DevOpsWebApp-1.0.0.war - QA SIT UAT Prod

	Dev QA SIT UAT Prod

	DevOpsWebApp-1.0.0-SNAPSHOT.war - dev --defects
	DevOpsWebApp-1.0.0-SNAPSHOT.war - dev --defects
	DevOpsWebApp-1.0.0-SNAPSHOT.war - dev --defects
	DevOpsWebApp-1.0.0-SNAPSHOT.war - dev --no defects

	DevOpsWebApp-1.0.0.war - QA -- defect
	DevOpsWebApp-1.0.1-SNAPSHOT.war - dev -- no defects
	DevOpsWebApp-1.0.1.war - QA -- defect
	DevOpsWebApp-1.0.2-SNAPSHOT.war - dev -- no defects
	DevOpsWebApp-1.0.2.war - QA -- no defects

	DevOpsWebApp-1.0.2.war - SIT -- defect
	DevOpsWebApp-1.0.3-SNAPSHOT.war - dev -- no defects
	DevOpsWebApp-1.0.3.war - QA -- no defects
	DevOpsWebApp-1.0.3.war - SIT -- defect
	DevOpsWebApp-1.0.4-SNAPSHOT.war - dev -- no defects
	DevOpsWebApp-1.0.4.war - QA -- no defects
	DevOpsWebApp-1.0.4.war - SIT -- defect

	Git Repo: DevOpsWebApp

		branches
		tags

# ----- Maven release plugin execution ----- #

1. clone

-V clean -B release:prepare release:perform -Dtag=${gitBranch}-DevOpsWebApp-${releaseVersion} -DreleaseVersion=${releaseVersion} -DdevelopmentVersion=${nextDevelopmentVersion} -Dusername=${gitUname} -Dpassword=${gitPwd}

2. release:prepare
	update the development version 1.0.0-SNAPSHOT to release version 1.0.0 (using git credentials)
	validate, compile, test, package, verify
	create and push a tag on git repo (using git credentials)
	revert the version from release version 1.0.0 to next development version 1.0.1-SNAPSHOT (using git credentials)
	
	Internally: Maven release plugin verifies the depednencies are released or not. Make sue all the depdencies are releases version. Maven release build will be failed if any of the dependency version is SNAPSHOT. The same thing will be appalicable to maven plugins.

3. release:perform
	checkout the tag
	validate, compile, test, package, verify, install, deploy(to nexus)
