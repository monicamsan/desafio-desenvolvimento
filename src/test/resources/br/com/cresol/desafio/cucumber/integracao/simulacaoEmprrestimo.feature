#language: pt
@simulacaoEmprestimo
Funcionalidade: Teste integracao simulacaoEmprrestimo

  Cenario: Teste dados ContratarEmprestimo
    Dado que tenha os seguintes dados para simulacao de Emprrestimo.
    |cpf        | nome       | email                | valorContrato |quantidadeParcelas|
    |64951629011|josé estrela|jose.estrela@gmail.com|   55600,56    |     12           |
    Quando chamar o seviço de simulação de emprestimo
    Entao os seguintes dados vão ser retornados
    | valorContrato |quantidadeParcelas|valorParcela |numeroContrato|taxaJurosParcela|
    |   55600,56    |     12           | 6301,40     |AAAAMMDD000001|  3             |