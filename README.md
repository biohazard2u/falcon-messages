# Falcon.io Coding Exercise
This is a personal project to practice with the following tecnologies:
	- docker-compose
	- Websockets
	- Postgress
	- Redis

## Solution
 - The main core of the app is a chat coded with websockets.
 - Redis db is used to track all users accesing the chat.
 - Postgress db is used to mantain a backup of all messages

## Running the application
 - download and build the project with maven
 - Start all docker containers with docker-compose up

## Result
### Websockets:
go to: http://localhost:8081/	
### Postgress & redis endpoints:
go to: http://localhost:8081/swagger-ui.html 
