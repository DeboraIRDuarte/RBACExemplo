package com.example;

public class Main {
    
    public static void configuracaoInicial(){
        Permissao visualizar = new Permissao("Visualizar");
        Permissao editar = new Permissao("Editar");
        Permissao deletar = new Permissao("Deletar");
        Permissao gerenciarPermissoes = new Permissao("gerenciar_permissoes");

        Papel viewer = new Papel("Viewer");
        viewer.addPermissao(visualizar);

        Papel editor = new Papel("Editor");
        editor.addPermissao(visualizar);
        editor.addPermissao(editar);

        Papel admin = new Papel("Admin");
        admin.addPermissao(visualizar);
        admin.addPermissao(editar);
        admin.addPermissao(deletar);

        Papel gerente = new Papel("Gerente");
        gerente.addPermissao(visualizar);
        gerente.addPermissao(gerenciarPermissoes);
    }

    // Métodos auxiliares para manipular o sistema

    public static Usuario criarUsuario(String nome) {
        return new Usuario(nome);
    }

    public static void atribuirPapel(Usuario usuario, Papel papel) {
        usuario.atribuiPapel(papel);
    }

    public static void criarEAdicionarPermissao(Usuario gerente, Papel papel, String nomePermissao) {
        Permissao novaPermissao = ControleDeAcesso.criaPermissao(gerente, nomePermissao);
        ControleDeAcesso.atribuiPermissao(gerente, papel, novaPermissao);
    }
    public static void main(String[] args) {
        configuracaoInicial();
    }
}