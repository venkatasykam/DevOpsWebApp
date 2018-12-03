# DevOpsWebApp - AWS Elastic Beanstalk example

* This is very simple and basic Java maven web project **DevOpsWebApp**.
* Web app is going to save the registered user details in the backend database **mySql**.
* Maven build, it will generate a java web archive (.war).
* Create a beanstack for tomcat java web app.
* Accessing the web app in any browser.
* Signup, so that user details should be saved in RDS (mySQL) database.


### Step-1: Clone to your local machine.

    git clone -b jdbc-eb https://github.com/venkatasykam/DevOpsWebApp.git

### Step-2: Maven build - compiling the java code & packaging as war.

    mvn clean package -DskipTests=true -DreleaseVersion=2.0

### Step-3: Create a an application in Elastic Beanstalk.

   3.1. Go to https://console.aws.amazon.com/elasticbeanstalk/
   
   3.2. Click on "Create New Application" and provide the application name & description.
   
   ![image](https://user-images.githubusercontent.com/24622526/49377988-93354480-f731-11e8-8a59-53119b41cf8e.png)

   3.3. Create a new environment.
   
   ![image](https://user-images.githubusercontent.com/24622526/49378339-574eaf00-f732-11e8-8e78-3c8127bfe200.png)

   ![image](https://user-images.githubusercontent.com/24622526/49378371-6b92ac00-f732-11e8-9184-d1e9161e916c.png)

   ![image](https://user-images.githubusercontent.com/24622526/49378426-941aa600-f732-11e8-9a13-c222a4287678.png)

   Choose the platform as Tomcat
   
   ![image](https://user-images.githubusercontent.com/24622526/49378470-adbbed80-f732-11e8-8315-5437b390c981.png)

   Click on upload: Upload the war file and click upload.
   
   ![image](https://user-images.githubusercontent.com/24622526/49378529-d643e780-f732-11e8-8f8c-fb9a2395c071.png)
   
   Click on Create Environment. See the below image, the environment is creating.
   
   ![image](https://user-images.githubusercontent.com/24622526/49378633-1a36ec80-f733-11e8-868c-ea952ff16747.png)


   

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
