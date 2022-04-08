 /***********************************************************************
 * Module:  User.java
 * Author:  VINORIOUS
 * Purpose: Defines the Class User
 ***********************************************************************/
package realisasiproker;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import realisasiprokerGUI.Login;
import realisasiprokerGUI.Menu_Prodi;
import realisasiprokerGUI.Menu_Wadek;

/** @pdOid 4b5d36b6-161a-4146-b958-d29c11a0de78 */
public class User {
    
   public static String iduser; 
   /** @pdOid 11760db9-1149-4f92-88eb-3b74ca735b59 */
   private int id_user;
   /** @pdOid 972c3d23-f1bb-4613-91c2-5616f67ff936 */
   private String username;
   /** @pdOid b135dad0-f39c-4f7d-a437-15cb184582b4 */
   private String password;
   
   /** @pdRoleInfo migr=no name=Realisasi assc=association4 coll=java.util.Collection impl=java.util.ArrayList mult=1..* */
  //public java.util.Collection<Realisasi> realisasi;
   /** @pdRoleInfo migr=no name=Jabatan assc=association5 mult=1..1 side=A */
   public Jabatan jabatan;
   
   /** @param 
    * @pdOid afb7a7a8-e318-4e0a-9a83-95ad67ce60ce */
   public void setIdUser(int idUser) {
      // TODO: implement
      this.id_user=idUser;
   }
   
   /** @param username
    * @pdOid a6d06440-64a4-4f06-b85e-888ea7caff1a */
   public void setUsername(String username) {
      // TODO: implement
      this.username=username;
   }
   
   /** @param password
    * @pdOid aec3cb8e-f0c6-4a56-872a-b1becab32bce */
   public void setPassword(String password) {
      // TODO: implement
      this.password=password;
   }
   
   /** @pdOid 11901362-b396-4739-97f1-b6a5c587f7a2 */
   public int getIdUser() {
      // TODO: implement
      return id_user;
   }
   
   /** @pdOid 67acf644-f37f-47ab-94cf-47a90f3ff1b4 */
   public String getUsername() {
      // TODO: implement
      return username;
   }
   
   /** @pdOid 8f9c7d3b-c342-467f-8487-29b0f159a533 */
   public String getPassword() {
      // TODO: implement
      return password;
   }
   
     public static String getID(){
        return iduser;
    
    }
   
    public void loginuser() throws Exception {
        
        User login = new User();
        String query = "select * from user where username=? and password=?";
        PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(query);
        statement.setString(1, getUsername());
        statement.setString(2, getPassword());
        ResultSet rs = statement.executeQuery();

        if (rs.next()) {
            if (rs.getInt("idJabatan") == 1) {
                iduser=rs.getString(1);
                Menu_Wadek menu = new Menu_Wadek();
                menu.setVisible(true);
                JOptionPane.showMessageDialog(null, "Berhasil login sebagai wadek!!!");

            } else if (rs.getInt("idJabatan") == 2) {
                iduser=rs.getString(1);
                Menu_Prodi menu = new Menu_Prodi();
                menu.setVisible(true);
                JOptionPane.showMessageDialog(null, "Berhasil login sebagai prodi !!!");

            }
            else if(rs.getInt("idJabatan") == 3){
                setIdUser(rs.getInt("id_user"));
                //lb_iduser.setText(rs.getString(1));
                JOptionPane.showMessageDialog(null, "Login sebagai admin!");
            }
            

        } else {
            JOptionPane.showMessageDialog(null, "User tidak ditemukan");
            Login log = new Login();
            log.setVisible(true);
        }

        statement.close();
        rs.close();

    }
  
 
   
   
//   /** @pdGenerated default getter */
//   public java.util.Collection<Realisasi> getRealisasi() {
//      if (realisasi == null)
//         realisasi = new java.util.ArrayList<Realisasi>();
//      return realisasi;
//   }
//   
//   /** @pdGenerated default iterator getter */
//   public java.util.Iterator getIteratorRealisasi() {
//      if (realisasi == null)
//         realisasi = new java.util.ArrayList<Realisasi>();
//      return realisasi.iterator();
//   }
//   
//   /** @pdGenerated default setter
//     * @param newRealisasi */
//   public void setRealisasi(java.util.Collection<Realisasi> newRealisasi) {
//      removeAllRealisasi();
//      for (java.util.Iterator iter = newRealisasi.iterator(); iter.hasNext();)
//         addRealisasi((Realisasi)iter.next());
//   }
//   
//   /** @pdGenerated default add
//     * @param newRealisasi */
//   public void addRealisasi(Realisasi newRealisasi) {
//      if (newRealisasi == null)
//         return;
//      if (this.realisasi == null)
//         this.realisasi = new java.util.ArrayList<Realisasi>();
//      if (!this.realisasi.contains(newRealisasi))
//      {
//         this.realisasi.add(newRealisasi);
//         newRealisasi.setUser(this);      
//      }
//   }
//   
//   /** @pdGenerated default remove
//     * @param oldRealisasi */
//   public void removeRealisasi(Realisasi oldRealisasi) {
//      if (oldRealisasi == null)
//         return;
//      if (this.realisasi != null)
//         if (this.realisasi.contains(oldRealisasi))
//         {
//            this.realisasi.remove(oldRealisasi);
//            oldRealisasi.setUser((User)null);
//         }
//   }
//////   
//////   /** @pdGenerated default removeAll */
//   public void removeAllRealisasi() {
//      if (realisasi != null)
//      {
//         Realisasi oldRealisasi;
//         for (java.util.Iterator iter = getIteratorRealisasi(); iter.hasNext();)
//         {
//            oldRealisasi = (Realisasi)iter.next();
//            iter.remove();
//            oldRealisasi.setUser((User)null);
//         }
//      }
//   }

}

