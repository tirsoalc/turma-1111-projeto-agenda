import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Contato.*;

public class Agenda {
    private static List<Contato> contatos = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int entrada = 0;
        while (true) {
            System.out.println("""
                    ##################
                    ##### AGENDA #####
                    ##################
                    """);
            System.out.println(">>>> Contatos <<<<");
            exibirContatos();

            System.out.println();
            System.out.println(">>>> Menu <<<<");
            System.out.println("1 - Adicionar Contato");
            System.out.println("2 - Remover Contato");
            System.out.println("3 - Editar Contato");
            System.out.println("4 - Sair");

            entrada = scanner.nextInt();
            if (entrada == 1) {
                adicionarContato();
            } else if (entrada == 4) {
                break;
            }

        }
        scanner.close();
    }

    private static void exibirContatos() {
        System.out.println("ID | Nome");
        for (int i = 0; i < contatos.size(); i++) {
            Contato contato = contatos.get(i);
            System.out.printf("%d | %s\n",contato.getId(),contato.getNomeCompleto());

        }
    }
    private static void adicionarContato() {
        Scanner scanner = new Scanner(System.in);

        Contato novoContato = new Contato();
        novoContato.setId(gerarNovoIdContato());
        editarNomeContato(novoContato);
        editarSobrenomeContato(novoContato);
//        adicionarTelefone(novoContato);

        contatos.add(novoContato);
    }

    private static Long gerarNovoIdContato() {
        if (contatos.size() == 0) {
            return 1L;
        }
        Long ultimoContatoID = contatos.get(contatos.size()-1).getId();
        return (ultimoContatoID+1);
    }

    private static void editarNomeContato(Contato contato) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do contato: ");
        String nomeContato = scanner.next();
        contato.setNome(nomeContato);
    }

    private static void editarSobrenomeContato(Contato contato) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o sobrenome do contato: ");
        String sobrenomeContato = scanner.next();
        contato.setSobrenome(sobrenomeContato);
    }

//    private static void adicionarTelefone(Contato contato) {
//        Scanner scanner = new Scanner(System.in);
//        Telefone novoTelefone = new Telefone();
//
//        try {
//            System.out.println("Digite o DDD do contato: ");
//            String dddContato = scanner.next();
//            System.out.println("Digite o telefone do contato: ");
//            Long telefoneContato = scanner.nextLong();
//
//            novoTelefone.setId(gerarNovoIdTelefone(contato));
//            novoTelefone.setDdd();
//        }
//    }

    private static Long gerarNovoIdTelefone(Contato contato) {
        List<Telefone> listaTelefonesDoContato = contato.getTelefones();
        System.out.println(listaTelefonesDoContato);
        if (listaTelefonesDoContato.size() == 0) {
            return 1L;
        }
        Long ultimoTelefoneID = listaTelefonesDoContato.get(listaTelefonesDoContato.size()-1).getId();
        return (ultimoTelefoneID+1);
    }
}