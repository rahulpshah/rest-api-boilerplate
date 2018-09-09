.PHONY: python golang java

python:
	gunicorn \
		--access-logfile - \
		--chdir python/ \
		app:api

node:
	node node/server.js

java:
	mvn package -f java/pom.xml && java -jar java/target/gs-rest-service-0.1.0.jar

golang:
	go run golang/main.go
