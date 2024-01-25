package Contato;

import java.util.List;

public class FormatadorJSON {
    public String formatarListaDeContatos(List<Contato> contatos) {

        String retorno = "";
        retorno += "[\n";
        for (int i = 0; i < contatos.size(); i++) {
            if (i == contatos.size() - 1) {
                retorno += contatos.get(i).contatosFormatadosJSON();
            } else {
                retorno += contatos.get(i).contatosFormatadosJSON() + ",\n";
            }
        }
        retorno +="\n]";
        return retorno;
    }
}
