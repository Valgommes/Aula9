package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class AutenticacaoSteps {
    private String usuarioCadastrado;
    private String senhaCadastrada;
    private boolean autenticado;

    @Dado("que o usuário {string} com senha {string} está cadastrado")
    public void cadastrar_usuario(String usuario, String senha) {
        this.usuarioCadastrado = usuario;
        this.senhaCadastrada = senha;
    }

    @Quando("eu faço login com {string} e {string}")
    public void fazer_login(String usuario, String senha) {
        this.autenticado = usuario.equals(this.usuarioCadastrado)
                && senha.equals(this.senhaCadastrada);
    }

    @Então("acesso é concedido")
    public void verificar_acesso_concedido() {
        assertTrue(this.autenticado);
    }

    @Então("o acesso é negado")
    public void verificar_acesso_negado() {
        assertFalse(this.autenticado);
    }
}