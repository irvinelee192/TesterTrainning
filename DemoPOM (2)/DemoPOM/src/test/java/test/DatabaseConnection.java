package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    public static final String connectionURL = "jdbc:mysql://localhost:3306/world";

    public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {

        DriverManager.registerDriver( new com.mysql.cj.jdbc.Driver());
        Connection con = DriverManager.getConnection(connectionURL,"hbstudent","hbstudent");

        Statement st = con.createStatement();
        String sqlSelect = "Select * from country;";
        String sqlDelete = "DELETE FROM demotable WHERE idDemotable = 1;";
        st.execute(sqlSelect);
        st.execute(sqlDelete);
        Thread.sleep(5000);
        st.close();
        con.close();
    }

}
