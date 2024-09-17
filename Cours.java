import java.util.ArrayList;
import java.util.List;

public class Cours {
    private int id;
    private String nom;
    private List<Etudiant> etudiants;
    public Cours(int id, String nom) {
        this.id = id;
        this.nom = nom;
        this.etudiants = new ArrayList<>();
        
    }
	public int getCode() {
		return id;
	}
	public void setCode(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void addEtudiant(Etudiant etudiant) { 
    	this.etudiants.add(etudiant); 
    }
	public List<Etudiant> getetudiant() { return etudiants; }
	
    
}
