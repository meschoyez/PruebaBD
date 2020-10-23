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
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/horariosclases",
                "meschoyez",
                "111mil");

            Statement stm = con.createStatement();
            ResultSet rs;

            // rs = stm.executeQuery("show tables");
            // stm.executeUpdate(arg0)

            rs = stm.executeQuery(
                "SELECT * FROM personas");
                // "SELECT * FROM personas WHERE apellido = 'W'");
                // "SELECT id, nombre FROM personas WHERE apellido = 'E'");

            System.out.println("\n--------------\nResultados consulta");

            while (rs.next()) {
                System.out.print(rs.getString("id") + " - ");
                System.out.print(rs.getString("nombre") + " - ");
                System.out.println(rs.getString("apellido"));
            }

            stm.executeUpdate("INSERT INTO personas" +
            //    " SET nombre = 'Ana', apellido = 'R' ");
               " SET nombre = 'Juan', apellido = 'R' ");
            rs = stm.executeQuery("SELECT * FROM personas");

            System.out.println("\n--------------\nNueva consulta");
            while (rs.next()) {
                System.out.print(rs.getString("id") + " - ");
                System.out.print(rs.getString("nombre") + " - ");
                System.out.println(rs.getString("apellido"));
            }


            con.close();
        }
        catch (SQLException e) {
            System.out.println(e);
        }
    }
}
