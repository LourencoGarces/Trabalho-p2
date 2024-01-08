package Backend;

import java.util.HashMap;
import java.util.Map;

// Classe Switch, que herda de Equipamento
public class Switch extends Equipamento {
    private int numeroPortas;
    private Map<String, Integer> tabelaEncaminhamento; // Tabela de encaminhamento

    public Switch(String nome, String enderecoMAC, int numeroPortas) {
        super(nome, enderecoMAC);
        this.numeroPortas = numeroPortas;
        this.tabelaEncaminhamento = new HashMap<>(); // Inicializa a tabela de encaminhamento
    }

    public int getNumeroPortas() {
        return numeroPortas;
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
    }

    @Override
    public String toString() {
        return "[NOME=" + getNome() + ", MAC=" + getEnderecoMAC() + ", Número de Portas=" + numeroPortas + "]";
    }
}
