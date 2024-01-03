package Backend;
// Classe Switch, que herda de Equipamento
public class Switch extends Equipamento {
    private int numeroPortas;
    public Switch(String nome, String enderecoMAC, int numeroPortas) {
        super(nome, enderecoMAC);
        this.numeroPortas = numeroPortas;
    }
    public int getNumeroPortas() {
        return numeroPortas;
    }
    @Override
    public String toString() {
        return "Switch [NOME=" + getNome() + ", MAC=" + getEnderecoMAC() + ", Número de Portas=" + numeroPortas + "]";
    }
}