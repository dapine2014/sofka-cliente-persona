FROM amazoncorretto:21.0.0

ENV TZ=America/Bogota
VOLUME /tmp
COPY /target/sofka-cliente-persona-0.0.1-SNAPSHOT.jar .
#EXPOSE 31000
#CMD ["java","-jar","locationsApi.jar"]
CMD ["java","-jar","sofka-cliente-persona-0.0.1-SNAPSHOT.jar" ,"--spring.config.name=application-prod"]