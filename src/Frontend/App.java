package Frontend;
import Backend.Rede;
import Backend.Terminal;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class App {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        Map<String, Rede> redes = new HashMap<>();
        int opcao;

        do{
            menu();
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o seu MAC: ");
                    String mac = teclado.next();
                    System.out.print("Digite o seu IP: ");
                    String ip = teclado.next();

                    // Criação de um terminal
                    Terminal terminal = new Terminal(mac, ip, "Smartphone");

                    // Criação ou obtenção da rede
                    Rede rede = obterOuCriarRede(redes, "MinhaRede");

                    // Adiciona o terminal à rede
                    rede.adicionarEquipamento(terminal);
                    System.out.println("Terminal adicionado à rede.");
                    break;

                case 2:
                    // Lógica para a opção 2 (Enviar Dados)
                    break;

                case 3:
                    // Lógica para a opção 3 (Gravar Configuração da Rede)
                    break;

                case 4:
                    // Lógica para a opção 4 (Gravar Registro de Envio de Dados)
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 5);
    }

    public static void menu(){
        System.out.println("=== Simulador de Rede ===");
        System.out.println("1. Configurar Rede");
        System.out.println("2. Enviar Dados");
        System.out.println("3. Gravar Configuração da Rede");
        System.out.println("4. Gravar Registro de Envio de Dados");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static Rede obterOuCriarRede(Map<String, Rede> redes, String nomeRede) {
        if (redes.containsKey(nomeRede)) {
            return redes.get(nomeRede);
        } else {
            Rede novaRede = new Rede(10); // Escolha um tamanho adequado
            redes.put(nomeRede, novaRede);
            return novaRede;
        }
    }
}
