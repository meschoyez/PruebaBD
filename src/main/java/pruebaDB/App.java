package pruebaDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/111mil", "meschoyez", "111mil");

            Statement stm = con.createStatement();
            ResultSet rs;

            rs = stm.executeQuery("show tables");

            // stm.executeUpdate(arg0)
        
            while (rs.next()) {
                System.out.println(  );
            }
            con.close();
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }
}
