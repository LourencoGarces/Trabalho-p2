package Frontend;

import Backend.*;
import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class App {
    private static final List<Equipamento> dispositivos = new ArrayList<>();
    private static final List<Ligacao> conexoes = new ArrayList<>();
    private static final List<String> filaDePacotes = new ArrayList<>();
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
                case 3:
                    enviarMensagem();
                    break;
                case 4:
                    salvarEstadoRedeEmTxt();
                    break;
                case 5:
                    carregarEstadoRede();
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
        System.out.println("3. Enviar Mensagem");
        System.out.println("4. Salvar Estado da Rede");
        System.out.println("5. Carregar Estado da Rede");
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
            System.out.println("5. Adicionar Conexão");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = getInputInt(scanner);

            switch (opcao) {
                case 1:
                    adicionarComputador(scanner, dispositivos);
                    break;
                case 2:
                    adicionarSwitch(scanner, dispositivos);
                    break;
                case 3:
                    adicionarRouter(scanner, dispositivos);
                    break;
                case 4:
                    adicionarServidor(scanner, dispositivos);
                    break;
                case 5:
                    adicionarConexao(scanner, dispositivos, conexoes);
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
    private static void adicionarComputador(Scanner scanner, List<Equipamento> dispositivos) {
        System.out.println("Digite o nome do computador: ");
        String nome = scanner.nextLine();

        // Verifica se o nome já existe
        if (equipamentoComNomeJaExiste(dispositivos, nome)) {
            System.out.println("Já existe um equipamento com esse nome. Operação cancelada.");
            return;
        }

        System.out.println("Deseja inserir manualmente o endereço MAC? (S/N): ");
        String opcaoMAC = scanner.nextLine();

        String enderecoMAC;
        if (opcaoMAC.equalsIgnoreCase("S")) {
            System.out.println("Digite o endereço MAC do computador: ");
            enderecoMAC = scanner.nextLine();

            // Verifica se o MAC possui o formato correto
            if (!validarFormatoMAC(enderecoMAC)) {
                System.out.println("Formato de endereço MAC inválido. Operação cancelada.");
                return;
            }

            // Verifica se o MAC já existe
            if (equipamentoComEnderecoMACJaExiste(dispositivos, enderecoMAC)) {
                System.out.println("Já existe um equipamento com esse endereço MAC. Operação cancelada.");
                return;
            }
        } else if (opcaoMAC.equalsIgnoreCase("N")) {
            enderecoMAC = GeradorMacAleatorio.gerarMacAleatorio();
        } else {
            System.out.println("Opção inválida. Operação cancelada.");
            return;
        }

        System.out.println("Deseja inserir manualmente o endereço IP? (S/N): ");
        String opcaoIP = scanner.nextLine();

        String enderecoIP;
        if (opcaoIP.equalsIgnoreCase("S")) {
            System.out.println("Digite o endereço IP do computador: ");
            enderecoIP = scanner.nextLine();

            if (!validarFormatoIP(enderecoIP)) {
                System.out.println("Formato de endereço IP inválido. Operação cancelada.");
                return;
            }
        } else if (opcaoIP.equalsIgnoreCase("N")) {
            enderecoIP = GeradorIP.gerarIPAleatorio();
        } else {
            System.out.println("Opção inválida. Operação cancelada.");
            return;
        }

        Terminal computador = new Terminal(nome, enderecoMAC, enderecoIP);
        dispositivos.add(computador);
    }
    private static void adicionarSwitch(Scanner scanner, List<Equipamento> dispositivos) {
        System.out.println("Digite o nome do switch: ");
        String nomeSwitch = scanner.nextLine();
        // Verifica se o nome já existe
        if (equipamentoComNomeJaExiste(dispositivos, nomeSwitch)) {
            System.out.println("Já existe um equipamento com esse nome. Operação cancelada.");
            return;
        }
        System.out.println("Deseja inserir manualmente o endereço MAC? (S/N): ");
        String opcaoMAC = scanner.nextLine();

        String enderecoMACSwitch;
        if (opcaoMAC.equalsIgnoreCase("S")) {
            System.out.println("Digite o endereço MAC do Switch: ");
            enderecoMACSwitch = scanner.nextLine();

            // Verifica se o MAC possui o formato correto
            if (!validarFormatoMAC(enderecoMACSwitch)) {
                System.out.println("Formato de endereço MAC inválido. Operação cancelada.");
                return;
            }

            // Verifica se o MAC já existe
            if (equipamentoComEnderecoMACJaExiste(dispositivos, enderecoMACSwitch)) {
                System.out.println("Já existe um equipamento com esse endereço MAC. Operação cancelada.");
                return;
            }
        } else if (opcaoMAC.equalsIgnoreCase("N")) {
            enderecoMACSwitch = GeradorMacAleatorio.gerarMacAleatorio();
        } else {
            System.out.println("Opção inválida. Operação cancelada.");
            return;
        }

        System.out.println("Digite o número de portas do switch: ");
        int numeroPortas = scanner.nextInt();
        scanner.nextLine();
        Switch switchDevice = new Switch(nomeSwitch, enderecoMACSwitch, numeroPortas);
        dispositivos.add(switchDevice);
    }
    private static void adicionarRouter(Scanner scanner, List<Equipamento> dispositivos) {
        System.out.println("Digite o nome do router: ");
        String nomeRouter = scanner.nextLine();
        // Verifica se o nome já existe
        if (equipamentoComNomeJaExiste(dispositivos, nomeRouter)) {
            System.out.println("Já existe um equipamento com esse nome. Operação cancelada.");
            return;
        }
        System.out.println("Deseja inserir manualmente o endereço MAC? (S/N): ");
        String opcaoMAC = scanner.nextLine();

        String enderecoMACRouter;
        if (opcaoMAC.equalsIgnoreCase("S")) {
            System.out.println("Digite o endereço MAC do Router: ");
            enderecoMACRouter = scanner.nextLine();

            // Verifica se o MAC possui o formato correto
            if (!validarFormatoMAC(enderecoMACRouter)) {
                System.out.println("Formato de endereço MAC inválido. Operação cancelada.");
                return;
            }

            // Verifica se o MAC já existe
            if (equipamentoComEnderecoMACJaExiste(dispositivos, enderecoMACRouter)) {
                System.out.println("Já existe um equipamento com esse endereço MAC. Operação cancelada.");
                return;
            }
        } else if (opcaoMAC.equalsIgnoreCase("N")) {
            enderecoMACRouter = GeradorMacAleatorio.gerarMacAleatorio();
        } else {
            System.out.println("Opção inválida. Operação cancelada.");
            return;
        }
        System.out.println("Digite o protocolo do router: ");
        String protocolo = scanner.nextLine();
        System.out.println("Digite o número de portas do router: ");
        int numeroPortas = scanner.nextInt();
        scanner.nextLine();
        Router router = new Router(nomeRouter, enderecoMACRouter, protocolo, numeroPortas);
        dispositivos.add(router);
    }
    private static void adicionarServidor(Scanner scanner, List<Equipamento> dispositivos) {
        System.out.println("Digite o nome do servidor: ");
        String nomeServidor = scanner.nextLine();
        // Verifica se o nome já existe
        if (equipamentoComNomeJaExiste(dispositivos, nomeServidor)) {
            System.out.println("Já existe um equipamento com esse nome. Operação cancelada.");
            return;
        }
        System.out.println("Deseja inserir manualmente o endereço MAC? (S/N): ");
        String opcaoMAC = scanner.nextLine();

        String enderecoMACServidor;
        if (opcaoMAC.equalsIgnoreCase("S")) {
            System.out.println("Digite o endereço MAC do Servidor: ");
            enderecoMACServidor = scanner.nextLine();

            // Verifica se o MAC possui o formato correto
            if (!validarFormatoMAC(enderecoMACServidor)) {
                System.out.println("Formato de endereço MAC inválido. Operação cancelada.");
                return;
            }

            // Verifica se o MAC já existe
            if (equipamentoComEnderecoMACJaExiste(dispositivos, enderecoMACServidor)) {
                System.out.println("Já existe um equipamento com esse endereço MAC. Operação cancelada.");
                return;
            }
        } else if (opcaoMAC.equalsIgnoreCase("N")) {
            enderecoMACServidor = GeradorMacAleatorio.gerarMacAleatorio();
        } else {
            System.out.println("Opção inválida. Operação cancelada.");
            return;
        }

        System.out.println("Digite o endereço Ip do servidor: ");
        String enderecoIPServidor = scanner.nextLine();
        System.out.println("Digite a capacidade do servidor: ");
        int capacidade = scanner.nextInt();
        scanner.nextLine();
        Servidor servidor = new Servidor(nomeServidor, enderecoMACServidor, enderecoIPServidor, capacidade);
        dispositivos.add(servidor);
    }
    private static boolean validarFormatoMAC(String enderecoMAC) {
        // Exemplo de expressão regular para validar o formato de um endereço MAC
        String regexMAC = "^([0-9A-Fa-f]{2}[:-]){5}([0-9A-Fa-f]{2})$";
        return enderecoMAC.matches(regexMAC);
    }
    private static boolean validarFormatoIP(String enderecoIP) {
        // Exemplo de expressão regular para validar o formato de um endereço IP
        String regexIP = "^(25[0-5]|2[0-4][0-9]|[0-1]?[0-9]?[0-9])(\\.(25[0-5]|2[0-4][0-9]|[0-1]?[0-9]?[0-9])){3}$";
        return enderecoIP.matches(regexIP);
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
    private static void adicionarConexao(Scanner scanner, List<Equipamento> dispositivos, List<Ligacao> conexoes) {
        exibirDispositivos(dispositivos);
        Equipamento origem = selecionarOrigem(scanner);
        int indice = dispositivos.indexOf(origem);

        if (indice != -1) {
            TipoConexao tipoConexao = obterTipoConexao(scanner);

            if (tipoConexao != null) {
                Equipamento destino = selecionarDestino(scanner);

                if (destino != null) {
                    estabelecerConexao(origem, destino, tipoConexao, conexoes);
                } else {
                    System.out.println("Destino inválido. Não foi possível estabelecer a conexão.");
                }
            } else {
                System.out.println("Tipo de conexão inválida. Não foi possível estabelecer a conexão.");
            }
        } else {
            System.out.println("Índice inválido. Não foi possível estabelecer a conexão.");
        }
    }
    private static Equipamento selecionarOrigem(Scanner scanner) {
        System.out.print("Escolha o dispositivo Origem (informe o índice): ");
        int indice = obterIndiceValido(scanner, dispositivos.size());

        return (indice != -1) ? dispositivos.get(indice) : null;
    }
    private static Equipamento selecionarDestino(Scanner scanner) {
        System.out.print("Escolha o dispositivo destino (informe o índice): ");
        int indice = obterIndiceValido(scanner, dispositivos.size());

        return (indice != -1) ? dispositivos.get(indice) : null;
    }
    private static void estabelecerConexao(Equipamento dispositivo, Equipamento destino, TipoConexao tipoConexao, List<Ligacao> conexoes)   {
        Ligacao conexao = new Ligacao(dispositivo, destino, tipoConexao);
        dispositivo.adicionarLigacao(destino, tipoConexao);
        conexoes.add(conexao);
        // Add a reverse connection
        Ligacao reverseConexao = new Ligacao(destino, dispositivo, tipoConexao);
        destino.adicionarLigacao(dispositivo, tipoConexao);
        conexoes.add(reverseConexao);

        if (destino instanceof Switch switchDestino) {
            if (dispositivo instanceof Router routerDispositivo) {
                adicionarConexaoNoSwitch(dispositivo, switchDestino);
                adicionarConexaoNoRouter(destino, routerDispositivo);
            } else if (dispositivo instanceof Servidor servidorDispositivo) {
                adicionarConexaoNoSwitch(dispositivo, switchDestino);
                adicionarConexaoNoServidor(destino, servidorDispositivo);
            }else if (dispositivo instanceof Terminal terminalDispositivo) {
                adicionarConexaoNoSwitch(dispositivo, switchDestino);
                adicionarConexaoNoTerminal(destino, terminalDispositivo);
            }
        } else if (destino instanceof Servidor servidorDestino) {
            if (dispositivo instanceof Router routerDispositivo) {
                adicionarConexaoNoServidor(dispositivo, servidorDestino);
                adicionarConexaoNoRouter(destino, routerDispositivo);
            } else if (dispositivo instanceof Switch switchDispositivo) {
                adicionarConexaoNoServidor(dispositivo, servidorDestino);
                adicionarConexaoNoSwitch(destino, switchDispositivo);
            }else if (dispositivo instanceof Terminal terminalDispositivo) {
                adicionarConexaoNoServidor(dispositivo, servidorDestino);
                adicionarConexaoNoTerminal(destino, terminalDispositivo);
            }
        } else if (destino instanceof Router routerDestino) {
            if (dispositivo instanceof Switch switchDispositivo) {
                adicionarConexaoNoRouter(dispositivo, routerDestino);
                adicionarConexaoNoSwitch(destino, switchDispositivo);
            } else if (dispositivo instanceof Servidor servidorDispositivo) {
                adicionarConexaoNoRouter(dispositivo, routerDestino);
                adicionarConexaoNoServidor(destino, servidorDispositivo);
            }else if (dispositivo instanceof Terminal terminalDispositivo) {
                adicionarConexaoNoRouter(dispositivo, routerDestino);
                adicionarConexaoNoTerminal(destino, terminalDispositivo);
            }
        } else if (destino instanceof Terminal terminalDestino) {
            if (dispositivo instanceof Switch switchDispositivo) {
                adicionarConexaoNoTerminal(dispositivo, terminalDestino);
                adicionarConexaoNoSwitch(destino, switchDispositivo);
            } else if (dispositivo instanceof Servidor servidorDispositivo) {
                adicionarConexaoNoTerminal(dispositivo, terminalDestino);
                adicionarConexaoNoServidor(destino, servidorDispositivo);
            }else if (dispositivo instanceof Router routerDispositivo) {
                adicionarConexaoNoTerminal(dispositivo, terminalDestino);
                adicionarConexaoNoRouter(destino, routerDispositivo);
            }
        } else {
            System.out.println("Conexão estabelecida com sucesso.");
        }
    }
    private static void adicionarConexaoNoSwitch(Equipamento dispositivo, Switch switchDestino) {
        int portasDisponiveis = switchDestino.getPortasDisponiveis();

        if (portasDisponiveis > 0) {
            int portaDestino = switchDestino.getNumeroPortas() - portasDisponiveis;

            switchDestino.adicionarEntradaTabelaEncaminhamento(dispositivo.getEnderecoMAC(), portaDestino);
            switchDestino.registrarPortaOcupada(portaDestino, dispositivo.getEnderecoMAC());
            System.out.println("Conexão estabelecida com sucesso no Switch.");

            // Imprimir o mapa de portas do Switch
            switchDestino.imprimirMapaPortas();
        } else {
            System.out.println("Não há portas disponíveis no Switch para estabelecer a conexão.");
        }
    }
    private static void adicionarConexaoNoRouter(Equipamento dispositivo, Router routerDestino) {
        int portasDisponiveis = routerDestino.getPortasDisponiveis();

        if (portasDisponiveis > 0) {
            int portaDestino = routerDestino.getNumeroPortas() - portasDisponiveis;

            routerDestino.adicionarEntradaTabelaEncaminhamento(dispositivo.getEnderecoMAC(), portaDestino);
            routerDestino.registrarPortaOcupada(portaDestino, dispositivo.getEnderecoMAC());
            System.out.println("Conexão estabelecida com sucesso no Router.");

            // Imprimir o mapa de portas do Router
            routerDestino.imprimirMapaPortas();
        } else {
            System.out.println("Não há portas disponíveis no Router para estabelecer a conexão.");
        }
    }
    private static void adicionarConexaoNoServidor(Equipamento dispositivo, Servidor servidorDestino) {
        int capacidadeDisponivel = servidorDestino.getCapacidadeDisponivel();

        if (capacidadeDisponivel > 0) {
            int portaDestino = servidorDestino.getCapacidade() - capacidadeDisponivel;

            servidorDestino.adicionarEntradaTabelaEncaminhamento(dispositivo.getEnderecoMAC(), portaDestino);
            servidorDestino.registrarPortaOcupada(portaDestino, dispositivo.getEnderecoMAC());
            System.out.println("Conexão estabelecida com sucesso no Servidor.");

            // Imprimir o mapa de ligações do Servidor
            servidorDestino.imprimirMapaPortas();
        } else {
            System.out.println("Não há mais capacidade no Servidor para estabelecer a conexão.");
        }
    }
    private static void adicionarConexaoNoTerminal(Equipamento dispositivo, Terminal terminalDestino) {
        if(terminalDestino.getLigacaoDisponivel() > 0){
            terminalDestino.adicionarLigacao(dispositivo);
            System.out.println("Conexão estabelecida com sucesso no Terminal.");
            terminalDestino.imprimirLigacao();
        }else {
            System.out.println("Não há mais capacidade no Terminal para estabelecer a conexão.");
        }
    }
    private static int obterIndiceValido(Scanner scanner, int tamanhoMaximo) {
        while (true) {
            //System.out.print("Escolha o dispositivo existente (informe o índice): ");
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
    // Adiciona a função para enviar mensagem
    public static void enviarMensagem() {
        Scanner scanner = new Scanner(System.in);

        // Exibe a lista de terminais disponíveis
        List<Equipamento> terminaisOrigem = dispositivos.stream()
                .filter(dispositivo -> dispositivo instanceof Terminal)
                .collect(Collectors.toList());

        // Seleciona o terminal de origem
        System.out.print("Escolha o terminal de origem (informe o índice): ");
        int indiceOrigem = obterIndiceValido(scanner, dispositivos.size());
        Terminal terminalOrigem = (indiceOrigem != -1) ? (Terminal) dispositivos.get(indiceOrigem) : null;

        if (terminalOrigem == null) {
            System.out.println("Terminal de origem inválido. Operação cancelada.");
            return;
        }

        // Exibe a lista de terminais disponíveis, excluindo o terminal de origem
        List<Equipamento> terminaisDestino = dispositivos.stream()
                .filter(dispositivo -> dispositivo instanceof Terminal && dispositivo != terminalOrigem)
                .collect(Collectors.toList());

        exibirTerminais(terminaisDestino);

        // Seleciona o terminal de destino
        System.out.print("Escolha o terminal de destino (informe o índice): ");
        int indiceDestino = obterIndiceValido(scanner, terminaisDestino.size());
        Terminal terminalDestino = (indiceDestino != -1) ? (Terminal) terminaisDestino.get(indiceDestino) : null;

        if (terminalDestino == null) {
            System.out.println("Terminal de destino inválido. Operação cancelada.");
            return;
        }

        // Obtém a mensagem a ser enviada
        System.out.print("Digite a mensagem a ser enviada: ");
        String mensagem = scanner.nextLine();

        // Divide a mensagem em pacotes e adiciona à fila
        String[] pacotes = dividirMensagemEmPacotes(mensagem);
        Collections.addAll(filaDePacotes, pacotes);

        System.out.println("Mensagem dividida em pacotes e adicionada à fila de envio.");
        receberMensagem();
    }
    // Adiciona função para dividir a mensagem em pacotes
    private static String[] dividirMensagemEmPacotes(String mensagem) {
        // Define o tamanho máximo de cada pacote (você pode ajustar conforme necessário)
        int tamanhoDoPacote = 10;

        // Divide a mensagem em pacotes
        List<String> pacotes = new ArrayList<>();
        for (int i = 0; i < mensagem.length(); i += tamanhoDoPacote) {
            int fim = Math.min(i + tamanhoDoPacote, mensagem.length());
            pacotes.add(mensagem.substring(i, fim));
        }

        return pacotes.toArray(new String[0]);
    }
    // Adiciona função para exibir terminais
    private static void exibirTerminais(List<Equipamento> terminais) {
        System.out.println("Terminais Disponíveis:");
        for (int i = 0; i < terminais.size(); i++) {
            System.out.println(i + ". " + terminais.get(i).getNome());
        }
    }
    public static void receberMensagem() {
        if (filaDePacotes.isEmpty()) {
            System.out.println("Não há pacotes na fila para receber.");
            return;
        }
        // Seleciona o terminal de destino para receber a mensagem
        Scanner scanner = new Scanner(System.in);
        exibirTerminais(dispositivos);

        System.out.print("Escolha o terminal de destino para receber a mensagem (informe o índice): ");
        int indiceDestino = obterIndiceValido(scanner, dispositivos.size());
        Terminal terminalDestino = (indiceDestino != -1) ? (Terminal) dispositivos.get(indiceDestino) : null;

        if (terminalDestino == null) {
            System.out.println("Terminal de destino inválido. Operação cancelada.");
            return;
        }

        // Verifica se o terminal de destino tem espaço para receber a mensagem
        if (terminalDestino.getLigacaoDisponivel() > 0) {
            // Recebe cada pacote da fila e exibe no ecrã
            System.out.println("Recebendo mensagem para o terminal " + terminalDestino.getNome() + ":");
            for (String pacote : filaDePacotes) {
                System.out.println("Pacote recebido: " + pacote);
            }

            // Limpa a fila de pacotes
            filaDePacotes.clear();
        } else {
            System.out.println("O terminal de destino não tem capacidade para receber a mensagem.");
        }
    }
    public static void salvarEstadoRedeEmTxt() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("estado_rede.txt"))) {
            // Write details of devices to the file
            writer.write("Detalhes dos Dispositivos:\n");
            for (Equipamento dispositivo : dispositivos) {
                writer.write(dispositivo.toString() + "\n");
            }

            // Write details of connections to the file
            writer.write("\nDetalhes das Conexões:\n");
            for (Ligacao conexao : conexoes) {
                writer.write(conexao.toString() + "\n");
            }

            System.out.println("Estado da rede salvo em arquivo de texto com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void carregarEstadoRede() {
        try (BufferedReader reader = new BufferedReader(new FileReader("estado_rede.txt"))) {
            String line;
            // Read devices from the file
            dispositivos.clear();
            while ((line = reader.readLine()) != null && !line.equals("")) {
                // Parse the line and create a device object
                Equipamento dispositivo = parseDeviceFromLine(line, dispositivos);
                // Add the device to the list
                dispositivos.add(dispositivo);
            }
            // Read connections from the file
            conexoes.clear();
            while ((line = reader.readLine()) != null) {
                // Parse the line and create a connection object, passing the list of devices
                Ligacao conexao = parseConnectionFromLine(line, dispositivos);
                // Add the connection to the list
                conexoes.add(conexao);
            }
            // Display the loaded network state
            imprimirRede(dispositivos, conexoes);
            System.out.println("Estado da rede carregado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static Equipamento parseDeviceFromLine(String line, List<Equipamento> dispositivos) {
        // Verifica se a linha contém informações de dispositivo
        if (!line.startsWith("[")) {
            throw new IllegalArgumentException("Formato de linha inválido para dispositivo: " + line);
        }

        // Supondo que o formato da linha seja "[NOME=nome, MAC=mac, Ip=ip]"
        String[] parts = line.split(", ");

        if (parts.length < 3) {
            throw new IllegalArgumentException("Formato de linha inválido para dispositivo: " + line);
        }

        String nome = parts[0].substring(parts[0].indexOf("=") + 1);
        String mac = parts[1].substring(parts[1].indexOf("=") + 1);
        String ip = parts[2].substring(parts[2].indexOf("=") + 1, parts[2].length() - 1);

        // Crie e retorne o objeto Equipamento com base nos valores extraídos
        Equipamento dispositivo = new Terminal(nome, mac, ip);

        // Adicione o dispositivo à lista de dispositivos
        dispositivos.add(dispositivo);

        return dispositivo;
    }
    private static Ligacao parseConnectionFromLine(String line, List<Equipamento> dispositivos) {
        // Supondo que o formato da linha seja "Ligacao [[NOME=origem], [NOME=destino], TipoConexao=tipo]"
        String[] parts = line.split(", ");

        if (parts.length < 3) {
            throw new IllegalArgumentException("Formato de linha inválido: " + line);
        }

        // Parse origem
        Equipamento origem = parseDeviceFromLine(parts[0].substring(parts[0].indexOf("[") + 1), dispositivos);

        // Parse destino
        Equipamento destino = parseDeviceFromLine(parts[1].substring(0, parts[1].indexOf("]")), dispositivos);

        // Parse tipo de conexão
        String tipoStr = parts[2].substring(parts[2].indexOf("=") + 1, parts[2].length() - 1);
        TipoConexao tipo = TipoConexao.valueOf(tipoStr);

        // Crie e retorne o objeto Ligacao com base nos valores extraídos
        return new Ligacao(origem, destino, tipo);
    }
}