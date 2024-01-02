package Backend;
public class SimuladorEnvioDados {
    private Rede rede;
    public SimuladorEnvioDados(Rede rede) {
        this.rede = rede;
    }
    public void enviarDados(Terminal origem, Terminal destino, String dados) {
        // Lógica para simular o envio de dados
        // Pode envolver a criação de PDUs, escolha de rota, registro do caminho, etc.
        System.out.println("Simulando envio de dados de " + origem.getMac() + " para " + destino.getMac());
        // Registre o percurso dos dados
        // Exemplo: System.out.println("Percurso: " + origem + " -> EquipamentoX -> EquipamentoY -> " + destino);

        // Adicione aqui a lógica específica para a simulação de envio de dados na rede
    }
    // Métodos adicionais conforme necessário
}
