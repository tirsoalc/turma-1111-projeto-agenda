package Arquivo;

public enum Diretorios {
    CONTATOS("arquivos-txt/contatos.txt"),
    TELEFONES("arquivos-txt/telefones.txt");

    private final String caminho;

    Diretorios(String caminho) {
        this.caminho = caminho;
    }

    public String getCaminho() {
        return caminho;
    }
}
