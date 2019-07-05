Feature: greeting end point




Scenario: create a user and then get it by id


  
* def MongoDBExample = Java.type('com.swathi.database.dbmango')
* def result = MongoDBExample.create()
* print 'created id is: ' + result

* match result == {  name : "kavitha" , lastName : "g" , age : 41 }
