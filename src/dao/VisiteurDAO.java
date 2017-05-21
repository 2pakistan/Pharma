package dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sheitan666
 */
import technique.GestionConnexion;
import metier.Visiteur;
import java.sql.*;
import java.util.ArrayList;
import technique.BCrypt;

public class VisiteurDAO {

    private Connection laConnection;

    public VisiteurDAO() {
        this.laConnection = GestionConnexion.getConnexion();
    }

    public ArrayList<Visiteur> getListeVisiteurs() {

        Connection cnx = this.getLaConnection();

        String sql = "SELECT id_visiteur, VIS_NOM ,VIS_PRENOM, VIS_ADRESSE ,VIS_CP ,VIS_VILLE,VIS_DATEEMBAUCHE FROM visiteur";

        ArrayList<Visiteur> listeVisiteurs = new ArrayList<>();

        try {
            Statement transmission = cnx.createStatement();
            ResultSet rs = transmission.executeQuery(sql);

            while (rs.next()) {
                int codePostal = rs.getInt("VIS_CP");
                String nom = rs.getString("VIS_NOM");
                String prenom = rs.getString("VIS_PRENOM");
                String adresse = rs.getString("VIS_ADRESSE");
                String id = rs.getString("id_visiteur");
                String ville = rs.getString("VIS_VILLE");
                String dateHired = rs.getString("VIS_DATEEMBAUCHE");

                Visiteur visiteurToAdd = new Visiteur(id, nom, prenom, adresse, codePostal, ville, dateHired);
                listeVisiteurs.add(visiteurToAdd);
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return listeVisiteurs;
    }

    public Visiteur getVisiteurById(String matriculeVisiteur) throws SQLException {
        Connection cnx = this.getLaConnection();

        String sql = "SELECT id_visiteur, VIS_NOM ,VIS_PRENOM, VIS_ADRESSE ,VIS_CP ,VIS_VILLE,VIS_DATEEMBAUCHE FROM visiteur WHERE id_visiteur=?";

        try {
            PreparedStatement preparedSmth = cnx.prepareStatement(sql);
            preparedSmth.setString(1, matriculeVisiteur);

            ResultSet rs = preparedSmth.executeQuery();

            while (rs.next()) {
                int codePostal = rs.getInt("VIS_CP");
                String nom = rs.getString("VIS_NOM");
                String prenom = rs.getString("VIS_PRENOM");
                String adresse = rs.getString("VIS_ADRESSE");
                String id = rs.getString("id_visiteur");
                String ville = rs.getString("VIS_VILLE");
                String dateHired = rs.getString("VIS_DATEEMBAUCHE");

                Visiteur visiteurFound = new Visiteur(id, nom, prenom, adresse, codePostal, ville, dateHired);
                return visiteurFound;
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return null;
    }
    
     public String getIdVisiteurByName(String name){
        Connection cnx = this.getLaConnection();

        String matricule = "" ;
        String sql = "SELECT id_visiteur FROM visiteur WHERE VIS_NOM = ?";

        try {
            PreparedStatement preparedSmth = cnx.prepareStatement(sql);
            preparedSmth.setString(1, name);

            ResultSet rs = preparedSmth.executeQuery();

            while (rs.next()) {
                String matriculeFound = rs.getString("id_visiteur");
                matricule = matriculeFound;
            }
        }catch (SQLException e1){
            e1.printStackTrace();
        }
        return matricule;
    }

    public boolean checkLogs(String nomUser, String passUser)  {
        
        boolean result = false;
        Connection cnx = this.getLaConnection();
        String sqlId = "SELECT VIS_PASS FROM visiteur WHERE VIS_NOM = ?";

        try{
            PreparedStatement preparedSmth = cnx.prepareStatement(sqlId);
            preparedSmth.setString(1, nomUser);

            ResultSet rs = preparedSmth.executeQuery();

            //Si utilisateur avec ce nom , on recupere le MDP et on verifie qu'il correspond
            if (rs.next()) {
                String pwd = rs.getString("VIS_PASS");
                
                //Utilisation de la methode checkPw de la classe Bcrypt. Compare une String avec son equivalent encrypté et renvoie true si correspondance
                boolean matched = BCrypt.checkpw(passUser, pwd);
                if (matched){
                    result = true;
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
            
        return result;
    }
    
        public void fillLogs()  {
        Connection cnx = this.getLaConnection();
        String sqlId = "SELECT VIS_PASS,id_visiteur FROM visiteur";
        ArrayList<String> listePwd = new ArrayList<>();
        ArrayList<String> listeId = new ArrayList<>();

        try{
            PreparedStatement preparedSmth = cnx.prepareStatement(sqlId);
            ResultSet rs = preparedSmth.executeQuery();

            //Si utilisateur avec ce nom , on recupere le MDP et on verifie qu'il correspond
            while (rs.next()) {
                Date pwdDate = rs.getDate("VIS_PASS");
                String pwd = pwdDate.toString();
                String pwdHashed = BCrypt.hashpw(pwd , BCrypt.gensalt());

                String id  = rs.getString("id_visiteur");
                
                listePwd.add(pwdHashed);
                listeId.add(id);
            }
            int nbPwd = listePwd.size();
            
             System.out.println(listePwd);
             
            for(int i =0 ; i < nbPwd ; i++  ){
                String sqlInsert = "UPDATE visiteur SET VIS_PASS = ? WHERE id_visiteur = ?";
                PreparedStatement preparedInsert = cnx.prepareStatement(sqlInsert);
                preparedInsert.setString(1, listePwd.get(i));
                preparedInsert.setString(2, listeId.get(i));
                preparedInsert.execute();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
        
    public void fillDefaultLogs()  {
        Connection cnx = this.getLaConnection();
        String sqlId = "SELECT id_visiteur,VIS_DATEEMBAUCHE FROM visiteur";
        ArrayList<Date> listePwd = new ArrayList<>();
        ArrayList<String> listeId = new ArrayList<>();

        try{
            PreparedStatement preparedSmth = cnx.prepareStatement(sqlId);
            ResultSet rs = preparedSmth.executeQuery();

            //Si utilisateur avec ce nom , on recupere le MDP et on verifie qu'il correspond
            while (rs.next()) {
                Date pwd =  rs.getDate("VIS_DATEEMBAUCHE");
                String id  = rs.getString("id_visiteur");
                
                listePwd.add(pwd);
                listeId.add(id);
            }
            int nbPwd = listePwd.size();
            
             System.out.println(listePwd);
             
            for(int i =0 ; i < nbPwd ; i++  ){
                String sqlInsert = "UPDATE visiteur SET VIS_PASS = ? WHERE id_visiteur = ?";
                PreparedStatement preparedInsert = cnx.prepareStatement(sqlInsert);
                preparedInsert.setDate(1, listePwd.get(i));
                preparedInsert.setString(2, listeId.get(i));
                preparedInsert.execute();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getLaConnection() {
        return laConnection;
    }

}
