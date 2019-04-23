#language: pt
@cliente
Funcionalidade: Teste Cliente

  Cenario: Teste dados clientes
    Dado que um cliente con seguintes dados.
    |cpf        | nome       | email                |
    |03106097561|josé estrela|jose.estrela@gmail.com|
    Quando quando consultar o cliente com id 1.
    Entao retornará o cliente cadastrado anteriomente.