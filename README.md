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
    │   │       ├── 📂 repository             
    │   │       │   └── ☕ FisicaRepository.java
    │   │       ├── 📂 resource             
    │   │       │   └── ☕ FisicaResource.java
    │   │       ├── 📂 service                
    │   │       │   └── ☕ FisicaService.java
    │   │       ├── 📂 utils                  
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
```

## Testar os Endpoints com curl

A lista de comandos abaixo é usada para testar os endpoints via linha de comando com ``curl``.

### Os parâmetros usados na request são:
- ``-s`` (silent): oculta a barra de progresso do ``curl`` para não poluir a tela.
- ``-H "Accept: application/json"``: envia o cabeçalho informando a Api que é esperado uma resposta no formato ``json``.
- ``| jq``: o pipe faz o redirecionamento para o formatador ``jq`` exibindo o response em formato ``json``.  
- ``-X``: especifica o método ``HTTP``, se for ``GET`` é opcional.
- ``-i``: mostra os cabeçalhos da requisição ``HTTP``, se usar precisa **remover** o ``| jq``.

#### Retorna a lista de entidades
```bash
curl -s -H -X "Accept: application/json" http://localhost:8082/entidade/v1/ | jq
```

#### Retorna a entidade pelo atributo ``cpf`` no formato ``111.222.333-45``
```bash
curl -s -H "Accept: application/json" http://localhost:8082/entidade/v1/{cpf} | jq
```

### Cadastrar uma entidade, usar o formato abaixo
```bash
curl -X POST http://localhost:8082/entidade/v1/ \
  -H "Content-Type: application/json" \
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
  }'
```

### Remover uma entidade pelo ``cpf`` no formato ``111.222.333-45``
```bash
curl -i -X DELETE http://localhost:8082/entidade/v1/{cpf}
```

### Atualizar uma entidade, usar o formato abaixo
```bash
curl -X PUT http://localhost:8082/entidade/v1/ \
  -H "Content-Type: application/json" \
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
  }'
```