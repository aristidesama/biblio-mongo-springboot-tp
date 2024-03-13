# Java SPRING-BOOT Rest Api communicating with mongodb

## This project is a Java Spring Boot Rest Api built with gradle. It communicates with a bibliTp mongodb database to perform CRUD operations.

## Steps to test .jar api


* Install jdk 17 or above and configure your JAVA_HOME.
...
* Then test your java installation with next command :

> java -version
java version "17.0.10" 2024-01-16 LTS
Java(TM) SE Runtime Environment (build 17.0.10+11-LTS-240)
Java HotSpot(TM) 64-Bit Server VM (build 17.0.10+11-LTS-240, mixed mode, sharing)

> javac -version
javac 17.0.10

* Download the backup_biblioTp\export folder up here, to find the exports of the collections of your mongodb biblioTp database.
> mongoimport --db biblioTp --collection emprunt --file emprunt.json --jsonArray 
> mongoimport --db biblioTp --collection livre --file livre.json --jsonArray
> mongoimport --db biblioTp --collection auteur --file auteur.json --jsonArray

* Fire the mongodb shell command to script some mongodb command.
> mongosh

* From here you are on mongodb shell prompt
> use biblioTp

> db.createUser({ user: "root",pwd:  "root", roles: [ { role: "readWrite", db: "biblioTp" }]})

## Next step is to download the file "biblioapp-0.0.1-SNAPSHOT.jar" from this github root repository to your local computer.

* Back to your operating system shell prompt

> java -jar biblioapp-0.0.1-SNAPSHOT.jar

## From this time onward you can open your Postman and go to http://127.0.0.1:8080/

* Then follow  instructions bit by bit, with the help of the CRUD exercise and testrun this Api.
