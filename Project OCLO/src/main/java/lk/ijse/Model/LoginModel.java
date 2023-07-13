package lk.ijse.Model;

import lk.ijse.db.DataBaseConnection;
import lk.ijse.dto.Customer;
import lk.ijse.dto.Employee;
import lk.ijse.dto.User;
import lk.ijse.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginModel {
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


    public static boolean check(User user) throws SQLException {
        String sql="SELECT * FROM user WHERE username = ?";
        return CrudUtil.execute(sql, user.getUsername(), user.getName(), user.getAccountType(), user.getPassword());
    }
}
