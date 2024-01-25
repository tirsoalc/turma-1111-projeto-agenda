import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import Contato.*;
import Utilitarios.*;


public class Agenda {
    private static List<Contato> contatos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static BuscaLinear buscaLinear = new BuscaLinear();
    private static BuscaBinaria buscaBinaria = new BuscaBinaria();
    private static FormatadorJSON FormatadorJSON = new FormatadorJSON();
    public static void main(String[] args) {

        int entrada;
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
            System.out.println("4 - Mostrar Lista De Telefones Do Contato");
            System.out.println("5 - Sair");

            entrada = scanner.nextInt();
            if (entrada == 1) {
                adicionarContato();
            } else if (entrada == 2) {
                System.out.println(removerContato());
            } else if (entrada == 3){
                System.out.println(editarContato());
            } else if (entrada == 4) {
                System.out.println(mostrarListaDeTelefones());
            } else if (entrada == 5) {
                System.out.println("Encerrando.");
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

        Contato novoContato = new Contato();
        novoContato.setId(gerarNovoIdContato());
        editarNomeContato(novoContato);
        editarSobrenomeContato(novoContato);
        adicionarTelefone(novoContato);

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

        System.out.println("Digite o nome do contato: ");
        String nomeContato = scanner.next();
        contato.setNome(nomeContato);
    }

    private static void editarSobrenomeContato(Contato contato) {

        System.out.println("Digite o sobrenome do contato: ");
        String sobrenomeContato = scanner.next();
        contato.setSobrenome(sobrenomeContato);
    }

    private static void adicionarTelefone(Contato contato) {

        Telefone novoTelefone = new Telefone();

        try {
            System.out.println("Digite o DDD do contato: ");
            String dddContato = scanner.next();
            System.out.println("Digite o telefone do contato: ");
            Long telefoneContato = scanner.nextLong();

            novoTelefone.setId(gerarNovoIdTelefone(contato));
            novoTelefone.setDdd(dddContato);
            novoTelefone.setNumero(telefoneContato);
        } catch (InputMismatchException e) {
            System.out.println("Erro. Por favor verifique as informações e edite o contato.");
        }

        if (telefoneDuplicado(novoTelefone)) {
            System.out.println("Telefone duplicado. por favor edite o contato e insira um novo telefone.");
        } else {
            contato.getTelefones().add(novoTelefone);
        }
    }

    private static Long gerarNovoIdTelefone(Contato contato) {
        List<Telefone> listaTelefonesDoContato = contato.getTelefones();

        if (listaTelefonesDoContato.size() == 0) {
            return 1L;
        }
        Long ultimoTelefoneID = listaTelefonesDoContato.get(listaTelefonesDoContato.size()-1).getId();
        return (ultimoTelefoneID+1);
    }

    private static boolean telefoneDuplicado(Telefone novoTelefone) {
        for (int i = 0; i < contatos.size(); i++) {
            List<Telefone> contatoAtualTelefones = contatos.get(i).getTelefones();
            for (int j=0; j< contatoAtualTelefones.size(); j++) {
                if (novoTelefone.getNumero().equals(contatoAtualTelefones.get(j).getNumero()) &&
                    novoTelefone.getDdd().equals(contatoAtualTelefones.get(j).getDdd())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static String removerContato() {
        System.out.println("Informe o ID do contato que será removido: ");
        Long idContatoRemovido = scanner.nextLong();

        Contato contatoRemovido = buscaBinaria.buscaContato(idContatoRemovido, contatos);

        if (contatoRemovido != null) {
            contatos.remove(contatoRemovido);
            return "Contato removido.";
        }
        return "Contato não encontrado.";
    }

    private static String editarContato() {
                System.out.println("Por favor informe o ID do contato que deseja alterar alguma informação");
        Long idContatoAlterarado = scanner.nextLong();

        Contato contatoAlterado = buscaBinaria.buscaContato(idContatoAlterarado, contatos);

        if (contatoAlterado != null){
            System.out.println("Contato Atual: " + contatoAlterado.getNomeCompleto());
            exibirMenuEditarContato();
            int opcao = scanner.nextInt();
            if (opcao == 1) {
                editarNomeContato(contatoAlterado);
                return "Nome do contato alterado.";
            } else if (opcao == 2) {
                editarSobrenomeContato(contatoAlterado);
                return "Sobrenome do contato alterado.";
            } else if (opcao == 3) {
                return editarTelefoneContato(contatoAlterado);
            } else {
                return "Opção Inválida.";
            }
        } else {
            return "Contato não encontrado";
        }
    }

    private static void exibirMenuEditarContato() {
        System.out.println("O que você deseja alterar no contato? Digite o número da opção: ");
        System.out.println("1 - Nome");
        System.out.println("2 - Sobrenome");
        System.out.println("3 - Telefone");
    }

    private static String editarTelefoneContato(Contato contato) {

        System.out.println("Você deseja adicionar ou alterar um telefone?");
        System.out.println("1 - Adicionar");
        System.out.println("2 - Alterar");
        System.out.println("3 - Remover");
        int opcao = scanner.nextInt();
        System.out.println(mostrarListaDeTelefones(contato));

        if (opcao == 1) {
            adicionarTelefone(contato);
            return "Telefone adicionado a lista de telefones do contato";
        } else if (opcao == 2) {
            System.out.println("Digite o ID do telefone a ser alterado: ");
            Long idTelefoneAlterado = scanner.nextLong();
            Telefone telefoneParaSerAlterado = buscaLinear.buscaTelefone(idTelefoneAlterado, contato.getTelefones());
            Telefone novoTelefone = new Telefone();


            if (telefoneParaSerAlterado != null) {
                try {
                    novoTelefone.setId(telefoneParaSerAlterado.getId());
                    System.out.println("Digite o novo DDD do contato: ");
                    String dddContato = scanner.next();
                    System.out.println("Digite o novo número do contato");
                    Long telefoneContato = scanner.nextLong();
                    novoTelefone.setDdd(dddContato);
                    novoTelefone.setNumero(telefoneContato);
                } catch (InputMismatchException e) {
                    return "Erro. Por favor verifique as informações e refaça o procedimento";
                }

                if (telefoneDuplicado(novoTelefone)) {
                    return "Telefone duplicado. Por favor verfique as informações e refaça o procedimento";
                } else {
                    telefoneParaSerAlterado.setDdd(novoTelefone.getDdd());
                    telefoneParaSerAlterado.setNumero(novoTelefone.getNumero());
                    return "O telefone do contato foi modificado.";
                }
            }
            return "Telefone não encontrado";
        } else if (opcao == 3) {
            System.out.println("Digite o ID do telefone que será removido: ");
            Long idTelefoneParaSerRemovido = scanner.nextLong();
            Telefone telefoneParaSerRemovido = buscaLinear.buscaTelefone(idTelefoneParaSerRemovido, contato.getTelefones());
            if (telefoneParaSerRemovido != null) {
                contato.getTelefones().remove(telefoneParaSerRemovido);
                return "Telefone removido.";
            }
            return "Telefone não encontrado";
        } else {
            return "Opção Inválida";
        }
    }

    private static String mostrarListaDeTelefones(Contato contato) {
        List<Telefone> telefones = contato.getTelefones();
        if (telefones.size() == 0) {
            return "Lista de telefones vazia";
        }
        String stringRetorno = "";
        stringRetorno += "Contato: " + contato.getNomeCompleto();
        stringRetorno += "\nID | DDD + Número\n";
        for(int i = 0; i < telefones.size(); i++) {
            stringRetorno += telefones.get(i).telefoneFormatado() + "\n";
        }
        return stringRetorno;
    }

    private static String mostrarListaDeTelefones() {
        System.out.println("Digite o ID do contato para ver a lista de telefones: ");
        Long contatoId = scanner.nextLong();
        Contato contatoAtual = buscaBinaria.buscaContato(contatoId, contatos);
        if (contatoAtual != null) {
            return mostrarListaDeTelefones(contatoAtual);
        }
        return "Contato não encontrado.";

    }

}