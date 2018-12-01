# DevOpsWebApp: 

* This is very simple and basic Java maven web project **DevOpsWebApp**.
* Web app is going to save the registered user details in the backend database **mySql**.
* Building docker images & creating containers using docker stack, docker-compose.

## Build the images from source code using docker compose.

### Step-1: Setup the cluster.
    
   Follow the steps from 1 to 4 [docker-stack](https://github.com/DevOpsPlatform/Phase-2/blob/master/Docker/DockerStacks/docker-stack.md)
    
    
   You can directly run Step-4(below) as one of my image already exists. If you want to build your own image and push to your account, then follow the below steps-2,3.
   
### Step-2: Run maven build

  * Install java, maven, git on ubuntu docker-master machine -- refer [java-maven-git-setup-ubuntu.sh](https://github.com/DevOpsPlatform/Phase-1/blob/master/java-maven-git-setup-ubuntu.sh).
  
  * Clone this current repo into docker manager and run the below goals.
  
  * cd DevOpsWebApp
  
        mvn clean install -DreleaseVersion=2.0-stack -Dmaven.test.skip=true

### Step-3: Build the docker image.

    Syntax: docker build -t image-name -f ./customDockerfile .
    
    Ex: docker build -t devopswebapp:2.0-stack -f ./DbWebDockerfile .
    
    docker images
    
Push the image to docker hub: refer: https://github.com/DevOpsPlatform/Phase-2/blob/master/Docker/DockerEngine/3.DokcerHub.md
    
    * update the image details in docker-compose-devops-web-db.yml file if you specify the different name.
    
### Step-4: Run the docker compose file using docker stack command on manager host.

    env DB_HOST=devops_db docker stack deploy -c docker-compose-devops-web-db.yml devops


![image](https://user-images.githubusercontent.com/24622526/49324384-595a1780-f552-11e8-96f0-3901610f2e18.png)


![image](https://user-images.githubusercontent.com/24622526/49324378-48a9a180-f552-11e8-9c65-bd7725cad4c7.png)


### Step-5: Connect to DB container to check whthert he data stored in db container or not.

    docker exec -it devops_db.1.4y65r5fzv19l6f5sacjnegr27 bash  # Container ID/name may be different in your case

    mysql -h 127.0.0.1 -P 3306 -uadmin -padmin123 usersdb;

    show tables;
    
    select * from USERS;
    
    Ctrl p + q

![image](https://user-images.githubusercontent.com/24622526/49324372-2c0d6980-f552-11e8-88a5-e99eeb882abb.png)


### Step-5: Remove the stack

    docker stack rm devopsweb-mysql
