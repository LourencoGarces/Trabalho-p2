package Backend;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
public class Switch extends Equipamento implements Serializable {
    private final int numeroPortas;
    private int portasDisponiveis;
    private Map<String, Integer> tabelaEncaminhamento;
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
        usarPorta(); // Usa uma porta
    }
    public void usarPorta() {
        if (portasDisponiveis > 0) {
            portasDisponiveis--;
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
        return "[NOME=" + getNome() + ", MAC=" + getEnderecoMAC() + ", Número de Portas=" + numeroPortas +
                ", Portas Disponíveis=" + portasDisponiveis + "]";
    }
}