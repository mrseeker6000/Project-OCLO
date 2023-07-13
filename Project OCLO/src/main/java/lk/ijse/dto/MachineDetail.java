package lk.ijse.dto;


public class MachineDetail {
    private String employee_id;
    private String machine_id;
    private String status;

    public MachineDetail(String employee_id, String machine_id, String status) {
        this.employee_id = employee_id;
        this.machine_id = machine_id;
        this.status = status;
    }

    public String getEmployeeId() {
        return employee_id;
    }

    public void setEmployeeId(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getMachineId() {
        return machine_id;
    }

    public void setMachineId(String machine_id) {
        this.machine_id = machine_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MachineDetail{" +
                "employee_id='" + employee_id + '\'' +
                ", machine_id='" + machine_id + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
