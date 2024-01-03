package Backend;

import java.util.ArrayList;
import java.util.List;

public class Rede {
    private Equipamento[][] matrizAdjacencia;
    private List<Equipamento> equipamentos;

    public Rede(int tamanho) {
        this.matrizAdjacencia = new Equipamento[tamanho][tamanho];
        this.equipamentos = new ArrayList<>();
    }

    public void adicionarEquipamento(Equipamento equipamento) {
        equipamentos.add(equipamento);
    }

    public void adicionarLigacao(Equipamento origem, Equipamento destino) {
        int indiceOrigem = equipamentos.indexOf(origem);
        int indiceDestino = equipamentos.indexOf(destino);

        if (indiceOrigem != -1 && indiceDestino != -1) {
            matrizAdjacencia[indiceOrigem][indiceDestino] = destino;
            matrizAdjacencia[indiceDestino][indiceOrigem] = origem;
        } else {
            System.out.println("Equipamentos não encontrados na rede.");
        }
    }

    public void comunicar(Equipamento origem, Equipamento destino, String mensagem) {
        int indiceOrigem = equipamentos.indexOf(origem);
        int indiceDestino = equipamentos.indexOf(destino);

        if (indiceOrigem != -1 && indiceDestino != -1) {
            Equipamento equipOrigem = equipamentos.get(indiceOrigem);
            Equipamento equipDestino = equipamentos.get(indiceDestino);

            System.out.println("Comunicando de " + equipOrigem + " para " + equipDestino + ": " + mensagem);
        } else {
            System.out.println("Equipamentos não encontrados na rede.");
        }
    }
    // Método público para obter equipamento por MAC
    public Equipamento obterEquipamentoPorMac(String mac) {
        for (Equipamento[] linha : matrizAdjacencia) {
            for (Equipamento equipamento : linha) {
                if (equipamento != null && equipamento instanceof Terminal && equipamento.getEnderecoMAC().equals(mac)) {
                    return equipamento;
                }
            }
        }
        return null;
    }

    public Equipamento[] getEquipamentos() {
        return equipamentos.toArray(new Equipamento[equipamentos.size()]);
    }
    // Outros métodos conforme necessário
}
