import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.ControleDeAcesso;
import com.example.Papel;
import com.example.Permissao;
import com.example.Usuario;

public class ControleDeAcessoTest {

    Usuario joao;
    Usuario maria;
    Papel viewer;
    Papel editor;
    Papel gerente;
    Permissao visualizar;
    Permissao editar;
    Permissao gerenciarPermissoes;

    @BeforeEach
    void setUp() {
        visualizar = new Permissao("Visualizar");
        editar = new Permissao("Editar");
        gerenciarPermissoes = new Permissao("gerenciar_permissoes");

        viewer = new Papel("Viewer");
        viewer.addPermissao(visualizar);

        editor = new Papel("Editor");
        editor.addPermissao(visualizar);
        editor.addPermissao(editar);

        gerente = new Papel("Gerente");
        gerente.addPermissao(visualizar);
        gerente.addPermissao(gerenciarPermissoes);

        joao = new Usuario("Joao");
        joao.atribuiPapel(viewer);

        maria = new Usuario("Maria");
        maria.atribuiPapel(gerente);
    }

    @Test
    void testJoaoNaoPodeEditar() {
        assertFalse(ControleDeAcesso.temPermissao(joao, "Editar"));
    }

    @Test
    void testMariaPodeGerenciarPermissoes() {
        assertTrue(ControleDeAcesso.temPermissao(maria, "gerenciar_permissoes"));
    }

    @Test
    void testGerenteCriaNovaPermissao() {
        Permissao nova = ControleDeAcesso.criaPermissao(maria, "publicar");
        assertEquals("publicar", nova.getNome());
    }

    @Test
    void testNaoGerenteNaoPodeCriarPermissao() {
        assertThrows(SecurityException.class, () -> {
            ControleDeAcesso.criaPermissao(joao, "banir");
        });
    }

    @Test
    void testGerenteAtribuiPermissaoParaEditor() {
        Permissao publicar = ControleDeAcesso.criaPermissao(maria, "publicar");
        ControleDeAcesso.atribuiPermissao(maria, editor, publicar);
        assertTrue(editor.getPermissoes().contains(publicar));
    }

    @Test
    void testAlterarPapelDeUsuario() {
        ControleDeAcesso.setPapelUsuario(maria, joao, editor);
        assertTrue(joao.getPapeis().contains(editor));
        assertFalse(joao.getPapeis().contains(viewer));
    }

    @Test
    void testCriacaoDePermissaoInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            ControleDeAcesso.criaPermissao(maria, "delete_all");
        });
    }

    @Test
    void testAtribuicaoDePapelRepetido() {
        int papeisAntes = joao.getPapeis().size();
        joao.atribuiPapel(viewer);  // viewer já foi atribuído no setUp
        int papeisDepois = joao.getPapeis().size();
        assertEquals(papeisAntes, papeisDepois);
    }
}
