# Projeto Agenda

Este projeto consiste em uma aplicação simples de agenda em Java, permitindo ao usuário adicionar, remover e editar contatos, bem como visualizar a lista de telefones associados a cada contato.

## Estrutura do Projeto
 O projeto é dividido em várias classes:

- **Agenda**: Classe principal que gerencia as interações com o usuário e manipula os contatos.
- **Contato**: Representa um contato, com um ID único, nome, sobrenome e uma lista de telefones associados.
- **Telefone**: Representa um número de telefone, com um ID único, DDD e número.
- **BuscaBinaria**: Realiza uma busca binária para encontrar um contato pelo ID na lista de contatos.
- **BuscaLinear**: Realiza uima busca linear para encontrar um telefone pelo ID na lista de telefones de um contato.
- **Diretorios**: Enumeração que define os caminhos dos arquivos de contatos e telefones.
- **Escritor**: Classe responsável por escrever e atualizar os arquivos de contatos e telefones.
- **Leitor**: Classe responsável por ler os arquivos de contatos e telefones.

## Como Usar

1. **Execução do programa**: Execute o programa a partir da classe 'Agenda' para interagir com a agenda.
2. **Menu de opções**: O programa exibirá um menu com diversas opções, digite o número da opção desejada.
3. **Adicionar Contato**: A opção 1 permite adicionar contatos informando nome, sobrenome e telefone.
4. **Remover Contato**: A opção 2 permite remover contatos informando o ID do contato que será removido.
5. **Editar Contato**: A opção 3 permite editar informações do contato como nome, sobrenome ou telefones.
6. **Mostrar Lista de Telefones**: A opção 4 permite visualizar a lista de telefones de um contato, basta apenas informar o ID do contato.
7. **Sair**: A opção 5 encerra o programa.

## Estrutura de arquivos
- As informações dos contatos serão armazenadas no arquivo contatos.txt no diretório 'arquivos-txt/contatos.txt'.
- As informações dos telefones dos contatos serão armazenadas no arquivo telefones.txt no diretório 'arquivos-txt/telefones.txt'.

Sinta-se à vontade para contribuir para este projeto, enviando sugestões, correções ou adicionando novos recursos. Todas as contribuições são bem-vindas!
