package Backend;

import java.util.ArrayList;
import java.util.List;

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
    // Método público para obter equipamento por MAC
    public Equipamentos obterEquipamentoPorMac(String mac) {
        for (Equipamentos[] linha : matrizAdjacencia) {
            for (Equipamentos equipamento : linha) {
                if (equipamento != null && equipamento instanceof Terminal && equipamento.getMac().equals(mac)) {
                    return equipamento;
                }
            }
        }
        return null;
    }

    public Equipamentos[] getEquipamentos() {
        return equipamentos.toArray(new Equipamentos[equipamentos.size()]);
    }
    // Outros métodos conforme necessário
}
