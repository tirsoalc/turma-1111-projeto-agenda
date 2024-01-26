package Arquivo;

import Contato.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Escritor {
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

    public void atualizarContatosETelefones(List<Contato> contatos) {
        atualizarContatos(contatos);
        atualizarTelefones(contatos);
    }
    public void adicionarArquivoTelefones(String telefoneString) {
        criarArquivo(telefonesTxt);
        try {
            FileWriter fileWriter = new FileWriter(telefonesTxt, true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(telefoneString+"\n");
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void adicionarArquivoContatos(String contatoString) {
        criarArquivo(contatosTxt);
        try {
            FileWriter fileWriter = new FileWriter(contatosTxt, true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write(contatoString+"\n");
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarContatos(List<Contato> contatos) {
        try {
            FileWriter fileWriter = new FileWriter(contatosTxt,false);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (int i = 0; i < contatos.size(); i++) {
                String contatoString = contatos.get(i).contatoFormatadoTxt();
                bw.write(contatoString+"\n");
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarTelefones(List<Contato> contatos) {
        try {
            FileWriter fileWriter = new FileWriter(telefonesTxt, false);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            for (int i = 0; i < contatos.size(); i++) {
                Contato contatoAtual = contatos.get(i);
                List<Telefone> telefonesContatoAtual = contatoAtual.getTelefones();
                for (int j = 0; j < telefonesContatoAtual.size(); j++) {
                    String telefoneAtualString = String.format("%d|%s",contatoAtual.getId(),
                            telefonesContatoAtual.get(j).telefoneFormatadoTxt());
                    bw.write(telefoneAtualString+"\n");
                }
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
