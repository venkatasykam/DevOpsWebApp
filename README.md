# DevOpsWebApp

mvn clean package

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
