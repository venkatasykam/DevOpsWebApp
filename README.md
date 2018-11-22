# DevOpsWebApp


docker run -d --name db -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=usersdb -e MYSQL_USER=admin -e MYSQL_PASSWORD=admin123 mysql

docker exec -it db bash

mysql -h 127.0.0.1 -P 3306 -uadmin -padmin123 usersdb;

show tables;

mvn clean package -DskipTests=true -DreleaseVersion=1.0

docker build -t devopswebapp:1.0-db -f DbWebDockerfile .

docker run -d --name devopsweb-db --link db -p 8080:8080 devopswebapp:1.0-db

docker rm $(docker ps -a -q) -f

docker rmi $(docker images -q)
