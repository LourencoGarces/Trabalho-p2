package Frontend;

import Backend.TipoConexao;
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
    private static final List<Equipamento> dispositivos = new ArrayList<>();
    private static final List<Ligacao> conexoes = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            exibirMenu();
            opcao = getInputInt(scanner);

            switch (opcao) {
                case 1:
                    construirRede();
                    break;
                case 2:
                    imprimirRede(dispositivos, conexoes);
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

    private static void exibirMenu() {
        System.out.println("Menu:");
        System.out.println("1. Construir Rede");
        System.out.println("2. Imprimir Rede");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }
    public static void construirRede() {
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("Menu:");
            System.out.println("1. Adicionar Computador");
            System.out.println("2. Adicionar Switch");
            System.out.println("3. Adicionar Roteador");
            System.out.println("4. Adicionar Servidor");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = getInputInt(scanner);

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
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
        scanner.close();
    }
    private static void adicionarComputador(Scanner scanner, List<Equipamento> dispositivos, List<Ligacao> conexoes) {
        System.out.println("Digite o nome do computador: ");
        String nome = scanner.nextLine();

        // Verifica se o nome já existe
        if (equipamentoComNomeJaExiste(dispositivos, nome)) {
            System.out.println("Já existe um equipamento com esse nome. Operação cancelada.");
            return;
        }

        System.out.println("Digite o endereço MAC do computador: ");
        String enderecoMAC = scanner.nextLine();

        // Verifica se o MAC já existe
        if (equipamentoComEnderecoMACJaExiste(dispositivos, enderecoMAC)) {
            System.out.println("Já existe um equipamento com esse endereço MAC. Operação cancelada.");
            return;
        }

        System.out.println("Digite o endereço IP do computador: ");
        String enderecoIP = scanner.nextLine();

        // meter verificação de ip

        Terminal computador = new Terminal(nome, enderecoMAC, enderecoIP);
        dispositivos.add(computador);

        if (dispositivos.size() > 1) {
            adicionarConexao(scanner, dispositivos, conexoes, computador);
        } else {
            System.out.println("Computador adicionado.");
        }
    }

    private static void adicionarSwitch(Scanner scanner, List<Equipamento> dispositivos, List<Ligacao> conexoes) {
        System.out.println("Digite o nome do switch: ");
        String nomeSwitch = scanner.nextLine();
        // Verifica se o nome já existe
        if (equipamentoComNomeJaExiste(dispositivos, nomeSwitch)) {
            System.out.println("Já existe um equipamento com esse nome. Operação cancelada.");
            return;
        }
        System.out.println("Digite o endereço MAC do switch: ");
        String enderecoMACSwitch = scanner.nextLine();

        // Verifica se o MAC já existe
        if (equipamentoComEnderecoMACJaExiste(dispositivos, enderecoMACSwitch)) {
            System.out.println("Já existe um equipamento com esse endereço MAC. Operação cancelada.");
            return;
        }
        System.out.println("Digite o número de portas do switch: ");
        int numeroPortas = scanner.nextInt();
        Switch switchDevice = new Switch(nomeSwitch, enderecoMACSwitch, numeroPortas);
        dispositivos.add(switchDevice);
        if(dispositivos.size() > 1) {
            adicionarConexao(scanner, dispositivos, conexoes, switchDevice);
        }else {
            System.out.println("Switch adicionado.");
        }
    }
    private static void adicionarRouter(Scanner scanner, List<Equipamento> dispositivos, List<Ligacao> conexoes) {
        System.out.println("Digite o nome do router: ");
        String nomeRouter = scanner.nextLine();
        // Verifica se o nome já existe
        if (equipamentoComNomeJaExiste(dispositivos, nomeRouter)) {
            System.out.println("Já existe um equipamento com esse nome. Operação cancelada.");
            return;
        }
        System.out.println("Digite o endereço MAC do router: ");
        String enderecoMACRouter = scanner.nextLine();
        // Verifica se o MAC já existe
        if (equipamentoComEnderecoMACJaExiste(dispositivos, enderecoMACRouter)) {
            System.out.println("Já existe um equipamento com esse endereço MAC. Operação cancelada.");
            return;
        }
        System.out.println("Digite o protocolo do router: ");
        String protocolo = scanner.nextLine();
        Router router = new Router(nomeRouter, enderecoMACRouter, protocolo);
        dispositivos.add(router);
        if(dispositivos.size() > 1) {
            adicionarConexao(scanner, dispositivos, conexoes, router);
        }else {
            System.out.println("Router adicionado.");
        }
    }
    private static void adicionarServidor(Scanner scanner, List<Equipamento> dispositivos, List<Ligacao> conexoes) {
        System.out.println("Digite o nome do servidor: ");
        String nomeServidor = scanner.nextLine();
        // Verifica se o nome já existe
        if (equipamentoComNomeJaExiste(dispositivos, nomeServidor)) {
            System.out.println("Já existe um equipamento com esse nome. Operação cancelada.");
            return;
        }
        System.out.println("Digite o endereço MAC do servidor: ");
        String enderecoMACServidor = scanner.nextLine();
        // Verifica se o MAC já existe
        if (equipamentoComEnderecoMACJaExiste(dispositivos, enderecoMACServidor)) {
            System.out.println("Já existe um equipamento com esse endereço MAC. Operação cancelada.");
            return;
        }
        System.out.println("Digite o endereço Ip do servidor: ");
        String enderecoIPServidor = scanner.nextLine();
        System.out.println("Digite a capacidade do servidor: ");
        int capacidade = scanner.nextInt();
        Servidor servidor = new Servidor(nomeServidor, enderecoMACServidor, enderecoIPServidor, capacidade);
        dispositivos.add(servidor);
        if(dispositivos.size() > 1) {
            adicionarConexao(scanner, dispositivos, conexoes, servidor);
        }else {
            System.out.println("Servidor adicionado.");
        }
    }
    private static boolean equipamentoComNomeJaExiste(List<Equipamento> dispositivos, String nome) {
        return dispositivos.stream().anyMatch(equipamento -> equipamento.getNome().equals(nome));
    }
    private static boolean equipamentoComEnderecoMACJaExiste(List<Equipamento> dispositivos, String enderecoMAC) {
        return dispositivos.stream().anyMatch(equipamento -> equipamento.getEnderecoMAC().equals(enderecoMAC));
    }
    private static int getInputInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, insira um número válido.");
            }
        }
    }
    private static void adicionarConexao(Scanner scanner, List<Equipamento> dispositivos, List<Ligacao> conexoes, Equipamento dispositivo) {
        exibirDispositivos(dispositivos);

        int indice = obterIndiceValido(scanner, dispositivos.size());

        if (indice != -1) {
            TipoConexao tipoConexao = obterTipoConexao(scanner);

            if (tipoConexao != null) {
                Equipamento destino = dispositivos.get(indice);

                // Estabelecer a conexão
                Ligacao conexao = new Ligacao(dispositivo, destino, tipoConexao);
                dispositivo.adicionarLigacao(destino, tipoConexao);
                conexoes.add(conexao);

                // Atualizar o número de portas/disponibilidade no dispositivo de destino
                if (destino instanceof Switch switchDestino) {
                    switchDestino.adicionarEntradaTabelaEncaminhamento(dispositivo.getEnderecoMAC(), switchDestino.getNumeroPortas() - 1);
                    System.out.println("Conexão estabelecida com sucesso no Switch.");
                } else if (destino instanceof Servidor servidorDestino) {
                    servidorDestino.adicionarEntradaTabelaEncaminhamento(dispositivo.getEnderecoMAC(), servidorDestino.getCapacidade() - 1);
                    System.out.println("Conexão estabelecida com sucesso no Servidor.");
                } else {
                    // Adicione lógica para outros tipos de destino, se aplicável
                    System.out.println("Conexão estabelecida com sucesso.");
                }
            } else {
                System.out.println("Tipo de conexão inválida. Não foi possível estabelecer a conexão.");
            }
        } else {
            System.out.println("Índice inválido. Não foi possível estabelecer a conexão.");
        }
    }

    private static int obterIndiceValido(Scanner scanner, int tamanhoMaximo) {
        while (true) {
            System.out.print("Escolha o dispositivo existente (informe o índice): ");
            int indice = getInputInt(scanner);

            if (indice >= 0 && indice < tamanhoMaximo) {
                return indice;
            } else {
                System.out.println("Índice inválido. Tente novamente.");
            }
        }
    }
    private static TipoConexao obterTipoConexao(Scanner scanner) {
        System.out.print("Escolha o tipo de conexão (ex. WIRELESS, ETHERNET): ");
        String tipoConexaoStr = scanner.nextLine().toUpperCase();

        try {
            return TipoConexao.valueOf(tipoConexaoStr);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
    public static void imprimirRede(List<Equipamento> dispositivos, List<Ligacao> conexoes) {
        exibirDispositivos(dispositivos);
        exibirConexoes(conexoes);
    }
    private static void exibirDispositivos(List<Equipamento> dispositivos) {
        System.out.println("Dispositivos de Rede:");
        for (Equipamento dispositivo : dispositivos) {
            System.out.println("- " + dispositivo);
        }
    }
    private static void exibirConexoes(List<Ligacao> conexoes) {
        if (!conexoes.isEmpty()) {
            System.out.println("\nConexões:");
            for (Ligacao conexao : conexoes) {
                System.out.println("- " + conexao);
            }
        } else {
            System.out.println("\nNenhuma conexão estabelecida.");
        }
    }
}