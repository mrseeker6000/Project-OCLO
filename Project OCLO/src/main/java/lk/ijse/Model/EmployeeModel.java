package lk.ijse.Model;

import lk.ijse.db.DataBaseConnection;
import lk.ijse.dto.Customer;
import lk.ijse.dto.Employee;
import lk.ijse.util.CrudUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel {
    public static List<Employee> getAll() throws SQLException {
        Connection con = DataBaseConnection.getInstance().getConnection();
        String sql = "SELECT * FROM employee";

        List<Employee> data = new ArrayList<>();

        ResultSet resultSet = con.createStatement().executeQuery(sql);
        while (resultSet.next()) {
            data.add(new Employee(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5)
            ));
        }
        return data;
    }

    public static boolean save(Employee employee) throws SQLException {
        String sql = "INSERT INTO employee (employee_id, name, address, salary, contact) VALUES (?, ?, ?, ?, ?)";
        return CrudUtil.execute(sql, employee.getId(), employee.getName(), employee.getAddress(), employee.getSalary(), employee.getContact());
    }
    public static boolean update(Employee employee) throws SQLException {
        String sql="UPDATE employee SET name = ?, address = ?, salary = ?, contact = ? WHERE employee_id = ?";
        return CrudUtil.execute(sql, employee.getName(), employee.getAddress(), employee.getSalary() , employee.getContact(), employee.getId());
    }

    public static boolean delete(String employee_id) throws SQLException {
        String sql="DELETE FROM employee WHERE employee_id = ?";
        return CrudUtil.execute(sql, employee_id);
    }
}
