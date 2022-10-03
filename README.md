# DevOpsWebApp : Java webapp

### tested on ubuntu

**Install java**:

```
apt-get update -y && apt-get upgrade -y && apt-get install openjdk-8-jdk -y

java -version
```

**Install Azure CLI**: https://docs.microsoft.com/en-us/cli/azure/ 

```
curl -sL https://aka.ms/InstallAzureCLIDeb | sudo bash

az version
```

**Install maven**: https://maven.apache.org/download.cgi

```
cd /opt

apt-get install unzip -y && wget https://dlcdn.apache.org/maven/maven-3/3.8.6/binaries/apache-maven-3.8.6-bin.zip

M2_HOME='/opt/apache-maven-3.8.6'
PATH="$M2_HOME/bin:$PATH"

mvn -v
```

**Clone and build**: 

```
git clone -b azure-webapp https://github.com/venkatasykam/DevOpsWebApp.git

mvn clean -V -B package -DreleaseVersion=1.0.0
```

**Create azure webapp service**

```
subscription: free trail
app service name: my-maven-webapp-oct-2022
runtime stack: java 8
java webserver stack: apache tomcat 9
region: central us
Sku and size: Basic B1 (100 total ACU, 1.75 GB memory)
```

**deploy**:

```
az login
az account set --subscription dd4206d4-849d-4947-99e4-b679452a0bee
az webapp deploy --resource-group my-lin-rg-03-oct --name my-maven-webapp-oct-2022 --src-path DevOpsWebApp-1.0.war --type war --async true

```
