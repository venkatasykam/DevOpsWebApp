# DevOpsWebApp

* This is the Java maven web project **DevOpsWebApp**.
* Web app is going to save the registered user details in the backend database **mySql**.
* Building docker images using docker file.
* Creating/running containers using docker run command.
* Accessing the web app in any browser.
* Signup.


### Step-1: Maven build - compiling the java code & packaging as war.

    mvn clean package -DskipTests=true -DreleaseVersion=1.0

### Step-2: Docker build - building image from docker file, it copies the war file into tomcat.

    docker build -t devopswebapp:1.0-db -f DbWebDockerfile .

### Step-3: Create the db container first.


  * Create the DB container.

        docker run -d --name db -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=usersdb -e MYSQL_USER=admin -e MYSQL_PASSWORD=admin123 mysql
  
  * (Optional) Connect to the DB container to verify the USERS table exists or not.

        docker exec -it db bash

        mysql -h 127.0.0.1 -P 3306 -uadmin -padmin123 usersdb;

        show tables;

        ctrl p + q

### Step-4: Run the container for web app by linking to DB container.
    
    docker run -d --name devopsweb-db --link db -p 8080:8080 devopswebapp:1.0-db

### Step-5: Launch the URL in amy browser.
    
    http://54.90.161.12:8181/ or http://54.90.161.12:8181/DevOpsWebApp-1.0/ (enter creds 'tomcat' & 's3cret' as uname and pwd if it prompts)
    
    signup to insert a new user record in the backend database.
    
### Step-6: Connect to DB contaner to see the data in table.

    docker exec -it devops_db bash

    mysql -h 127.0.0.1 -P 3306 -uadmin -padmin123 usersdb;

    show tables;
    
    select * from USERS;
    
    Ctrl p + q
    
### Step-7: Remove the container & images from your docker host.

    docker rm $(docker ps -a -q) -f

    docker rmi $(docker images -q) -f
    
   if you want to remove only one
    
    docker rm devopsweb-db -f
    
    docker rmi devopswebapp:1.0-db
