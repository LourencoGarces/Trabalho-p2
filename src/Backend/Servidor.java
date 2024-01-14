package Backend;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

// Classe que representa um servidor na rede
public class Servidor extends Equipamento implements Serializable {
    private final String enderecoIP; // Endereço IP do servidor
    private int capacidade; // Capacidade total de portas do servidor
    private int capacidadeDisponivel; // Número de portas disponíveis no servidor
    private Map<String, Integer> tabelaEncaminhamento; // Tabela de encaminhamento do servidor

    // Construtor da classe Servidor
    public Servidor(String nome, String enderecoMAC, String enderecoIP, int capacidade) {
        super(nome, enderecoMAC);
        this.enderecoIP = enderecoIP;
        this.capacidade = capacidade;
        this.capacidadeDisponivel = capacidade; // Inicializa o número de portas disponíveis
        this.tabelaEncaminhamento = new HashMap<>(); // Inicializa a tabela de encaminhamento
    }

    // Método para obter o endereço IP do servidor
    public String getEnderecoIP() {
        return enderecoIP;
    }

    // Método para obter a capacidade total de portas do servidor
    public int getCapacidade() {
        return capacidade;
    }

    // Método para obter a capacidade disponível do servidor
    public int getCapacidadeDisponivel() {
        return capacidadeDisponivel;
    }

    // Método para obter a porta associada a um determinado endereço MAC na tabela de encaminhamento
    public int obterPortaPorMAC(String enderecoMAC) {
        if (tabelaEncaminhamento.containsKey(enderecoMAC)) {
            return tabelaEncaminhamento.get(enderecoMAC);
        }
        return -1; // Retorna -1 se o endereço MAC não for encontrado (envia para todas as portas)
    }

    // Método para adicionar uma entrada à tabela de encaminhamento do servidor
    public void adicionarEntradaTabelaEncaminhamento(String enderecoMAC, int porta) {
        // Verifica se o endereço MAC já está na tabela de encaminhamento
        if (tabelaEncaminhamento.containsKey(enderecoMAC)) {
            System.out.println("Endereço MAC " + enderecoMAC + " já está atribuído a uma porta.");
            return;
        }

        // Verifica se a porta já está ocupada
        if (tabelaEncaminhamento.containsValue(porta)) {
            System.out.println("Porta " + porta + " já está ocupada por outro endereço MAC.");
            return;
        }

        // Adiciona o endereço MAC e a porta correspondente à tabela de encaminhamento
        tabelaEncaminhamento.put(enderecoMAC, porta);
        usarCapacidade(); // Usa um lugar na capacidade disponível
    }

    // Método para usar a capacidade disponível (chamado ao estabelecer uma nova conexão)
    public void usarCapacidade() {
        if (capacidadeDisponivel > 0) {
            capacidadeDisponivel--;
        }
    }

    // Método para registrar uma porta ocupada na tabela de encaminhamento
    public void registrarPortaOcupada(int porta, String enderecoMACDestino) {
        tabelaEncaminhamento.put(enderecoMACDestino, porta);
    }

    // Método para imprimir o mapa de portas do servidor
    public void imprimirMapaPortas() {
        System.out.println("Mapa de Portas:" + getNome());
        for (Map.Entry<String, Integer> entrada : tabelaEncaminhamento.entrySet()) {
            System.out.println("MAC: " + entrada.getKey() + ", Porta: " + entrada.getValue());
        }
    }

    // Sobrescrita do método toString para fornecer uma representação em string do servidor
    @Override
    public String toString() {
        return "[NOME=" + getNome() + ", MAC=" + getEnderecoMAC() + ", IP=" + enderecoIP + ", Capacidade=" + capacidade + "]";
    }
}
