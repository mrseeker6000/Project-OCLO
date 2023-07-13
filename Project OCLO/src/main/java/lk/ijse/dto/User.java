package lk.ijse.dto;


public class User {
    private String username;
    private String name;
    private String accountType;
    private String password;

    public User(String username, String name, String accountType) {
        this.username = username;
        this.name = name;
        this.accountType = accountType;
    }

    public User(String username, String name, String accountType, String password) {
        this.username = username;
        this.name = name;
        this.accountType = accountType;
        this.password = password;
    }

    public User(String username,String password){this.username=username;this.password=password; }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", accountType='" + accountType + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
