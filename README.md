# Installation
아래의 명령어를 실행하여 Docker Image 를 설치한다.
```
$ cd docker
$ docker-compose up -d
```

# docker
아래의 명령어를 실행하여 Docker Image 를 생성 및 실행한다.
## 생성
```
$ docker build --tag kafka-example:0.0.1 .
```
## 실행
```
$ docker run -d -p 8080:8080 --name kafka-example kafka-example:0.0.1
```

# Document
[Spring Kafka 참고문서](https://docs.spring.io/spring-kafka/docs/current/reference/html/#ex-jdbc-sync)
[Spring Kafka 샘플코드 1](https://github.com/spring-projects/spring-kafka/tree/main/samples)
[Spring Kafka 샘플코드 2](https://github.com/TechPrimers/spring-boot-kafka-producer-example)
[Spring Kafka 샘플코드 3](https://github.com/TechPrimers/spring-boot-kafka-consumer-example)
[Kafka Producer & Consumer Configuration 참고문서](https://madplay.github.io/post/kafka-producer-consumer-options)
[Kafka ErrorHandlingDeserializer 참고문서](https://www.skyer9.pe.kr/wordpress/?p=1614)

# Issue
## 하나의 프로젝트에서 각기 다른 Kafka 의 producer / consumer 를 생성할 경우 
기본적으로 같은 Kafka 를 바라보면서 여러개의 Topic 을 바라보는 경우는 Spring Boot 의 Auto Configuration 을 이용하여 간단히 구현할 수 있지만 물리적으로 다른 Kafka 들의 Topic 을 바라보고자 한다면 Java 코드로 직접 구현하여야한다. 
[샘플코드](https://github.com/TechPrimers/spring-boot-kafka-consumer-example)