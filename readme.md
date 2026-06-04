# Customer-Accounts Management System (CAMS)

## Overview

Customer-Accounts Management System (CAMS) is a command-line application developed for CS425 Banking Corporation.

The application manages customer account information and supports:

* Displaying all accounts in JSON format
* Sorting accounts by balance in descending order
* Calculating and displaying the bank's Liquidity Position
* Displaying only Platinum-tier accounts

The application uses an in-memory data store and follows a layered architecture consisting of:

* Controller Layer
* Service Layer
* Repository Layer
* In-Memory Database Layer

---

## Runtime Requirements

### Java

This application requires:

```text
Java Development Kit (JDK) 25
```

Verify installation:

```bash
java -version
javac -version
```

### Maven

This application requires:

```text
Apache Maven 3.9+
```

Verify installation:

```bash
mvn -version
```

---

## Build Instructions

Compile and package the application:

```bash
mvn clean package
```

After a successful build, the executable JAR file will be generated in:

```text
target/cams-cli-app-1.0.0.jar
```

---

## Run Instructions

Run the application using:

```bash
java -jar target/cams-cli-app-1.0.0.jar
```

---

## Application Menu

Upon startup, the following menu is displayed:

```text
===== CAMS =====
1. Display All Accounts
2. Display Platinum Accounts
0. Exit
```

### Option 1

Displays:

* All customer accounts
* Associated customer information
* Account tier (Standard, Silver, Gold, Platinum)
* Accounts sorted by balance in descending order
* Bank Liquidity Position

### Option 2

Displays:

* Only Platinum-tier accounts

### Option 0

Exits the application.

---

## Project Structure

```text
src/main/java
│
├── controller
├── service
├── repository
├── database
├── domain
└── App.java
```

---

## Continuous Integration

A GitHub Actions workflow is configured to automatically build the application whenever code is pushed to the repository.

Workflow file:

```text
.github/workflows/build.yml
```

---

## Author

CS425 Banking Corporation – Customer-Accounts Management System (CAMS)
