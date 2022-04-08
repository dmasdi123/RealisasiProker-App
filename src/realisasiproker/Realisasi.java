/***********************************************************************
 * Module:  Realisasi.java
 * Author:  VINORIOUS
 * Purpose: Defines the Class Realisasi
 ***********************************************************************/
package realisasiproker;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import realisasiproker.Proker;

/** @pdOid e21f960c-fa8a-496d-89cf-de737f0e0d3d */
public class Realisasi {
   /** @pdOid 8ddd98db-fae0-461f-b85d-d3b1bc8ccfa2 */
   private int id_laporan;
   private int id_user;
   private int id_proker;
   /** @pdOid 2d195379-c093-43bc-9873-f0e5aeea4c0a */
   private String tglRealisasi;
   /** @pdOid fc7ac7a2-763d-4270-9e24-d81151b86011 */
   private Double anggaran;
   /** @pdOid c2dcf29e-1d4f-4968-8a55-6c04f5313a17 */
   private String deskripsi_laporan;
   private String status;
   
   /** @pdRoleInfo migr=no name=Proker assc=Association_6 mult=1..1 */
   public Proker proker;
   /** @pdRoleInfo migr=no name=User assc=association4 mult=1..1 side=A */
   public User user;
   
   /** @param idLaporan
    * @pdOid 7c36b7ac-a630-4596-85ad-65b88fc14d59 */
   public void setIdLaporan(int idLaporan) {
      // TODO: implement
      this.id_laporan=idLaporan;
   }
   
   /** @param tglRealisasi
    * @pdOid eea1f07d-6f68-4819-816e-2fcc8cb89f39 */
   public void setTglRealisasi(String tglRealisasi) {
      this.tglRealisasi=tglRealisasi;
   }
   
   /** @param anggaran
    * @pdOid 8a2d1a4a-657f-427b-b612-35fd565b006f */
   public void setAnggaran(Double anggaran) {
      this.anggaran=anggaran;
   }
   
   /** @param deskripsiLaporan
    * @pdOid 686294fd-4928-4872-86c1-70411334f454 */
   public void setDeskripsiLaporan(String deskripsiLaporan) {
      this.deskripsi_laporan=deskripsiLaporan;
   }
   
    public void setIdDariUser(int iduser) {
      // TODO: implement
      this.id_user=iduser;
   }
    
    public void setIdDariProker(int idproker) {
      // TODO: implement
      this.id_proker=idproker;
   }
    
     public void setStatus(String statusreal) {
      // TODO: implement
      this.status=statusreal;
   }
    
   
   /** @pdOid e7fa2c6c-e303-48c8-896f-64709cc7f4a1 */
   public int getIdLaporan() {
      // TODO: implement
      return id_laporan;
   }
    public int getIdDariUser() {
      // TODO: implement
      return id_user;
   }
     public int getIdDariProker() {
      // TODO: implement
      return id_proker;
   }
   
   /** @pdOid f8c5c73d-6234-421c-b7eb-8f7560c5a4f1 */
   public String getTglRealisasi() {
      // TODO: implement
      return tglRealisasi;
   }
   
   /** @pdOid 0715504c-216e-4ee3-89af-6d9708496f44 */
   public Double getAnggaran() {
      // TODO: implement
      return anggaran;
   }
   
   /** @pdOid 63674b4a-7e53-4e42-86f6-67656b9f5104 */
   public String getDeskripsi() {
      // TODO: implement
      return deskripsi_laporan;
   }
   
   public String getStatus() {
      // TODO: implement
      return status;
   }
   
   
   
   /** @pdGenerated default parent getter */
   
   public User getUser() {
      return user;
   }
   public Proker getProker() {
      return proker;
   }
   
    public ArrayList viewCari() throws Exception{
       Realisasi real = new Realisasi();
       ArrayList list = new ArrayList<>();
       String query = "select * from realisasi where id_laporan=? ";
       PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(query);
       statement.setInt(1, getIdLaporan());
       ResultSet rs = statement.executeQuery();
       while(rs.next()){
           
           real.setIdLaporan(rs.getInt("id_laporan"));
           real.setIdDariUser(rs.getInt("id_user"));
           real.setIdDariProker(rs.getInt("id_proker"));
           real.setTglRealisasi(rs.getString("tglRealisasi"));
           real.setAnggaran(rs.getDouble("anggaran"));
           real.setDeskripsiLaporan(rs.getString("deskripsi_laporan"));
           real.setStatus(rs.getString("Status"));
           list.add(real);
       }
       
       statement.close();
       rs.close();
       return list;
   }
    
    public ArrayList viewSaja() throws Exception{
       ArrayList list = new ArrayList<>();
       String query = "select * from realisasi";
       PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(query);
       ResultSet rs = statement.executeQuery();
       while(rs.next()){
           Realisasi realisasi = new Realisasi();
           realisasi.setIdLaporan(rs.getInt("id_laporan"));
           realisasi.setIdDariUser(rs.getInt("id_user"));
           realisasi.setIdDariProker(rs.getInt("id_proker"));
           realisasi.setTglRealisasi(rs.getString("tglRealisasi"));
           realisasi.setAnggaran(rs.getDouble("anggaran"));
           realisasi.setDeskripsiLaporan(rs.getString("deskripsi_laporan"));
           realisasi.setStatus(rs.getString("Status"));
           list.add(realisasi);
//           list.add(proker);
//           list.add(user);
       }
       
       statement.close();
       rs.close();
       return list;
   }
    
     
    
    
     public void insertDb() throws Exception{
       String query = "insert into realisasi (id_laporan, tglRealisasi, anggaran, deskripsi_laporan,Status) values (?,?,?,?,?)";
       PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(query);
       statement.setInt(1, getIdLaporan());
       statement.setString(2, getTglRealisasi());
       statement.setDouble(3, getAnggaran());
       statement.setString(4, getDeskripsi());
       statement.setString(5, getStatus());
       statement.execute();
       statement.close();
 
       
   }
    public void hapusRealisasi() throws Exception {
        String query = "delete from realisasi where id_laporan=?";
        //String query = "delete from realisasi where id_laporan=? and tglRealisasi=? and anggaran=? and deskripsi_laporan=? and Status=?";
        PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(query);
        statement.setInt(1, getIdLaporan());
//        statement.setString(2, getTglRealisasi());
//        statement.setDouble(3, getAnggaran());
//        statement.setString(4, getDeskripsi());
//        statement.setString(5, getStatus());
        statement.executeUpdate();
        statement.close();

    
   }
    
    public ArrayList viewAllRealisasi() throws Exception{
       ArrayList list = new ArrayList<>();
       String query = "select * from realisasi";
       PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(query);
       ResultSet rs = statement.executeQuery();
       while(rs.next()){
           Realisasi real = new Realisasi();
           real.setIdLaporan(rs.getInt("id_laporan"));
           real.setTglRealisasi(rs.getString("tglRealisasi"));
           real.setAnggaran(rs.getDouble("anggaran"));
           real.setDeskripsiLaporan(rs.getString("deskripsi_laporan"));
           
           list.add(real);
       }
       
       statement.close();
       rs.close();
       return list;
   } 
   
   
   /** @pdGenerated default parent setter
     * @param newUser */
//   public void setUser(User newUser) {
//      if (this.user == null || !this.user.equals(newUser))
//      {
//         if (this.user != null)
//         {
//            User oldUser = this.user;
//            this.user = null;
//            oldUser.removeRealisasi(this);
//         }
//         if (newUser != null)
//         {
//            this.user = newUser;
//            this.user.addRealisasi(this);
//         }
//      }
//   }

}