FROM openjdk:17-alpine
ENV ARTIFACT_NAME=app.jar
ENV APP_DIR=/usr/src/myapp/
ENV JAR_PATH=${APP_DIR}app/build/libs/${ARTIFACT_NAME}
COPY . $APP_DIR
WORKDIR $APP_DIR
RUN ./gradlew clean build
## Running Azul via the CLI environment.
ENTRYPOINT java -jar ${JAR_PATH} -cli