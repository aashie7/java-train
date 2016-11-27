# java-train


Java service to fetch trains with given parameter



Databas: mysql
-----------------------------------------------------------
run this command

mysql -u root -p IRCTC < dbScript.txt

enter password when prompted
-----------------------------------------------------------
Unzip project and run on command prompt
mvn clean install
then mvn jetty:run

then open browser and hit the service

service url: http://127.0.0.1:8080/trains/rest/trains?source=Bhopal&destination=New Delhi&date=2016-12-02

parameters:-
source:New Delhi/Mumbai/Kolkatta/Pune/Bhopal
destination:New Delhi/Mumbai/Kolkatta/Pune/Bhopal
date:any date between 2016-11-28 and 2016-12-05
