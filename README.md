# 🚀 Projeto Curso – API REST com Spring Boot

Este projeto é uma **API REST desenvolvida em Java com Spring Boot**, aplicando **boas práticas de arquitetura**, **modelagem relacional**, **tratamento de exceções**, **padrões REST** e **persistência com JPA/Hibernate**.

O sistema simula um **cenário real de e-commerce**, com usuários, pedidos, produtos, categorias e pagamentos, criado para demonstrar conhecimentos em **backend Java**.

---

## 🧠 Visão Geral do Projeto

A aplicação permite:

- Gerenciar **Usuários**
- Consultar **Produtos** e **Categorias**
- Criar e consultar **Pedidos**
- Calcular automaticamente o **valor total do pedido**
- Controlar **status do pedido** (aguardando pagamento, pago, enviado, etc.)
- Tratar erros de forma padronizada (RESTful)

Tudo isso seguindo uma **arquitetura em camadas**, facilitando manutenção, escalabilidade e leitura do código.

---

## 🏗️ Arquitetura Utilizada

O projeto foi organizado seguindo o padrão **Controller → Service → Repository**, amplamente utilizado em aplicações profissionais com Spring Boot.

com.ProjetoJN.curso
│
├── entities → Entidades JPA

├── entities.enums → Enumerações do domínio

├── entities.pk → Chaves primárias compostas
│
├── repositorios → Interfaces JpaRepository

├── servicos → Regras de negócio

├── recursos → Controllers REST

├── recursos.exceptions → Tratamento global de erros
│
└── CursoApplication → Classe principal


---

## 🗃️ Modelagem do Domínio

### Principais Entidades

- **Usuario**
- **Pedido**
- **Produto**
- **Categoria**
- **ItemDoPedido** (relacionamento N:N com chave composta)
- **Pagamento**

### Relacionamentos

- Usuário **1:N** Pedido  
- Pedido **1:N** ItemDoPedido  
- Produto **N:N** Categoria  
- Pedido **1:1** Pagamento  

✔️ Utilização de:
- `@OneToMany`
- `@ManyToOne`
- `@ManyToMany`
- `@OneToOne`
- `@Embeddable` (chave composta)

---

## 📦 Tecnologias Utilizadas

- **Java JDK 8+**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **Maven**
- **MySQL**
- **Jackson (JSON)**
- **Postman** (testes da API)

---

## 🔗 Endpoints da API

### Usuários
- `GET /usuarios` – Lista todos os usuários
- `GET /usuarios/{id}` – Busca usuário por ID
- `POST /usuarios` – Cria um novo usuário
- `PUT /usuarios/{id}` – Atualiza usuário existente
- `DELETE /usuarios/{id}` – Deleta usuário por ID

### Produtos
- `GET /produtos` – Lista todos os produtos
- `GET /produtos/{id}` – Busca produto por ID

### Categorias
- `GET /categorias` – Lista todas as categorias
- `GET /categorias/{id}` – Busca categoria por ID

### Pedidos
- `GET /pedidos` – Lista todos os pedidos
- `GET /pedidos/{id}` – Busca pedido por ID

---

## ⚠️ Tratamento de Exceções

A aplicação possui **tratamento global de erros**, retornando respostas claras e padronizadas:

```json
{
  "dataHora": "2025-01-01T12:00:00Z",
  "codigoStatus": 404,
  "erro": "Recurso nao encontrado",
  "mensagem": "Recurso nao encontrado. Id 10",
  "caminhoRequisicao": "/usuarios/10"
}
```

🧮 Regras de Negócio Implementadas

- Conversão de Status do Pedido via enum

- Cálculo automático do total do pedido

- Validação de exclusão de usuário

- Atualização parcial de dados

- Proteção contra inconsistência no banco

🧪 Testes da API

A API foi testada utilizando o Postman, validando:

- Retornos HTTP corretos

- Criação e atualização de recursos

- Tratamento de erros

- Serialização JSON


🎯 Objetivo do Projeto

Este projeto foi desenvolvido com foco em:

- Consolidar conhecimentos em Java e Spring Boot

- Aplicar boas práticas de desenvolvimento backend

- Servir como projeto de portfólio profissional

- Simular um sistema real usado no mercado

👨‍💻 Autor

João Neto
🎓 Estudante de Sistemas de Informação
🚀 Em constante evolução e busca por oportunidades
linkedin: https://www.linkedin.com/in/joao-rodrigues-neto-855757293/
