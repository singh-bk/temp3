package com.atlassian.interview;

import java.sql.DriverManager;
import java.sql.SQLException;

public class PoolConnectionImplTest {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        final Connection conn = init();
        System.out.println(conn);
        final PoolConnectionImpl pool = new PoolConnectionImpl(conn);
    }

    public static Connection init() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        final Connection con = (Connection) DriverManager
                                                         .getConnection("jdbc:mysql://127.0.0.1:3306/gstores_api_test",
                                                                        "rails", "rails");
        return con;
    }
}
