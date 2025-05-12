# 🧠 Generative AI Application with Java + Spring Boot

This is a simple backend built with **Java** and **Spring Boot**, 
using the **HuggingFace API** to enable generative AI features.

## 🚀 Technologies Used

- Java 24+
- Spring Boot
  - Web
  - Data JPA
  - Security
  - Test
- Spring AI
  - HuggingFace model integration (Flan-T5)
- PostgreSQL
- Flyway (for database migrations)
- Lombok

## ✅ Prerequisites

Before running the project, make sure you have the following installed on your machine:

- **Java 17 or higher** – [Download here](https://adoptium.net/en-GB/)
- **Maven** – [Installation guide](https://maven.apache.org/install.html)
- **PostgreSQL** – Ensure it's installed, running locally, and accessible
- **Hugging Face API Key** – [Get your key](https://huggingface.co/settings/tokens)

### (Optional) Run PostgreSQL using Docker

If you prefer using Docker to run PostgreSQL:

```bash
docker run --name postgres-ai \
  -e POSTGRES_PASSWORD=your_password \
  -e POSTGRES_DB=api_ai \
  -p 5432:5432 \
  -d postgres
```

## ⚙️ Project Setup

### 1. Clone the repository

```bash
git clone https://github.com/your-username/your-repository.git
cd your-repository
````

### 2. Configure environment variables
Create a .env file or export the variables in your terminal:
```bash
API_KEY=your_huggingface_api_key
DB_USERNAME=your_db_username
DB_PASSWORD=your_password
DB_NAME=your_database_name
HOST=your_server_host
PORT=your_server_port
```
Or set them directly in application.properties:
```bash
SPRING_AI_HUGGINGFACE_CHAT_API_KEY=${API_KEY}
SPRING_AI_HUGGINGFACE_CHAT_URL=google/flan-t5-small

spring.datasource.url=${HOST}://localhost:5432/api_ai
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.security.user.name=user
spring.security.user.password=123
```
### 3. Run the application
```bash
./mvnw spring-boot:run
```
The app will be available at:
```bash
http://localhost:8080
```