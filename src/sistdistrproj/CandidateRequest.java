package sistdistrproj;

public class CandidateRequest {

    String operation;
    Candidate data;

    public CandidateRequest(String operation, Candidate data) {
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

    public Candidate getData() {
        return data;
    }

    public void setData(Candidate data) {
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
