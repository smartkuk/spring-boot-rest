# sample spring-boot

## Build

* gradle build

    ```sh
    ./gradlew clean build
    ```

    Or

    ```sh
    ./gradlew clean build bootBuildImage --imageName=spring-boot-rest:latest
    ```

    

* Only docker build

    ```sh
    docker build --build-arg JAR_FILE=./build/libs/spring-boot-rest-0.0.1-SNAPSHOT.jar -t spring-boot-rest .
    ```

## Run

* Run with jar

    ```sh
    java -jar build/libs/spring-boot-rest-0.0.1-SNAPSHOT.jar
    ```

* Run with docker container

    ```sh
    docker run --name spring-boot-rest -t -d -p 8080:8080 spring-boot-rest:latest
    ```

    If you want to run by injecting environment variables...

    ```sh
    APP_PORT=8090
    docker run --name spring-boot-rest -t -d -p 8080:${APP_PORT} -e APP_PORT=${APP_PORT} spring-boot-rest:latest
    ```

* ENV list

    |Name|Description|
    |:---|:---|
    |APP_NAME|Name of application|
    |APP_PORT|spring boot server port number(default: 8080)|
    |APP_LEVEL|com.smartkuk log level(default: debug)|
    |ROOT_LEVEL|root log level(default: info)|

## Push public registry

* Tagging

    ```sh
    docker tag spring-boot-rest:latest smartkuk/spring-boot-rest:latest
    ```

    > The smartkuk is my group. Maybe you need change your group.

* Push

    ```sh
    docker push smartkuk/spring-boot-rest:latest
    ```
