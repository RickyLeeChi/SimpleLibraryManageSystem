# Simple Library Management System

A simplified version of a library management system.

## IDE
- Eclipse

## Requirements

For building and running the application you need:

- [JDK 1.17](https://www.oracle.com/tw/java/technologies/downloads/#java17)
- [Maven 3](https://maven.apache.org)

## Dependencies
 Spring Boot, Spring Data JPA, SQLite(as simple database for the application)

## Running the application locally

Excutable JAR has been created in target folder.
Download the project, then we can execute the following command to start the application.

```shell
java -jar target/*.jar
```

##Scenario Sample (Add Books to Library, Checkout Book, Return Book, List Available Books)

```shell
Welcome to Library Management System.
Please enter your operation : 
# ADD_BOOK 001 "The Great Gatsby" "F. Scott Fitzgerald" 3
# ADD_BOOK 002 "1984" "George Orwell" 2
# CHECKOUT_BOOK 001
Checked out [The Great Gatsby]
# RETURN_BOOK 001
Returned [The Great Gatsby]
# LIST_AVAILABLE_BOOKS
1984 by George Orwell - 2 available
The Great Gatsby by F. Scott Fitzgerald - 3 available
# exit
# Thank you. Bye Bye.
```
