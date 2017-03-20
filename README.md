# Intertec-test-java-developer
Intertec test java developer

This application was developed using intellij, gradle,gson, mockito, git and the java 8 version.
 
 Mode To Use
 
 Make sure you have installed gradle in you machine, if you are not sure follow the gradle documentation: https://docs.gradle.org/current/userguide/installation.html
 
 Make sure too that you have installed the java 8 version: Follow the next link:
 
https://docs.oracle.com/cd/E19182-01/820-7851/inst_cli_jdk_javahome_t/

How to deploy the application at the firts time:
 
  Open a git console and text the comands:
  
  gradlew clean build
  
  gradlew clean idea
 
The list of restricted words was taken from: https://gist.github.com/jamiew/1112488

The application is using txt files to the current data with the application works.

The application has a list of existing userNames in the file: \src\main\resources\inputFiles\usernamesStored.txt
and a list of restricetd words in the file:\src\main\resources\inputFiles\restrictedUserNames.txt

You can modify the stored type and then you have to modify the DaoImplementations classes according of the data Sotored type you choosed: database, json Files, xml etc. 
