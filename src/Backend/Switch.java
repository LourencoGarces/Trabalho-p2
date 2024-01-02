package Backend;
public class Switch extends Equipamentos {
    private int numPortas;

    public Switch(String mac, String ip, int numPortas) {
        super(mac, ip);
        this.numPortas = numPortas;
    }

    public int getNumPortas() {
        return numPortas;
    }

    @Override
    public String toString() {
        return "Switch [MAC=" + getMac() + ", IP=" + getIp() + ", NumPortas=" + numPortas + "]";
    }
}

