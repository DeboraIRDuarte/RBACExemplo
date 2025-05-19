package com.example;

public enum PermissoesValidas {
    VISUALIZAR, EDITAR, GERENCIAR_PERMISSOES, DELETAR, MOVER, AUTORIZAR;

    public static boolean contem(String valor) {
        if (valor == null) return false;
        for (PermissoesValidas permissaoNome : PermissoesValidas.values()) {
            if (permissaoNome.name().equalsIgnoreCase(valor)) {
                return true;
            }
        }
        return false;
    }
}
