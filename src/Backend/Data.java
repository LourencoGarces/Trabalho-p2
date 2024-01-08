package Backend;
// Subclasse Data
public class Data {
    private String payload;
    // Adicione outros campos de dados conforme necessário

    public Data(String payload) {
        this.payload = payload;
        // Inicialize outros campos de dados conforme necessário
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    // Adicione getters e setters para outros campos de dados conforme necessário

    @Override
    public String toString() {
        return "Data{" +
                "payload='" + payload + '\'' +
                // Adicione outros campos de dados conforme necessário
                '}';
    }
}
