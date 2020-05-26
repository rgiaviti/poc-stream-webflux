Essa é uma POC usando o Spring Webflux para fazer _streaming_ de dados de uma _capped collection_ do Mongo.

## Requisitos
Para fazer a aplicação funcionar irá precisar:

- Mongo instalado;
- JDK 11;
- Maven;

## Objetivo
O objetivo dessa aplicação é receber uma atualização sempre que um novo livro for inserido em uma collection do Mongo usando o Flux.
Isso é possível usando o _@Tailable_ do Spring Data onde o ao se a fazer uma consulta, o Mongo não fecha o cursor ao final ao terminar.
Fechar o cursor é o comportamente padrão do Mongo quando ele termina de executar uma consulta em uma _collection_.

O Mongo somente permite manter o cursor aberto em capped collection porque ficá inpraticável manter cursores abertos em coleções "infinitas".

## Baixando e Compilando
```
$ git clone git@github.com:rgiaviti/poc-stream-webflux.git
$ cd poc-stream-webflux/server
```
Mude no _**application.properties**_ a URI de conexão com o Mongo para a aplicação se conectar a sua instalação do Mongo.

Acesse o Mongo e **crie uma capped collection** com o nome de **books**. É muito importante que essa coleção seja capped, pois o `@Tailable` somente funciona em capped collections. Mais informações sobre as capped collections, você encontra aqui: https://docs.mongodb.com/manual/core/capped-collections

Do jeito que está, se você não alterar nada no `application.properties`, a aplicação se conectará a esse Mongo:

```
mongodb://root:root@localhost:27017/library?authSource=admin&authMechanism=SCRAM-SHA-256
```

## Rodando a aplicação
```
$ mvn spring-boot:run
```

## Testando
Basta fazer um cURL:
```
$ curl http://localhost:8080/books/subscribe
```
Você também pode testar através do client Python aqui do repositório.
```
$ cd client
$ python3 FluxStreamClient.py
```