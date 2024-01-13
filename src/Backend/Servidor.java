package Backend;

import java.util.HashMap;
import java.util.Map;
public class Servidor extends Equipamento {
    private final String enderecoIP;
    private int capacidade;
    private int capacidadeDisponivel ;
    private Map<String, Integer> tabelaEncaminhamento; // Tabela de encaminhamento
    public Servidor(String nome, String enderecoMAC, String enderecoIP, int capacidade) {
        super(nome, enderecoMAC);
        this.enderecoIP = enderecoIP;
        this.capacidade = capacidade;
        this.capacidadeDisponivel = capacidade; // Inicializa o número de portas disponíveis
        this.tabelaEncaminhamento = new HashMap<>(); // Inicializa a tabela de encaminhamento
    }
    public String getEnderecoIP() {
        return enderecoIP;
    }
    public int getCapacidade() {
        return capacidade;
    }
    public int obterPortaPorMAC(String enderecoMAC) {
        // Simula a busca do endereço MAC na tabela de encaminhamento do switch
        // Implemente a lógica real conforme necessário
        if (tabelaEncaminhamento.containsKey(enderecoMAC)) {
            return tabelaEncaminhamento.get(enderecoMAC);
        }
        return -1; // Retorna -1 se o endereço MAC não for encontrado (envia para todas as portas)
    }
    // Adiciona um endereço MAC e a porta correspondente à tabela de encaminhamento
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
        usarCapacidade(); // Usa um lugar
    }
    public int getCapacidadeDisponivel() {
        return capacidadeDisponivel;
    }
    // Método para usar a capacidade (chamado ao estabelecer uma nova conexão)
    public void usarCapacidade() {
        if (capacidadeDisponivel > 0) {
            capacidadeDisponivel--;
        }
    }
    public void registrarPortaOcupada(int porta, String enderecoMACDestino) {
        tabelaEncaminhamento.put(enderecoMACDestino, porta);
    }
    public void imprimirMapaPortas() {
        System.out.println("Mapa de Portas:" + getNome());
        for (Map.Entry<String, Integer> entrada : tabelaEncaminhamento.entrySet()) {
            System.out.println("MAC: " + entrada.getKey() + ", Porta: " + entrada.getValue());
        }
    }
    @Override
    public String toString() {
        return "[NOME=" + getNome() + ", MAC=" + getEnderecoMAC() + ", IP=" + enderecoIP + ", Capacidade=" + capacidade + "]";
    }
}