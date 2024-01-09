package Backend;

import java.util.HashMap;
import java.util.Map;

public class Switch extends Equipamento {
    private final int numeroPortas;
    private int portasDisponiveis; // Nova variável para rastrear as portas disponíveis
    private Map<String, Integer> tabelaEncaminhamento; // Tabela de encaminhamento

    public Switch(String nome, String enderecoMAC, int numeroPortas) {
        super(nome, enderecoMAC);
        this.numeroPortas = numeroPortas;
        this.portasDisponiveis = numeroPortas; // Inicializa o número de portas disponíveis
        this.tabelaEncaminhamento = new HashMap<>(); // Inicializa a tabela de encaminhamento
    }
    public int getNumeroPortas() {
        return numeroPortas;
    }
    public int getPortasDisponiveis() {
        return portasDisponiveis;
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
        usarPorta(); // Usa uma porta
    }
    // Método para usar uma porta (chamado ao estabelecer uma nova conexão)
    public void usarPorta() {
        if (portasDisponiveis > 0) {
            portasDisponiveis--;
        }
    }
    @Override
    public String toString() {
        return "[NOME=" + getNome() + ", MAC=" + getEnderecoMAC() + ", Número de Portas=" + numeroPortas +
                ", Portas Disponíveis=" + portasDisponiveis + "]";
    }
}
