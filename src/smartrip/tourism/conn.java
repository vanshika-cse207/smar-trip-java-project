
package smartrip.tourism;

import java.sql.*;
public class conn {
    
    
    Connection c;
    Statement s;
    conn() {
    
        try {
           Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/smartriptourism", "root", "Vanshikadgi@19209");
        
           s = c.createStatement();
        
        }catch(Exception e) {
          e.printStackTrace();
        }
    
    
    
    
    }
    
    
    
}

