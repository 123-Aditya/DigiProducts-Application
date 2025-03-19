# DigiProducts-Application

Microservices application built using Spring Boot

High level diagram:


<img width="1204" alt="Screenshot 2024-11-03 at 5 42 33 PM" src="https://github.com/user-attachments/assets/770ed49f-0044-457d-82d2-c4c73cf056ac" />



As part of this project, I have covered the below implementations:

1. Built 3 microservices - ProductService, OrderService and Inventory Service
   

<img width="1470" alt="Screenshot 2024-11-03 at 5 33 53 PM" src="https://github.com/user-attachments/assets/2e93bd39-219f-44dc-aff0-0f1aae4cefc3" />



2. MongoDB - using Docker container

3. MySQL - using Docker container

4. Spring Data JPA

5. REST APIs

6. Flyway for DB migration

7. Integration Tests for each microservice

8. Spring Cloud OpenFeign - for REST calls from OrderService to InventoryService (OpenFeign is not being updated anymore, so later in project refactoring is done to remove it, and "REST Clients" is used instead)


<img width="1458" alt="Screenshot 2025-01-04 at 12 01 25 PM" src="https://github.com/user-attachments/assets/37ed527c-49c4-42f3-9ec5-5efabe0c18e3" />



9. WireMock - to test the external API communication in Integration test (as APIs can be paid and we don't want to hit paid requests each time we run Integration tests!)


<img width="1458" alt="Screenshot 2025-01-04 at 11 03 20 AM" src="https://github.com/user-attachments/assets/b3da9d6b-03a4-4641-9366-c560b560ae7d" />



10. Spring Cloud Gateway - API Gateway


<img width="1464" alt="Screenshot 2025-01-04 at 12 04 03 PM" src="https://github.com/user-attachments/assets/89425f7b-333c-4bdd-ab4a-799ae81f08bc" />



11. Keycloak authentication


<img width="1465" alt="Screenshot 2025-01-11 at 4 17 02 PM" src="https://github.com/user-attachments/assets/8eda724c-f066-4882-9ebe-4a9b177fcc40" />



12. Circuit Breaker using Resilience4j


<img width="1464" alt="Screenshot 2025-02-16 at 8 07 02 PM" src="https://github.com/user-attachments/assets/d70964f3-bd35-4e7f-952a-358ec4b79392" />


<img width="1116" alt="Screenshot 2025-03-10 at 6 10 33 PM" src="https://github.com/user-attachments/assets/a9e3de56-7a82-4bd6-89ee-5ea07bf297a4" />


13. Implementing Frontend using Angular

<img width="1465" alt="Screenshot 2025-03-18 at 6 11 35 PM" src="https://github.com/user-attachments/assets/50f31460-378f-4393-ad8e-013994070681" />

Sign in using KeyCloak:

<img width="1460" alt="Screenshot 2025-03-18 at 6 11 42 PM" src="https://github.com/user-attachments/assets/618336ba-a8fc-47ba-aa82-1df0238d2c13" />

<img width="1465" alt="Screenshot 2025-03-18 at 6 11 53 PM" src="https://github.com/user-attachments/assets/3a27a83c-5437-4a74-85c4-705b492b57a7" />

Available Products displayed:
<img width="1463" alt="Screenshot 2025-03-18 at 6 12 00 PM" src="https://github.com/user-attachments/assets/b862c911-913b-48dc-b4a4-8f3ca747738b" />

Order request executed successfully:
<img width="1463" alt="Screenshot 2025-03-18 at 6 12 10 PM" src="https://github.com/user-attachments/assets/fc99b65a-cae2-4e68-93e1-e99a2bf7342c" />

Order request failed as quantity is not set:
<img width="1460" alt="Screenshot 2025-03-18 at 6 12 21 PM" src="https://github.com/user-attachments/assets/b210721a-121d-4952-a672-4aab797d8d68" />








