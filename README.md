

```markdown
# Product Service (Spring Boot 3.5.5 + Java 21 + PostgreSQL + Flyway)

A simple **REST API microservice** built with **Java 21**, **Spring Boot 3.5.5**, **PostgreSQL**, **Flyway**, and **Maven**.  
It demonstrates a clean microservice setup with CRUD operations for managing `Product` entities.

---

## Features
- Java 21 & Spring Boot 3.5.5
- REST API with CRUD endpoints
- PostgreSQL database
- Flyway for database migrations
- Docker & Docker Compose support
- Postman collection for testing
- Maven build system

---

## Project Structure

product-service/
├── src/main/java/com/example/productservice
│    ├── controller/       # REST controllers
│    ├── entity/           # JPA entities
│    ├── repository/       # Spring Data repositories
│    ├── service/          # Service layer
│    └── ProductServiceApplication.java
│
├── src/main/resources
│    ├── db/migration      # Flyway migrations
│    │    └── V1\_\_init.sql
│    └── application.yml   # Configuration
│
├── docker-compose.yml
├── Dockerfile
├── pom.xml
└── README.md

````

## Prerequisites
- Java 21
- Maven 3.9+
- Docker & Docker Compose
- Postman (optional, for testing)

---

## Setup & Run

### 1. Clone the repo
```bash
git clone https://github.com/your-username/product-service.git
cd product-service
````

### 2. Start PostgreSQL with Docker

```bash
docker-compose up -d
```

> Uses PostgreSQL **16** (Flyway compatible).

### 3. Run the app

```bash
./mvnw spring-boot:run
```

App runs at: **[http://localhost:8080](http://localhost:8080)**

---

## API Endpoints

| Method | Endpoint             | Description        |
| ------ | -------------------- | ------------------ |
| GET    | `/api/products`      | List all products  |
| GET    | `/api/products/{id}` | Get product by ID  |
| POST   | `/api/products`      | Create new product |
| PUT    | `/api/products/{id}` | Update product     |
| DELETE | `/api/products/{id}` | Delete product     |

### Example `Product` JSON

```json
{
  "name": "Laptop",
  "description": "Gaming laptop with RTX 4070",
  "price": 1499.99
}
```

---

## Testing with Postman

A Postman collection is included:

```
postman/ProductService.postman_collection.json
```

1. Open Postman
2. Import the collection
3. Run CRUD requests against `http://localhost:8080/api/products`

---

## Docker Build & Run (App + DB)

Build the app image:

```bash
docker build -t product-service .
```

Run both app & db:

```bash
docker-compose up --build
```

---

## Notes

* If you use **PostgreSQL 17**, Flyway may fail with `Unsupported Database`.
  Recommended: Use PostgreSQL **16** for Flyway compatibility.
* If you don’t need migrations, disable Flyway in `application.yml`:

  ```yaml
  spring:
    flyway:
      enabled: false
  ```

---

##  License

MIT License © 2025

```

