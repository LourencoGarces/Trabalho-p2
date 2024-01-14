package Backend;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

// Classe Switch, que herda de Equipamento
public class Switch extends Equipamento implements Serializable {
    private final int numeroPortas; // Número total de portas do switch
    private int portasDisponiveis; // Número de portas disponíveis no switch
    private Map<String, Integer> tabelaEncaminhamento; // Tabela de encaminhamento do switch

    // Construtor da classe Switch
    public Switch(String nome, String enderecoMAC, int numeroPortas) {
        super(nome, enderecoMAC);
        this.numeroPortas = numeroPortas;
        this.portasDisponiveis = numeroPortas; // Inicializa o número de portas disponíveis
        this.tabelaEncaminhamento = new HashMap<>(); // Inicializa a tabela de encaminhamento
    }

    // Método para obter o número total de portas do switch
    public int getNumeroPortas() {
        return numeroPortas;
    }

    // Método para obter o número de portas disponíveis no switch
    public int getPortasDisponiveis() {
        return portasDisponiveis;
    }

    // Método para obter a porta associada a um determinado endereço MAC na tabela de encaminhamento
    public int obterPortaPorMAC(String enderecoMAC) {
        if (tabelaEncaminhamento.containsKey(enderecoMAC)) {
            return tabelaEncaminhamento.get(enderecoMAC);
        }
        return -1; // Retorna -1 se o endereço MAC não for encontrado (envia para todas as portas)
    }

    // Método para adicionar uma entrada à tabela de encaminhamento do switch
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
        usarPorta(); // Usa uma porta disponível
    }

    // Método para usar uma porta disponível (chamado ao estabelecer uma nova conexão)
    public void usarPorta() {
        if (portasDisponiveis > 0) {
            portasDisponiveis--;
        }
    }

    // Método para registrar uma porta ocupada na tabela de encaminhamento
    public void registrarPortaOcupada(int porta, String enderecoMACDestino) {
        tabelaEncaminhamento.put(enderecoMACDestino, porta);
    }

    // Método para imprimir o mapa de portas do switch
    public void imprimirMapaPortas() {
        System.out.println("Mapa de Portas:" + getNome());
        for (Map.Entry<String, Integer> entrada : tabelaEncaminhamento.entrySet()) {
            System.out.println("MAC: " + entrada.getKey() + ", Porta: " + entrada.getValue());
        }
    }

    // Sobrescrita do método toString para fornecer uma representação em string do switch
    @Override
    public String toString() {
        return "[NOME=" + getNome() + ", MAC=" + getEnderecoMAC() + ", Número de Portas=" + numeroPortas +
                ", Portas Disponíveis=" + portasDisponiveis + "]";
    }
}
