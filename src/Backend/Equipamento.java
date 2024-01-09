package Backend;
import java.util.ArrayList;
import java.util.List;
public class Equipamento {
    private final String nome;
    private final String enderecoMAC;
    private List<Ligacao> ligacoes = new ArrayList<>();

    public Equipamento(String nome, String enderecoMAC) {
        this.nome = nome;
        this.enderecoMAC = enderecoMAC;
    }

    // Métodos getters e setters

    public String getNome() {
        return nome;
    }

    public String getEnderecoMAC() {
        return enderecoMAC;
    }

    public List<Ligacao> getLigacoes() {
        return ligacoes;
    }

    public void setLigacoes(List<Ligacao> ligacoes) {
        this.ligacoes = ligacoes;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Equipamento equipamento = (Equipamento) obj;

        return enderecoMAC.equals(equipamento.enderecoMAC);
    }
    @Override
    public String toString() {
        return "Equipamento [NOME=" + nome + ", MAC=" + enderecoMAC + ", Ligacoes=" + ligacoes + "]";
    }
    public void adicionarLigacao(Equipamento destino, TipoConexao tipo) {
        Ligacao novaLigacao = new Ligacao(this, destino, tipo);
        ligacoes.add(novaLigacao);
    }

    public void removerLigacao(Equipamento destino) {
        ligacoes.removeIf(ligacao -> ligacao.getMacDestino().equals(destino));
    }
}