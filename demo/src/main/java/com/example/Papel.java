package com.example;
import java.util.HashSet;
import java.util.Set;

//Classe que representa uma função/papel (admin, editor)
public class Papel {
    private final String nome;
    private final Set<Permissao> permissoes = new HashSet<>();

    public Papel(String nome) {
        this.nome = nome;
    }

    // Adiciona permissao a um papel
    public void addPermissao(Permissao permissao) {
        permissoes.add(permissao);
    }

    // Remove uma permissao
    public void removePermissao(Permissao permissao) {
        permissoes.remove(permissao);
    }

    public String getNome() {
        return nome;
    }

    public Set<Permissao> getPermissoes() {
        return permissoes;
    }
}
