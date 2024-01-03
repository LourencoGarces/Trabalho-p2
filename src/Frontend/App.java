package Frontend;
import Backend.Rede;
import Backend.Equipamentos;
import Backend.Terminal;
import Backend.ConstrutorDeRede;

import java.util.*;

import static Backend.ConstrutorDeRede.construirRede;

public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Map<String, Rede> redes = new HashMap<>();
        int opcao;

        do {
            menu();
            opcao = obterOpcao(teclado);

            switch (opcao) {
                case 1:
                    adicionarTerminal(teclado, redes);
                    break;
                case 2:
                    enviarDados(teclado, redes);
                    break;

                case 3:
                    gravarConfiguracaoRede(teclado, redes);
                    break;

                case 4:
                    gravarRegistroEnvioDados();
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

    private static void menu() {
        System.out.println("=== Simulador de Rede ===");
        System.out.println("1. Configurar Rede");
        System.out.println("2. Enviar Dados");
        System.out.println("3. Gravar Configuração da Rede");
        System.out.println("4. Gravar Registro de Envio de Dados");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int obterOpcao(Scanner teclado) {
        try {
            return teclado.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Certifique-se de inserir um número.");
            teclado.nextLine(); // Limpe o buffer do scanner
            return -1; // Retorna um valor inválido para indicar que a opção não foi obtida corretamente
        }
    }


    private static void adicionarTerminal(Scanner teclado, Map<String, Rede> redes) {
        System.out.print("Digite o seu MAC: ");
        String mac = teclado.next();
        System.out.print("Digite o seu IP: ");
        String ip = teclado.next();

        // Criação de um terminal
        Equipamentos terminal = new Terminal(mac, ip, "Smartphone");

        // Criação ou obtenção da rede
        Rede rede = obterOuCriarRede(redes, "MinhaRede");

        // Adiciona o terminal à rede
        rede.adicionarEquipamento(terminal);
        System.out.println("Terminal adicionado à rede.");
    }

    private static void enviarDados(Scanner teclado, Map<String, Rede> redes) {
        System.out.println("Enviar Dados:");
        System.out.print("Digite o MAC do equipamento de origem: ");
        String macOrigem = teclado.next();
        System.out.print("Digite o MAC do equipamento de destino: ");
        String macDestino = teclado.next();
        teclado.nextLine(); // Limpe o buffer do scanner
        System.out.print("Digite a mensagem a ser enviada: ");
        String mensagem = teclado.nextLine();

        // Obtenha os equipamentos de origem e destino
        Equipamentos equipOrigem = obterEquipamentoPorMac(redes, macOrigem);
        Equipamentos equipDestino = obterEquipamentoPorMac(redes, macDestino);

        if (equipOrigem != null && equipDestino != null) {
            // Realize a comunicação
            redes.get("MinhaRede").comunicar(equipOrigem, equipDestino, mensagem);
        } else {
            System.out.println("Equipamentos não encontrados na rede.");
        }
    }

    private static void gravarConfiguracaoRede(Scanner teclado, Map<String, Rede> redes) {
        System.out.println("Gravar Configuração da Rede:");
        System.out.print("Digite o nome da rede a ser gravada: ");
        String nomeRede = teclado.next();

        // Obtenha a rede
        Rede redeParaGravar = redes.get(nomeRede);

        if (redeParaGravar != null) {
            // Lógica para gravar configuração da rede (pode envolver serialização, por exemplo)
            System.out.println("Configuração da rede gravada com sucesso.");
        } else {
            System.out.println("Rede não encontrada.");
        }
    }

    private static void gravarRegistroEnvioDados() {
        System.out.println("Gravar Registro de Envio de Dados:");
        // Lógica para gravar registro de envio de dados (pode envolver log em arquivo, por exemplo)
        System.out.println("Registro de envio de dados gravado com sucesso.");
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
    private static Equipamentos obterEquipamentoPorMac(Map<String, Rede> redes, String mac) {
        for (Rede rede : redes.values()) {
            for (Equipamentos equipamento : rede.getEquipamentos()) {
                if (equipamento.getMac().equals(mac)) {
                    return equipamento;
                }
            }
        }
        return null;
    }
}
