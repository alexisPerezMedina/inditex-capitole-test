## Test prueba Inditex

## Getting Started

### Requirement

This application requires Java 8 or later.

### Building and running the application

To build the application run this command in the project directory:
```
mvn clean install
```
To start the application run this command:
```
mvn spring-boot:run
```
The endpoints can be accessed on:
```
http://localhost:8099/
```

### Integration with IntelliJ IDEA

After cloning this repository you can import the project into your IDE using the following steps:
```
File > New > Project from Existing Sources > {Choose directory and Maven as Build Tool}
```
To configure the test module if it doesn't work in IntellIJ:

File > Project Structure > Modules > Select 'Test' Folder > Mark as: Tests > Apply > OK

### Integration Test (Inditex test)

Folder: test/com/Inditex/IntegrationTest/Integrationtest.java

### Unit Test 

Folder: test/com/Inditex/UnitTest

