package Backend;
public class PDU {
    private String sourceAddress;
    private String destinationAddress;
    private String payload;

    // Construtor
    public PDU(String sourceAddress, String destinationAddress, String payload) {
        this.sourceAddress = sourceAddress;
        this.destinationAddress = destinationAddress;
        this.payload = payload;
    }

    // Métodos getter
    public String getSourceAddress() {
        return sourceAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public String getPayload() {
        return payload;
    }

    // Método toString para representação de string da PDU
    @Override
    public String toString() {
        return "PDU{" +
                "sourceAddress='" + sourceAddress + '\'' +
                ", destinationAddress='" + destinationAddress + '\'' +
                ", payload='" + payload + '\'' +
                '}';
    }
}

