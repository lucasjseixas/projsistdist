package sistdistrproj;

public class Data {
    String email;
    String password;
    String name;

    public Data(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public Data() {

    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Data{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
