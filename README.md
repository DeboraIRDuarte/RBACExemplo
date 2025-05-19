# Sistema RBAC em Java

Este projeto demonstra um sistema simples de controle de acesso baseado em papéis (RBAC), com 3 papéis principais:
- **Viewer**: pode apenas visualizar dados.
- **Editor**: pode visualizar e editar.
- **Gerente**: pode visualizar e gerenciar permissões e papéis.

## Como executar
- Requisitos: Java 11+, JUnit 5
- Compile: `javac com/example/*.java`
- Teste: usando seu framework ou ferramenta preferida (JUnit via IntelliJ, VSCode ou Maven)

## Testes cobertos
- Acesso negado e permitido com base no papel
- Criação de permissões por gerente
- Alteração de papéis de outros usuários
