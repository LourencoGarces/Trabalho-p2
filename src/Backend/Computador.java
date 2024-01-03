package Backend;
// Classe Computador, que herda de Equipamento
public class Computador extends Equipamento {
    private String enderecoIP;

    // Construtor
    public Computador(String nome, String enderecoMAC, String enderecoIP) {
        super(nome, enderecoMAC);
        this.enderecoIP = enderecoIP;
    }

    // Getter
    public String getEnderecoIP() {
        return enderecoIP;
    }
}