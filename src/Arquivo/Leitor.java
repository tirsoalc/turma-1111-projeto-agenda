package Arquivo;

import Contato.Contato;
import Contato.Telefone;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Leitor {
    private static String DIRETORIO_CONTATOS = Diretorios.CONTATOS.getCaminho();
    private static String DIRETORIO_TELEFONES = Diretorios.TELEFONES.getCaminho();
    private static File telefonesTxt = new File(DIRETORIO_TELEFONES);
    private static File contatosTxt = new File(DIRETORIO_CONTATOS);

    private void criarArquivo(File arquivo) {
        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private List<String> lerArquivos(File arquivo) {
        List<String> linhas = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fileReader);
            String linha = br.readLine();
            while (linha != null) {
                if (!linha.equals("")) {
                    linhas.add(linha);
                }
                linha = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return linhas;
    }


    private List<Contato> lerArquivoContatos() {
        criarArquivo(contatosTxt);
        List<Contato> contatos = new ArrayList<>();
        List<String> linhas = lerArquivos(contatosTxt);
        String linha;

        for (int i = 0; i < linhas.size(); i++) {
            linha = linhas.get(i);
            String[] contatoPartes = linha.split("\\|");
            Long id = Long.parseLong(contatoPartes[0]);
            String nome = contatoPartes[1];
            String sobrenome = contatoPartes[2];
            Contato contatoAtual = new Contato(id, nome, sobrenome);
            contatos.add(contatoAtual);
        }
        return contatos;

    }
    private void lerArquivoTelefones(List<Contato> contatos) {
        criarArquivo(telefonesTxt);
        List<String> linhas = lerArquivos(telefonesTxt);
        String linha;

        for (int i = 0; i < linhas.size(); i++) {
            linha = linhas.get(i);
            String[] telefonePartes = linha.split("\\|");
            Long idContato = Long.parseLong(telefonePartes[0]);
            Long idTelefone = Long.parseLong(telefonePartes[1]);
            String ddd = telefonePartes[2];
            Long numero = Long.parseLong(telefonePartes[3]);
            Telefone telefoneAtual = new Telefone(idTelefone, ddd, numero);

            for (int j = 0; j < contatos.size(); j++) {
                Contato contatoAtual = contatos.get(j);
                if (contatoAtual.getId().equals(idContato)) {
                    contatoAtual.getTelefones().add(telefoneAtual);
                    break;
                }
            }
        }
    }

    public List<Contato> listaDeContatos() {
        List<Contato> contatos = lerArquivoContatos();
        lerArquivoTelefones(contatos);
        return contatos;
    }
}
