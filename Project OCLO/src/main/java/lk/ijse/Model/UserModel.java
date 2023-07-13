package lk.ijse.Model;

import lk.ijse.db.DataBaseConnection;
import lk.ijse.dto.Customer;
import lk.ijse.dto.User;
import lk.ijse.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserModel {
    public static List<User> getAll() throws SQLException {
        Connection con = DataBaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM user";

        List<User> data = new ArrayList<>();

        ResultSet resultSet = con.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            data.add(new User(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
            ));
        }
        return data;
    }

    public static boolean save(User user) throws SQLException {
        String sql = "INSERT INTO user (username, name, accountType, password) VALUES (?, ?, ?, ?)";
        return CrudUtil.execute(sql, user.getUsername(), user.getName(), user.getAccountType(), user.getPassword());
    }

    public static boolean update(User user) throws SQLException {
        String sql="UPDATE user SET name = ?, accountType = ?, password = ? WHERE username = ?";
        return CrudUtil.execute(sql, user.getName(), user.getAccountType(), user.getPassword(), user.getUsername());
    }

    public static boolean delete(String username) throws SQLException {
        String sql="DELETE FROM user WHERE username = ?";
        return CrudUtil.execute(sql, username);
    }
}
