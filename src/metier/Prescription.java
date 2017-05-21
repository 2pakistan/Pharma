package metier;


import java.util.ArrayList;

/**
 *
 * @author sheitan666
 */
public class Prescription {

    private String idVisiteur;
    private ArrayList<Integer> qteMedoc;
    private ArrayList<Medoc> refMedoc;
    private int rapNum;

    public Prescription(String idVisiteur, ArrayList<Integer> qteMedoc, ArrayList<Medoc> refMedoc,int rapNum) {
        this.idVisiteur = idVisiteur;
        this.qteMedoc = qteMedoc;
        this.refMedoc = refMedoc;
        this.rapNum = rapNum;
    }
    
    public Prescription(String idVisiteur, ArrayList<Integer> qteMedoc, ArrayList<Medoc> refMedoc) {
        this.idVisiteur = idVisiteur;
        this.qteMedoc = qteMedoc;
        this.refMedoc = refMedoc;
    }
    
    public Prescription(){
        qteMedoc = new ArrayList<>();
        refMedoc = new ArrayList<>();
    }


    public String getIdVisiteur() {
        return idVisiteur;
    }

    public void setIdVisiteur(String idVisiteur) {
        this.idVisiteur = idVisiteur;
    }

    public ArrayList<Integer> getQteMedoc() {
        return qteMedoc;
    }

    public void setQteMedoc(ArrayList<Integer> qteMedoc) {
        this.qteMedoc = qteMedoc;
    }

    public ArrayList<Medoc> getRefMedoc() {
        return refMedoc;
    }

    public void setRefMedoc(ArrayList<Medoc> refMedoc) {
        this.refMedoc = refMedoc;
    }

    public int getRapNum() {
        return rapNum;
    }

    public void setRapNum(int rapNum) {
        this.rapNum = rapNum;
    }
    
    
    public void addMedoc(Medoc unMedoc){
        refMedoc.add(unMedoc);
    }
    
    public void addMedocQte(int unMedocQte){
        qteMedoc.add(unMedocQte);
    }
    
    public boolean isPrescripted(String nameMedSeeked){
        boolean result = false;
        int i = 0;
        
        while( i < refMedoc.size() && result == false ){
            String nomMed = refMedoc.get(i).getNomCommercial();
            
            if (nomMed.equals(nameMedSeeked)){
                result = true;
            }
        }
        
        return result;
    }

    @Override
    public String toString() {
        return "Prescription{" + "idVisiteur=" + idVisiteur + ", qteMedoc=" + qteMedoc + ", refMedoc=" + refMedoc + ", rapNum=" + rapNum + '}';
    }

    
}
