FROM maven:3.8.1-openjdk-17-slim
ENV ARTIFACT_NAME=azul-1.0-SNAPSHOT.jar
ENV APP_DIR=/usr/src/myapp/
ENV JAR_PATH=${APP_DIR}target/${ARTIFACT_NAME}
COPY . $APP_DIR
WORKDIR $APP_DIR
RUN mvn install
ENTRYPOINT java -jar ${JAR_PATH} -cli
