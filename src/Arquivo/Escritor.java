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

//    public void escreverArquivos(List<Contato> contatos) {
//
//
//        for (int i = 0; i < contatos.size(); i++) {
//            Contato contatoAtual = contatos.get(i);
//            String contatoString = contatoAtual.contatoFormatadoTxt();
//            escreverArquivoContatos(contatosTxt, contatoString);
//
//            for (int j = 0; j < contatoAtual.getTelefones().size(); j++) {
//                Telefone telefoneAtual = contatoAtual.getTelefones().get(j);
//                String telefoneString= String.format("%d|%s",
//                        contatoAtual.getId(),
//                        telefoneAtual.telefoneFormatadoTxt()
//                        );
//
//                escreverArquivoTelefones(telefonesTxt, telefoneString);
//            }
//        }
//    }
    public void escreverArquivoTelefones(String telefoneString) {
        criarArquivo(telefonesTxt);
        try {
            FileWriter fileWriter = new FileWriter(telefonesTxt, true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.newLine();
            bw.write(telefoneString);
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void escreverArquivoContatos(String contatoString) {
        criarArquivo(contatosTxt);
        try {
            FileWriter fileWriter = new FileWriter(contatosTxt, true);
            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.newLine();
            bw.write(contatoString);
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
