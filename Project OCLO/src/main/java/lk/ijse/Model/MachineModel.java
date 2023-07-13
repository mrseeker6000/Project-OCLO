package lk.ijse.Model;

import lk.ijse.db.DataBaseConnection;
import lk.ijse.dto.Customer;
import lk.ijse.dto.Machine;
import lk.ijse.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MachineModel {
    public static List<Machine> getAll() throws SQLException {
        Connection con = DataBaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM machine";

        List<Machine> data = new ArrayList<>();

        ResultSet resultSet = con.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            data.add(new Machine(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            ));
        }
        return data;
    }

    public static boolean save(Machine machine) throws SQLException {
        String sql = "INSERT INTO machine (machine_id, description, status) VALUES (?, ?, ?)";
        return CrudUtil.execute(sql, machine.getMachine_id(), machine.getDescription(), machine.getStatus());
    }

    public static boolean update(Machine machine) throws SQLException {
        String sql="UPDATE machine SET description = ?, status = ? WHERE machine_id = ?";
        return CrudUtil.execute(sql, machine.getDescription(), machine.getStatus(), machine.getMachine_id());
    }

    public static boolean delete(String machine_id) throws SQLException {
        String sql="DELETE FROM machine WHERE machine_id = ?";
        return CrudUtil.execute(sql, machine_id);

    }
}
