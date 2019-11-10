# Desafios Técnico Conductor

# Desafio Técnico 01

Nós da Conductor trabalhamos com meios de pagamento e nada melhor que um bom sistema para gestão de contas:

## Pré-requisitos:

* Desenvolver os recursos em API Rest que realizam operações bancárias com a entidade conta a seguir:
- [x] Contas	            Tipo
- [x] idConta	            Numérico
- [x] idPessoa	        	Numérico
- [x] saldo	            	Monetário
- [x] limiteSaqueDiario		Monetário
- [x] flagAtivo	        	Condicional
- [x] tipoConta	        	Numérido
- [x] dataCriacao	        Data

* Tabela de transações realizadas na conta
- [x] Transacoes	    Tipo
- [x] idTransacao	    Numérico
- [x] idConta	        Numérico
- [x] valor	        	Monetário
- [x] dataTransacao		Data

* P.S.: Não é necessário realizar operações com a tabela pessoa, mas é necessária a criação da tabela para mapeamento da relação com a conta e enviar script de criação de pelo menos uma pessoa.
Pessoas			Tipo
idPessoa		Numérico
nome			Texto
cpf				Texto
dataNascimento	Data


## O que esperamos como escopo mínimo:

- [x]  Implementar path que realiza a criação de uma conta;
- [x]  Implementar path que realiza operação de depósito em uma conta;
- [x]  Implementar path que realiza operação de consulta de saldo em determinada conta;
- [x]  Implementar path que realiza operação de saque em uma conta;
- [x]  Implementar path que realiza o bloqueio de uma conta;
- [x]  Implementar path que recupera o extrato de transações de uma conta;

## O que será diferencial:

- [x]  Implementar extrato por período;
- [ ]  Elaborar manual de execução;
- [ ]  Elaborar documentação javadoc;
- [ ]  Elaborar testes.


# Desafio Técnico 02

Nós da Conductor trabalhamos com meios de pagamento e a maior parte das nossas integrações com outros sistemas são via arquivo de texto. O desafio será um simples sistema para geração de arquivos;

Deve-se desenvolver uma aplicação que acesse o banco de dados e gere um arquivo a partir da tabela e layout abaixo:

* Tabela de transações
	  Transacoes	Tipo
- [x] idTransacao	Numérico
- [x] cartao		Numérico
- [x] valor			Monetário
- [x] data			Data

* Layout do arquivo a ser gerado
	  Campo				Tipo			Tamanho/Formato
- [x] cartao			Numérico		16
- [x] dataNascimento	Data			ddMMyyyy
- [x] valor				Monetário		11 (sem virgula, as duas ultimas posições são os decimais)

## O que esperamos como escopo mínimo:

- [x] Geração de um arquivo com as transações de acordo com a data informada como parametro na execução da aplicação;

## O que será diferencial:

- [x] Desempenho otimizado;
- [ ] Elaborar manual de execução;
- [ ] Elaborar documentação;
- [ ] Elaborar testes;

# API
- [x] eProcessos e eProtocolos
- [x] Autorização do Gestor em Documentos Fiscais
- [x] GED (Gestão Eletrônica de Documentos
- [x] Solicitação de cadastro de Fornecedores
- [x] Solicitação de adiantamento de despesas
- [x] Autorização do Gestor em adiantamento de despesas
- [x] Controle de Prestação de Contas
- [x] Aprovação de Prestação de Contas
- [x] Controle de Equipamentos do TI

# O que vamos avaliar:

* Seu código;
* Script de banco;
* Organização;
* Boas práticas;
* Diferenciais;


# Stack utilizada no desenvolvimento
- [x] Java 8
- [x] Spring Boot 2.2.0.RELEASE
- [x] Spring MVC
- [x] Spring Data JPA