package Backend;
public class Equipamento {
    private String nome;
    private String enderecoMAC;
    public Equipamento(String nome, String enderecoMAC) {
        this.nome = nome;
        this.enderecoMAC = enderecoMAC;
    }
    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public String getEnderecoMAC() {
        return enderecoMAC;
    }
    @Override
    public String toString() {
        return "Equipamento [NOME= " + nome + "MAC=" + enderecoMAC + "]";
    }
}