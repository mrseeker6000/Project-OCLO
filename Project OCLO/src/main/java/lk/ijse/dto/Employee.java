package lk.ijse.dto;

import lk.ijse.dto.tm.EmployeeTM;

public class Employee {
    private String id;
    private String name;
    private String address;
    private String salary;
    private String contact;

    public Employee() {
    }

    public Employee(String id, String name, String address, String salary, String contact) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.salary = salary;
        this.contact = contact;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", salary='" + salary + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
