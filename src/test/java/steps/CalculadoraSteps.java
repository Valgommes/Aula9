package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

class Calculadora {
    public static int somar(int a, int b) {
        return a + b;
    }

    public static int dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisão por zero não permitida");
        }
        return a / b;
    }
}

public class CalculadoraSteps {
    private int num1, num2;
    private int resultado;
    private Exception exception;

    @Dado("que eu tenho os números {int} e {int}")
    public void definir_numeros(int a, int b) {
        this.num1 = a;
        this.num2 = b;
    }

    @Quando("eu peço para somar")
    public void somar() {
        this.resultado = Calculadora.somar(num1, num2);
    }

    @Então("o resultado deve ser {int}")
    public void verificar_resultado(int esperado) {
        assertEquals(esperado, resultado);
    }

    @Quando("eu peço para dividir")
    public void dividir() {
        try {
            this.resultado = Calculadora.dividir(num1, num2);
        } catch (Exception e) {
            this.exception = e;
        }
    }

    @Então("o sistema deve informar {string}")
    public void verificar_mensagem(String mensagem) {
        assertNotNull(exception);
        assertEquals(mensagem, exception.getMessage());
    }
}