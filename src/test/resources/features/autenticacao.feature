# language: pt
Funcionalidade: Autenticação de usuário

  Cenário: Login válido
    Dado que o usuário "admin" com senha "1234" está cadastrado
    Quando eu faço login com "admin" e "1234"
    Então acesso é concedido

  Cenário: Senha inválida
    Dado que o usuário "admin" com senha "1234" está cadastrado
    Quando eu faço login com "admin" e "senhaerrada"
    Então o acesso é negado