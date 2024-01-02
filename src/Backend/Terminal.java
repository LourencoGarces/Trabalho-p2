package Backend;
public class Terminal extends Equipamentos {
    private String tipo;

    public Terminal(String mac, String ip, String tipo) {
        super(mac, ip);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return "Terminal [MAC=" + getMac() + ", IP=" + getIp() + ", Tipo=" + tipo + "]";
    }
}