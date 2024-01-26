package Contato;

public class Telefone {
    private Long id;
    private String ddd;
    private Long numero;


    public Telefone(){}

    public Telefone(Long id, String ddd, Long numero) {
        this.id = id;
        this.ddd = ddd;
        this.numero = numero;
    }


    public void setId(Long id) {this.id = id;}
    public Long getId() {return id;}

    public void setDdd(String ddd) {this.ddd = ddd;}
    public String getDdd() {return ddd;}

    public void setNumero(Long numero) {this.numero = numero;}
    public Long getNumero() {return numero;}



    public String telefoneFormatado() {
        return String.format("%d | %s %d", id, ddd, numero);
    }

    public String telefoneFormatadoTxt() {
        return String.format("%d|%s|%d",id,ddd,numero);
    }



}
