package sistdistrproj;

public class CandidateRequest {

    String operation;
    Data data;

    public CandidateRequest(String operation, Data data) {
        this.operation = operation;
        this.data = data;
    }

    public CandidateRequest() {

    }

    public String getOperation() {

        return operation;
    }

    public void setOperation(String operation) {

        this.operation = operation;
    }

    public Data getData() {

        return data;
    }

    public void setData(Data data) {

        this.data = data;
    }

    @Override
    public String toString() {
        return "CandidateRequest{" +
                "operation='" + operation + '\'' +
                ", data=" + data +
                '}';
    }
}
