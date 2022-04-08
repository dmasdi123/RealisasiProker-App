package realisasiproker;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
//import java.util.logging.Level;
//import java.util.logging.Logger;

public class DatabaseMySQL {
    private static Connection connection = null;
    
    public static Connection getConnection() throws Exception{
        if (connection==null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost/db_realisasiasli","root","");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Database belum terhubung");
                e.printStackTrace();
                return null;
            }
        }
        return connection;
    }
    
    public static boolean isConnect(){
        try {
            if (getConnection()==null){
                return false;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }

    Connection getcoConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
