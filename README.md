# Circuit Breaker Spring Boot Order Service

Este repositório contém uma implementação de um serviço de pedidos que utiliza o padrão **Circuit Breaker** para se comunicar com um serviço externo de endereços. O Circuit Breaker é implementado usando a biblioteca [Resilience4j](https://resilience4j.readme.io/docs) para gerenciar falhas de comunicação e garantir maior resiliência na aplicação.

## Visão Geral

O **Circuit Breaker Spring Boot Order Service** é um serviço de pedidos que faz requisições ao [Circuit Breaker Spring Boot Address Service](https://github.com/willbigas/CircuitBreakerSpringBootAddressService) para obter informações de endereço. Esse serviço aplica o padrão Circuit Breaker para:
- Monitorar as falhas de comunicação com o serviço de endereços.
- Bloquear temporariamente as tentativas de comunicação após um número específico de falhas consecutivas.
- Realizar tentativas automáticas de reativação do serviço quando o endereço estiver acessível novamente.

## Repositórios

- **Order Service (este projeto):** [Circuit Breaker Spring Boot Order Service](https://github.com/willbigas/CircuitBreakerSpringBootOrderService)
- **Address Service:** [Circuit Breaker Spring Boot Address Service](https://github.com/willbigas/CircuitBreakerSpringBootAddressService)

## Tecnologias Utilizadas

Este serviço foi construído utilizando:

- **Spring Boot:** Framework para criação de serviços REST.
- **Spring Data JPA:** Acesso simplificado ao banco de dados.
- **Spring Boot Actuator:** Monitoramento e métricas do serviço.
- **Resilience4j:** Implementação do Circuit Breaker.
- **H2 Database:** Banco de dados em memória para desenvolvimento e testes.
- **Lombok:** Redução de boilerplate com anotações.

## Dependências

```groovy
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-aop'
    implementation 'io.github.resilience4j:resilience4j-spring-boot3:2.2.0'
    implementation 'org.springframework.boot:spring-boot-starter-actuator'
    compileOnly 'org.projectlombok:lombok'
    developmentOnly 'org.springframework.boot:spring-boot-devtools'
    runtimeOnly 'com.h2database:h2'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
}
