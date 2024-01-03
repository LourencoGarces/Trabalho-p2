package Backend;
public class Servidor extends Equipamento {
    private String enderecoIP;
    private int capacidade;
    public Servidor(String nome, String enderecoMAC, String enderecoIP, int capacidade) {
        super(nome, enderecoMAC);
        this.enderecoIP = enderecoIP;
        this.capacidade = capacidade;
    }
    public String getEnderecoIP() {
        return enderecoIP;
    }
    public int getCapacidade() {
        return capacidade;
    }
    @Override
    public String toString() {
        return "Servidor [NOME=" + getNome() + ", MAC=" + getEnderecoMAC() + ", IP=" + enderecoIP + ", Capacidade=" + capacidade + "]";
    }
}