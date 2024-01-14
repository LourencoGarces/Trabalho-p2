package Backend;
import java.util.Random;
public class GeradorIP {
    public static String gerarIPAleatorio() {
        Random rand = new Random();
        StringBuilder ip = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            ip.append(rand.nextInt(256));
            if (i < 3) {
                ip.append(".");
            }
        }

        return ip.toString();
    }
    public static void main(String[] args) {
        String ipAleatorio = gerarIPAleatorio();
        System.out.println("IP Aleatório: " + ipAleatorio);
    }
}