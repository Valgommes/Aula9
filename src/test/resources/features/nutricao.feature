# language: pt
Funcionalidade: Controle de meta calórica diária
  Como um usuário do sistema de nutrição
  Eu quero registrar as calorias das minhas refeições
  Para acompanhar se estou dentro da minha meta calórica diária

  Cenário: Registro de refeição dentro da meta diária
    Dado que o usuário possui uma meta diária de 2000 calorias
    Quando ele registra o consumo de 600 calorias no almoço
    E registra o consumo de 400 calorias no jantar
    Então o total consumido no dia deve ser 1000 calorias
    E o status do plano deve ser "Dentro da meta"

  Cenário: Alerta ao ultrapassar a meta calórica diária
    Dado que o usuário possui uma meta diária de 2000 calorias
    Quando ele registra o consumo de 1200 calorias no almoço
    E registra o consumo de 1100 calorias no jantar
    Então o total consumido no dia deve ser 2300 calorias
    E o status do plano deve ser "Meta diária excedida"