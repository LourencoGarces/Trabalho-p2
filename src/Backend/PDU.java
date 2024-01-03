package Backend;
public class PDU {
    private String header;
    private String data;
    private String trailer;
    // Construtor
    public PDU(String header, String data, String trailer) {
        this.header = header;
        this.data = data;
        this.trailer = trailer;
    }
    // Métodos para acessar e modificar os campos
    public String getHeader() {
        return header;
    }
    public void setHeader(String header) {
        this.header = header;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public String getTrailer() {
        return trailer;
    }
    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
    // Método para representação textual da PDU
    @Override
    public String toString() {
        return "PDU{" +
                "header='" + header + '\'' +
                ", data='" + data + '\'' +
                ", trailer='" + trailer + '\'' +
                '}';
    }
}
