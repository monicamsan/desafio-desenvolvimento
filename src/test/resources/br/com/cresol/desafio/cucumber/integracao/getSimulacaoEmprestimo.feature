#language: pt
@simulacaoEmprestimoGet
Funcionalidade: Teste integracao simulacaoEmprrestimo get

  Cenario: Teste dados ContratarEmprestimo get
    Dado que tenha os seguintes dados para simulacao de Emprrestimo para get.
    |cpf        | nome       | email                | valorContrato |quantidadeParcelas|
    |64951629011|josé estrela|jose.estrela@gmail.com|   55600,56    |     12           |
    Quando chamar o seviço de busca por id de simulação de emprestimo
    Entao a simulação deve ser retornada