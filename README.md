# Desafio Back-End Techis

## Requisitos

[Java](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)

[Maven](https://maven.apache.org/download.cgi)

[MongoDB](https://www.mongodb.com/try/download/community)

### Banco de dados aplicação
MongoDB

database: starwars-planets

host: localhost

porta: 27017

usuário: techis

senha: techis

### Banco de dados teste
MongoDB

database: starwars-planets-test

host: localhost

porta: 27017

usuário: techis

senha: techis

## Instalação

### Compilar projeto
```bash
mvn clean install
```

### Executar projeto
```bash
java -jar target/starwars-planets-0.0.1.jar
```

## Executar Testes

### Testes unitários
```bash
mvn test
```

### Testes unitários e integrados
```bash
mvn verify
```

## Documentação

http://localhost:8080/swagger-ui.html