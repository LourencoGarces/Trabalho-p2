package Backend;
public class Ligacao {
    private Equipamento macorigem;
    private Equipamento macdestino;
    private TipoConexao tipoConexao;
    public Ligacao(Equipamento macorigem, Equipamento macdestino, TipoConexao tipoConexao) {
        this.macorigem = macorigem;
        this.macdestino = macdestino;
        this.tipoConexao = tipoConexao;
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
        return "Ligacao [" + macorigem + macdestino + ", TipoConexao=" + tipoConexao + "]";
    }
}