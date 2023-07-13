package lk.ijse.dto.tm;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class ItemTM {
    private String item_id;
    private String category;
    private String description;
    private String qty;
    private String unit_price;
}
