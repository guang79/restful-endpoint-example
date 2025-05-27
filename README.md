# restful-endpoint-example
RESTful API endpoint


Technologies setup
- Java
- Git
- Maven
- Spring boot
- Flyway


Restful API endpoints
- http://localhost:8000/axaxl/api/department
- http://localhost:8000/axaxl/api/employee


Swagger UI
- http://localhost:8000/axaxl/swagger-ui/index.html#/


H2 database console, it is in memory database
- http://localhost:8000/axaxl/h2-console


Flyway schema history checking
- select * from "PUBLIC"."flyway_schema_history"
- select * from department
- select * from employee


Maven commands
- mvn clean install
- mvn spring-boot:run


Employee Json Test Data
{
"firstName": "Henry",
"lastName": "Lin",
"phoneNumber": "444-444-4444",
"email": "henrylin@axaxl.com",
"salary": 1000.00,
"departmentId": 100,
"jobTitle": "Senior Software Engineer"
}