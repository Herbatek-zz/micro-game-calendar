***At this moment only game-service has a docker-compose.yml.***

***To run the game-service:***
- build with gradle **discovery-service** and **gateway-service** by executing command `gradle clean build`
in correct directories
- run `docker-compose up -d` to build images and run them as containers (include cassandra database for game-service)

to fetch users through gateway send request
piotrke/users/{id}