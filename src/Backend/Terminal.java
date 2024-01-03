package Backend;
// Classe Terminal, que herda de Equipamento
public class Terminal extends Equipamento {
    private String ip;
    public Terminal(String nome, String mac, String ip) {
        super(nome, mac);
        this.ip = ip;
    }
    public String getIp() {
        return ip;
    }
    @Override
    public String toString() {
        return "Terminal [NOME=" + getNome() + ", MAC=" + getEnderecoMAC() + ", Ip=" + ip + "]";
    }
}