package com.example;
import java.util.Objects;

//Classe que representa uma permissão (ex: visualizar, editar, deletar)
public class Permissao {
    private final String nome;

    public Permissao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    // Permissões são consideradas iguais se tiverem o mesmo nome
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Permissao))
            return false;
        Permissao that = (Permissao) o;
        return nome.equalsIgnoreCase(that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome.toLowerCase());
    }
}
