package Backend;
public class Trailer {
    private String data;
    public Trailer(String data) {
        this.data = data;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String calculateChecksum() {
        // Implementação simples de soma de verificação
        int checksum = 0;
        for (char c : data.toCharArray()) {
            checksum += (int) c;
        }
        return Integer.toHexString(checksum);  // Retorna o resultado como uma string hexadecimal
    }
    @Override
    public String toString() {
        return "Trailer{" +
                "data='" + data + '\'' +
                ", checksum='" + calculateChecksum() + '\'' +
                '}';
    }
}