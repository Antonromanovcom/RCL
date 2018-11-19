package com.antonromanov.springhibernate.DAO;

import com.antonromanov.springhibernate.model.User;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private DataSource dataSource;
    private static final String TEST_SQL = "select * from dual";

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<User> getPersonList() {
        List<User> result = new ArrayList<User>();
        Connection conn = null;

        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(TEST_SQL);

            User customer = null;
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                customer = new User(rs.getString(1));
                result.add(customer);
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }

return result;

}
}
