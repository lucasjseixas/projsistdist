package sistdistrproj;

public class CandidateRequestLogar {

    String operation;
    DataLogar dataLogar;

    public CandidateRequestLogar(String operation, DataLogar dataLogar) {
        this.operation = operation;
        this.dataLogar = dataLogar;
    }

    public CandidateRequestLogar() {

    }

    public String getOperation() {

        return operation;
    }

    public void setOperation(String operation) {

        this.operation = operation;
    }

    public DataLogar getData() {

        return dataLogar;
    }

    public void setData(DataLogar dataLogar) {

        this.dataLogar = dataLogar;
    }

    @Override
    public String toString() {
        return "CandidateRequest{" +
                "operation='" + operation + '\'' +
                ", data=" + dataLogar +
                '}';
    }
}