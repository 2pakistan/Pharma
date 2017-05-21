package dao;


/**
 *
 * @author sheitan666
 */
import technique.GestionConnexion;
import metier.Medoc;
import metier.FamilleMedoc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class MedocDAO {

    private Connection laConnection;

    public MedocDAO() {
        this.laConnection = GestionConnexion.getConnexion();
    }

    public ArrayList<FamilleMedoc> findAllFamilles() {

        Connection cnx = this.getLaConnection();

        String sql = "SELECT * FROM famille ";

        ArrayList<FamilleMedoc> listeFamilles = new ArrayList<>();

        try {
            Statement transmission = cnx.createStatement();
            ResultSet rs = transmission.executeQuery(sql);

            while (rs.next()) {
                String codeMedoc = rs.getString("FAM_CODE");
                String nomMedoc = rs.getString("FAM_LIBELLE");

                FamilleMedoc familleToAdd = new FamilleMedoc(codeMedoc, nomMedoc);
                listeFamilles.add(familleToAdd);
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return listeFamilles;
    }

    public String findCodeByLibelleFamille(String unLibelle) {
        Connection cnx = this.getLaConnection();
        String result = "";

        String sql = "SELECT FAM_CODE FROM famille WHERE FAM_LIBELLE = ? ";

        try {

            PreparedStatement preparedSmth = cnx.prepareStatement(sql);
            preparedSmth.setString(1, unLibelle);
            ResultSet rs = preparedSmth.executeQuery();

            while (rs.next()) {
                result = rs.getString("FAM_CODE");
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return result;
    }

    public ArrayList<Medoc> findMedocsByFamily(String codeFamilleMedoc) {

        Connection cnx = this.getLaConnection();

        String sql = "SELECT * FROM medicament WHERE FAM_CODE = ? ";

        ArrayList<Medoc> listeMedocs = new ArrayList<>();

        try {
            PreparedStatement preparedSmth = cnx.prepareStatement(sql);
            preparedSmth.setString(1, codeFamilleMedoc);
            ResultSet rs = preparedSmth.executeQuery();

            while (rs.next()) {
                String idMedoc = rs.getString("MED_DEPOTLEGAL");
                String nomMedoc = rs.getString("MED_NOMCOMMERCIAL");
                String codeFamille = rs.getString("FAM_CODE");
                String composition = rs.getString("MED_COMPOSITION");
                String effets = rs.getString("MED_EFFETS");
                String contreIndic = rs.getString("MED_CONTREINDIC");

                Medoc medocToAdd = new Medoc(idMedoc, nomMedoc, codeFamille, composition, effets, contreIndic);
                listeMedocs.add(medocToAdd);
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return listeMedocs;
    }

    public Medoc findMedocByName(String nomMedoc) {

        Connection cnx = this.getLaConnection();
        Medoc medocFound = new Medoc();
        
        String sql = "SELECT * FROM medicament WHERE MED_NOMCOMMERCIAL = ? ";

        try {
            PreparedStatement preparedSmth = cnx.prepareStatement(sql);
            preparedSmth.setString(1, nomMedoc);
            ResultSet rs = preparedSmth.executeQuery();

            while (rs.next()) {
                String idMedoc = rs.getString("MED_DEPOTLEGAL");
                String compo   = rs.getString("MED_COMPOSITION");
                String effets   = rs.getString("MED_EFFETS");
                String contreIndic   = rs.getString("MED_CONTREINDIC");
                String famille = rs.getString("FAM_CODE");
                
                medocFound.setComposition(compo);
                medocFound.setContreindic(contreIndic);
                medocFound.setDepotLegal(idMedoc);
                medocFound.setFamilleCode(famille);
                medocFound.setEffets(effets);
                
            }
            
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        
       return medocFound;
    }
    
    

    public ArrayList<Medoc> findAllMedocs() {

        Connection cnx = this.getLaConnection();

        String sql = "SELECT * FROM medicament";

        ArrayList<Medoc> listeMedocs = new ArrayList<>();

        try {
            Statement transmission = cnx.createStatement();
            ResultSet rs = transmission.executeQuery(sql);

            while (rs.next()) {
                String idMedoc = rs.getString("MED_DEPOTLEGAL");
                String nomMedoc = rs.getString("MED_NOMCOMMERCIAL");
                String codeFamille = rs.getString("FAM_CODE");
                String composition = rs.getString("MED_COMPOSITION");
                String effets = rs.getString("MED_EFFETS");
                String contreIndic = rs.getString("MED_CONTREINDIC");

                Medoc medocToAdd = new Medoc(idMedoc, nomMedoc, codeFamille, composition, effets, contreIndic);
                listeMedocs.add(medocToAdd);
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return listeMedocs;
    }

    public Connection getLaConnection() {
        return laConnection;
    }

}
