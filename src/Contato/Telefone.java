package Contato;

public class Telefone {
    private Long id;
    private String ddd;
    private Long numero;

    //Refatorar Getters/Setters, verificar a necessidade de alguns e criar o constructor com os parâmetros

    public void setId(Long id) {this.id = id;}
    public Long getId() {return id;}

    public void setDdd(String ddd) {this.ddd = ddd;}
    public String getDdd() {return ddd;}

    public void setNumero(Long numero) {this.numero = numero;}
    public Long getNumero() {return numero;}



    public String telefoneFormatado() {
        return String.format("%d | %s %d", id, ddd, numero);
    }

    public String telefoneFormatadoJSON() {
        return String.format("   {\n" +
                "    " +
                "\"id\": %d,\n" +
                "    " +
                "\"ddd\": \"%s\",\n" +
                "    " +
                "\"numero\": %d\n" +
                "   }", id, ddd, numero);
    }
}
