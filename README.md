# Primeira Aplicação
## Pré-requisitos
* JDK 1.8+ com JAVA_HOME configurado
* Uma IDE (Eclipse ou IntelliJ)
* Apache Maven 3.5.3+
* Docker (caso queira criar e executar uma imagem da aplicação)
* GraalVM (caso queira gerar o executável nativo para Linux)

## Passos

### 1. Como Criar Projeto


* [Baixar fonte](https://github.com/viniciusfcf/quarkus/archive/v0.0.1.zip)

* Clonar do projeto do meu GIT: **git clone --branch v0.0.1 https://github.com/viniciusfcf/quarkus.git**

O projeto irá conter:

1. Estrutura maven
2. O recurso com.github.viniciusfcf.hello.HelloResource disponível no contexto /hello e /hello/quarkus
3. Um teste de unidade para HelloResource utilizando REST Assured 
4. Uma página inicial index.html
5. Arquivos Dockerfile para criação de imagens em modo nativo e JVM
6. Arquivo application.properties para configuração das extensões

### 2. Subir aplicação com Hot Reloading
* ./mvnw compile quarkus:dev

### 3. Acessar aplicação
* http://localhost:8080
* http://localhost:8080/hello
* http://localhost:8080/hello/quarkus

### 4. Apresentação

[Baixe aqui](https://docs.google.com/presentation/d/1S8oylcN4Hpcj0m6Zavkes9Q6SO4zfy_IMB4g0DMQuuI/edit?usp=sharing)

### 5. Vídeo do Youtube

https://youtu.be/pBc0qSLaHO8


# Segundo vídeo: Utilizando Hibernate ORM

## Pré-requisitos
* JDK 1.8+ com JAVA_HOME configurado
* Uma IDE (Eclipse ou IntelliJ)
* Apache Maven 3.5.3+
* Postgres
* GraalVM (caso queira gerar o executável nativo para Linux)

## Passos

### 1. Como acessar o código do projeto do final do vídeo

* [Baixar fonte](https://github.com/viniciusfcf/quarkus/archive/v0.0.2.zip)

* Clonar do projeto do meu GIT: **git clone --branch v0.0.2 https://github.com/viniciusfcf/quarkus.git**

O projeto irá conter:

1. Estrutura maven
2. O recurso novo com.github.viniciusfcf.hibernate.ProdutoResource disponível no contexto /produtos (GET e POST)
3. A entidade com.github.viniciusfcf.hibernate.Produto
4. Arquivo application.properties foi atualizado com as configuraçãoes de banco de dados

### 2. Subir aplicação com Hot Reloading
* ./mvnw compile quarkus:dev -Dquarkus.profile=dev

### 3. Acessar aplicação
* http://localhost:8080/produtos (GET e POST)


### 2. Vídeo do Youtube

https://youtu.be/geXSv1RMvK4


# Terceiro Vídeo: Rastreando seus microsserviços com Jaeger
## Pré-requisitos
* JDK 1.8+ com JAVA_HOME configurado
* Uma IDE (Eclipse ou IntelliJ)
* Apache Maven 3.5.3+
* Docker (caso queira criar e executar uma imagem da aplicação)
* GraalVM (caso queira gerar o executável nativo para Linux)
* Postgres
  * docker pull postgres
  * docker run --network host -e POSTGRES_PASSWORD=postgres -d postgres
* Jaeger
  * docker pull jaegertracing/all-in-one
  * docker run --network host jaegertracing/all-in-one

## Passos

### 1. Como Criar Projeto

* Versão do início do Vídeo
  * [Baixar fonte](https://github.com/viniciusfcf/quarkus/archive/v0.0.2.zip)
  * Clonar do projeto do meu GIT: **git clone --branch v0.0.2 https://github.com/viniciusfcf/quarkus.git**

* Versão final do Vídeo
  * [Baixar fonte](https://github.com/viniciusfcf/quarkus/archive/v0.0.3.zip)
  * Clonar do projeto do meu GIT: **git clone --branch v0.0.3 https://github.com/viniciusfcf/quarkus.git**


### 2. Subir aplicação com Hot Reloading
* ./mvnw compile quarkus:dev


### 3. Apresentação

[Baixe aqui](https://docs.google.com/presentation/d/1F-uOYhBRME0AEy57N5c4IR6248j26VZB5zq0RzUCROU/edit?usp=sharing)

### 4. Vídeo do Youtube

https://www.youtube.com/watch?v=_tHkrmheW7k


# Quarto Vídeo: Health check
## Pré-requisitos
* JDK 1.8+ com JAVA_HOME configurado
* Uma IDE (Eclipse ou IntelliJ)
* Apache Maven 3.5.3+
* Docker (caso queira criar e executar uma imagem da aplicação)
* GraalVM (caso queira gerar o executável nativo para Linux)
* Postgres
  * docker pull postgres
  * docker run --network host -e POSTGRES_PASSWORD=postgres -d postgres

## Passos

### 1. Como Criar Projeto

* Versão do início do Vídeo
  * [Baixar fonte](https://github.com/viniciusfcf/quarkus/archive/v0.0.3.zip)
  * Clonar do projeto do meu GIT: **git clone --branch v0.0.3 https://github.com/viniciusfcf/quarkus.git**

* Versão final do Vídeo
  * [Baixar fonte](https://github.com/viniciusfcf/quarkus/archive/v0.0.4.zip)
  * Clonar do projeto do meu GIT: **git clone --branch v0.0.4 https://github.com/viniciusfcf/quarkus.git**


### 2. Subir aplicação com Hot Reloading
* ./mvnw compile quarkus:dev


### 3. Apresentação

[Baixe aqui](https://docs.google.com/presentation/d/11OJwisv7boiqVYaLavKJQXlHQqQOkn-GKkOZ6kPcpiw/edit?usp=sharing)

### 4. Vídeo do Youtube

https://youtu.be/OnPffQ1_idQ

# Quinto Vídeo: Monitoramento com Prometheus e Grafana
## Pré-requisitos
* JDK 1.8+ com JAVA_HOME configurado
* Uma IDE (Visual Studio)
* Apache Maven 3.5.3+
* Docker (caso queira criar e executar uma imagem da aplicação)
* GraalVM (caso queira gerar o executável nativo para Linux)
* Postgres
* Prometheus (Ver apresentação)
* Grafana (Ver apresentação)

## Passos

### 1. Como Criar Projeto

* Versão do início do Vídeo
  * [Baixar fonte](https://github.com/viniciusfcf/quarkus/archive/v0.0.4.zip)
  * Clonar do projeto do meu GIT: **git clone --branch v0.0.4 https://github.com/viniciusfcf/quarkus.git**

* Versão final do Vídeo
  * [Baixar fonte](https://github.com/viniciusfcf/quarkus/archive/v0.0.5.zip)
  * Clonar do projeto do meu GIT: **git clone --branch v0.0.5 https://github.com/viniciusfcf/quarkus.git**


### 2. Subir aplicação com Hot Reloading
* ./mvnw compile quarkus:dev


### 3. Apresentação

[Baixe aqui](https://docs.google.com/presentation/d/1SxPjwm4dElR9wx1nzk7iOd-Af9-4p5jRCIclHT33NMQ/edit?usp=sharing)

### 4. Vídeo do Youtube

https://youtu.be/OnPffQ1_idQ

# A partir do sexto vídeo: Todos os passos estão nos respectivos vídeos no youtube

https://www.youtube.com/channel/UCJNOHl-pTTTj4S9yq60Ps9A
