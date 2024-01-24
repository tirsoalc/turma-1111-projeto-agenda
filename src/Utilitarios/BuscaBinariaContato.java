package Utilitarios;

import Contato.Contato;

import java.util.List;


public class BuscaBinariaContato {
    public Contato buscaContato(Long id, List<Contato> contatos) {
        if (contatos.size() == 0) {
            return null;
        }

        int low = 0;
        int high = contatos.size() - 1;

        while (low <= high) {
            int mid = low + (high-low)/2;

            if (contatos.get(mid).getId().equals(id)) {
                return contatos.get(mid);
            }
            if (contatos.get(mid).getId() > id) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }
}
