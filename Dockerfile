FROM openjdk

WORKDIR /app 

COPY target/api-parking-control-0.0.1-SNAPSHOT.jar /app/api-parking-control.jar

ENTRYPOINT ["java", "-jar", "api-parking-control.jar"]

