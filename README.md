# Mock API - API REST Genérica

## Descrição

Esta é uma API REST genérica desenvolvida com **Java 17** e **Spring Boot 3.4.0**. Ela permite criar, consultar e deletar dados mockados, armazenando qualquer estrutura de JSON associada a uma chave única (`key`). Seu objetivo é atuar como um serviço de mock para testes de outras APIs, possibilitando adaptar-se automaticamente a diferentes formatos de dados.

A API utiliza **arquitetura Clean**, **MapStruct** para mapeamento de objetos, **Swagger** para documentação e **MySQL** para persistência.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.4.0**
- **Hibernate e Spring Data JPA**
- **MapStruct** (mapeamento de objetos)
- **MySQL** (persistência de dados)
- **Swagger/OpenAPI** (documentação)

## Funcionalidades

1. **Criar mock data**: Armazena um JSON associado a uma chave única.
2. **Consultar mock data**: Busca o JSON armazenado a partir da chave.
3. **Deletar mock data**: Remove os dados mockados com base na chave.

## Pré-requisitos

- **Java 17** instalado
- **MySQL** em execução
- Ferramenta como Postman ou cURL para testar os endpoints

## Configuração do Banco de Dados

Certifique-se de que o MySQL está rodando e crie um banco de dados chamado `mock_api`. Atualize o arquivo `application.yml` com as suas credenciais do banco:
- **application.yml**:
  ```yaml
  spring:
    datasource:
      url: jdbc:mysql://localhost:3306/mock_api
      username: seu_usuario
      password: sua_senha
    jpa:
      hibernate:
        ddl-auto: update
      show-sql: true

## Como Rodar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/mock-api.git
   cd mock-api

2. Compile o projeto e resolva as dependências:
   ```bash
   mvn clean install

3. Execute a aplicação:
   ```bash
   mvn spring-boot:run

4. Acesse o Swagger para explorar a API:
   ```bash
   http://localhost:8080/swagger-ui.html

## Endpoints

### **Base URL**: `http://localhost:8080/api/mock`

### **1. Criar Mock Data**
- **Método**: `POST`
- **URL**: `/api/mock`
- **Descrição**: `Armazena um JSON associado a uma chave.`
- **Body (exemplo)**:
  ```json
  {
    "key": "example-key",
    "value": {
      "name": "John Doe",
      "age": 30
    }
  }

## **Resposta (201)**

### Descrição

Indica que a criação de um recurso foi bem-sucedida. O código HTTP `201` significa que o servidor processou a solicitação e criou um novo recurso no banco de dados.

- **Resposta (201)**:
  ```json
    {
      "key": "example-key",
      "value": {
        "name": "John Doe",
        "age": 30
      }
    }

### **2. Consultar Mock Data

- **Método**: `GET`
- **URL**: `/api/mock/{key}`
- **Descrição**: `Busca um JSON pelo identificador da chave.`
- **Exemplo de Requisição**:
  ```vbnet
  GET /api/mock/example-key

## **Resposta (200)**:
- **Resposta (200)**:
  ```json
  {
    "key": "example-key",
    "value": {
      "name": "John Doe",
      "age": 30
    }
  }

### **3. Deletar Mock Data
- **Método**: `DELETE`
- **URL**: `/api/mock/{key}`
- **Descrição**: `Remove os dados associados à chave fornecida.`
- **Exemplo de Requisição**:
  ```bash
    DELETE /api/mock/example-key
- **Resposta (204)**: Sem conteúdo.
