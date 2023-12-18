import java.util.ArrayList;
import java.util.List;

public class Rede {
    private List<Equipamentos> equipamentos;
    private List<Ligacao> ligacoes;

    public Rede() {
        this.equipamentos = new ArrayList<>();
        this.ligacoes = new ArrayList<>();
    }

    // Método para adicionar equipamento à lista
    public void adicionarEquipamento(Equipamentos equipamento) {
        equipamentos.add(equipamento);
    }
    public void adicionarLigacao(Ligacao ligacao) {
        // Implemente
    }
}

