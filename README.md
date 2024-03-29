# Microservices Architecture with Spring Boot

This repository contains a sample microservices architecture implemented using Spring Boot, including services for order management, inventory management, product management, a common API gateway, a Eureka server for service registration, a Zipkin server for distributed tracing, and a separate Config Server for externalized configuration.

## Services

### 1. Order Service

The Order Service manages orders placed by customers. It exposes REST endpoints for creating, updating, and retrieving orders.

- **Port:** 6001
- **Endpoint:** `/api/orders`

### 2. Inventory Service

The Inventory Service manages the inventory of products. It provides REST endpoints for querying product availability and managing stock.

- **Port:** 6002
- **Endpoint:** `/api/inventory`

### 3. Product Service

The Product Service handles product information. It offers REST endpoints for retrieving product details.

- **Port:** 8080
- **Endpoint:** `/api/products`

## Infrastructure

### 1. Eureka Server

The Eureka Server provides service registration and discovery. All microservices register themselves with the Eureka server, allowing other services to discover and communicate with them dynamically.

- **Port:** 8761
- **Dashboard:** [http://localhost:8761](http://localhost:8761)

### 2. Zipkin Server

The Zipkin Server is used for distributed tracing. It collects and visualizes tracing data, allowing you to monitor and troubleshoot requests as they propagate through various microservices.

- **Port:** 9411
- **Dashboard:** [http://localhost:9411](http://localhost:9411)

### 3. Config Server

The Config Server centralizes configuration management for microservices. It fetches configuration files from a Git repository and serves them to microservices upon request.

- **Port:** 8888
- **Repository:** [https://github.com/your-config-repo](https://github.com/your-config-repo)

## Setup and Deployment

1. **Clone the Repository:**

```
git clone https://github.com/Immaculatekimani/Springboot-Microservice

```

2. **Build the Microservices:**
```
cd microservices
mvn clean install spring-boot:run

```


3. **Start the Infrastructure Services:**
- Eureka Server
- Zipkin Server
- Config Server


4. **Start the Microservices:**
- Order Service
- Inventory Service
- Product Service

5. **Start the API Gateway:**

```
cd api-gateway
mvn spring-boot:run
```


6. **Access the Services:**
- Eureka Dashboard: [http://localhost:8761](http://localhost:8761)
- Zipkin Dashboard: [http://localhost:9411](http://localhost:9411)
- Config Server: [http://localhost:8888](http://localhost:8888)

## Configuration

- All microservices fetch their configuration from the Config Server at startup.
- Update the Config Server repository with environment-specific configuration files.

## Monitoring

- Monitor service health and metrics using Spring Boot Actuator endpoints.
- Use the Eureka dashboard to view registered services and their status.
- Utilize the Zipkin dashboard for distributed tracing and performance monitoring.

## Sample Requests

```
### Simple hello endpoint
GET http://localhost:7000/api/hello HTTP/1.1

### List Products
# @name ProductList
GET http://localhost:7000/api/products HTTP/1.1


### Save Product
# @name Saveproduct
POST http://localhost:7000/api/products HTTP/1.1
Content-Type: application/json

{
    
    "name":"Candy",
    "price":"199.00",
    "productCode":"CND2543"
}


### Get Product
# @name GetProductById
GET http://localhost:7000/api/products/1 HTTP/1.1

### Place Order
# @name placeorder
POST http://localhost:6001/api/orders/placeOrder HTTP/1.1
Content-Type: application/json

{
   "orderItems":[
        {
            "productCode":"PIN001",
            "quantity":2
        },
        {
            "productCode":"PHN001",
            "quantity":3
        }
   ]
}


### Save Inventory
# @name SaveInventory
POST http://localhost:6002/api/inventory/create HTTP/1.1
Content-Type: application/json

{
    "productCode":"PHN001",
    "quantity":"10"
}
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.