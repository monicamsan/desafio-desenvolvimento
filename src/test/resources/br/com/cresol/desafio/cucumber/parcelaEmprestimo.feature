#language: pt
@parcelaEmprestimo
Funcionalidade: Teste ParcelaEmprestimo

  Cenario: Teste dados ParcelaEmprestimo
    Dado que tenha um cliente com seguintes dados ParcelaEmprestimo.
    |cpf        | nome       | email                |
    |03106097561|josé estrela|jose.estrela@gmail.com|
    E que tenha simulacao com seguintes dados ParcelaEmprestimo
    |  numeroContrato   | valorContrato   | quantidadeParcelas    |taxaJurosParcela  |   dataSimulacaoStr | dataValidadeSimulacaoStr | valorParcela |idCliente|      
    |     0216131       |   456.20        |        5              | 1.8              |   2011-11-11       |  2015-11-11              |  91.24       | 1       |
    E que tenha contrato emprestimo com seguintes dados ParcelaEmprestimo
    |  numeroContrato   | valorContrato   | quantidadeParcelas    |taxaJurosParcela  |   dataContratacaoStr | iofContrato  |idSimularEmprestimo|      
    |     0216131       |   456.20        |        5              | 1.8              |   2011-11-11         |  91.24       | 3                 |
    E que tenha Parcela Emprestimo com seguintes dados 
    |  numeroDaParcela   | valorParcela   | dataVencimentoStr     |idContratarEmprestimo  |  
    |     1              |  91.24         |       2015-11-11      |4                      |  
    Quando quando consultar a ParcelaEmprestimo com id 8.
    Entao retornará a ParcelaEmprestimo cadastrado anteriomente.