# DevOpsWebApp: VPC example-2

Refer: https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/USER_VPC.Scenarios.html#USER_VPC.Scenario1

* This is very simple and basic Java maven web project **DevOpsWebApp**.
* Web app is going to save the registered user details in the backend database **mySql**.
* Web application will be deployed into **public** EC2 instance.
* DB(MySQL) will be installed into **private** EC2 instance.
* Accessing the web app in any browser.
* Signup.
* Signup details will be saved into the backend database table.

### Step-1: Create VPC with 1 public & 1 private subnet.

### Step-2: Create two Ubuntu EC2 instance.

  * Create two Ubuntu EC2 instances, one for mySQL into private subnet and another one fro web app (tomcat server) into public subnet.
  
  * Connect to the private instance thropugh public instance.

   * MySQL Server installation, refer https://support.rackspace.com/how-to/installing-mysql-server-on-ubuntu/

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
    
   * Connect to mysql server
   
    Syntax: mysql -h <private-IP-Address> -P 3306 -u<username> -p<password> <db-name>;
    
    Ex: mysql -h 10.1.2.184 -P 3306 -uebstack2018 -pebstack2018 ebdb;
    
   Make sure the securoty group open the port number 3306 to public instance.
    
### Step-3: Ubuntu instance for Java Web app

   * **tomcat install**: https://github.com/DevOpsPlatform/Phase-1/blob/master/tomcat9-setup-on-ubuntu.md
   
   * **refer git, maven installtion doc**: https://github.com/DevOpsPlatform/Phase-1/blob/master/java-maven-git-setup-ubuntu.sh
   
   * Update the java file [DockerConnectMySQL.java](src/main/java/DockerConnectMySQL.java) line-8 with DB hostname, dbname.
   * Line 10, 11 will be updated with db username & passowrd.
   
### Step-4: Build and deploy

   * git clone -b jdbc-vpc-example-2 https://github.com/venkatasykam/DevOpsWebApp.git jdbc-vpc-example-2
   
   * cd jdbc-vpc-example-2
   
   * **Build**: mvn clean package -DskipTests=true -DreleaseVersion=1.0
   
   * **Deploy**: cp target/DevOpsWebApp-1.0.war /opt/tomcat/latest/webapps/DevOpsWebApp-1.0.war
   
### Step-5: Launch an website URL in any browser from any machine.

   * URL: http://13.233.8.52:8080/DevOpsWebApp-1.0/
   
   * Signup URL: http://13.233.8.52:8080/DevOpsWebApp-1.0/signup.html
   
   * Provide some details and signup.
   
### Step-6: Connect to the database

   * Run the command
   
      * if you are connecting from the client: `mysql -h 52.66.250.163 -P 3306 -uebstack2018 -pebstack2018 ebdb;`
      
      * if you are connecting from the same server: `mysql -u ebstack2018 -pebstack2018 ebdb;`
      
   * Check the table: `select * from USERS;`
  
  ---
  
  ### **FYI**: history of commands in mysql server
  
  root@mysql-private:~# history
    1  hostname mysql-private
    2  echo "mysql-private" > /etc/hostname
    3  exit
    4  apt-get update -y && apt-get install mysql-server -y
    5  vi /etc/mysql/mysql.conf.d/mysqld.cnf
    6  systemctl restart mysql
    7  clear
    8  systemctl restart mysql
    9  git clone -b jdbc-vpc-example-2 https://github.com/venkatasykam/DevOpsWebApp.git jdbc-vpc-example-2
   10  clear
   11  mysql -u ebstack2018 -pebstack2018 ebdb;
   12  history
root@mysql-private:~#

  
  ### **FYI**: history of commands in devops web app (tomcat) server
  
  root@devops-webapp-public:~/jdbc-vpc-example-2# history
    1  clear
    2  hostname devops-webapp-public
    3  echo "devops-webapp-public" > /etc/hostname
    4  exit
    5  clear
    6  apt-get update && apt-get install mysql-client -y
    7  mysql -h 13.234.4.119 -P 3306 -uebstack2018 -pebstack2018 ebdb;
    8  mysql -h 10.1.2.184 -P 3306 -uebstack2018 -pebstack2018 ebdb;
    9  cleare
   10  clear
   11  sudo apt update && sudo apt install default-jdk -y
   12  wget http://www-eu.apache.org/dist/tomcat/tomcat-9/v9.0.14/bin/apache-tomcat-9.0.14.tar.gz -P /tmp
   13  sudo tar xf /tmp/apache-tomcat-9*.tar.gz -C /opt/tomcat
   14  ls
   15  ll /opt
   16  mkdir /opt/tomcat
   17  sudo useradd -r -m -U -d /opt/tomcat -s /bin/false tomcatsudo useradd -r -m -U -d /opt/tomcat -s /bin/false tomcat
   18  sudo useradd -r -m -U -d /opt/tomcat -s /bin/false tomcat
   19  sudo tar xf /tmp/apache-tomcat-9*.tar.gz -C /opt/tomcat
   20  sudo ln -s /opt/tomcat/apache-tomcat-9.0.14 /opt/tomcat/latest
   21  sudo chown -RH tomcat: /opt/tomcat/latest
   22  sudo chmod o+x /opt/tomcat/latest/bin/
   23  sudo vi /opt/tomcat/latest/conf/tomcat-users.xml
   24  sudo vi /opt/tomcat/latest/webapps/manager/META-INF/context.xml
   25  sh /opt/tomcat/latest/bin/startup.sh
   26  apt-get install -git
   27  apt-get install git -y
   28  #Maven Setup:
   29  echo Maven Setup:
   30  #Download maven:
   31  echo Download maven:
   32  #Unzip tar file
   33  echo Unzip tar file
   34  tar zxpvf apache-maven-3.5.4-bin.tar.gz
   35  vi ~/.profile
   36  source ~/.profile
   37  mvn -v
   38  clear
   39  git clone -b jdbc-vpc-example-2 https://github.com/venkatasykam/DevOpsWebApp.git jdbc-vpc-example-2
   40  cd jdbc-vpc-example-2/
   41  mvn clean package -DskipTests=true -DreleaseVersion=1.0
   42  cp target/DevOpsWebApp-1.0.war /opt/tomcat/latest/webapps/DevOpsWebApp-1.0.war
   43  mysql -h 10.1.2.184 -P 3306 -uebstack2018 -pebstack2018 ebdb;
   44  history
root@devops-webapp-public:~/jdbc-vpc-example-2#

  
  
  

   
   
   
   
   
    
    



















