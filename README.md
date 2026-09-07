# Projeto Spring Data JPA e Dockerização 🚀

Implementações práticas e testes desenvolvidos para a disciplina de **Arquitetura de Software (Teoria e Prática)**, sob orientação do **Prof. Dr. Frank J. Affonso** no Mestrado da **UNESP**. 

O projeto explora o mapeamento objeto-relacional (ORM) com **Spring Data JPA**, persistência em **MySQL** e conteinerização completa da aplicação e infraestrutura utilizando **Docker**.

---

## 🛠️ Tecnologias Utilizadas

* **Java 17** (Eclipse Temurin)
* **Spring Boot 3 / 4**
  * Spring Data JPA (Hibernate)
* **MySQL 8.0** (Banco de Dados Relacional)
* **JUnit 5** (Testes Unitários e de Integração)
* **Apache Maven** (Gerenciamento de dependências e build)
* **Docker & Docker Compose** (Conteinerização e orquestração)

---

## 📦 Estrutura do Projeto

```text
.
├── 🐳 docker-compose.yml                     # Orquestração dos containers (App + MySQL)
├── 🐳 Dockerfile                             # Build multi-stage para a aplicação Spring Boot
├── 📄 HELP.md
├── ⚙️ mvnw
├── ⚙️ mvnw.cmd
├── 📦 pom.xml                                # Dependências e configurações do Maven
└── 📂 src
    ├── 📂 main
    │   ├── 📂 java
    │   │   └── 📂 br/unesp/moisesolimpio/springjpatutorial
    │   │       ├── 📂 entity                 # Mapeamento das entidades JPA
    │   │       │   ├── ☕ Acesso.java
    │   │       │   ├── ☕ Contato.java
    │   │       │   ├── ☕ Endereco.java
    │   │       │   ├── ☕ Fisica.java
    │   │       │   ├── ☕ Juridica.java
    │   │       │   └── ☕ Pessoa.java
    │   │       ├── 📂 repository             # Interfaces Spring Data JPA Repositories
    │   │       │   └── ☕ FisicaRepository.java
    │   │       ├── 📂 service                # Camada de regras de negócio
    │   │       │   └── ☕ FisicaService.java
    │   │       ├── 📂 utils                  # Classes utilitárias e geradores
    │   │       │   └── ☕ InstanceGenerator.java
    │   │       └── ☕ SpringjpatutorialApplication.java
    │   └── 📂 resources
    │       ├── ⚙️ application.properties     # Configurações de conexão e Hibernate
    │       ├── 📂 static
    │       └── 📂 templates
    └── 📂 test
        └── 📂 java
            └── 📂 br/unesp/moisesolimpio/springjpatutorial
                ├── 📂 service                # Testes das camadas de serviço
                │   └── 🧪 FisicaServiceTest.java
                └── 🧪 SpringjpatutorialApplicationTests.java