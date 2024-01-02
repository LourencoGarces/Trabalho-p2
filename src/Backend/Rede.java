package Backend;
import java.util.List;
import java.util.ArrayList;

public class Rede {
    private Equipamentos[][] matrizAdjacencia;
    private List<Equipamentos> equipamentos;

    public Rede(int tamanho) {
        this.matrizAdjacencia = new Equipamentos[tamanho][tamanho];
        this.equipamentos = new ArrayList<>();
    }

    public void adicionarEquipamento(Equipamentos equipamento) {
        equipamentos.add(equipamento);
    }

    public void adicionarLigacao(Equipamentos origem, Equipamentos destino) {
        int indiceOrigem = equipamentos.indexOf(origem);
        int indiceDestino = equipamentos.indexOf(destino);

        if (indiceOrigem != -1 && indiceDestino != -1) {
            matrizAdjacencia[indiceOrigem][indiceDestino] = destino;
            matrizAdjacencia[indiceDestino][indiceOrigem] = origem;
        } else {
            System.out.println("Equipamentos não encontrados na rede.");
        }
    }

    public void comunicar(Equipamentos origem, Equipamentos destino, String mensagem) {
        int indiceOrigem = equipamentos.indexOf(origem);
        int indiceDestino = equipamentos.indexOf(destino);

        if (indiceOrigem != -1 && indiceDestino != -1) {
            Equipamentos equipOrigem = equipamentos.get(indiceOrigem);
            Equipamentos equipDestino = equipamentos.get(indiceDestino);

            System.out.println("Comunicando de " + equipOrigem + " para " + equipDestino + ": " + mensagem);
        } else {
            System.out.println("Equipamentos não encontrados na rede.");
        }
    }

    // Outros métodos conforme necessário
}