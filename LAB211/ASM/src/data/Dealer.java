package data;

public class Dealer implements Comparable<Dealer> {
    private String ID, name, addr, phone, status;

    public Dealer(String ID, String name, String addr, String phone, String status) {
        this.ID = ID;
        this.name = name;
        this.addr = addr;
        this.phone = phone;
        this.status = status;
    }

    public Dealer() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String outputString() {
        return ID + ',' + name + ',' + addr + ',' + phone + ',' + status;
    }

    public void print() {
        System.out.printf("%-10s|%-35s|%-17s|%-15s|%-6s\n", ID, name, addr, phone, status);
    }

    @Override
    public int compareTo(Dealer o) {
        return ID.compareTo(o.ID);
    }
}
