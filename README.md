# UserName List Problem Java Practice MVC, mockito, spring and gson.

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

# Funtional explanation

The App receives a username from the user and it checks in a storage (could be anything DB, dictionary, file, mock
data, etc.. whatever you prefer) if the username is already taken or if is a valid new username.

If the username is valid it returns a success Boolean result if not it returns a False Boolean result with a List of at
least 14 alternate suggested usernames based of the input username string. The alternate usernames List should
be in alphabetical order and also each suggested username should be unique. (e.g: input username is john and
taken, the suggested alternates could be : john1, john2,johnJohn,etc)

There is also a dictionary/list of restricted words which the username should not contain. This dictionary of words
could contain any list of words that we want to exclude from being used in the username. So a username would
fail also if it contains a restricted word and it would also generate the alternate username list from this. (e.g:
possible List : cannabis, abuse, crack, damn, drunk, grass.) The design should allow adding more restricted words
to the list in the future in an easy manner.

The usernames in the suggested alternate list should also be available and should not contain a restricted word.
Hint: The app should try to generate 14 possible usernames from these rules at least three times. It if it is unable
to generate 14 usernames it returns the list with the number it could generate (less than 14).
Example of a possible interface.

Result&lt;Boolean, List&lt;String&gt;&gt; result = checkUsername(String username)
Result contains the Boolean which identifies the result of the operation. TRUE= success: username is valid, FALSE =
fail: username is invalid.
