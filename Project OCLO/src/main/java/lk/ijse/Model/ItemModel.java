package lk.ijse.Model;

import lk.ijse.db.DataBaseConnection;
import lk.ijse.dto.CartDTO;
import lk.ijse.dto.Customer;
import lk.ijse.dto.Item;
import lk.ijse.util.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemModel {
    public static List<Item> getAll() throws SQLException {
        Connection con = DataBaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM item";

        List<Item> data = new ArrayList<>();

        ResultSet resultSet = con.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            data.add(new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            ));
        }
        return data;
    }

    public static boolean save(Item item) throws SQLException {
        String sql = "INSERT INTO item (item_id, category, description, qty, unit_price) VALUES (?, ?, ?, ?, ?)";
        return CrudUtil.execute(sql, item.getItem_id(), item.getCategory(), item.getDescription(), item.getQty(), item.getUnit_price());
    }

    public static boolean update(Item item) throws SQLException {
        String sql="UPDATE item SET category = ?, description = ?, qty = ?, unit_price = ? WHERE item_id = ?";
        return CrudUtil.execute(sql, item.getCategory(), item.getDescription(), item.getQty(), item.getUnit_price(), item.getItem_id());
    }

    public static boolean delete(String item) throws SQLException {
        String sql="DELETE FROM item WHERE item_id = ?";
        return CrudUtil.execute(sql, item);
    }

    public static List<String> getCodes() throws SQLException {
        Connection con = DataBaseConnection.getInstance().getConnection();

        List<String> codes = new ArrayList<>();

        String sql = "SELECT item_id FROM item";
        ResultSet resultSet = con.createStatement().executeQuery(sql);
        while(resultSet.next()) {
            codes.add(resultSet.getString(1));
        }
        return codes;
    }
    public static boolean updateQty(List<CartDTO> cartDTOList) throws SQLException {
        for (CartDTO dto : cartDTOList) {
            if(!updateQty((List<CartDTO>) dto)) {
                return false;
            }
        }
        return true;
    }
    public static Item searchById(String item_id) throws SQLException {
        Connection con = DataBaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM item WHERE item_id = ?";

        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, item_id);

        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            return new Item(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            );
        }
        return null;
    }
}
