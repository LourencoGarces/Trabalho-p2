package Frontend;

import Backend.Equipamento;
import Backend.Ligacao;
import Backend.Servidor;
import Backend.Switch;
import Backend.Router;
import Backend.Terminal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
                    construirRede();
                    break;
                case 2:
                    // imprimirRede(List<Equipamento> dispositivos, List<Ligacao> conexoes);
                    break;
                case 0:
                    System.out.println("Saindo do programa.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
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

    public static void construirRede() {
        Scanner scanner = new Scanner(System.in);
        List<Equipamento> dispositivos = new ArrayList<>();
        List<Ligacao> conexoes = new ArrayList<>();

        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Computador");
            System.out.println("2. Adicionar Switch");
            System.out.println("3. Adicionar Roteador");
            System.out.println("4. Adicionar Servidor");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (opcao) {
                case 1:
                    adicionarComputador(scanner, dispositivos, conexoes);
                    break;
                case 2:
                    adicionarSwitch(scanner, dispositivos, conexoes);
                    break;
                case 3:
                    adicionarRouter(scanner, dispositivos, conexoes);
                    break;
                case 4:
                    adicionarServidor(scanner, dispositivos, conexoes);
                    break;
                case 0:
                    System.out.println("Saindo do programa. Construção da rede finalizada.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void adicionarComputador(Scanner scanner, List<Equipamento> dispositivos, List<Ligacao> conexoes) {
        System.out.println("Digite o nome do computador: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o endereço MAC do computador: ");
        String enderecoMAC = scanner.nextLine();
        System.out.println("Digite o endereço IP do computador: ");
        String enderecoIP = scanner.nextLine();
        Terminal computador = new Terminal(nome, enderecoMAC, enderecoIP);
        dispositivos.add(computador);
        adicionarConexao(scanner, dispositivos, conexoes, computador);
    }

    private static void adicionarSwitch(Scanner scanner, List<Equipamento> dispositivos, List<Ligacao> conexoes) {
        System.out.println("Digite o nome do switch: ");
        String nomeSwitch = scanner.nextLine();
        System.out.println("Digite o endereço MAC do switch: ");
        String enderecoMACSwitch = scanner.nextLine();
        System.out.println("Digite o número de portas do switch: ");
        int numeroPortas = scanner.nextInt();
        Switch switchDevice = new Switch(nomeSwitch, enderecoMACSwitch, numeroPortas);
        dispositivos.add(switchDevice);
        adicionarConexao(scanner, dispositivos, conexoes, switchDevice);
    }

    private static void adicionarRouter(Scanner scanner, List<Equipamento> dispositivos, List<Ligacao> conexoes) {
        System.out.println("Digite o nome do router: ");
        String nomeRouter = scanner.nextLine();
        System.out.println("Digite o endereço MAC do router: ");
        String enderecoMACRouter = scanner.nextLine();
        System.out.println("Digite o protocolo do router: ");
        String protocolo = scanner.nextLine();
        Router router = new Router(nomeRouter, enderecoMACRouter, protocolo);
        dispositivos.add(router);
        adicionarConexao(scanner, dispositivos, conexoes, router);
    }

    private static void adicionarServidor(Scanner scanner, List<Equipamento> dispositivos, List<Ligacao> conexoes) {
        System.out.println("Digite o nome do servidor: ");
        String nomeServidor = scanner.nextLine();
        System.out.println("Digite o endereço MAC do servidor: ");
        String enderecoMACServidor = scanner.nextLine();
        System.out.println("Digite o endereço Ip do servidor: ");
        String enderecoIPServidor = scanner.nextLine();
        System.out.println("Digite a capacidade do servidor: ");
        int capacidade = scanner.nextInt();
        Servidor servidor = new Servidor(nomeServidor, enderecoMACServidor, enderecoIPServidor, capacidade);
        dispositivos.add(servidor);
        adicionarConexao(scanner, dispositivos, conexoes, servidor);
    }

    private static void adicionarConexao(Scanner scanner, List<Equipamento> dispositivos, List<Ligacao> conexoes, Equipamento dispositivo) {
        System.out.println("Conectar a qual dispositivo existente? (Informe o índice)");
        for (int i = 0; i < dispositivos.size(); i++) {
            System.out.println(i + ". " + dispositivos.get(i));
        }

        int indice = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character

        if (indice >= 0 && indice < dispositivos.size()) {
            System.out.println("Escolha o tipo de conexão (ex. wireless, ethernet): ");
            String tipoConexao = scanner.nextLine();

            Ligacao conexao = new Ligacao(dispositivo, dispositivos.get(indice), tipoConexao);
            conexoes.add(conexao);
            System.out.println("Dispositivos conectados.");
        } else {
            System.out.println("Índice inválido. Não foi possível estabelecer a conexão.");
        }
    }
}
