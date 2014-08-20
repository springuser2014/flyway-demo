package nz.co.eroad.demo;


import com.google.inject.Inject;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo {

    private final DataSource dataSource;

    @Inject
    public Demo(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void read() {
        try {
            Connection connection = dataSource.getConnection();
            ResultSet rs = connection.prepareStatement(SELECT_CAR).executeQuery();

            while (rs.next()) {
                StringBuilder builder = new StringBuilder("Found car with id: ")
                                .append(rs.getString("id")).append(" and rego: ").append(rs.getString("rego"));
                System.out.println(builder.toString());
            }

            rs = connection.prepareStatement(SELECT_USER).executeQuery();

            while (rs.next()) {
                StringBuilder builder = new StringBuilder("Found user with id: ")
                                .append(rs.getString("id")).append(" and name: ").append(rs.getString("name"));
                System.out.println(builder.toString());
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error selecting cars...", e);
        }
    }

    private static final String SELECT_CAR = "select * from transport.car;";
    private static final String SELECT_USER = "select * from management.user;";
}
