# DevOpsWebApp

* This is very simple and basic Java maven web project **DevOpsWebApp**.
* Web app is going to save the registered user details in the backend database **mySql**.
* Building docker images & creating containers using docker stack, docker-compose.

## Build the images from source code using docker compose.

### Step-1: Setup the cluster.
    
   Follow the steps from 1 to 4 https://github.com/DevOpsPlatform/Phase-2/blob/master/Docker/DockerStacks/docker-stack.md.
    
### Step-2: Run maven build

  * Install java, maven, git on ubuntu docker-master machine -- refer [java-maven-git-setup-ubuntu.sh](https://github.com/DevOpsPlatform/Phase-1/blob/master/java-maven-git-setup-ubuntu.sh).
  
  * Clone this current repo into docker manager and run the below goals.
  
  * cd DevOpsWebApp
  
          mvn clean package -DskipTests=true -DreleaseVersion=1.0

### Step-3: Build the docker image.

    Syntax: docker build -t image-name -f ./customDockerfile .
    
    Ex: docker build -t devopswebapp:1.0 -f ./DbWebDockerfile .
    
    docker images
    
    Pusht the image to docker hub
    
### Step-4: Run the docker compose file using docker stack command on manager host.

    docker stack deploy -c docker-compose-devops-web-db.yml devopsweb-mysql

### Step-5: Connect to DB container to check whthert he data stored in db container or not.

    docker exec -it devopsweb-mysql-db-wsfsfgsgfsf bash  # Container name may be different

    mysql -h 127.0.0.1 -P 3306 -uadmin -padmin123 usersdb;

    show tables;
    
    select * from USERS;
    
    Ctrl p + q

### Step-5: Remove the stack

    docker stack rm devopsweb-mysql
