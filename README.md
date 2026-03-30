# Lojinha Online — Arquitetura de Software

Simulação de um sistema de lojinha online desenvolvido em Java com Spring Boot, seguindo arquitetura cliente-servidor monolítica.

## Tecnologias
- Java 21
- Spring Boot 3.5
- Maven

## Estrutura do Projeto
```
src/br/com/lojinha/
├── model/       — entidades do sistema (Cliente, Produto, Pedido, ItemPedido, Pagamento)
├── payment/     — conexão com o sistema externo de pagamento (Singleton)
├── service/     — regras de negócio e orquestração do fluxo
└── controller/  — endpoints REST da API
```

## Decisões Arquiteturais
- **Arquitetura monolítica:** toda a lógica do backend está concentrada em uma única aplicação Spring Boot, que centraliza as responsabilidades de cliente, servidor e pagamento.
- **Dados estáticos em memória:** clientes e produtos são inicializados diretamente nos services, sem banco de dados, conforme requisito da atividade.
- **Separação de responsabilidades:** models representam os dados, services contêm as regras de negócio e controllers expõem os endpoints REST.

## Singleton — PagamentoGateway
O padrão Singleton foi aplicado na classe `PagamentoGateway`, localizada no pacote `payment/`. O objetivo é garantir que exista apenas uma instância de conexão com o sistema externo de pagamento durante toda a execução do sistema, evitando múltiplas conexões desnecessárias e centralizando o ponto de comunicação.

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

## Testando a API
O script de teste completo está disponível em `docs/script-teste.txt`.