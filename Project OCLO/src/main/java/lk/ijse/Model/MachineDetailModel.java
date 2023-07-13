package lk.ijse.Model;

import lk.ijse.db.DataBaseConnection;
import lk.ijse.dto.MachineDetail;
import lk.ijse.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MachineDetailModel {
    public static List<MachineDetail> getAll1() throws SQLException {
        Connection con = DataBaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM machine_detail";

        List<MachineDetail> data = new ArrayList<>();

        ResultSet resultSet = con.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            data.add(new MachineDetail(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3)
            ));
        }
        return data;
    }
    public static boolean save(MachineDetail machineDetail) throws SQLException {
        String sql = "INSERT INTO machine_detail (employee_id, machine_id, status) VALUES (?, ?, ?)";
        return CrudUtil.execute(sql,machineDetail.getEmployeeId(), machineDetail.getMachineId(), machineDetail.getStatus());
    }

    public static boolean update(MachineDetail machineDetail) throws SQLException {
        String sql="UPDATE machine_detail SET employee_id = ?, status = ? WHERE machine_id = ?";
        return CrudUtil.execute(sql, machineDetail.getEmployeeId(), machineDetail.getStatus(), machineDetail.getMachineId());
    }

    public static boolean remove(String machine_id) throws SQLException {
        String sql="DELETE FROM machine_detail WHERE machine_id = ?";
        return CrudUtil.execute(sql, machine_id);

    }
}
