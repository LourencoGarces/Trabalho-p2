package Frontend;
import Backend.ConstrutorDeRede;
import Backend.Equipamento;
import Backend.Ligacao;
import Backend.Router;
import Backend.Servidor;
import Backend.Switch;
import Backend.Terminal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);
                ConstrutorDeRede construtorDeRede = new ConstrutorDeRede();

                int opcao;
                do {
                    System.out.println("Menu:");
                    System.out.println("1. Construir Rede");
                    System.out.println("2. Imprimir Rede");
                    System.out.println("0. Sair");
                    System.out.print("Escolha uma opção: ");
                    opcao = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline character

                    switch (opcao) {
                        case 1:
                            construtorDeRede.construirRede();
                            break;
                        case 2:
                            //imprimirRede(List<Equipamento> dispositivos, List<Ligacao> conexoes);
                            break;
                        case 0:
                            System.out.println("Saindo do programa.");
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }

                } while (opcao != 0);
            }
            private static void imprimirRede(List<Equipamento> dispositivos, List<Ligacao> conexoes) {
            System.out.println("Dispositivos de Rede:");
            for (Equipamento dispositivo : dispositivos) {
                System.out.println("- " + dispositivo);
            }

            System.out.println("\nConexões:");
            for (Ligacao conexao : conexoes) {
                System.out.println("- " + conexao);
            }
    }
}

