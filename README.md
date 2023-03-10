# BE-Got-JavaApi

This repo is for setting up a Spring Boot Java API server with the following routes available,

All your routes should follow RESTFUL principles and your server should implement the MVC pattern. All your routes should handle errors using 'next', and send the correct status code and error message dependant on the error.

```
The ability to get all houses (done)
The ability to get a house by id (done)
The ability to add a house (done)
The ability to delete a house (done)
The ability to get all people (done)
The ability to get a person by id (done)
The ability to add a person (done)
The ability to get all people who pass a certain criteria (using queries). The queries should be available for 'dead' and 'religion' e.g. /people?dead=true
(partially done - I've only just figured out how to use hibernate to seed data)
The ability to change a character's record to mark them as dead/alive (it happens a lot in Game of Thrones so we should make it easy on our wiki!)
The ability to get all people for a particular house
The ability to get all religions
The ability to add a religion
The ability to get all religions for a particular house
```

Any data held will be stored on an SQL database using MySql. This repo will also include unit tests for all paths created.