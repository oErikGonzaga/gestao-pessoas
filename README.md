# Gestão de Pessoas

---
Projeto Java desenvolvido para avaliação.

<br>

__Para ilustrar o projeto inclui:__

_(a) Uma aplicação que oferece funcionalidade de registro de dados:
(b) uma RESTFul API para acesso à funcionalidade._

<br>

> _Objetivo: ilustrar uma organização de código em Java usando
> "clean code" e "boas práticas"_.

<br>

- `Funcionalidade 1` `Cadastro de Pessoas`: 
   Nosso sistema estar apto a cadastrar os dados de uma pessoa. 
   Para cadastrar uma pessoa, devem ser informados seu nome completo, e sua data de nascimento.
   Todos os campos são obrigatórios.



- `Funcionalidade 2` `Edição do cadastro de pessoas`: 
   O sistema pode editar os dados de uma pessoa. 
   Para a edição dos dados no sistema, é preciso informar obrigatoriamente ou seu nome, 
   ou data de nascimento, ou ambos para ser alterado.



- `Funcionalidade 3` `Consulta de pessoa`: 
   Para consulta de uma pessoa no sistema, precisamos informar seu identificador válido no cadastro do sistema.



- `Funcionalidade 4` `Listagem de pessoas cadastradas`: 
   O sistema realiza uma listagem de todas pessoas cadastradas no sistema.



- `Funcionalidade 5` `Cadastro de endereço de pessoa`:
   Cadastra um ou mais endereços se informado um identificador da Pessoa.



- `Funcionalidade 6` `Listagem de endereço da pessoa`:
   O sistema realiza uma listagem de todas endereços relacionados a pessoa cadastrada, 
   quando informado o identificador na requisição.



## ✔️ Como rodar a aplicação via Docker

---

* Acesse a raiz do projeto onde está o arquivo Dockerfile:

```
* Build container
docker build -t gestao-pessoas-java-container:1.0 .

* Run the container
docker run -d -p 8080:8080 -t gestao-pessoas-java-container:1.0
```

_Obs: Deixei o jar do projeto na raiz para rodar via Docker._

## ✔️ Teste Unitários

---

* Prova conceitual da execução dos testes unitários:
* ``JUnit 5 e Mockito``

<br>

![tests.png](https://dsm01pap003files.storage.live.com/y4mgYlqDOmHUDp4obKr7ayX2REjyb_OiYZEtYKKAO0Jz-UGpeBCf5jwX-SX-it85gs_1TqsRmB3OVZ7UrersxqNzJ2Ii-LPX0lNjeXNQ-A8c-2SI0w6rFr_pFabJmV_H-paYvzxMtB6tVrxx-BQShKhVbcDt-c7VPjHwVx82Uoxx1vxm2rmvv5ywVIzeY_mH0n9?width=1024&height=239&cropmode=none)



## ✔️ Técnicas e tecnologias utilizadas

---
- ``Java 11``
- ``Maven 3.8.1``
- ``SpringBoot 2.7.7``
- ``IntelliJ IDEA``
- ``Postman``
- ``Paradigma de orientação a objetos``

---

## 📁 Acesso ao projeto

---
Você pode acessar os arquivos do projeto clicando 
[aqui](https://github.com/oErikGonzaga/gestao-pessoas/tree/main/src).


