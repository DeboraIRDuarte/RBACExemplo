package com.example;
//Classe que verifica as permissoes
public class ControleDeAcesso {
    // Verifica se o usuario tem uma permissao especifica
    public static boolean temPermissao(Usuario usuario, String nomePermissao) {
        Permissao target = new Permissao(nomePermissao);

        for (Papel papel : usuario.getPapeis()) {
            if (papel.getPermissoes().contains(target))
                return true;
        }
        return false;
    }

    // Cria uma nova permissao (somente para gerentes)
    public static Permissao criaPermissao(Usuario usuarioAgindo, String nome) {
        if (temPermissao(usuarioAgindo, "gerenciar_permissoes")) {
            return new Permissao(nome);
        } else {
            throw new SecurityException("Usuário sem permissão para criar permissões.");
        }
    }

    // Atribui uma permissão a um papel (somente gerente)
    public static void atribuiPermissao(Usuario usuarioAgindo, Papel papel, Permissao permissao) {
        if (temPermissao(usuarioAgindo, "gerenciar_permissoes")) {
            papel.addPermissao(permissao);
        } else {
            throw new SecurityException("Usuário sem permissão para atribuir permissões.");
        }
    }

    // Remove uma permissão de um papel (somente gerente)
    public static void removePermissao(Usuario usuarioAgindo, Papel papel, Permissao permissao) {
        if (temPermissao(usuarioAgindo, "gerenciar_permissoes")) {
            papel.removePermissao(permissao);
        } else {
            throw new SecurityException("Usuário sem permissão para remover permissões.");
        }
    }

    // Altera o papel de um usuário (somente gerente)
    public static void setPapelUsuario(Usuario usuarioAgindo, Usuario targetUsuario, Papel newPapel) {
        if (temPermissao(usuarioAgindo, "gerenciar_permissoes")) {
            targetUsuario.limparPapeis();
            targetUsuario.atribuiPapel(newPapel);
        } else {
            throw new SecurityException("Usuário sem permissão para alterar papéis.");
        }
    }
}