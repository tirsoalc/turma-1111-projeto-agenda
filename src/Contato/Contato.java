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


    public String contatosFormatados() {
        return String.format("{\"id\": %d, \"nome\":\"%s\", \"sobrenome\": \"%s\", \"telefones\": [%s]}",id,nome,sobrenome,telefonesFormatados());
    }

    public String telefonesFormatados() {
        String resultado = "";
        for (int i = 0; i < telefones.size(); i++){
            if (i == telefones.size()-1) {
                resultado += telefones.get(i).telefoneFormatado();
            } else {
                resultado += telefones.get(i).telefoneFormatado() + ", ";
            }
        }
        return resultado;
    }

    //Refatorar o código de maneira que a string formatada não venha do toString e também receba o telefone formatado.
}
