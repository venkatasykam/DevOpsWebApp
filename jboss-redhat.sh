#!/bin/bash

### Download and install JAVA ##

#JAVA Setup
echo JAVA Setup
#download JDK rpm
echo download JDK rpm
wget -c --header "Cookie: oraclelicense=accept-securebackup-cookie" https://download.oracle.com/otn-pub/java/jdk/8u201-b09/42970487e3af4f5aa5bca3f542482c60/jdk-8u201-linux-x64.rpm
#Install RPM
echo Install RPM
rpm -i jdk-8u201-linux-x64.rpm


echo JAVA_HOME=/usr/java/jdk1.8.0_201-amd64 >> ~/.bash_profile # RHEL/Linux machine
source ~/.bash_profile

#Refer the file to install JAVA on ubuntu machines

#Setup Maven
#export JAVA_HOME=/usr/java/jdk1.8.0_201-amd64

export PATH=$JAVA_HOME/bin:$PATH

#Check java
echo Check the java version
java -version

#Java Home path: /usr/java/jdk1.8.0_131
echo Java Home path: $JAVA_HOME


### Download and install Jboss ##

fileid="1orAg2SymZzf_sKmFNbuLeqiaDnkdDPAn"
filename="jboss-eap-7.1.zip"
curl -c ./cookie -s -L "https://drive.google.com/uc?export=download&id=${fileid}" > /dev/null
curl -Lb ./cookie "https://drive.google.com/uc?export=download&confirm=`awk '/download/ {print $NF}' ./cookie`&id=${fileid}" -o ${filename}

yum install unzip -y

unzip jboss-eap-7.1.zip

#export JBOSS_HOME=$HOME/jboss-eap-7.1

echo JBOSS_HOME=$HOME/jboss-eap-7.1 >> ~/.bash_profile # RHEL/Linux machine
source ~/.bash_profile

#add-user.sh

# echo JBOSS_HOME=$HOME/jboss-eap-7.1 >> ~/.profile # ubuntu machines
# source ~/.profile

sed -i "s/127.0.0.1/0.0.0.0/g" $HOME/jboss-eap-7.1/standalone/configuration/standalone.xml

# sh $HOME/jboss-eap-7.1/bin/standalone.sh