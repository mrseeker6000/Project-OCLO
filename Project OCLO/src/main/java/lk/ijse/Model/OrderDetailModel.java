package lk.ijse.Model;


import lk.ijse.db.DataBaseConnection;
import lk.ijse.dto.CartDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OrderDetailModel {
    public static boolean save(String oId, List<CartDTO> cartDTOList) throws SQLException {
        for(CartDTO dto :  cartDTOList) {
            if(!save(oId, dto)) {
                return false;
            }
        }
        return true;
    }

    private static boolean save(String oId, CartDTO dto) throws SQLException {
        Connection con = DataBaseConnection.getInstance().getConnection();
        String sql = "INSERT INTO OrderDetail(order_id, item_id, qty, unit_price) VALUES (?, ?, ?, ?)";

        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, oId);
        pstm.setString(2, dto.getCode());
        pstm.setInt(3, dto.getQty());
        pstm.setDouble(4, dto.getUnitPrice());

        return pstm.executeUpdate() > 0;

    }
}
