/***********************************************************************
 * Module:  Dosen.java
 * Author:  VINORIOUS
 * Purpose: Defines the Class Dosen
 ***********************************************************************/
package realisasiproker;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.*;
import java.sql.Date;
import java.sql.ResultSet;

/** @pdOid 9ad3d658-538d-41c2-a2e8-55f53c336a9e */
public class Dosen extends User {
   /** @pdOid 8691dac8-4243-43d9-a537-20d13a6bc644 */
   private int idDosen;
   /** @pdOid fb973412-6466-4dd7-9f73-02ced0746314 */
   private int NPP;
   /** @pdOid 86111ed5-4e33-4acd-b4d9-2a6fea8a6610 */
   private String nama_dosen;
   /** @pdOid 13b98a1d-666f-4e93-bec0-98e26859548c */
   private String ttl_dosen;
   /** @pdOid 0e5c1df5-130c-4726-b051-1274b2684ec6 */
   private String agama_dosen;
   /** @pdOid 29113cd4-b608-4da3-8a06-9112e3262422 */
   private String jenis_kelamin;
   
   /** @pdRoleInfo migr=no name=Jabatan assc=association3 mult=0..1 */
   public Jabatan jabatan;
   
   /** @param idDosen
    * @pdOid 4ab9a579-45ef-4efc-b3b9-2df5ced0fd21 */
   public void setIdDosen(int idDosen) {
      // TODO: implement
      this.idDosen=idDosen;
   }
   
   /** @param npp
    * @pdOid 10349316-e6f2-48dc-97f6-1ef712414ff4 */
   public void setNpp(double npp) {
      // TODO: implement
      this.NPP=(int) npp;
   }
   
   /** @param namaDosen
    * @pdOid 1215f234-60cd-45ca-99a3-e3d8d903eb55 */
   public void setNamaDosen(String namaDosen) {
      // TODO: implement
      this.nama_dosen=namaDosen;
   }
   
   /** @param ttlDosen
    * @pdOid d4229236-7083-411a-a83a-eeaf9c13d81b */
   public void setTtlDosen(String ttlDosen) {
      // TODO: implement
      this.ttl_dosen=ttlDosen;
   }
   
   /** @param agamaDosen
    * @pdOid 4ce65b67-9afb-4c70-aa2e-62284ce6095e */
   public void setAgamaDosen(String agamaDosen) {
      // TODO: implement
      this.agama_dosen=agamaDosen;
   }
   
   /** @param jenisKelamin
    * @pdOid ccf660c2-aea0-486a-bcf1-04257271c14e */
   public void setJenisKelamin(String jenisKelamin) {
      // TODO: implement
      this.jenis_kelamin=jenisKelamin;
   }
   
   /** @pdOid 314da69a-b285-4dfc-907f-9fb3fef6e775 */
   public int getIdDosen() {
      // TODO: implement
      return idDosen;
   }
   
   /** @pdOid 70eab484-df6b-47c2-a6fa-07a3085a3d3f */
   public double getNpp() {
      // TODO: implement
      return NPP;
   }
   
   /** @pdOid 291a9c61-3ebc-4c30-8044-6db4ee2b41ad */
   public String getNamaDosen() {
      // TODO: implement
      return nama_dosen;
   }
   
   /** @pdOid c5fd4086-7757-4ee1-bddb-9803688b2645 */
   public String getTtlDosen() {
      // TODO: implement
      return ttl_dosen;
   }
   
   /** @pdOid af52f09e-d557-4dbc-9417-4756b7ce926d */
   public String getAgamaDosen() {
      // TODO: implement
      return agama_dosen;
   }
   
   /** @pdOid fe9a7646-d1ab-443f-b6f2-db358d708ad0 */
   public String getJenisKelamin() {
      // TODO: implement
      return jenis_kelamin;
   }
   
     public void inputDosen() throws Exception{
       
       String query = "insert into dosen (idDosen,NPP,nama_dosen,ttl_dosen,agama_dosen,jenis_kelamin) values (?,?,?,?,?,?)";
       PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(query);
       statement.setInt(1, getIdDosen());
       //statement.setInt(2, jbt.getIdJabatan());
       statement.setDouble(2, getNpp());
       statement.setString(3, getNamaDosen());
       statement.setString(4,  getTtlDosen());
       statement.setString(5, getAgamaDosen());
       statement.setString(6, getJenisKelamin());
       statement.execute();
       statement.close();
       
   
   }
     
     public ArrayList viewDosen() throws Exception{
       ArrayList list = new ArrayList<>();
       String query = "select * from dosen";
       PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(query);
       ResultSet rs = statement.executeQuery();
       while(rs.next()){
           Dosen dosen = new Dosen();
           dosen.setIdDosen(rs.getInt("idDosen"));
           dosen.setNpp(rs.getInt("NPP"));
           dosen.setNamaDosen(rs.getString("nama_dosen"));
           dosen.setTtlDosen(rs.getString("ttl_dosen"));
           dosen.setAgamaDosen(rs.getString("agama_dosen"));
           dosen.setJenisKelamin(rs.getString("jenis_kelamin"));
           
          
           list.add(dosen);
//           list.add(proker);
//           list.add(user);
       }
       
       statement.close();
       rs.close();
       return list;
   }
     
     public void hapusdosen() throws Exception {
        String query = "delete from dosen where idDosen=?";
        //String query = "delete from realisasi where id_laporan=? and tglRealisasi=? and anggaran=? and deskripsi_laporan=? and Status=?";
        PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(query);
        statement.setInt(1, getIdDosen());
        statement.executeUpdate();
        statement.close();

    
   }
     
     public void inputUser() throws Exception{
         String query = "insert into user (id_user,username,password) values (?,?,?)";
         PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(query);
         statement.setInt(1, getIdUser());
         //statement.setInt(2, jbt.getIdJabatan());
         statement.setString(2, getUsername());
         statement.setString(3, getPassword());
         statement.execute();
         statement.close();

     }
     
          public void hapususer() throws Exception {
        String query = "delete from user where id_user=?";
        //String query = "delete from realisasi where id_laporan=? and tglRealisasi=? and anggaran=? and deskripsi_laporan=? and Status=?";
        PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(query);
        statement.setInt(1, getIdUser());
        statement.executeUpdate();
        statement.close();

    
   }
     
   
     
//      public void updateDosen() throws Exception {
//        Jabatan jbt= new Jabatan();
//        //String query = "update dosen set id_user='"+txt_kodeuser.getText()+"' ,idJabatan='"+txt_kodejabatan.getText()+"' where idDosen='"+txt_kodedosen.getText()+"' ";
//        String query2 = "update dosen set id_user=? ,idJabatan=? where idDosen=? ";
//        PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(query2);
//        statement.setString(1, String.valueOf(getIdUser()));
//        statement.setString(2, String.valueOf(jbt.getIdJabatan()));
//        statement.setString(3, String.valueOf(getIdDosen()));
//        statement.executeUpdate();
//        statement.close();
//
//    }
     
     

}