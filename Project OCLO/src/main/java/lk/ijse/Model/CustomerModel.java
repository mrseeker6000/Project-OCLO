package lk.ijse.Model;

import lk.ijse.dto.Customer;
import lk.ijse.db.DataBaseConnection;
import lk.ijse.util.CrudUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerModel {
    public static List<Customer> getAll() throws SQLException {
        Connection con = DataBaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM customer";

        List<Customer> data = new ArrayList<>();

        ResultSet resultSet = con.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            data.add(new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            ));
        }
        return data;
    }

    public static boolean save(Customer customer) throws SQLException {
        String sql = "INSERT INTO customer (customer_id, name, address, contact) VALUES (?, ?, ?, ?)";
        return CrudUtil.execute(sql, customer.getNic(), customer.getName(), customer.getAddress(), customer.getContact());
    }

    public static boolean update(Customer customer) throws SQLException {
        String sql="UPDATE customer SET name = ?, address = ?, contact = ? WHERE customer_id = ?";
        return CrudUtil.execute(sql, customer.getName(), customer.getAddress(), customer.getContact(), customer.getNic());
    }

    public static boolean delete(String cutomer_id) throws SQLException {
        String sql="DELETE FROM customer WHERE customer_id = ?";
        return CrudUtil.execute(sql, cutomer_id);

    }

    public static List<String> getIds() throws SQLException {
        Connection con = DataBaseConnection.getInstance().getConnection();
        String sql = "SELECT customer_id FROM customer";

        List<String> ids = new ArrayList<>();

        ResultSet resultSet = con.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            ids.add(resultSet.getString(1));
        }
        return ids;
    }

    public static Customer searchById(String cusId) throws SQLException {
        Connection con = DataBaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM customer WHERE customer_id = ?";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, cusId);

        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()) {
            return new Customer(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            );
        }
        return null;
    }
}
