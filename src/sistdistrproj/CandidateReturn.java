package sistdistrproj;

public class CandidateReturn {
    String operation;
    String status;
    Data data;

    public CandidateReturn(String operation, String status) {
        this.operation = operation;
        this.status = status;
        this.data = new Data();
    }

    public CandidateReturn(String operation, String status, Data data) {
        this.operation = operation;
        this.status = status;
        this.data = data;
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