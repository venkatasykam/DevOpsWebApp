# DevOpsWebApp: VPC example

Refer: https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_VPC.Scenarios.html#USER_VPC.Scenario1

* This is very simple and basic Java maven web project **DevOpsWebApp**.
* Web app is going to save the registered user details in the backend database **mySql**.
* Web application will be deployed into public EC2 instance.
* RDS - MySQL db private instance will be created.
* Accessing the web app in any browser.
* Signup.

### Step-1: Create VPC with two subnets (One public and one private subnets).

### Step-2: Create subnet group in RDS.

   * Goto https://console.aws.amazon.com/rds/
   
   * Subnets --> Create DB Subnet --> Add the private subnet as a DB subnet --> Create.
   
### Step-3: Create MySQL db with efault values and choose the custom VPC (that you created in step-1).

### Step-4: After the DB instance created, 

   * Update the java file [DockerConnectMySQL.java](src/main/java/DockerConnectMySQL.java) line-8 with DB endpoint, dbname.
   * Line 10, 11 will be updated with db username & passowrd.
   * Note down the endpoint, dbname, db username & passowrd.
   
### Step-5: Create a public instance, and install tomcat, git, maven.

   * **refer git, maven installtion doc**: https://github.com/DevOpsPlatform/Phase-1/blob/master/java-maven-git-setup-ubuntu.sh
   
   * **tomcat install**: https://github.com/DevOpsPlatform/Phase-1/blob/master/tomcat9-setup-on-ubuntu.md.
   
   * git clone -b jdbc-vpc https://github.com/venkatasykam/DevOpsWebApp.git jdbc-vpc
   
   * cd jdbc-vpc
   
   * **Build**: mvn clean package -DskipTests=true -DreleaseVersion=1.0

### Step-6: Deploy the package to tomcat

   * cp jdbc-vpc/target/DevOpsWebApp-1.0.war /opt/tomcat/latest/webapps/DevOpsWebApp-1.0.war

### Step-7: Connect to the DB instance to verify the USERS table exists or not.

   * Install my sql client on ubuntu: `apt-get update -y && apt-get install mysql-client -y`

   * Syntax: `mysql -h [Endpoint] -P 3306 -u[username] -p[password] [dbname];` (as you noted in **Step-4**)
   
   * Example: mysql -h ebdb.cj2rewrwrf4bkj.us-east-1.rds.amazonaws.com -P 3306 -uebstack2018 -pebstack2018 ebdb;

            show tables;

            ctrl p + q
        
   * If `USERS` table, doest not exists, create it.
        
            CREATE TABLE USERS (uname VARCHAR(30) not NULL, firstname VARCHAR(255), lastname VARCHAR(255), password VARCHAR(8), PRIMARY KEY ( uname ));

### Step-8: Launch the URL in amy browser.
    
    http://54.90.161.12:8080/ or http://54.90.161.12:8080/DevOpsWebApp-1.0/ (enter creds 'admin' & 'admin_password' as uname and pwd if it prompts)
    
    signup to insert a new user record in the backend database.
    
### Step-6: Connect to DB contaner to see the data in table.

    mysql -h ebdb.cj2rewrwrf4bkj.us-east-1.rds.amazonaws.com -P 3306 -uebstack2018 -pebstack2018 ebdb;
    show tables;
    
    select * from USERS;
    
    Ctrl p + q
