# Spring Boot Routing Service

This project provides a RESTful API that calculates the optimal route based on available transfers and a maximum weight constraint. The service utilizes a strategy pattern to choose between dynamic programming and recursion for route calculation, optimizing for performance.

---

## Features

- Dynamic route calculation based on constraints.
- Strategy pattern for optimized performance.
- RESTful API with JSON request and response handling.

---

## API Documentation

### Endpoint: `/getRoute`

#### Description

The `/getRoute` endpoint accepts a JSON payload with the following fields:
- **`maxWeight`**: The maximum allowable weight (integer).
- **`availableTransfers`**: A list of transfers, each with fields such as `weight` and other custom attributes.

It returns the selected transfers, total weight, and total cost.

---

## Running Application
### Prerequisites
- Java 21 or later
- Maven 3.6+
- Spring Boot 3.x


### Steps to Run
1. Clone the repository:
```
git clone https://github.com/dtkav22/Cheapest-Transfer-Route.git
```
2. Build the Project
```bash
    mvn clean install
```
3. Run the Application:
```
    mvn spring-boot:run
```
---

### Request

**Method:** `POST`  
**URL:** `http://localhost:8080/getRoute`

```curl
curl -X POST http://localhost:8080/getRoute \
-H "Content-Type: application/json" \
-d '{
  "maxWeight": 15,
  "availableTransfers": [
    { "weight": 5, "cost": 10 },
    { "weight": 10, "cost": 20 },
    { "weight": 3, "cost": 5 },
    { "weight": 8, "cost": 15 }
  ]
}'
```