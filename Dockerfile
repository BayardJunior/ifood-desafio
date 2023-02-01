FROM maven:3.8.2-jdk-11

WORKDIR /ifood-restaurant-services

COPY . .

RUN mvn clean install

CMD mvn spring-boot:run

#ENTRYPOINT ["java", "-Xdebug", "-Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=*:5005", "-jar", "/caas-file-upload-services-0.0.1-SNAPSHOT.jar"]