package Backend;
// Classe Roteador, que herda de Equipamento
public class Router extends Equipamento {
    private String protocolo;
    public Router(String nome, String enderecoMAC, String protocolo) {
        super(nome, enderecoMAC);
        this.protocolo = protocolo;
    }
    public String getProtocolo() {
        return protocolo;
    }
    @Override
    public String toString() {
        return "Roteador [NOME=" + getNome() + ", MAC=" + getEnderecoMAC() + ", Protocolo=" + protocolo + "]";
    }
}