# DevOpsWebApp : 

1. signinin/signup to redhat (search for redhat jboss in google, you will get a link from google suggestion)

https://www.redhat.com/en/technologies/jboss-middleware/application-platform

2. Products & services --> Jboss Development & management --> RegHat Jboss Enterprise App Platform

4. Downloads --> select the version 7.1 or any version

5. uzip jboss-eap-7.1.0.zip

6. Setup the JBOSS_HOME in environment variables - like C:\Downloads\jboss\jboss-eap-7.1

7. open a command prompt at C:\Downloads\jboss\jboss-eap-7.1\bin

8. run the standalone.bat file

9. Once the server up, you will able to see the below message message in the log

09:51:12,922 INFO  [org.jboss.as] (Controller Boot Thread) WFLYSRV0051: Admin console listening on http://0.0.0.0:9990
09:51:12,923 INFO  [org.jboss.as] (Controller Boot Thread) WFLYSRV0025: JBoss EAP 7.1.0.GA (WildFly Core 3.0.10.Final-redhat-1) started in 31289ms - Started 482 of 711 services (359 services are lazy, passive or on-demand)

10. launch the URL in any browser: http://localhost:9990

11. setup user --> open command prompt at bin directory

	run the bat file add-user.bat
	
	ex: ramkrishna DevOps#123

	roles: admin

12. launch the URL again in the browser: http://localhost:9990, this time it will ask you to entrer login creds.

13. git clone or download a ear app from https://github.com/venkatasykam/DevOpsWebApp

	ex: git clone -b ear-jboss https://github.com/venkatasykam/DevOpsWebApp

14. configure jboss deploy plugin in maven pom.xml and run the command mvn clean install

15. go to http://localhost:9990 --> Deployments --> there you should able to see your app.

16. Run the app : http://localhost:8080/DevOpsWebAppEAR-web

19. After the build, and deploy, go to management console --> Deployments --> there you will see the deployed artifact details.

20. Run the application using the web context(This you can see it in the jboss server log console): 

	URL (as per the above example): http://localhost:8080/simple-ear-web




