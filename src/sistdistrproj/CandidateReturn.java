package sistdistrproj;

public class CandidateReturn {
    String operation;
    String status;
    Object data;

    public CandidateReturn(String operation, String status) {
        this.operation = operation;
        this.status = status;
        this.data = new Object();
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

    public void setData(Object data) {
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