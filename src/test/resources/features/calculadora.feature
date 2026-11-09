# language: pt
Funcionalidade: Calculadora

  Cenário: Soma de dois números
    Dado que eu tenho os números 5 e 7
    Quando eu peço para somar
    Então o resultado deve ser 12

  Cenário: Divisão por zero
    Dado que eu tenho os números 10 e 0
    Quando eu peço para dividir
    Então o sistema deve informar "Divisão por zero não permitida"