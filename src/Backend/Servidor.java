package Backend;

import java.util.HashMap;
import java.util.Map;
public class Servidor extends Equipamento {
    private final String enderecoIP;
    private int capacidade;
    private Map<String, Integer> tabelaEncaminhamento; // Tabela de encaminhamento
    public Servidor(String nome, String enderecoMAC, String enderecoIP, int capacidade) {
        super(nome, enderecoMAC);
        this.enderecoIP = enderecoIP;
        this.capacidade = capacidade;
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
        tabelaEncaminhamento.put(enderecoMAC, porta);
        usarCapacidade(); // Usa um lugar
    }
    // Método para usar a capacidade (chamado ao estabelecer uma nova conexão)
    public void usarCapacidade() {
        if (capacidade > 0) {
            capacidade--;
        }
    }
    @Override
    public String toString() {
        return "[NOME=" + getNome() + ", MAC=" + getEnderecoMAC() + ", IP=" + enderecoIP + ", Capacidade=" + capacidade + "]";
    }
}