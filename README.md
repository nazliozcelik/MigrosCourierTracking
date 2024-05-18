## Courier Tracking Application For Migros Case Study
********

**Description** 

This is a Spring Boot application for tracking the locations of couriers.  

 

You can access the Github repository on: https://github.com/nazliozcelik/MigrosCourierTracking 
 
 

**How to Run** 

 

1. Clone the repository via below link. 

    https://github.com/nazliozcelik/MigrosCourierTracking.git  

 

2. Navigate to the project directory.  

 

3. Run the application using the command: 

	./mvnw spring-boot:run 

 

4. Access the Swagger UI at: 

 ` http://localhost:8080/swagger-ui/index.html#/` 

 

## API Endpoints 

- **POST /api/couriers/location**: Update courier location.  

- **GET /api/couriers/{courierId}/distance**: Get total travel distance for a courier.  

 

  

 

### Update Courier Location  

 

- **URL:** `/api/couriers/locations`  

- **Method:** `POST`  

- **Request Body:**   

{  

"courierId": "courier1", 

"latitude": 40.0,  

"longitude": 29.0,  

"timestamp": "2024-05-16T14:00:00"  

}

### Get Total Travel Distance  

- **URL:** `/api/couriers/{courierId}/total-distance`  

- **Method:** `GET` 

 

## Requirements 

- Java 17  

- MySQL Database  

- Maven 
 

## Design Patterns 

 

**Mapper Pattern**: Used to map between DTO and entity objects using MapStruct. 

**Service Layer Pattern**: Encapsulates business logic in service classes. 
