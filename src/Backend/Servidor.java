package Backend;
public class Servidor extends Equipamentos {
    private int capacidade;

    public Servidor(String mac, String ip, int capacidade) {
        super(mac, ip);
        this.capacidade = capacidade;
    }

    public int getCapacidade() {
        return capacidade;
    }

    @Override
    public String toString() {
        return "Servidor [MAC=" + getMac() + ", IP=" + getIp() + ", Capacidade=" + capacidade + "]";
    }
}
