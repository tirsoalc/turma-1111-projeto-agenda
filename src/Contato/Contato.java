package Contato;

import java.util.ArrayList;
import java.util.List;

public class Contato {
    private Long id;
    private String nome;
    private String sobrenome;
    private List<Telefone> telefones = new ArrayList<>();

    public void setId(Long id) {this.id = id;}
    public Long getId() {return id;}

    public void setNome(String nome) {this.nome = nome;}

    public void setSobrenome(String sobrenome) {this.sobrenome = sobrenome;}
    public String getNomeCompleto() {return nome + " " + sobrenome;}

    public List<Telefone> getTelefones() {return telefones;}
}
