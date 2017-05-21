package metier;



/**
 * Created by sheitan666 on 19/01/2017.
 */
public class Praticien {

    private String nom ;
    private String prenom ;
    private String adresse ;
    private int codePostal ;
    private int id;
    private String ville;
    private double coefNotoriete;
    private int statut;
    private String typeCode;

    public Praticien(String nom, String prenom, String adresse, int codePostal, int id, String ville, double coefNotoriete, int statut, String typeCode) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.id = id;
        this.ville = ville;
        this.coefNotoriete = coefNotoriete;
        this.statut = statut;
        this.typeCode = typeCode;
    }

    public Praticien() {
    }

    public Praticien(String nom, String prenom, String adresse, int codePostal, String ville, double coefNotoriete, int statut, String typeCode) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.coefNotoriete = coefNotoriete;
        this.statut = statut;
        this.typeCode = typeCode;
    }
    
    public Praticien(String nom, String prenom, String adresse, int codePostal, String ville, int statut, String typeCode) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
        this.statut = statut;
        this.typeCode = typeCode;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public double getCoefNotoriete() {
        return coefNotoriete;
    }

    public void setCoefNotoriete(double coefNotoriete) {
        this.coefNotoriete = coefNotoriete;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return prenom + " " + nom;
    }


}
