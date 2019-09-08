# Primeira Aplicação
## Pré-requisitos
* JDK 1.8+ com JAVA_HOME configurado
* Uma IDE (Eclipse, IntelliJ)
* Apache Maven 3.5.3+

## Passos

### 1. Criar Projeto
* mvn io.quarkus:quarkus-maven-plugin:0.21.2:create -DprojectGroupId=com.github.viniciusferraz -DprojectArtifactId=aprenda-quarkus -DclassName="com.github.viniciusferraz.HelloResource" -Dpath="/hello"

### 2. Subir aplicação
* cd aprenda-quarkus
* ./mvnw compile quarkus:dev

### 3. Acessar aplicação
* http://localhost:8080
* http://localhost:8080/hello

