package Backend;
// Classe Terminal, que herda de Equipamento
public class Terminal extends Equipamento {
    private final String ip;
    public Terminal(String nome, String mac, String ip) {
        super(nome, mac);
        this.ip = ip;
    }
    public String getIp() {
        return ip;
    }
    @Override
    public String toString() {
        return "[NOME=" + getNome() + ", MAC=" + getEnderecoMAC() + ", Ip=" + ip + "]";
    }
}