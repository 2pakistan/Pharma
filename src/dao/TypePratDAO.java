/**
 *
 * @author sheitan666
 */

package dao;

import technique.GestionConnexion;
import metier.TypePraticien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class TypePratDAO {

    private Connection laConnection;

    public TypePratDAO() {
        this.laConnection = GestionConnexion.getConnexion();
    }

    public ArrayList<TypePraticien> findAllTypes() {

        Connection cnx = this.getLaConnection();

        String sql = "SELECT * FROM type_praticien ";

        ArrayList<TypePraticien> listeTypes = new ArrayList<>();

        try {
            Statement transmission = cnx.createStatement();
            ResultSet rs = transmission.executeQuery(sql);

            while (rs.next()) {
                String codeType = rs.getString("TYP_CODE");
                String nomType = rs.getString("TYP_LIBELLE");
                String lieuType = rs.getString("TYP_LIEU");

                TypePraticien typeToAdd = new TypePraticien(codeType, nomType,lieuType);
                listeTypes.add(typeToAdd);
            }

        } catch (SQLException e1) {
            e1.printStackTrace();
        }

        return listeTypes;
    }
    
    public String findCodeByLibelleType(String unLibelle) {
        Connection cnx = this.getLaConnection();
        String result = "";

        String sql = "SELECT TYP_CODE FROM type_praticien WHERE TYP_LIBELLE = ? ";

        try {

            PreparedStatement preparedSmth = cnx.prepareStatement(sql);
            preparedSmth.setString(1, unLibelle);
            ResultSet rs = preparedSmth.executeQuery();

            while (rs.next()) {
                result = rs.getString("TYP_CODE");
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
