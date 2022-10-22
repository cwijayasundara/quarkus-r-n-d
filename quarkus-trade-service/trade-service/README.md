# trade-service Project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./gradlew quarkusDev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./gradlew build
```
It produces the `quarkus-run.jar` file in the `build/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/quarkus-app/lib/` directory.

The application is now runnable using `java -jar build/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./gradlew build -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar build/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./gradlew build -Dquarkus.package.type=native
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./build/trade-service-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/gradle-tooling.

## Related Guides

- RESTEasy Classic JSON-B ([guide](https://quarkus.io/guides/rest-json)): JSON-B serialization support for RESTEasy Classic

## Provided Code

### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)

### Create the Quarkus project using Maven plugin

mvn -U io.quarkus:quarkus-maven-plugin:create \
-DprojectGroupId=com.cham.quarkus.trading \
-DprojectArtifactId=trade-service \
-DclassName="com.cham.quarkus.trading.TradeResource" \
-Dpath="/api/trades" \
-Dextensions="resteasy-jsonb" \
-DbuildTool=gradle

### Installing and configuring GraalVm

brew install --cask graalvm/tap/graalvm-ce-lts-java11

### If you are using mac of m1 chip
curl -L -o graalvm-ce-java11-darwin-aarch64-22.1.0.tar.gz  https://github.com/graalvm/graalvm-ce-builds/releases/download/vm-22.1.0/graalvm-ce-java11-darwin-aarch64-22.1.0.tar.gz
sudo mv graalvm-ce-java11-22.1.0 /Library/Java/JavaVirtualMachines

### Common steps for both m1 and intel chip
sudo xattr -r -d com.apple.quarantine /Library/Java/JavaVirtualMachines/graalvm-ce-lts-java11/Contents/Home
/Library/Java/JavaVirtualMachines/graalvm-ce-lts-java11/Contents/Home/bin/gu install native-image

### Add the following in ~/.zshrc
export GRAALVM_HOME=/Library/Java/JavaVirtualMachines/graalvm-ce-lts-java11/Contents/Home
export PATH=$PATH:$GRAALVM_HOME
source ~/.zshrc

###  Build using either mvn or gradle
mvn package -Dquarkus.package.type=native
OR
./gradlew build -Dquarkus.package.type=native

###  Build the Docker image
./gradlew build -Dquarkus.container-image.build=true -Dquarkus.package.type=jar -Dquarkus.container-image.tag=jvm

###  Build native image
./gradlew build -Dquarkus.container-image.build=true -Dquarkus.package.type=native -Dquarkus.container-image.tag=native -Dquarkus.native.container-build=true

###  Run the image
docker run -i —rm -p 8080:8080 xxxxxx/rest-book:native

###  Build the Quarkus apps
./gradlew build -Dquarkus.package.type=jar
./gradlew build -Dquarkus.package.type=uber-jar
./gradlew build -Dquarkus.package.type=legacy-jar
./gradlew build -Dquarkus.package.type=native

./gradlew build -Pnative

###  Run the app
./build/trade-service-1.0.0-SNAPSHOT-runner

## native gets deployed in less than a sec
2022-10-22 07:19:23,806 INFO  [io.quarkus] (main) trade-service 1.0.0-SNAPSHOT native (powered by Quarkus 2.13.2.Final) started in 0.177s. Listening on: http://0.0.0.0:8080

##  Creating Docker images: first add the quarkus extention for Docker

./gradlew addExtension --extensions='container-image-docker'

##  build and run the image
./gradlew build -Dquarkus.container-image.build=true -Dquarkus.package.type=jar
./gradlew build -Dquarkus.container-image.build=true -Dquarkus.package.type=legacy-jar
./gradlew build -Dquarkus.container-image.build=true -Dquarkus.package.type=native -Dquarkus.container-image.tag=native -Dquarkus.native.container-build=true

docker run -i --rm -p 8080:8080 xxxx/trade-service:1.0.0-SNAPSHOT
