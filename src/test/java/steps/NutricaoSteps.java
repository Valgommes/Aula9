package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.E;
import static org.junit.Assert.assertEquals;

class DiarioNutricional {
    private final int metaCalorica;
    private int caloriasConsumidas = 0;

    public DiarioNutricional(int metaCalorica) {
        this.metaCalorica = metaCalorica;
    }

    public void adicionarRefeicao(int calorias) {
        this.caloriasConsumidas += calorias;
    }

    public int getCaloriasConsumidas() {
        return caloriasConsumidas;
    }

    public String obterStatus() {
        if (caloriasConsumidas > metaCalorica) {
            return "Meta diária excedida";
        }
        return "Dentro da meta";
    }
}

public class NutricaoSteps {
    private DiarioNutricional diario;

    @Dado("que o usuário possui uma meta diária de {int} calorias")
    public void definir_meta_diaria(int meta) {
        this.diario = new DiarioNutricional(meta);
    }

    @Quando("ele registra o consumo de {int} calorias no almoço")
    public void registrar_almoco(int calorias) {
        this.diario.adicionarRefeicao(calorias);
    }

    @E("registra o consumo de {int} calorias no jantar")
    public void registrar_jantar(int calorias) {
        this.diario.adicionarRefeicao(calorias);
    }

    @Então("o total consumido no dia deve ser {int} calorias")
    public void verificar_total_consumido(int totalEsperado) {
        assertEquals(totalEsperado, this.diario.getCaloriasConsumidas());
    }

    @E("o status do plano deve ser {string}")
    public void verificar_status_plano(String statusEsperado) {
        assertEquals(statusEsperado, this.diario.obterStatus());
    }
}