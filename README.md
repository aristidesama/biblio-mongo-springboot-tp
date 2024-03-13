# School exam : Java SPRING-BOOT Rest Api communicating with mongodb biblioTp

## Steps to test .jar api


* Installer au prealable la >= jdk 17. en et configurer le JAVA_HOME.
...
* Puis tester les commandes java suivant. Et si elle fonctionne, poursuivre.
>java -version
java version "17.0.10" 2024-01-16 LTS
Java(TM) SE Runtime Environment (build 17.0.10+11-LTS-240)
Java HotSpot(TM) 64-Bit Server VM (build 17.0.10+11-LTS-240, mixed mode, sharing)

>javac -version
javac 17.0.10


>mongoimport --db biblioTp --collection emprunt --file emprunt.json --jsonArray 
>mongoimport --db biblioTp --collection livre --file livre.json --jsonArray
>mongoimport --db biblioTp --collection auteur --file auteur.json --jsonArray

>mongosh

>use biblioTp

>db.createUser({ user: "root",pwd:  "root", roles: [ { role: "readWrite", db: "biblioTp" }]})

>java -jar biblioapp-0.0.1-SNAPSHOT.jar

