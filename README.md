# spring-boot-project-mongDB

## Descrição

Este projeto é uma aplicação Spring Boot que demonstra a integração com o MongoDB para a criação de uma API RESTful. Ele gerencia entidades de `User` (usuário) e `Post` (publicação), permitindo operações CRUD (Criar, Ler, Atualizar, Deletar) e funcionalidades de busca avançada para posts.

## Tecnologias Utilizadas

*   **Java 25**: Linguagem de programação.
*   **Spring Boot**: Framework para facilitar o desenvolvimento de aplicações Java.
*   **Spring Data MongoDB**: Módulo do Spring Data para integração com o MongoDB.
*   **Maven**: Ferramenta de automação de build e gerenciamento de dependências.
*   **MongoDB**: Banco de dados NoSQL orientado a documentos.

## Funcionalidades

### Usuários
*   **Listar todos os usuários**: `GET /users`
*   **Buscar usuário por ID**: `GET /users/{id}`
*   **Buscar posts de um usuário**: `GET /users/{id}/posts`
*   **Inserir novo usuário**: `POST /users`
*   **Atualizar usuário existente**: `PUT /users/{id}`
*   **Deletar usuário por ID**: `DELETE /users/{id}`

### Posts
*   **Buscar post por ID**: `GET /posts/{id}`
*   **Buscar posts por título**: `GET /posts/titlesearch?text={text}`
*   **Busca completa de posts**: `GET /posts/fullsearch?text={text}&minDate={yyyy-MM-dd}&maxDate={yyyy-MM-dd}`

### Outras Funcionalidades
*   **Tratamento de Exceções**: Manipulação de erros para recursos não encontrados.
*   **População Inicial de Dados**: A classe `Instatiation` em `com.springboot.mongodb.config` popula o banco de dados com alguns usuários e posts de exemplo ao iniciar a aplicação.

## Estrutura do Projeto

O projeto segue a estrutura padrão de um projeto Spring Boot, com os seguintes pacotes principais:

*   `com.springboot.mongodb.config`: Classes de configuração, como a `Instatiation` para popular o banco de dados.
*   `com.springboot.mongodb.dto`: Objetos de Transferência de Dados (DTOs) para comunicação entre as camadas.
*   `com.springboot.mongodb.entities`: Classes de entidade que representam os documentos no MongoDB (`User` e `Post`).
*   `com.springboot.mongodb.repositories`: Interfaces de repositório para acesso aos dados, estendendo `MongoRepository`.
*   `com.springboot.mongodb.resources`: Controladores REST (`UserResource`, `PostResource`) que expõem os endpoints da API.
*   `com.springboot.mongodb.services`: Classes de serviço (`UserService`, `PostService`) que contêm a lógica de negócio.
*   `com.springboot.mongodb.resources.exceptions`: Classes para tratamento de exceções personalizadas.
*   `com.springboot.mongodb.resources.util`: Classes utilitárias, como `URL` para decodificação de parâmetros e conversão de datas.

## Como Rodar o Projeto

### Pré-requisitos

*   **Java Development Kit (JDK) 25** ou superior.
*   **Apache Maven** 3.x.
*   **MongoDB** instalado e rodando na porta padrão (27017).

### Passos

1.  **Clonar o repositório:**
    ```bash
    git clone https://github.com/Konkvon/spring-boot-project-mongDB.git
    cd spring-boot-project-mongDB
    ```

2.  **Configurar o MongoDB:**
    Certifique-se de que o MongoDB esteja em execução. A aplicação tentará se conectar a `mongodb://localhost:27017/mongo` por padrão, conforme configurado em `src/main/resources/application.properties`.

3.  **Compilar e Executar:**
    Você pode compilar e executar a aplicação usando Maven:
    ```bash
    ./mvnw spring-boot:run
    ```
    Ou, se preferir, pode gerar o JAR executável e rodá-lo:
    ```bash
    ./mvnw clean package
    java -jar target/mongodb-0.0.1-SNAPSHOT.jar
    ```

    A aplicação estará disponível em `http://localhost:8080`.
