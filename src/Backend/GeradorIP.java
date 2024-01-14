package Backend;
import java.util.Random;
// Classe para gerar endereços IP aleatórios
public class GeradorIP {
    // Método que gera e retorna um endereço IP aleatório
    public static String gerarIPAleatorio() {
        Random rand = new Random();
        StringBuilder ip = new StringBuilder();

        // Gera cada parte do endereço IP
        for (int i = 0; i < 4; i++) {
            ip.append(rand.nextInt(256)); // Gera um número aleatório entre 0 e 255
            if (i < 3) {
                ip.append("."); // Adiciona um ponto entre as partes do endereço, exceto na última
            }
        }

        return ip.toString(); // Retorna o endereço IP gerado como uma string
    }
}