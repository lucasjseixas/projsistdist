package sistdistrproj;

public class CandidateReturn {
    String operation;
    String status;
    Candidate data;

    public CandidateReturn(String operation, String status) {
        this.operation = operation;
        this.status = status;

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

    public Candidate getData() {
        return data;
    }

    public void setData(Candidate data) {
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