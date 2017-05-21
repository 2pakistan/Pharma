package metier;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sheitan666
 */
public class Rapport {

    private String idVisiteur;
    private int idRapport;
    private int idPraticien;
    private String date;
    private String bilan;
    private String motif;
    private int coef;
    private Prescription prescription;

    public Rapport(String idVisiteur, int idRapport, int idPraticien, String date, String bilan, String motif, int coef , Prescription prescription) {
        this.idVisiteur = idVisiteur;
        this.idRapport = idRapport;
        this.idPraticien = idPraticien;
        this.date = date;
        this.bilan = bilan;
        this.motif = motif;
        this.coef = coef;
        this.prescription = prescription;

    }

    public Rapport(String idVisiteur,  int idPraticien, String date, String bilan, String motif, int coef) {
        this.idVisiteur = idVisiteur;
        this.idPraticien = idPraticien;
        this.date = date;
        this.bilan = bilan;
        this.motif = motif;
        this.coef = coef;
    }

    public String getIdVisiteur() {
        return idVisiteur;
    }

    public void setIdVisiteur(String idVisiteur) {
        this.idVisiteur = idVisiteur;
    }

    public int getIdRapport() {
        return idRapport;
    }

    public void setIdRapport(int idRapport) {
        this.idRapport = idRapport;
    }

    public int getIdPraticien() {
        return idPraticien;
    }

    public void setIdPraticien(int idPraticien) {
        this.idPraticien = idPraticien;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBilan() {
        return bilan;
    }

    public void setBilan(String bilan) {
        this.bilan = bilan;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public int getCoef() {
        return coef;
    }

    public void setCoef(int coef) {
        this.coef = coef;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

   
    @Override
    public String toString() {
        return "Rapport{" + "idVisiteur=" + idVisiteur + ", idRapport=" + idRapport + ", idPraticien=" + idPraticien + ", date=" + date + ", bilan=" + bilan + ", motif=" + motif + ", coef=" + coef + '}';
    }

    
}
