package Backend;
import java.util.HashMap;
import java.util.Map;

// Classe Roteador, que herda de Equipamento
public class Router extends Equipamento {
    private final String protocolo;
    private final int numeroPortas;
    private int portasDisponiveis; // Nova variável para rastrear as portas disponíveis
    private Map<String, Integer> tabelaEncaminhamento; // Tabela de encaminhamento
    public Router(String nome, String enderecoMAC, String protocolo, int numeroPortas) {
        super(nome, enderecoMAC);
        this.protocolo = protocolo;
        this.numeroPortas = numeroPortas;
        this.portasDisponiveis = numeroPortas; // Inicializa o número de portas disponíveis
        this.tabelaEncaminhamento = new HashMap<>(); // Inicializa a tabela de encaminhamento
    }
    public String getProtocolo() {
        return protocolo;
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
    // Método para usar uma porta (chamado ao estabelecer uma nova conexão)
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
        return "[NOME=" + getNome() + ", MAC=" + getEnderecoMAC() + ", Protocolo=" + protocolo + "]";
    }
}