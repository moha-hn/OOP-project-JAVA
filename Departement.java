import java.util.ArrayList;
import java.util.List;

public class Departement {
    private int id;
    private String nom;
    private List<Etudiant> etudiants;

    public Departement(int id, String nom) {
        this.id=id;
        this.nom = nom;
        this.etudiants = new ArrayList<>();
    }


    public List<Etudiant> getEtudiants() { return etudiants; }
    
    public void addEtudiant(Etudiant etudiant) { 
    	this.etudiants.add(etudiant); 
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
}
