# charter-technical

# Customer Rewards Program - Spring Boot REST API

## Overview
This project implements a customer rewards program where points are awarded based on purchase transactions.  
Customers receive:
- 2 points for every dollar spent over $100
- 1 point for every dollar spent between $50 and $100
Example:  
	$120 purchase = 2 * 20 + 1 * 50 = 90 points

This system calculates monthly reward points per customer over the last three months and provides total rewards for each customer.

## Features
- ✅ RESTful API to fetch reward points per customer.
- ✅ Spring Boot + JPA for seamless database integration (used H2 Database).
- ✅ Global Exception Handling for better error responses.
- ✅ Unit & Integration Tests with negative scenarios.


## Tech Stack
- Spring Boot (REST API)
- Spring Data JPA (Database Access)
- H2 Database (In-memory database)
- JUnit (Unit & Integration Tests)
- Maven (Dependency Management)


---

## API Endpoints
| Method |            Endpoint 	 		|         Description 		   |
|--------|--------------------------------------|----------------------------------|
| GET 	 | {Base Url}/api/v1/reward/{customerId}| Get reward points for a customer |
| POST 	 | {Base Url}/api/v1/reward/purchase	| create purchase   		   |

## Other Details
- Sample data is hadrcoded and written in RewardApplication.java file and It will be created once the application is UP.
- Sample test data also created in the RewardApplication.java file for positive and negative scenario.
