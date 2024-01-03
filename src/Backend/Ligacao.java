package Backend;
public class Ligacao {
    private Equipamento macorigem;
    private Equipamento macdestino;
    private String tipoConexao;
    public Ligacao(Equipamento macorigem, Equipamento macdestino, String tipoConexao) {
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
    public String getTipoConexao() {
        return tipoConexao;
    }
    @Override
    public String toString() {
        return "Ligacao [MacOrigem=" + macorigem + ", MacDestino=" + macdestino + ", TipoConexao=" + tipoConexao + "]";
    }
}