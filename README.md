### About
---
` REST API for providing costumers of address manipulating services. Spring Security is not implemented for customer sign up & sign in`



### Coded using 
---
* MySQL Driver
* Lombok
* Spring Boot DevTools
* Spring Data Jpa
* Spring Web

### Included Packages
---
1. Controller Package
    * Consisted of Customer & Address Entity contollers
2. Service & Service Implementation Packages
    * Contain Customer & Address service logic interfaces & their implementations
3. Repsoitory Package 
    * Provided with both entities repository interfaces that inherit JpaRepository
4. Model Package
    * For entity classes codes

### Reviewing Some Points
---
* In both Costumer & Address entity classes, both email & name fields (respectively) in database are set to be unique values. 
* Create, Delete, Update & List services are implemented and tested on Postman for both entities
* In servcie implementation classes,  the delete method will return response as string to controller showing whether the sent id belongs to an existing record or not. The message will be shown to user when calling delete service.
* In addition, the update method will throw an exception directly from Exception class's constructor instead of adding new package for NotFoundException class. 
* Controllers points data flowing between user requests and server responses, sending recieved data from user to service layer which in its term process them and send them to repository where they get sent to server.
  
  In other direction data get fetched from server to controller where it get sent to user by the user request to get data. In this way data is getting transfered among layers of the application.
 






