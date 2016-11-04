package dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	private static Connection con = null;
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "PRUEBA";
	private static final String PASS = "1234";

    public static Connection getConnection() {
        if (con == null){
            try {
                Class.forName(DRIVER);
                con = DriverManager.getConnection(URL, USER, PASS);
            } catch (ClassNotFoundException cnfe) {
                System.out.println(cnfe);
            } catch (SQLException sqe) {
                System.out.println(sqe);
            } 
        }
        
        return con;

    }
}