
package Database;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
   Connection c;
   public Statement s;
    public Conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/university_schema", "root","shuvaranjan2004");

            s = c.createStatement();

        } catch (Exception e) {
           e.printStackTrace();
        }
    }
   
   

  
}
