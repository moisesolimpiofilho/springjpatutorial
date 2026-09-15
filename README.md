# 🚀 Spring Data JPA + Docker

Projeto desenvolvido para a disciplina **Arquitetura de Software (Teoria e Prática)**, sob orientação do **Prof. Dr. Frank J. Affonso**, no **Mestrado da UNESP**.

O projeto apresenta implementações práticas envolvendo **mapeamento objeto-relacional (ORM)**, **persistência de dados**, **arquitetura em camadas**, **desenvolvimento de API REST** e **conteinerização** utilizando Docker.

A aplicação utiliza **Spring Data JPA/Hibernate** para persistência, **MySQL** como banco de dados relacional e **Docker Compose** para orquestração da aplicação e da infraestrutura.

---

## 🎯 Objetivos

Este projeto tem como principais objetivos:

* Aplicar conceitos de **ORM (Object-Relational Mapping)**;
* Utilizar **Spring Data JPA** para persistência de dados;
* Implementar entidades utilizando **JPA/Hibernate**;
* Desenvolver uma **API REST**;
* Aplicar uma arquitetura organizada em camadas;
* Implementar operações de **CRUD**;
* Criar testes unitários e de integração;
* Utilizar **MySQL** como banco de dados;
* Conteinerizar a aplicação com **Docker**;
* Utilizar **Docker Compose** para orquestrar aplicação e banco de dados;
* Disponibilizar a API por meio do **Swagger/OpenAPI**.

---

## 🏗️ Arquitetura

A aplicação está organizada em camadas, seguindo uma estrutura semelhante à arquitetura:

```text
┌───────────────────────────────┐
│           REST API            │
│       FisicaResource          │
└───────────────┬───────────────┘
                │
                ▼
┌───────────────────────────────┐
│            Service            │
│        FisicaService          │
└───────────────┬───────────────┘
                │
                ▼
┌───────────────────────────────┐
│          Repository           │
│       FisicaRepository        │
└───────────────┬───────────────┘
                │
                ▼
┌───────────────────────────────┐
│        Spring Data JPA        │
│           Hibernate           │
└───────────────┬───────────────┘
                │
                ▼
┌───────────────────────────────┐
│           MySQL 8             │
└───────────────────────────────┘
```

### Fluxo de uma requisição

```text
Cliente
   │
   │ HTTP
   ▼
Resource / Controller
   │
   ▼
Service
   │
   ▼
Repository
   │
   ▼
JPA / Hibernate
   │
   ▼
MySQL
```

---

## 🛠️ Tecnologias utilizadas

| Tecnologia               | Utilização                                |
| ------------------------ | ----------------------------------------- |
| ☕ **Java 17**            | Linguagem de programação                  |
| 🍃 **Spring Boot**       | Framework principal                       |
| 💾 **Spring Data JPA**   | Persistência de dados                     |
| 🔄 **Hibernate**         | Implementação ORM                         |
| 🐬 **MySQL 8.0**         | Banco de dados relacional                 |
| 🧪 **JUnit 5**           | Testes unitários e de integração          |
| 📦 **Apache Maven**      | Gerenciamento de dependências e build     |
| 🐳 **Docker**            | Conteinerização                           |
| 🐳 **Docker Compose**    | Orquestração dos containers               |
| 📖 **Swagger / OpenAPI** | Documentação da API                       |
| 🔎 **jq**                | Formatação das respostas JSON no terminal |

> **Nota:** confirme no `pom.xml` a versão exata do Spring Boot utilizada pelo projeto. O README original mencionava "Spring Boot 3 / 4", mas o ideal é documentar apenas a versão efetivamente utilizada.

---

## 📦 Estrutura do projeto

```text
.
├── 🐳 docker-compose.yml
├── 🐳 Dockerfile
├── 📄 HELP.md
├── ⚙️ mvnw
├── ⚙️ mvnw.cmd
├── 📦 pom.xml
│
└── 📂 src
    ├── 📂 main
    │   ├── 📂 java
    │   │   └── 📂 br/unesp/moisesolimpio/springjpatutorial
    │   │       │
    │   │       ├── 📂 entity
    │   │       │   ├── ☕ Acesso.java
    │   │       │   ├── ☕ Contato.java
    │   │       │   ├── ☕ Endereco.java
    │   │       │   ├── ☕ Fisica.java
    │   │       │   ├── ☕ Juridica.java
    │   │       │   └── ☕ Pessoa.java
    │   │       │
    │   │       ├── 📂 repository
    │   │       │   └── ☕ FisicaRepository.java
    │   │       │
    │   │       ├── 📂 resource
    │   │       │   └── ☕ FisicaResource.java
    │   │       │
    │   │       ├── 📂 service
    │   │       │   └── ☕ FisicaService.java
    │   │       │
    │   │       ├── 📂 utils
    │   │       │   └── ☕ InstanceGenerator.java
    │   │       │
    │   │       └── ☕ SpringjpatutorialApplication.java
    │   │
    │   └── 📂 resources
    │       ├── ⚙️ application.properties
    │       ├── 📂 static
    │       └── 📂 templates
    │
    └── 📂 test
        └── 📂 java
            └── 📂 br/unesp/moisesolimpio/springjpatutorial
                │
                ├── 📂 service
                │   └── 🧪 FisicaServiceTest.java
                │
                └── 🧪 SpringjpatutorialApplicationTests.java
```

### Organização das principais camadas

**`entity`**

Contém as classes responsáveis pelo mapeamento das entidades Java para as tabelas do banco de dados utilizando JPA.

**`repository`**

Responsável pelo acesso aos dados por meio do Spring Data JPA.

**`service`**

Contém as regras de negócio e coordena as operações realizadas pela aplicação.

**`resource`**

Responsável pela exposição dos endpoints da API REST.

**`utils`**

Contém classes utilitárias utilizadas pelo projeto.

**`test`**

Contém os testes automatizados da aplicação.

---

# 🐳 Executando com Docker

## Pré-requisitos

Antes de executar o projeto, certifique-se de possuir:

* [Docker](https://www.docker.com/)
* Docker Compose
* Git

Opcionalmente, para executar e testar a aplicação diretamente:

* Java 17
* Maven
* `curl`
* `jq`

---

## ▶️ Subindo a aplicação

Clone o repositório:

```bash
git clone <URL_DO_REPOSITORIO>
```

Entre no diretório:

```bash
cd <DIRETORIO_DO_PROJETO>
```

Execute os containers:

```bash
docker compose up --build
```

Para executar em segundo plano:

```bash
docker compose up --build -d
```

Verifique os containers em execução:

```bash
docker compose ps
```

Para acompanhar os logs:

```bash
docker compose logs -f
```

Para encerrar a aplicação:

```bash
docker compose down
```

---

# 🗄️ Banco de dados

O projeto utiliza **MySQL 8.0** como banco de dados relacional.

A configuração da conexão encontra-se em:

```text
src/main/resources/application.properties
```

Quando executada utilizando Docker Compose, a aplicação deve utilizar o **nome do serviço do MySQL** definido no `docker-compose.yml` como hostname, em vez de `localhost`.

Exemplo conceitual:

```properties
spring.datasource.url=jdbc:mysql://mysql:3306/<database>
spring.datasource.username=<usuario>
spring.datasource.password=<senha>
```

> **Importante:** não publique senhas, tokens ou outras credenciais reais no repositório. Para ambientes reais, prefira variáveis de ambiente ou arquivos de configuração externos.

---

# 🌐 API REST

A aplicação disponibiliza endpoints para gerenciamento de entidades do tipo **Pessoa Física (`Fisica`)**.

A URL base utilizada nos exemplos abaixo é:

```text
http://localhost:8082/entidade/v1
```

## 📋 Endpoints

| Método   | Endpoint             | Descrição                    |
| -------- | -------------------- | ---------------------------- |
| `GET`    | `/entidade/v1/`      | Lista as entidades           |
| `GET`    | `/entidade/v1/{cpf}` | Busca uma entidade pelo CPF  |
| `POST`   | `/entidade/v1/`      | Cadastra uma nova entidade   |
| `PUT`    | `/entidade/v1/`      | Atualiza uma entidade        |
| `DELETE` | `/entidade/v1/{cpf}` | Remove uma entidade pelo CPF |

---

# 🧪 Testando os endpoints com cURL

Os exemplos abaixo permitem testar a API diretamente pelo terminal.

## 🔎 Parâmetros utilizados

### `-s`

Executa o `curl` em modo silencioso, ocultando a barra de progresso.

```bash
-s
```

### `-H`

Define um cabeçalho HTTP.

Exemplo:

```bash
-H "Accept: application/json"
```

Indica que o cliente espera receber uma resposta no formato JSON.

### `-X`

Define explicitamente o método HTTP.

Exemplo:

```bash
-X POST
```

Para `GET`, o uso de `-X GET` é opcional, pois o `curl` utiliza GET por padrão.

### `-i`

Exibe os cabeçalhos HTTP da resposta.

```bash
-i
```

Quando utilizar `-i`, evite combinar a saída diretamente com `jq`, pois os cabeçalhos HTTP não são JSON.

### `| jq`

Envia a resposta para o programa `jq`, facilitando a visualização de JSON.

```bash
| jq
```

---

## 📄 Listar entidades

```bash
curl -s \
  -H "Accept: application/json" \
  http://localhost:8082/entidade/v1/ | jq
```

---

## 🔎 Buscar entidade pelo CPF

O CPF deve ser informado no formato utilizado pela aplicação.

Exemplo:

```bash
curl -s \
  -H "Accept: application/json" \
  http://localhost:8082/entidade/v1/111.222.333-45 | jq
```

---

# ➕ Cadastrar uma entidade

Utilize o método `POST`:

```bash
curl -X POST \
  http://localhost:8082/entidade/v1/ \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -d '{
    "usuario": "springBoot231",
    "senha": "123mudar",
    "telefoneResidencial": "3333-4444",
    "telefoneComercial": "3333-5555",
    "celular": "98888-7777",
    "email": "juca@chaves.com.br",
    "nome": "Juca Chaves",
    "cpf": "311.222.333-41",
    "dataNascimento": "2020-07-24T11:58:58.911-0300",
    "endereco": [
      {
        "rua": "Avenida 24A",
        "numero": 1515,
        "bairro": "Bela Vista",
        "cep": "13506-900",
        "cidade": "Rio Claro",
        "estado": "SP"
      },
      {
        "rua": "Avenida 24A",
        "numero": 1515,
        "bairro": "Bela Vista",
        "cep": "13506-900",
        "cidade": "Rio Claro",
        "estado": "SP"
      }
    ]
  }' | jq
```

---

# ✏️ Atualizar uma entidade

Utilize o método `PUT`:

```bash
curl -X PUT \
  http://localhost:8082/entidade/v1/ \
  -H "Content-Type: application/json" \
  -H "Accept: application/json" \
  -d '{
    "usuario": "springBoot231",
    "senha": "123mudar",
    "telefoneResidencial": "3333-4444",
    "telefoneComercial": "3333-5555",
    "celular": "98888-7777",
    "email": "juca@chaves.com.br",
    "nome": "Juca Chaves",
    "cpf": "311.222.333-41",
    "dataNascimento": "2020-07-24T11:58:58.911-0300",
    "endereco": [
      {
        "rua": "Avenida 24A",
        "numero": 1515,
        "bairro": "Bela Vista",
        "cep": "13506-900",
        "cidade": "Rio Claro",
        "estado": "SP"
      },
      {
        "rua": "Avenida 24A",
        "numero": 1515,
        "bairro": "Bela Vista",
        "cep": "13506-900",
        "cidade": "Rio Claro",
        "estado": "SP"
      }
    ]
  }' | jq
```

---

# 🗑️ Remover uma entidade

Para excluir uma entidade pelo CPF:

```bash
curl -i \
  -X DELETE \
  http://localhost:8082/entidade/v1/311.222.333-41
```

O parâmetro `-i` permite visualizar o status HTTP retornado pela API.

---

# 📖 Swagger / OpenAPI

A documentação interativa da API pode ser acessada pelo Swagger UI:

**Swagger UI**

```text
http://localhost:8082/swagger-ui/index.html
```

O Swagger permite:

* visualizar os endpoints disponíveis;
* consultar os métodos HTTP;
* visualizar os modelos utilizados pela API;
* enviar requisições diretamente pelo navegador;
* analisar as respostas HTTP.

---

# 🧪 Testes automatizados

O projeto possui testes utilizando **JUnit 5**.

Para executar os testes com Maven Wrapper:

### Linux / macOS

```bash
./mvnw test
```

### Windows

```cmd
mvnw.cmd test
```

Ou, caso o Maven esteja instalado:

```bash
mvn test
```

---

# 🔨 Build da aplicação

Para gerar o artefato da aplicação:

```bash
./mvnw clean package
```

O arquivo `.jar` será gerado no diretório:

```text
target/
```

---

# 🐳 Build manual da imagem Docker

Para construir a imagem:

```bash
docker build -t spring-jpa-tutorial .
```

Executar o container:

```bash
docker run -p 8082:8082 spring-jpa-tutorial
```

> Para o funcionamento completo da aplicação, o banco MySQL também precisa estar disponível e corretamente configurado.

---

# 🔐 Boas práticas

Este projeto possui finalidade **acadêmica e experimental**. Para utilização em produção, recomenda-se:

* não armazenar senhas diretamente no código;
* utilizar variáveis de ambiente;
* utilizar secrets para credenciais;
* configurar corretamente os profiles do Spring;
* adicionar validação de entrada;
* implementar tratamento global de exceções;
* utilizar DTOs para entrada e saída de dados;
* adicionar autenticação e autorização;
* configurar logs adequadamente;
* adicionar observabilidade;
* utilizar migrations, como Flyway ou Liquibase;
* configurar health checks dos containers;
* adicionar pipeline de CI/CD.

---

# 📚 Contexto acadêmico

Este projeto foi desenvolvido como parte das atividades da disciplina:

> **Arquitetura de Software — Teoria e Prática**

**Programa:** Mestrado
**Instituição:** UNESP
**Orientador da disciplina:** Prof. Dr. Frank J. Affonso

O projeto busca relacionar conceitos teóricos de **Arquitetura de Software** com uma implementação prática utilizando tecnologias amplamente utilizadas no desenvolvimento de aplicações Java.

---

## 👨‍💻 Autor

**Moises Olimpio**

Projeto acadêmico desenvolvido para fins de estudo, experimentação e aplicação prática dos conceitos apresentados na disciplina.

---

## 📄 Licença

Caso este projeto seja disponibilizado publicamente, recomenda-se definir uma licença apropriada, como **MIT**, **Apache 2.0** ou outra licença compatível com os objetivos do projeto.

---

⭐ Se este projeto foi útil para seus estudos, considere deixar uma **estrela ⭐ no repositório**.
