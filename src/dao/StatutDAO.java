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


public class StatutDAO {

    private Connection laConnection;

    public StatutDAO() {
        this.laConnection = GestionConnexion.getConnexion();
    }

        public String findLibelleStatutByCode(int idStatut) {
        Connection cnx = this.getLaConnection();
        String result = "";

        String sql = "SELECT libelle_statut FROM statut WHERE id_statut = ? ";

        try {

            PreparedStatement preparedSmth = cnx.prepareStatement(sql);
            preparedSmth.setInt(1, idStatut);
            ResultSet rs = preparedSmth.executeQuery();

            while (rs.next()) {
                result = rs.getString("libelle_statut");
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
