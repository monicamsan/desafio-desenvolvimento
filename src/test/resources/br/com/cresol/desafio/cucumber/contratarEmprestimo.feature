#language: pt
@contratarEmprestimo
Funcionalidade: Teste ContratarEmprestimo

  Cenario: Teste dados ContratarEmprestimo
    Dado que tenha um cliente com seguintes dados ContratarEmprestimo.
    |cpf        | nome       | email                |
    |03106097561|josé estrela|jose.estrela@gmail.com|
    E que tenha simulacao com seguintes dados ContratarEmprestimo
    |  numeroContrato   | valorContrato   | quantidadeParcelas    |taxaJurosParcela  |   dataSimulacaoStr | dataValidadeSimulacaoStr | valorParcela |idCliente|      
    |     0216131       |   456.20        |        5              | 1.8              |   2011-11-11       |  2015-11-11              |  91.24       | 1       |
    E que tenha contrato emprestimo com seguintes dados 
    |  numeroContrato   | valorContrato   | quantidadeParcelas    |taxaJurosParcela  |   dataContratacaoStr | iofContrato  |idSimularEmprestimo|      
    |     0216131       |   456.20        |        5              | 1.8              |   2011-11-11         |  91.24       | 3                 |
    Quando quando consultar o ContratarEmprestimo com id 4.
    Entao retornará o ContratarEmprestimo cadastrado anteriomente.