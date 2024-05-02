package sistdistrproj;

public class CandidateRequestLogarClient {

    String operation;
    String status;
    DataLogar dataLogar;
    String token;

    public CandidateRequestLogarClient(String operation, String status, DataLogar dataLogar, String token) {
        this.operation = operation;
        this.status = status;
        this.dataLogar = dataLogar;
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

    public DataLogar getDataLogar() {
        return dataLogar;
    }

    public void setDataLogar(DataLogar dataLogar) {
        this.dataLogar = dataLogar;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "CandidateRequestLogarClient{" +
                "operation='" + operation + '\'' +
                ", status='" + status + '\'' +
                ", dataLogar=" + dataLogar +
                ", token='" + token + '\'' +
                '}';
    }
}