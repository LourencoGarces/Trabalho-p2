package Backend;
// Subclasse Header
public class Header {
    private String sourceAddress;
    private String destinationAddress;
    // Adicione outros campos do cabeçalho conforme necessário

    public Header(String sourceAddress, String destinationAddress) {
        this.sourceAddress = sourceAddress;
        this.destinationAddress = destinationAddress;
        // Inicialize outros campos do cabeçalho conforme necessário
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    // Adicione getters e setters para outros campos do cabeçalho conforme necessário

    @Override
    public String toString() {
        return "Header{" +
                "sourceAddress='" + sourceAddress + '\'' +
                ", destinationAddress='" + destinationAddress + '\'' +
                // Adicione outros campos do cabeçalho conforme necessário
                '}';
    }
}
