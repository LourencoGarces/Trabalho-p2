public class Equipamentos {
    private String mac;
    private String ip;
    public Equipamentos(String mac, String ip) {
        this.mac = mac;
        this.ip = ip;
    }
    public String getMac() {
        return mac;
    }
    public String getIp() {
        return ip;
    }
}