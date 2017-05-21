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
public class Medoc {
    
    private String depotLegal;
    private String nomCommercial;
    private String familleCode;
    private String composition;
    private String effets;
    private String contreindic;

    public Medoc(String depotLegal, String nomCommercial, String familleCode, String composition, String effets, String contreindic) {
        this.depotLegal = depotLegal;
        this.nomCommercial = nomCommercial;
        this.familleCode = familleCode;
        this.composition = composition;
        this.effets = effets;
        this.contreindic = contreindic;
    }

    public Medoc() {
    }
    

    public String getDepotLegal() {
        return depotLegal;
    }

    public void setDepotLegal(String depotLegal) {
        this.depotLegal = depotLegal;
    }

    public String getNomCommercial() {
        return nomCommercial;
    }

    public void setNomCommercial(String nomCommercial) {
        this.nomCommercial = nomCommercial;
    }

    public String getFamilleCode() {
        return familleCode;
    }

    public void setFamilleCode(String familleCode) {
        this.familleCode = familleCode;
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public String getEffets() {
        return effets;
    }

    public void setEffets(String effets) {
        this.effets = effets;
    }

    public String getContreindic() {
        return contreindic;
    }

    public void setContreindic(String contreindic) {
        this.contreindic = contreindic;
    }



    
}
