# Lojinha Online — Arquitetura de Software

Simulação de um sistema de lojinha online desenvolvido em Java com Spring Boot, seguindo arquitetura cliente-servidor monolítica.

## Tecnologias
- Java 21
- Spring Boot 3.5
- Maven

## Como executar
```bash
cd lojinha-online/lojinha
mvn spring-boot:run
```
A aplicação sobe em `http://localhost:8080`.

## Endpoints
| Método | Rota | Descrição |
|--------|------|-----------|
| GET | /clientes | Lista clientes |
| POST | /clientes | Cadastra cliente |
| GET | /produtos | Lista produtos |
| POST | /produtos | Adiciona produto |
| GET | /pedidos | Lista pedidos |
| POST | /pedidos | Cria pedido |
| GET | /pagamentos | Lista pagamentos |
| POST | /pagamentos | Processa pagamento |

## Padrão de Projeto
O Singleton foi aplicado na classe `PagamentoGateway`, garantindo uma única instância de conexão com o sistema externo de pagamento durante toda a execução.

## Testando com Postman
O script de teste completo seguindo o fluxo do sistema está disponível no arquivo `lojinha-online/lojinha/docs/script-teste.txt`.