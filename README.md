####################################
#### Falcon.io Coding Exercise  ####
####################################
This task is meant to verify the candidate’s understanding of different concepts (REST, Messaging, Websockets) 
and show the pragmatic approach the candidate has in delivering software solutions. 
The completion is estimated to 20 hours of work, and we expect to have a working submission within a week from you start.
 
The deliverable is two part:
1. Access to a github repository containing your solution for us to review.
2. Either a fully running solution on an AWS instance(Ubuntu) OR a Docker-compose setup and configuration for running the 
solution locally (preferred).

The task is to implement a data processing pipeline in the cloud.
Set up a running environment aligned with the technologies mentioned below
A Readme file containing information you deem useful for someone getting to know your code and want to try the system out
Develop the application in Java 8, using either DropWizard or Spring Boot as the foundation
A REST endpoint is taking a dummy JSON input, and the server puts the REST payload on Redis or another tool you think is well suited for the task
A Consumer is running in the application, taking the freshly received message and persists it in a database of your choice
A REST endpoint is implemented for retrieving all the messages persisted in JSON format from the database
The message should also be pushed through Websockets for listening browser clients at the time the message was received on the REST endpoint
A simple HTML page is implemented to show the real time message delivery
Please setup a github repository to host the code and share it with your final note for review

We're looking for that:
All tasks are solved in the solution
The application has a solid commit history
The application is built with scalability and maintainability in mind
The application is built for testability, demonstrated by actual tests
Your solution reflects a sense of quality you would be confident in releasing to production
Documentation is applied to code / repository describing intent and purpose, as well as complicated / non obvious choices in the implementation



################################
### Running the application  ###
################################
This is an Springboot application - REST microservice.
 - To build the application do: mvn clean install
 - To run the application do: mvn spring-boot:run
 - The app has been set with swagger, to try the app just go to: http://localhost:8081/falcon-message-service/swagger-ui.html
 	JSON examples can be seen in swagger.
 - Library used is: api.ideal-postcodes.co.uk
 	
 
 
 
################
### Example  ###
################
 
REQUEST:
	http://localhost:8080/postcode?postcode=W6%200LG
	
RESPONSE:
	{
		"address": "5-17 Hammersmith Grove"
	}
