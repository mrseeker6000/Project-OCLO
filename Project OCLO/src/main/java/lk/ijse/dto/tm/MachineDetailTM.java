package lk.ijse.dto.tm;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class MachineDetailTM {
    private String employeeId;
    private String machineId;
    private String status;
}
