# DevOpsWebApp

* This is very simple and basic Java maven web project **DevOpsWebApp**.
* Web app is going to save the registered user details in the backend database **mySql**.
* Building docker images & creating containers using docker-compose.

## Build the images from source code using docker compose.

### Step-1: Run maven build

    mvn clean package -DskipTests=true -DreleaseVersion=1.0

### Step-2: Run docker compose file to build the docker image for this web app & run the containers.
    
    docker-compose -f DB-Docker-compose.yml up -d

    docker ps
    
### Step-3: Launch the URL in amy browser.
    
    http://54.90.161.12:8181/ or http://54.90.161.12:8181/DevOpsWebApp-1.0/ (enter creds 'tomcat' & 's3cret' as uname and pwd if it prompts)
    
    signup to insert a new user record in the backend database.

### Step-4: Connect to DB contaner to see the data in table.

    docker exec -it devops_db bash

    mysql -h 127.0.0.1 -P 3306 -uadmin -padmin123 usersdb;

    show tables;
    
    select * from USERS;
    
    Ctrl p + q

### Step-5: Push the docker image to docker hub.

    docker login (enter the credetials)
    
    docker tag devopswebapp venkatasykam/devopswebapp:1.0-db 
    
        Note: Here you need to specify your docker hub username and repo. Make sure the repo devopswebapp should already exists in dockerhub.
    
    docker push venkatasykam/devopswebapp:1.0-db
    
### Step-6: Remove the container & images from your docker host.

    docker-compose -f DB-Docker-compose.yml down (OR) docker rm $(docker ps -a -q) -f

    docker rmi $(docker images -q) -f
    
## Refer: After the above steps(after pushed the tag to dockerhub) if you want to run these apps anywhere into docker,

   refer [docker-compose-devops-web-db.yml](docker-compose-devops-web-db.yml)

        docker-compose -f docker-compose-devops-web-db.yml up -d
        
   Repeat the above steps 3, 4, 6.
