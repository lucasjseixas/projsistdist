package sistdistrproj;


public class DataLogar {
    String email;
    String password;

    public DataLogar(String email, String password, String name) {
        this.email = email;
        this.password = password;
    }

    public DataLogar() {

    }

    public DataLogar(String email, String password) {
        this.email = email;
        this.password = password;

    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Data{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
