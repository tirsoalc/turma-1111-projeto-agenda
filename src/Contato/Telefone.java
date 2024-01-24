package Contato;

public class Telefone {
    private Long id;
    private String ddd;
    private Long numero;

    public void setId(Long id) {this.id = id;}
    public Long getId() {return id;}

    public void setDdd(String ddd) {this.ddd = ddd;}
    public String getDdd() {return ddd;}

    public void setNumero(Long numero) {this.numero = numero;}
    public Long getNumero() {return numero;}



    public String telefoneFormatado() {
        return String.format("{\"id\": %d, \"ddd\": \"%s\", \"numero\": %d}", id, ddd, numero);
    }
}
