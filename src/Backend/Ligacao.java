package Backend;
public class Ligacao {
    private Equipamentos origem;
    private Equipamentos destino;
    private int distancia;

    public Ligacao(Equipamentos origem, Equipamentos destino, int distancia) {
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
    }
    public Equipamentos getOrigem() {
        return origem;
    }
    public Equipamentos getDestino() {
        return destino;
    }
    public int getDistancia() {
        return distancia;
    }
    @Override
    public String toString() {
        return "Ligacao [Origem=" + origem + ", Destino=" + destino + ", Distancia=" + distancia + "]";
    }
}