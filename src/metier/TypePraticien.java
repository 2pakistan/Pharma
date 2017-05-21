package metier;

/**
 *
 * @author sheitan666
 */
public class TypePraticien {
    
    private String code;
    private String libelle;
    private String lieu;

    public TypePraticien(String code, String libelle, String lieu) {
        this.code = code;
        this.libelle = libelle;
        this.lieu = lieu;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }


    
}
