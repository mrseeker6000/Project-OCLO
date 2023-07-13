package lk.ijse.dto.tm;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

public class UserTM {
    private String username;
    private String name;
    private String accountType;
    private String password;
}
