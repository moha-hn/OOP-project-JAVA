import java.util.ArrayList;
import java.util.List;

public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private int niveau; // New attribute for student level
    private List<Note> notes;

    public Etudiant(int id, String nom, String prenom, int niveau) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.niveau = niveau;
        this.notes = new ArrayList<>();
    }

    // Getters and setters for the new attribute
    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }


    public List<Note> getNotes() { return notes; }
    
    
    public void addNote(Note note) { this.notes.add(note);}
    
    public float calculermoyenne() {
    	float somme=0;
    	for(Note note: notes) {
    		
    		somme+=note.moyenne();
    	}
		return somme/notes.size();
    }
    
    public void displaynoteetd(){
    	System.out.println("cours -- tp --controle -- examen --moyenne"); 
    	for(Note note: notes) {	
    		System.out.println(note.getCodeCours()+" -- "+note.getTp()+" -- "+note.getControle()+ " -- "+note.getExamen()+" -- "+note.moyenne());    	
    	}
    }
  }

