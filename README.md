
# 📚 Tarefas API

API RESTful para gerenciamento de tarefas desenvolvida em Java com Spring Boot e MySQL, utilizando Docker para o banco de dados.

---

## ✅ Sumário

- [📦 Tecnologias e Dependências](#-tecnologias-e-dependencias)  
- [⚙️ Configuração do Banco com Docker](#-configuracao-do-banco-com-docker)  
- [▶️ Como Rodar o Projeto](#-como-rodar-o-projeto)  
- [🌐 Endpoints da API](#-endpoints-da-api)  
- [📮 Exemplos de Payloads](#-exemplos-de-payloads)  
- [📝 Autor](#-autor)

---

## 📦 Tecnologias e Dependências

| Tecnologia   | Versão  |
|--------------|---------|
| Java         | 17      |
| Spring Boot  | 3.5.3   |
| MySQL        | 8.0     |
| Docker       | Latest  |
| Lombok       | 1.18.38 |

### 📋 Dependências Maven

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.38</version>
    <scope>provided</scope>
</dependency>
```

---

## ⚙️ Configuração do Banco com Docker

### 📄 docker-compose.yml

```yaml
version: '3.8'

services:
  mysql:
    image: mysql:8.0
    container_name: mysql-tarefa
    restart: always
    environment:
      MYSQL_ROOT_PASSWORD: 123456
      MYSQL_DATABASE: tarefa_db
    ports:
      - "3306:3306"
    volumes:
      - mysql_data:/var/lib/mysql

volumes:
  mysql_data:
```

### ▶️ Subir o banco com:

```bash
docker-compose up -d
```

---

## ▶️ Como Rodar o Projeto

1. Subir o banco de dados com o Docker:

```bash
docker-compose up -d
```

2. Configurar o arquivo `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/tarefa_db
spring.datasource.username=root
spring.datasource.password=123456
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

3. Executar o projeto com:

```bash
./mvnw spring-boot:run
```

ou rodar diretamente na IDE.

---

## 🌐 Endpoints da API

| Método | Endpoint                               | Descrição               |
|--------|----------------------------------------|-------------------------|
| POST   | http://localhost:8080/tarefas/create   | Criar uma nova tarefa   |
| GET    | http://localhost:8080/tarefas/all      | Listar todas as tarefas |
| GET    | http://localhost:8080/tarefas/{id}     | Buscar uma tarefa por ID|
| PUT    |http://localhost:8080/tarefas/{id}      | Atualizar uma tarefa    |
| DELETE |http://localhost:8080/tarefas/{id}      | Remover uma tarefa      |

---

## 📮 Exemplos de Payloads

### Criar Tarefa (POST `http://localhost:8080/tarefas/create`)

```json
{
  "nome": "Desenvolvimento da API",
  "dataEntrega": "12/12/2025",
  "responsavel": "Raquel Silva Pereira",
  "ru": "4570506"
}
```

### Atualizar Tarefa (PUT `http://localhost:8080/tarefas/{id}`)

```json
{
  "nome": "Documentação Atualizada",
  "dataEntrega": "20/12/2025",
  "responsavel": "Carlos Souza",
  "ru": "1234567"
}
```

---

## 📝 Autor

Raquel Silva Pereira - RU:4570506 
