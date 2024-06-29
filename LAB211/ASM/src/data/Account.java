package data;

public class Account {
    private String accName;
    private String pwd;
    private String role;

    public Account() {
    }

    public Account(String accName, String pwd, String role) {
        this.accName = accName;
        this.pwd = pwd;
        this.role = role;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
