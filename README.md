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



