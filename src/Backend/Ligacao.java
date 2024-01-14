package Backend;

import java.io.Serializable;

// Classe para representar uma ligação entre equipamentos
public class Ligacao implements Serializable {
    private Equipamento macOrigem; // Equipamento de origem
    private Equipamento macDestino; // Equipamento de destino
    private TipoConexao tipoConexao; // Tipo de conexão da ligação

    // Construtor da classe Ligacao
    public Ligacao(Equipamento macOrigem, Equipamento macDestino, TipoConexao tipoConexao) {
        this.macOrigem = macOrigem;
        this.macDestino = macDestino;
        this.tipoConexao = tipoConexao;

        // Adiciona esta ligação como ligação direta nos equipamentos de origem e destino
        macOrigem.adicionarLigacaoDireta(this);
        macDestino.adicionarLigacaoDireta(this);
    }

    // Método para obter o equipamento de origem da ligação
    public Equipamento getMacOrigem() {
        return macOrigem;
    }

    // Método para obter o equipamento de destino da ligação
    public Equipamento getMacDestino() {
        return macDestino;
    }

    // Método para obter o tipo de conexão da ligação
    public TipoConexao getTipoConexao() {
        return tipoConexao;
    }

    // Sobrescrita do método toString para fornecer uma representação em string da ligação
    @Override
    public String toString() {
        return "Ligacao [" + macOrigem + ", " + macDestino + ", TipoConexao=" + tipoConexao + "]";
    }
}