# DevOpsWebApp


    mvn clean package -DskipTests=true -DreleaseVersion=1.0
    
    docker-compose -f DB-Docker-compose.yml up -d

    docker ps
    
    http://54.90.161.12:8181/ or http://54.90.161.12:8181/DevOpsWebApp-1.0/ (enter creds 'tomcat' & 's3cret' as uname and pwd if it prompts)
   
    docker exec -it devops_db bash

    mysql -h 127.0.0.1 -P 3306 -uadmin -padmin123 usersdb;

    show tables;
    
    select * from USERS;
    
    docker rm $(docker ps -a -q) -f

    docker rmi $(docker images -q)

