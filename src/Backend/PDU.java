package Backend;
public class PDU {
    private Header header;
    private Data data;
    private Trailer trailer;

    // Construtor
    public PDU(Header header, Data data, Trailer trailer) {
        this.header = header;
        this.data = data;
        this.trailer = trailer;
    }

    // Métodos para acessar e modificar os campos
    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    // Método para representação textual da PDU
    @Override
    public String toString() {
        return "PDU{" +
                "header=" + header +
                ", data=" + data +
                ", trailer=" + trailer +
                '}';
    }
}

