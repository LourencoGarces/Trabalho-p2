package Backend;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Equipamento implements Serializable {
    private final String nome; // Nome do equipamento
    private final String enderecoMAC; // Endereço MAC do equipamento
    private List<Ligacao> ligacoes = new ArrayList<>(); // Lista de ligações do equipamento
    private List<Ligacao> ligacoesDiretas = new ArrayList<>(); // Lista de ligações diretas do equipamento

    // Construtor da classe Equipamento
    public Equipamento(String nome, String enderecoMAC) {
        this.nome = nome;
        this.enderecoMAC = enderecoMAC;
    }

    // Métodos getters e setters

    // Método para obter o nome do equipamento
    public String getNome() {
        return nome;
    }

    // Método para obter o endereço MAC do equipamento
    public String getEnderecoMAC() {
        return enderecoMAC;
    }

    // Método para definir a lista de ligações do equipamento
    public void setLigacoes(List<Ligacao> ligacoes) {
        this.ligacoes = ligacoes;
    }

    // Método para adicionar uma ligação direta ao equipamento
    public void adicionarLigacaoDireta(Ligacao ligacao) {
        ligacoesDiretas.add(ligacao);
    }

    // Método para obter a lista de ligações diretas do equipamento
    public List<Ligacao> getLigacoesDiretas() {
        return ligacoesDiretas;
    }

    // Sobrescrita do método equals para comparar equipamentos com base no endereço MAC
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Equipamento equipamento = (Equipamento) obj;

        return enderecoMAC.equals(equipamento.enderecoMAC);
    }

    // Sobrescrita do método toString para fornecer uma representação em string do equipamento
    @Override
    public String toString() {
        return "Equipamento [NOME=" + nome + ", MAC=" + enderecoMAC + ", Ligacoes=" + ligacoes + "]";
    }

    // Método para adicionar uma nova ligação ao equipamento
    public void adicionarLigacao(Equipamento destino, TipoConexao tipo) {
        Ligacao novaLigacao = new Ligacao(this, destino, tipo);
        ligacoes.add(novaLigacao);
    }

    // Método para remover uma ligação do equipamento com um destino específico
    public void removerLigacao(Equipamento destino) {
        ligacoes.removeIf(ligacao -> ligacao.getMacDestino().equals(destino));
    }
}
