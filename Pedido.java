public class Pedido {
    private String nome;
    private int tempoPreparo;
    private String categoria;

    public Pedido(String nome, int tempoPreparo, String categoria) {
        this.nome = nome;
        this.tempoPreparo = tempoPreparo;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public String getCategoria() {
        return categoria;
    }
}