package Backend;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

// Classe Terminal, que herda de Equipamento
public class Terminal extends Equipamento implements Serializable {
    private final String ip;
    private int ligacaoDisponivel = 1;
    private final ArrayList<Equipamento> ligacoes;
    public Terminal(String nome, String mac, String ip) {
        super(nome, mac);
        this.ip = ip;
        this.ligacoes = new ArrayList<>(1);
    }
    public String getIp() {
        return ip;
    }
    public List<Equipamento> getLigacoes() {
        return ligacoes;
    }
    public void adicionarLigacao(Equipamento destino) {
        ligacoes.add(destino);
        setLigacaoDisponivel();
    }
    public int getLigacaoDisponivel() {
        return ligacaoDisponivel;
    }
    public void setLigacaoDisponivel() {
        this.ligacaoDisponivel = 0;
    }
    public void imprimirLigacao() {
        System.out.println("Ligado:" + getNome());
        for (Equipamento equipamento : ligacoes) {
            System.out.println("Nome: " + equipamento.getNome() + ", MAC: " + equipamento.getEnderecoMAC());
        }
    }
    @Override
    public String toString() {
        return "[NOME=" + getNome() + ", MAC=" + getEnderecoMAC() + ", Ip=" + ip + "]";
    }
}