package Utilitarios;

import Contato.Telefone;

import java.util.List;

public class BuscaLinear {
    public Telefone buscaTelefone(Long id, List<Telefone> telefones) {
        for (int i = 0; i < telefones.size(); i++) {
            Telefone telefoneAtual = telefones.get(i);
            if (telefoneAtual.getId().equals(id)) {
                return telefoneAtual;
            }
        }
        return null;
    }
}
