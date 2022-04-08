/***********************************************************************
 * Module:  Jabatan.java
 * Author:  VINORIOUS
 * Purpose: Defines the Class Jabatan
 ***********************************************************************/
package realisasiproker;
import java.util.*;

/** @pdOid f1c2b09f-1e19-494d-8622-3edd27b4540b */
public class Jabatan {
   /** @pdOid 8c44e1de-9a38-4b52-bb22-783e00cad930 */
   private int idJabatan;
   /** @pdOid be222f69-d619-47cd-9c1d-e059960d739b */
   private String jabatan_dosen;
   /** @pdOid 23ff86e0-0ae1-4dfe-8d4f-1b9d8a56e978 */
   private String masaJabatan;
   /** @pdOid 1a9d2c67-1b9c-4284-93a4-88a8f613c66d */
   private String statusJabatan;
   
   /** @pdRoleInfo migr=no name=Dosen assc=association3 mult=0..1 side=A */
   public Dosen dosen;
   
   /** @param idJabatan
    * @pdOid 63c9784a-a7ca-410e-9f1d-9bb5cfc2e6cc */
   public void setIdJabatan(int idJabatan) {
      // TODO: implement
      this.idJabatan=idJabatan;
   }
   
   /** @param namaJabatan
    * @pdOid 2ce2d8c3-fcf3-476c-978e-f31857d9b7c9 */
   public void setNamaJabatan(String namaJabatan) {
      // TODO: implement
   }
   
   /** @param masaJabatan
    * @pdOid e3024236-6fad-4c41-9f30-6b6c3d05fcf8 */
   public void setMasaJabatan(String masaJabatan) {
      // TODO: implement
   }
   
   /** @param statusJabatan
    * @pdOid 5051089c-8efb-4052-95f1-5cc6d352f60f */
   public void setStatusJabatan(String statusJabatan) {
      // TODO: implement
   }
   
   /** @pdOid 3c6fde46-510e-4c91-a2bb-f0cde92f4768 */
   public int getIdJabatan() {
      // TODO: implement
      return idJabatan;
   }
   
   /** @pdOid 99c9f374-fcd1-4d2d-bfb2-48616b61a882 */
   public String getNamaJabatan() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 4babe0c3-67f5-4eef-93b8-ec967947e428 */
   public String getMasaJabatan() {
      // TODO: implement
      return null;
   }
   
   /** @pdOid 49b9bac2-02a6-473d-a704-8f633b99736c */
   public String getStatusJabatan() {
      // TODO: implement
      return null;
   }

}