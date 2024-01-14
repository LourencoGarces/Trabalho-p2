package Backend;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

// Classe Terminal, que herda de Equipamento
public class Terminal extends Equipamento implements Serializable {
    private final String ip; // Endereço IP do terminal
    private int ligacaoDisponivel = 1; // Número de ligações disponíveis no terminal
    private final ArrayList<Equipamento> ligacoes; // Lista de equipamentos conectados ao terminal

    // Construtor da classe Terminal
    public Terminal(String nome, String mac, String ip) {
        super(nome, mac);
        this.ip = ip;
        this.ligacoes = new ArrayList<>(1); // Inicializa a lista de ligações com capacidade inicial 1
    }

    // Método para obter o endereço IP do terminal
    public String getIp() {
        return ip;
    }

    // Método para obter a lista de equipamentos conectados ao terminal
    public List<Equipamento> getLigacoes() {
        return ligacoes;
    }

    // Método para adicionar uma ligação ao terminal
    public void adicionarLigacao(Equipamento destino) {
        ligacoes.add(destino);
        setLigacaoDisponivel(); // Reduz o número de ligações disponíveis
    }

    // Método para obter o número de ligações disponíveis no terminal
    public int getLigacaoDisponivel() {
        return ligacaoDisponivel;
    }

    // Método para definir que uma ligação foi estabelecida (reduz o número de ligações disponíveis)
    public void setLigacaoDisponivel() {
        this.ligacaoDisponivel = 0;
    }

    // Método para imprimir as ligações do terminal
    public void imprimirLigacao() {
        System.out.println("Ligado:" + getNome());
        for (Equipamento equipamento : ligacoes) {
            System.out.println("Nome: " + equipamento.getNome() + ", MAC: " + equipamento.getEnderecoMAC());
        }
    }

    // Sobrescrita do método toString para fornecer uma representação em string do terminal
    @Override
    public String toString() {
        return "[NOME=" + getNome() + ", MAC=" + getEnderecoMAC() + ", Ip=" + ip + "]";
    }
}
