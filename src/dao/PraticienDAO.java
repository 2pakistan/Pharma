package dao;



import technique.GestionConnexion;
import metier.Praticien;
import java.sql.*;
import java.util.ArrayList;

public class PraticienDAO {

    private Connection laConnection;

    public PraticienDAO(){
        this.laConnection = GestionConnexion.getConnexion();
    }

  

    public int getIdPraticienByName(String name){
        Connection cnx = this.getLaConnection();

        int idReturn = 0 ;
        String sql = "SELECT PRA_NUM FROM praticien WHERE PRA_NOM = ?";

        try {
            PreparedStatement preparedSmth = cnx.prepareStatement(sql);
            preparedSmth.setString(1, name);

            ResultSet rs = preparedSmth.executeQuery();

            while (rs.next()) {
                int idPraticien = rs.getInt("PRA_NUM");
                idReturn = idPraticien;
            }
        }catch (SQLException e1){
            e1.printStackTrace();
        }
        return idReturn;
    }
    
    public Praticien getPraticienById(int idPrat) throws SQLException{
        Connection cnx = this.getLaConnection();

        String sql = "SELECT PRA_NUM,PRA_NOM,PRA_PRENOM,PRA_CP,PRA_ADRESSE,PRA_VILLE,PRA_COEFNOTORIETE,TYP_LIBELLE,statut "
                    + "FROM praticien, statut,type_praticien "
                    + "WHERE praticien.TYP_CODE = type_praticien.TYP_CODE "
                    + "AND PRA_NUM = ?";

        try {
            PreparedStatement preparedSmth = cnx.prepareStatement(sql);
            preparedSmth.setInt(1, idPrat);

            ResultSet rs = preparedSmth.executeQuery();

            while (rs.next()) {
                int codePostal = rs.getInt("PRA_CP");
                String nom = rs.getString("PRA_NOM");
                String prenom = rs.getString("PRA_PRENOM");
                String adresse = rs.getString("PRA_ADRESSE");
                int id = rs.getInt("PRA_NUM");
                String ville = rs.getString("PRA_VILLE");
                double coef = rs.getDouble("PRA_COEFNOTORIETE");
                int statut = rs.getInt("statut");
                String typeCode = rs.getString("TYP_LIBELLE");


                Praticien praticienFound = new Praticien(nom, prenom, adresse, codePostal,id, ville , coef, statut, typeCode);
                return praticienFound;
            }
        }catch (SQLException e1){
            e1.printStackTrace();
        }
        return null;
    }

    public ArrayList<Praticien> getListePraticiens(){

        Connection cnx = this.getLaConnection();

        String sql = "SELECT PRA_NUM,PRA_NOM,PRA_PRENOM,PRA_CP,PRA_ADRESSE,PRA_VILLE,PRA_COEFNOTORIETE,TYP_LIBELLE,statut "
                    + "FROM praticien,type_praticien "
                    + "WHERE praticien.TYP_CODE = type_praticien.TYP_CODE "
                    + "ORDER BY PRA_NUM ASC";
        
        ArrayList<Praticien> listePraticiens = new ArrayList<>();

        try{
            Statement transmission = cnx.createStatement();
            ResultSet rs = transmission.executeQuery(sql);

            while ( rs.next() ) {
                int codePostal = rs.getInt("PRA_CP");
                String nom = rs.getString("PRA_NOM");
                String prenom = rs.getString("PRA_PRENOM");
                String adresse = rs.getString("PRA_ADRESSE");
                int id = rs.getInt("PRA_NUM");
                String ville = rs.getString("PRA_VILLE");
                double coef = rs.getDouble("PRA_COEFNOTORIETE");
                int statut = rs.getInt("statut");
                String typeCode = rs.getString("TYP_LIBELLE");

                Praticien praticienToAdd = new Praticien(nom, prenom, adresse, codePostal,id, ville , coef, statut, typeCode);
                listePraticiens.add(praticienToAdd);
            }

        }catch(SQLException e1){
            e1.printStackTrace();
        }

        return listePraticiens;
    }
    
      public void insertPraticien(Praticien unPraticien) {

        Connection cnx = this.getLaConnection();

        String sql = "INSERT INTO praticien(PRA_NOM,PRA_PRENOM,PRA_CP,PRA_ADRESSE,PRA_VILLE,PRA_COEFNOTORIETE,TYP_CODE,statut) VALUES (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement preparedSmth = cnx.prepareStatement(sql);

            preparedSmth.setString(1, unPraticien.getNom());
            preparedSmth.setString(2, unPraticien.getPrenom());
            preparedSmth.setInt(3, unPraticien.getCodePostal());
            preparedSmth.setString(4, unPraticien.getAdresse());
            preparedSmth.setString(5, unPraticien.getVille());
            preparedSmth.setDouble(6, unPraticien.getCoefNotoriete());
            preparedSmth.setString(7, unPraticien.getTypeCode());
            preparedSmth.setInt(8, unPraticien.getStatut());

            preparedSmth.execute();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }


    public Connection getLaConnection(){
        return this.laConnection;
    }


}
