# DevOpsWebApp


    mvn clean package -DskipTests=true -DreleaseVersion=1.0

    docker-compose -f DB-Docker-compose.yml up -d

    docker exec -it db bash

    mysql -h 127.0.0.1 -P 3306 -uadmin -padmin123 usersdb;

    show tables;
    
    docker rm $(docker ps -a -q) -f

    docker rmi $(docker images -q)

