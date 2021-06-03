# Comic Store

Stores comics and covers.

This is a [Spring](https://spring.io) project bootstrapped with [Spring Boot Initializr](https://start.spring.io).

## Dependencies
- [Java 11 JDK](https://adoptopenjdk.net/)
- A running Postgres database with the schema defined in `./src/schema/schema.sql`
    - See the `./src/main/resources/application.properties` file to see which environment variables can be used to specify database connection details to this application.

## To Run

To run in development-mode, execute the [Maven Wrapper](https://maven.apache.org/) task `spring-boot:run`. Like this:

```bash
./mvnw clean spring-boot:run
```

The results are served at [http://localhost:8080](http://localhost:8080) and "hot-reloading" is enabled (meaning, with certain limitations, changes made to source code can be seen without needing to quit and re-run).

## To Run Tests

```bash
./mvnw clean test
```

## To Build and Deploy

```bash
./mvnw clean install
java -jar [...the jarfile...]
```

See details [here](https://spring.io/blog/2014/03/07/deploying-spring-boot-applications).
>If you use the Maven build ... provided by the Spring Boot Initialzr, you’ll get a fat jar. This jar is handy because it includes all the other dependencies and things like your web server inside the archive. You can give anybody this one .jar and they can run your entire Spring application with no fuss: no build tool required, no setup, no web server configuration, etc: just `java -jar ...your.jar`.

## Code Organization