package Backend;
public class Impressora extends Equipamentos {
    private String modelo;

    public Impressora(String mac, String ip, String modelo) {
        super(mac, ip);
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return "Impressora [MAC=" + getMac() + ", IP=" + getIp() + ", Modelo=" + modelo + "]";
    }
}