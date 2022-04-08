/***********************************************************************
 * Module:  Proker.java
 * Author:  VINORIOUS
 * Purpose: Defines the Class Proker
 ***********************************************************************/
package realisasiproker;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

/** @pdOid 24c049a4-a767-4f24-8135-278e9b6b5ec1 */
public class Proker {
   /** @pdOid 0b514ea3-6157-4b23-9103-a3025e5c5151 */
   private int id_proker;
   /** @pdOid fb31a089-a575-4559-8aa9-a641ab82df1d */
   private String Dosen_penanggung;
   /** @pdOid 7cfd9044-5c79-49fb-84fb-76cc7a6e8d42 */
   private String uraian_proker;
   /** @pdOid a30c8e3c-c87c-4f97-b57e-7d57793aa4e4 */
   private String Status_proker;
   /** @pdOid 3ce4ad0b-4496-4691-b64d-6ab0a74085fa */
   private int anggaran_dana;
   /** @pdOid 045403ed-ad24-4cad-9d79-083258709593 */
   private String tglperencanaan_proker;
   
   /** @pdRoleInfo migr=no name=Realisasi assc=Association_6 mult=1..1 side=A */
   public Realisasi realisasi;
   
   /** @param idProker
    * @pdOid dac42e0b-79b8-4845-8d33-6be6955640e9 */
   public void setIdProker(int idProker) {
      this.id_proker=idProker;
   }
   
   /** @param dosenPenanggung
    * @pdOid 8f8b86ce-a49f-4fba-b357-691430ed727f */
   public void setDosenPenanggung(String dosenPenanggung) {
      this.Dosen_penanggung=dosenPenanggung;
   }
   
   /** @param uraianProker
    * @pdOid 3939ec40-7987-4539-89bd-2520dec6d659 */
   public void setUraianProker(String uraianProker) {
      this.uraian_proker=uraianProker;
   }
   
   /** @param statusProker
    * @pdOid 341d7193-5f2c-4a3d-b7f1-3c84cc541bb7 */
   public void setStatusProker(String statusProker) {
      this.Status_proker=statusProker;
   }
   
   /** @param anggaranDana
    * @pdOid 005698f6-1d9d-4199-85a5-2d2564e2e2f4 */
   public void setAnggaranDana(int anggaranDana) {
      this.anggaran_dana=anggaranDana;
   }
   
   /** @param tglperencanaanProker
    * @pdOid 764868a6-2ad4-4e73-9a36-693b70720930 */
   public void setTglperencanaanProker(String tglperencanaanProker) {
      this.tglperencanaan_proker=tglperencanaanProker;
   }
   
   /** @pdOid 3ea19331-e24f-4121-b0a0-d9052b7369b5 */
   public int getIdProker() {
      // TODO: implement
      return id_proker;
   }
   
   /** @pdOid 593e0a91-5ea9-41a3-aafa-8c8dfd52c6ed */
   public String getDosenPenanggung() {
      // TODO: implement
      return Dosen_penanggung;
   }
   
   /** @pdOid c3e4bf5f-2310-490f-904b-d5f83a53e78c */
   public String getUraianProker() {
      // TODO: implement
      return uraian_proker;
   }
   
   /** @pdOid cf88fff0-2a2e-4ca1-bbee-6b6ad363ca33 */
   public String getStatusProker() {
      // TODO: implement
      return Status_proker;
   }
   
   /** @pdOid 6dd04f41-e712-4f76-b258-8cfae494a075 */
   public int getAnggaranDana() {
      // TODO: implement
      return anggaran_dana;
   }
   
   /** @pdOid 0d80c753-8e2b-4899-b007-52194058d4e5 */
   public String getTglperencanaan() {
      // TODO: implement
      return tglperencanaan_proker;
   }
   
    public ArrayList viewCariProker() throws Exception{
       Proker proker = new Proker();
       ArrayList list = new ArrayList<>();
       String query = "select * from proker where id_proker=? ";
       PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(query);
       statement.setInt(1, getIdProker());
       ResultSet rs = statement.executeQuery();
       while(rs.next()){
           
           proker.setDosenPenanggung(rs.getString("Dosen_penanggung"));
           proker.setUraianProker(rs.getString("uraian_proker"));
           proker.setStatusProker(rs.getString("Status_proker"));
           proker.setAnggaranDana(rs.getInt("anggaran_dana"));
           proker.setAnggaranDana(rs.getInt("anggaran_dana"));
           proker.setTglperencanaanProker(rs.getString("tglperencanaan_proker"));
           list.add(proker);
       }
       
       statement.close();
       rs.close();
       return list;
   }
    
    public ArrayList viewCariProker2() throws Exception{
       Proker proker = new Proker();
       ArrayList list = new ArrayList<>();
       String query = "select * from proker where id_proker=? ";
       PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(query);
       statement.setInt(1, getIdProker());
       ResultSet rs = statement.executeQuery();
       while(rs.next()){
           
           proker.setIdProker(rs.getInt("id_proker"));
           proker.setDosenPenanggung(rs.getString("Dosen_penanggung"));
           proker.setUraianProker(rs.getString("uraian_proker"));
           proker.setStatusProker(rs.getString("Status_proker"));
           proker.setAnggaranDana(rs.getInt("anggaran_dana"));
           proker.setTglperencanaanProker(rs.getString("tglperencanaan_proker"));
           list.add(proker);
       }
       
       statement.close();
       rs.close();
       return list;
   }
    
     public ArrayList viewProker() throws Exception{
       
       ArrayList list = new ArrayList<>();
       String query = "select * from proker";
       PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(query);
       ResultSet rs = statement.executeQuery();
       while(rs.next()){
           Proker proker = new Proker();
           proker.setIdProker(rs.getInt("id_proker"));
           proker.setDosenPenanggung(rs.getString("Dosen_penanggung"));
           proker.setUraianProker(rs.getString("uraian_proker"));
           proker.setStatusProker(rs.getString("Status_proker"));
           proker.setAnggaranDana(rs.getInt("anggaran_dana"));
           proker.setTglperencanaanProker(rs.getString("tglperencanaan_proker"));
           list.add(proker);
       }
       
       statement.close();
       rs.close();
       return list;
   }
     
       public ArrayList viewProkerRejectnProsess() throws Exception{
       
       ArrayList list = new ArrayList<>();
       String query = "select * from proker where Status_proker='Rejected' or Status_proker='On Prosess'";
       PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(query);
       ResultSet rs = statement.executeQuery();
       while(rs.next()){
           Proker proker = new Proker();
           proker.setIdProker(rs.getInt("id_proker"));
           proker.setDosenPenanggung(rs.getString("Dosen_penanggung"));
           proker.setUraianProker(rs.getString("uraian_proker"));
           proker.setStatusProker(rs.getString("Status_proker"));
           proker.setAnggaranDana(rs.getInt("anggaran_dana"));
           proker.setTglperencanaanProker(rs.getString("tglperencanaan_proker"));
           list.add(proker);
       }
       
       statement.close();
       rs.close();
       return list;
   }
     
       public ArrayList viewProkerApprove() throws Exception{
       
       ArrayList list = new ArrayList<>();
       String query = "select * from proker where Status_proker='Approved'";
       PreparedStatement statement = DatabaseMySQL.getConnection().prepareStatement(query);
       ResultSet rs = statement.executeQuery();
       while(rs.next()){
           Proker proker = new Proker();
           proker.setIdProker(rs.getInt("id_proker"));
           proker.setDosenPenanggung(rs.getString("Dosen_penanggung"));
           proker.setUraianProker(rs.getString("uraian_proker"));
           proker.setStatusProker(rs.getString("Status_proker"));
           proker.setAnggaranDana(rs.getInt("anggaran_dana"));
           proker.setTglperencanaanProker(rs.getString("tglperencanaan_proker"));
           list.add(proker);
       }
       
       statement.close();
       rs.close();
       return list;
   }
       
   

   
   

}