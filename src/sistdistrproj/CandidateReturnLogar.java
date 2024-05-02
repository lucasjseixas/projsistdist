package sistdistrproj;

public class CandidateReturnLogar {
    String operation;
    String status;
    Data data;
    String token;

    public CandidateReturnLogar(String operation, String status, String token) {
        this.operation = operation;
        this.status = status;
        this.data = new Data();
        this.token = token;
    }

    public CandidateReturnLogar(String operation, String status, Data data, String token) {
        this.operation = operation;
        this.status = status;
        this.data = data;
        this.token = token;
    }

    public CandidateReturnLogar(String operation, String status, Data data) {
        this.operation = operation;
        this.status = status;
        this.data = data;
    }

    public CandidateReturnLogar(String operation, String status) {
        this.operation = operation;
        this.status = status;
        this.data = new Data();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Data data) {

        this.data = data;
    }

    @Override
    public String toString() {
        return "CandidateReturn{" +
                "operation='" + operation + '\'' +
                ", status='" + status + '\'' +
                ", data=" + data +
                '}';
    }
}