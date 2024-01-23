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

            System.out.println(">>>> Menu <<<<");
            System.out.println("1 - Adicionar Contato");
            System.out.println("2 - Remover Contato");
            System.out.println("3 - Editar Contato");
            System.out.println("4 - Sair");
            entrada = scanner.nextInt();

        }
        scanner.close();
    }
}