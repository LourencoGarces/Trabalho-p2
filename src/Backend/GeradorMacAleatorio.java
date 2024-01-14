package Backend;
import java.util.Random;

// Classe para gerar endereços MAC aleatórios
public class GeradorMacAleatorio {

    // Método que gera e retorna um endereço MAC aleatório
    public static String gerarMacAleatorio() {
        Random rand = new Random();
        byte[] macAddress = new byte[6];
        rand.nextBytes(macAddress);

        // Define o bit de local admin (bit mais significativo do primeiro byte) como 0
        macAddress[0] = (byte) (macAddress[0] & (byte) ~2);

        // Formata o endereço MAC como string
        StringBuilder sb = new StringBuilder(18);
        for (byte b : macAddress) {
            if (sb.length() > 0) {
                sb.append(":");
            }
            sb.append(String.format("%02x", b)); // Converte o byte para hexadecimal
        }

        return sb.toString().toUpperCase(); // Retorna o endereço MAC gerado em maiúsculas
    }
}
