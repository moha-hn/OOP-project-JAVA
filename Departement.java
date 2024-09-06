import java.util.ArrayList;
import java.util.List;

public class Departement {
    private String id_dept;
    private String nom;
    private List<Etudiant> etudiants;
    private List<Cours> cours;

    public Departement(String id_dept, String nom) {
        this.setId_dept(id_dept);
        this.nom = nom;
        this.etudiants = new ArrayList<>();
        this.cours = new ArrayList<>();
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public List<Etudiant> getEtudiants() { return etudiants; }
    public void addEtudiant(Etudiant etudiant) { this.etudiants.add(etudiant); }

    public List<Cours> getCours() { return cours; }
    public void addCours(Cours cours) { this.cours.add(cours); }

    public List<Note> rechercherNotes(String etudiantId) {
        for (Etudiant etudiant : etudiants) {
            if (etudiant.getId().equals(etudiantId)) {
                return etudiant.getNotes();
            }
        }
        return new ArrayList<>();
    }

	public String getId_dept() {
		return id_dept;
	}

	public void setId_dept(String id_dept) {
		this.id_dept = id_dept;
	}
}
