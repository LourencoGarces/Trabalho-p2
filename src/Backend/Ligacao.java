package Backend;

import java.io.Serializable;
public class Ligacao implements Serializable {
    private Equipamento macorigem;
    private Equipamento macdestino;
    private TipoConexao tipoConexao;
    public Ligacao(Equipamento macorigem, Equipamento macdestino, TipoConexao tipoConexao) {
        this.macorigem = macorigem;
        this.macdestino = macdestino;
        this.tipoConexao = tipoConexao;

        macorigem.adicionarLigacaoDireta(this);
        macdestino.adicionarLigacaoDireta(this);
    }
    public Equipamento getMacOrigem() {
        return macorigem;
    }
    public Equipamento getMacDestino() {
        return macdestino;
    }
    public TipoConexao getTipoConexao() {
        return tipoConexao;
    }
    @Override
    public String toString() {
        return "Ligacao [" + macorigem + ", " + macdestino + ", TipoConexao=" + tipoConexao + "]";
    }
}