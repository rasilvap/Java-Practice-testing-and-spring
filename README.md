# Intertec-test-java-developer
Intertec test java developer

This application was developed using intellij, gradle,gson, mockito,java swing,spring, git and the java 8 version.
 
Mode To Use
 
Make sure you have installed gradle in you machine, if you are not sure follow the gradle documentation: https://docs.gradle.org/current/userguide/installation.html
 
Make sure too that you have installed the java 8 version: Follow the next link:
 
https://docs.oracle.com/cd/E19182-01/820-7851/inst_cli_jdk_javahome_t/

How to deploy the application at the firts time:
 
Move to the master branch of the project, if you are not in there. You have to see the your root project/userNameValidations (master)

Put the command: gradle clean build.
 
Then refresh you dependencies,  go to project in your Id and refresh the project.
 
The list of restricted words was taken from: https://gist.github.com/jamiew/1112488

The application is using txt files to the current data with the application works.

The application has a list of existing userNames in the file: \src\main\resources\inputFiles\usernamesStored.txt
and a list of restricetd words in the file:\src\main\resources\inputFiles\restrictedUserNames.txt

You can modify the stored type and then you have to modify the DaoImplementations classes according of the data Sotored type you choosed: database, json Files, xml etc. 
