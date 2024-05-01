package sistdistrproj;

public class CandidateTeste {
    Data data;

    public CandidateTeste(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CandidateTeste{" +
                "data=" + data +
                '}';
    }

}
