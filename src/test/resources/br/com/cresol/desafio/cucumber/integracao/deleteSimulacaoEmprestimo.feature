#language: pt
@simulacaoEmprestimoDelete
Funcionalidade: Teste integracao simulacaoEmprrestimo delete

  Cenario: Teste dados ContratarEmprestimo delete
    Dado que tenha os seguintes dados para simulacao de Emprrestimo para delete.
    |cpf        | nome       | email                | valorContrato |quantidadeParcelas|
    |64951629011|josé estrela|jose.estrela@gmail.com|   55600,56    |     12           |
    Quando chamar o seviço de delete de simulação de emprestimo
    Entao o mesmo deve ser deletado
