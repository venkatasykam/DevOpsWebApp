# DevOpsWebApp: EC2 example (Java web -- DB )

Refer: https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_VPC.Scenarios.html#USER_VPC.Scenario1

* This is very simple and basic Java maven web project **DevOpsWebApp**.
* Web app is going to save the registered user details in the backend database **mySql**.
* Web application will be deployed into EC2 instance.
* DB(MySQL) will be installed into another EC2 instance.
* Accessing the web app in any browser.
* Signup.
* Signup details will be saved into the backend database table.

### Step-1: Create an Ubuntu EC2 instance for mySQL.

   * Server installation, refer https://support.rackspace.com/how-to/installing-mysql-server-on-ubuntu/

    apt-get update -y && apt-get install mysql-server -y
    
   * Connect to the server
   
    /usr/bin/mysql -u root -p  
    
    Or
    
    mysql -u root -p
    
    Press Enter without entering the password.
    
   * Create user
   
    Syntax: CREATE USER 'username'@'%' IDENTIFIED BY 'password';
    
    Ex: CREATE USER 'ebstack2018'@'%' IDENTIFIED BY 'ebstack2018';    
    
   * Grant all access to the user
    
    Ex: GRANT ALL PRIVILEGES ON *.* TO 'ebstack2018'@'%' WITH GRANT OPTION;
    
   * Create database & use it
   
    Syntax: CREATE DATABASE dbname;
    
    ex: CREATE DATABASE ebdb;
    
    USE ebdb;
    
   * Create table
   
    CREATE TABLE USERS (uname VARCHAR(30) not NULL, firstname VARCHAR(255), lastname VARCHAR(255), password VARCHAR(8), PRIMARY KEY ( uname ));

   * exit from mysql command mode
   
    \q
    
   * Update the bind address 
   
    vi /etc/mysql/mysql.conf.d/mysqld.cnf
    
    change from
    
      bind-address            = 127.0.0.1
    
    to
    
      bind-address            = 0.0.0.0
      
   * restart the mysql server
   
    systemctl restart mysql
     
     
### Step-2(Optional): Try to connect mysql server from other instance.

   * Launch an Ubuntu EC2 instance and install mysql cleint to check the myusql server connecting from other instance or not.
   
    apt-get update && apt-get install mysql-client -y
    
   * 
   
    
    



















