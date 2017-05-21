package dao;


/**
 *
 * @author sheitan666
 */
import technique.GestionConnexion;
import metier.Rapport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import metier.Medoc;
import metier.Prescription;

public class RapportDAO {

    private Connection laConnection;

    public RapportDAO() {
        this.laConnection = GestionConnexion.getConnexion();
    }
    
    public Rapport findRapportById(int idRapp){
        
        String sql = "SELECT * FROM rapport_visite WHERE RAP_NUM=?";

        Connection cnx = this.getLaConnection();
        try {
            PreparedStatement preparedSmth = cnx.prepareStatement(sql);
            preparedSmth.setInt(1, idRapp);

            ResultSet rs = preparedSmth.executeQuery();

            while (rs.next()) {
                String idVis = rs.getString("VIS_MATRICULE");
                int idPrat = rs.getInt("PRA_NUM");
                String dateRapp = rs.getString("RAP_DATE");
                String bilan = rs.getString("RAP_BILAN");
                String motif = rs.getString("RAP_MOTIF");
                int coef = rs.getInt("RAP_COEF");

                Rapport rappFound = new Rapport(idVis, idPrat, dateRapp, bilan, motif,coef);
                return rappFound;
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    public ArrayList<Rapport> findRapportByVisiteur(String unMatricule) {
        Connection cnx = this.getLaConnection();
        String sql = "SELECT * FROM rapport_visite WHERE VIS_MATRICULE = ? ";
        ArrayList<Rapport> listeRapports = new ArrayList<>();

        try {
            PreparedStatement preparedSmth = cnx.prepareStatement(sql);
            preparedSmth.setString(1, unMatricule);
            ResultSet rs = preparedSmth.executeQuery();

            while (rs.next()) {
                String bilan = rs.getString("RAP_BILAN");
                String motif = rs.getString("RAP_MOTIF");
                String date = rs.getString("RAP_DATE");
                int idPrat = rs.getInt("PRA_NUM");
                int idRap = rs.getInt("RAP_NUM");
                int coef = rs.getInt("RAP_COEF");
                String idVis = rs.getString("VIS_MATRICULE");
                Prescription laPrescription  = this.findPrescriptionByRapport(idRap);

                Rapport rappToAdd = new Rapport(idVis, idRap, idPrat, date, bilan, motif, coef , laPrescription);
                listeRapports.add(rappToAdd);
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return listeRapports;
    }

   public void insertPrescription(Prescription laPrescription) {

        Connection cnx = this.getLaConnection();

        String sql = "INSERT INTO offrir(VIS_MATRICULE,MED_DEPOTLEGAL,OFF_QTE,RAP_NUM) VALUES (?,?,?,?)";

        try {
            PreparedStatement preparedSmth = cnx.prepareStatement(sql);

            ArrayList<Medoc> medocsOfferts = laPrescription.getRefMedoc();
            ArrayList<Integer> qteOffertes = laPrescription.getQteMedoc();
            
            String idVisiteur = laPrescription.getIdVisiteur();
            int rapNum        = laPrescription.getRapNum();
            
            for (int i = 0; i < medocsOfferts.size(); i++) {
                int laQtt = Integer.parseInt(qteOffertes.get(i).toString());
                
                preparedSmth.setString(1, idVisiteur);
                preparedSmth.setString(2, medocsOfferts.get(i).getDepotLegal());
                preparedSmth.setInt(3, laQtt);
                preparedSmth.setInt(4, rapNum);

                preparedSmth.execute();
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
     

    public Prescription findPrescriptionByRapport(int rapNum) {
        Connection cnx = this.getLaConnection();
        String sql = "SELECT * FROM offrir WHERE RAP_NUM = ? ";
        
        Prescription laPrescription = new Prescription();
        laPrescription.setRapNum(rapNum);

        try {
            PreparedStatement preparedSmth = cnx.prepareStatement(sql);
            preparedSmth.setInt(1, rapNum);
            ResultSet rs = preparedSmth.executeQuery();

            while (rs.next()) {
                String idVis = rs.getString("VIS_MATRICULE");
                int qte = rs.getInt("OFF_QTE");
                String nomMedoc = rs.getString("MED_DEPOTLEGAL");
                
                MedocDAO medDao = new MedocDAO();
                Medoc leMedoc = medDao.findMedocByName(nomMedoc);
                laPrescription.addMedoc(leMedoc);
                laPrescription.addMedocQte(qte);
                laPrescription.setIdVisiteur(idVis);
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return laPrescription;
    }

    public void insertRapport(Rapport unRapport) {

        Connection cnx = this.getLaConnection();
        
        int lastInserted = this.getLastInserted();
        
        String sqlRap = "INSERT INTO rapport_visite(VIS_MATRICULE,RAP_NUM,PRA_NUM,RAP_DATE,RAP_BILAN,RAP_MOTIF,RAP_COEF) VALUES (?,?,?,?,?,?,?)";


        try {
            PreparedStatement preparedSmth = cnx.prepareStatement(sqlRap);
                
            preparedSmth.setString(1, unRapport.getIdVisiteur());
            preparedSmth.setInt(2, unRapport.getIdRapport());
            preparedSmth.setInt(3, unRapport.getIdPraticien());
            preparedSmth.setString(4, unRapport.getDate());
            preparedSmth.setString(5, unRapport.getBilan());
            preparedSmth.setString(6, unRapport.getMotif());
            preparedSmth.setInt(7, unRapport.getCoef());

            preparedSmth.execute();
            int newInserted = this.getLastInserted();
            if(lastInserted != newInserted){
                System.out.println("insert presc");
                this.insertPrescription(unRapport.getPrescription());
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public int getLastInserted() {
        int result = 0;

        Connection cnx = this.getLaConnection();

        String sql = "SELECT MAX(RAP_NUM) AS idLast FROM rapport_visite";

        try {
            Statement transmission = cnx.createStatement();
            ResultSet rs = transmission.executeQuery(sql);
            
            if(rs.next()){
                 result = rs.getInt("idLast");
            }
            
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return result;
    }

    public Connection getLaConnection() {
        return laConnection;
    }

}
