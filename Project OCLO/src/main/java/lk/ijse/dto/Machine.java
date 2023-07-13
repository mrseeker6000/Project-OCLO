package lk.ijse.dto;



public class Machine {
    private String machine_id;
    private String description;
    private String status;

    public Machine(String machine_id, String description, String status) {
        this.machine_id = machine_id;
        this.description = description;
        this.status = status;
    }

    public String getMachine_id() {
        return machine_id;
    }

    public void setMachine_id(String machine_id) {
        this.machine_id = machine_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Machine{" +
                "machine_id='" + machine_id + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
