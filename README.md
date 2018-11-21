# DevOpsWebApp

mvn clean package -DskipTests=true 

docker run -d --name db -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=usersdb -e MYSQL_USER=admin -e MYSQL_PASSWORD=admin123 mysql

docker exec -it db bash

mysql -h 127.0.0.1 -P 3306 -uadmin -padmin123 usersdb

docker run --name devopswebdb-link --link db -p 8080:8080 devopswebdb:1.0 -d
