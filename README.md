# Primeira Aplicação
## Pré-requisitos
* JDK 1.8+ com JAVA_HOME configurado
* Uma IDE (Eclipse, IntelliJ)
* Apache Maven 3.5.3+
* Docker (caso queira criar e executar uma imagem da aplicação)
* GraalVM (caso queira criar um executável Linux)
## Passos

### 1. Criar Projeto
* mkdir aprenda-quarkus
* cd aprenda-quarkus
* mvn io.quarkus:quarkus-maven-plugin:0.21.2:create -DprojectGroupId=com.github.viniciusferraz -DprojectArtifactId=aprenda-quarkus -DclassName="com.github.viniciusferraz.HelloResource" -Dpath="/hello"
* Ou fazer clone do meu projeto: git clone --branch v0.0.1 

Este comando irá gerar:

1. Projeto seguindo estrutura maven

2. O recurso com.github.viniciusferraz.HelloResource disponível no contexto /hello

3. Um teste de unidade para HelloResource utilizando REST Assured 

4. Uma página inicial index.html

5. Arquivos Dockerfile para criação de imagens em modo nativo e JVM

the application configuration file
### 2. Subir aplicação com Hot Reloading
* ./mvnw compile quarkus:dev

### 3. Acessar aplicação
* http://localhost:8080
* http://localhost:8080/hello

### 4. Link da apresentação

https://docs.google.com/presentation/d/1S8oylcN4Hpcj0m6Zavkes9Q6SO4zfy_IMB4g0DMQuuI/edit?usp=sharing
