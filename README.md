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

    mvn clean package -DskipTests=true -DreleaseVersion=5.0

### Step-3: Create a an application in Elastic Beanstalk.

   3.1. Go to https://console.aws.amazon.com/elasticbeanstalk/
   
   3.2. Click on "Create New Application" and provide the application name & description.
   
   ![image](https://user-images.githubusercontent.com/24622526/49377988-93354480-f731-11e8-8a59-53119b41cf8e.png)

   3.3. Create a new environment.
   
   ![image](https://user-images.githubusercontent.com/24622526/49378339-574eaf00-f732-11e8-8e78-3c8127bfe200.png)

   ![image](https://user-images.githubusercontent.com/24622526/49378371-6b92ac00-f732-11e8-9184-d1e9161e916c.png)

   ![image](https://user-images.githubusercontent.com/24622526/49378426-941aa600-f732-11e8-9a13-c222a4287678.png)

   3.4. Choose the platform as Tomcat
   
   ![image](https://user-images.githubusercontent.com/24622526/49378470-adbbed80-f732-11e8-8315-5437b390c981.png)

   3.5. Click on upload: Upload the war file and click upload.
   
   ![image](https://user-images.githubusercontent.com/24622526/49378529-d643e780-f732-11e8-8f8c-fb9a2395c071.png)
   
   3.6. Click on Create Environment to create env with default values (OR) customise the configuration. See the below image, the environment is creating. Part of this, it will create Security group, Elastic IP, Autoscaling, EC2 instance etc
   
   ![image](https://user-images.githubusercontent.com/24622526/49378633-1a36ec80-f733-11e8-868c-ea952ff16747.png)
   
   This will take few mins to complete.
   
   3.7. Access the application in browser. Click on the application url which is circled as shown in below image.
   
   ![image](https://user-images.githubusercontent.com/24622526/49378878-c4167900-f733-11e8-9f8d-8da9aec8ba44.png)
   
   ![image](https://user-images.githubusercontent.com/24622526/49378964-08a21480-f734-11e8-944d-c92a4e417c74.png)


### Step-4: Create RDS (mySQL) batabase.

   Go to https://console.aws.amazon.com/rds/, and create a database with default free tire options. 
   
   Note down the below details & connect to DB and create a table.
   
        Endpoint: usersdb.endpointname

        uname/pwd: admin123

        dbname: usersdb

        port: 3306

        mysql -h usersdb.endpointname -P 3306 -uUSERNAME -pPWD DB_NAME;
        
        CREATE TABLE USERS (uname VARCHAR(30) not NULL, firstname VARCHAR(255), lastname VARCHAR(255), password VARCHAR(8), PRIMARY KEY ( uname ))

  ![image](https://user-images.githubusercontent.com/24622526/49379877-4f910980-f736-11e8-97fb-5718e8569011.png)


### Step-5: Configure DB details as environemnt variables.

   5.1. Go to https://console.aws.amazon.com/elasticbeanstalk/
   
   5.2. Select your application.
   
   ![image](https://user-images.githubusercontent.com/24622526/49379430-1b691900-f735-11e8-9d46-6f364404e5b0.png)


   5.3. Go to **Configuration**.
   
   5.4. Modify the configuration of **Software**.
   
   ![image](https://user-images.githubusercontent.com/24622526/49379517-4b182100-f735-11e8-91eb-e0d44625d61c.png)
   
   5.5. Configure the environment variables https://docs.aws.amazon.com/elasticbeanstalk/latest/dg/java-rds.html#java-rds-tomcat
   
   ![image](https://user-images.githubusercontent.com/24622526/49379649-95999d80-f735-11e8-9d26-66b2882bfdb8.png)
   
        RDS_HOSTNAME: usersdb.endpointname

        RDS_USERNAME: admin123
        
        RDS_PASSWORD: admin123

        RDS_DB_NAME: usersdb

        RDS_PORT: 3306

   ![image](https://user-images.githubusercontent.com/24622526/49379946-78190380-f736-11e8-94f2-45a7d9242094.png)
   
   Click on Apply, this will take few mins to complete.
   
   ![image](https://user-images.githubusercontent.com/24622526/49380022-a696de80-f736-11e8-8848-d1f1fb99c79a.png)

### Step-6: Register User details and check the databse.

   Make sure the EC2 instance securoty group added a rule as to open the port at 3306.
   
   
   ![image](https://user-images.githubusercontent.com/24622526/49380244-35a3f680-f737-11e8-97df-65d08d153356.png)

   ![image](https://user-images.githubusercontent.com/24622526/49380263-43597c00-f737-11e8-9209-deaf2073bdaf.png)
   
   ![image](https://user-images.githubusercontent.com/24622526/49380434-b19e3e80-f737-11e8-86c9-6f1d8216f392.png)





    
   

