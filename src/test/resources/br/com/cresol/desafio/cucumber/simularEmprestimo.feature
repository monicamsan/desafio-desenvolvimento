#language: pt
@simularEmprestimo
Funcionalidade: Teste SimularEmprestimo

  Cenario: Teste dados SimularEmprestimo
    Dado que tenha um cliente com seguintes dados.
    |cpf        | nome       | email                |
    |03106097561|josé estrela|jose.estrela@gmail.com|
    E que tenha simulacao com seguintes dados 
    |  numeroContrato   | valorContrato   | quantidadeParcelas    |taxaJurosParcela  |   dataSimulacaoStr | dataValidadeSimulacaoStr | valorParcela |idCliente|      
    |     0216131       |   456.20        |        5              | 1.8              |   2011-11-11       |  2015-11-11              |  91.24       | 1       |
    Quando quando consultar a SimularEmprestimo com id 3.
    Entao retornará o SimularEmprestimo cadastrado anteriomente.