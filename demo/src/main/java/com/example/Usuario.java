package com.example;
import java.util.HashSet;
import java.util.Set;

//Classe para representar um usuário no sistema
public class Usuario {

    private final String nomeUsuario;
    private final Set<Papel> papeis = new HashSet<>();

    public Usuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    // Atribuição de um papel para o usuario 
    public void atribuiPapel(Papel papel) {
        if (!papeis.contains(papel)){ //verifica se papel já existe antes de atribuir
            papeis.add(papel);
        }
    }

    public void removerPapel(Papel papel) {
        papeis.remove(papel);
    }

    public void limparPapeis() {
        papeis.clear();
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public Set<Papel> getPapeis() {
        return papeis;
    }
}
