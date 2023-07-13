package lk.ijse.Model;

import lk.ijse.db.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class OrderModel {

    public static String generateNextOrderId() throws SQLException {
        Connection con = DataBaseConnection.getInstance().getConnection();

        String sql = "SELECT order_id FROM Orders ORDER BY order_id DESC LIMIT 1";

        ResultSet resultSet = con.createStatement().executeQuery(sql);
        if(resultSet.next()) {
            return splitOrderId(resultSet.getString(1));
        }
        return splitOrderId(null);
    }

    public static String splitOrderId(String currentOrderId) {
        if(currentOrderId != null) {
            String[] strings = currentOrderId.split("O0");
            int id = Integer.parseInt(strings[1]);
            id++;

            return "O0"+id;
        }
        return "O001";
    }

    public static boolean save(String oId, String cusId, LocalDate date) throws SQLException {
        Connection con = DataBaseConnection.getInstance().getConnection();
        String sql = "INSERT INTO Orders(order_id, date, customer_id) VALUES (?, ?, ?)";

        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, oId);
        pstm.setString(2, String.valueOf(date));
        pstm.setString(3, cusId);

        return pstm.executeUpdate() > 0;
    }
}
