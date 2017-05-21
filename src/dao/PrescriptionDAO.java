package dao;


import technique.GestionConnexion;
import metier.Prescription;
import metier.Medoc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author sheitan666
 */
public class PrescriptionDAO {

    private Connection laConnection;

    public PrescriptionDAO( ) {
        this.laConnection = GestionConnexion.getConnexion();
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

    public Connection getLaConnection() {
        return laConnection;
    }

}
