package Backend;
public class Router extends Equipamentos {
    private String protocolo;
    public Router(String mac, String ip, String protocolo) {
        super(mac, ip);
        this.protocolo = protocolo;
    }
    public String getProtocolo() {
        return protocolo;
    }
    @Override
    public String toString() {
        return "Router [MAC=" + getMac() + ", IP=" + getIp() + ", Protocolo=" + protocolo + "]";
    }
}