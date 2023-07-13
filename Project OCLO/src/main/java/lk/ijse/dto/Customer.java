package lk.ijse.dto;


import lombok.*;

//@NoArgsConstructor
//@AllArgsConstructor
//@Setter
//@Getter
//@ToString
public class Customer {
    private String nic;
    private String name;
    private String address;
    private String contact;

    public Customer() {
    }

    public Customer(String nic, String name, String address, String contact) {
        this.nic = nic;
        this.name = name;
        this.address = address;
        this.contact = contact;
    }


    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "nic='" + nic + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
