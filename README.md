# 🌱 EcoCity - Backend

Este é o **backend da aplicação EcoCity**, desenvolvido em **Java com Spring Boot**. Ele oferece uma API RESTful para o gerenciamento, utilizando banco de dados **PostgreSQL**. Todo o ambiente é executado via **Docker e Docker Compose**.

---

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- PostgreSQL
- Docker & Docker Compose
- Maven

---

## ✅ Pré-requisitos

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)
- [Java 17](https://adoptium.net/en-GB/temurin/releases/)
- [Maven](https://maven.apache.org/)

---

## ▶️ Como rodar localmente

```bash
# 1. Gere o wrapper Maven (caso ainda não tenha feito):
mvn -N io.takari:maven:wrapper

# 2. Compile o projeto (sem rodar testes):
./mvnw clean install -DskipTests

# 3. Inicie os containers com Docker:
docker-compose up --build
```

E já pode testar as rotas em http://localhost:8080/
