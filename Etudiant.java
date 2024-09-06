import java.util.ArrayList;
import java.util.List;

public class Etudiant {
    private String id_etd;
    private String nom;
    private String prenom;
    private String niveau;
    private List<Note> notes;

    public Etudiant(String id_etd, String nom, String prenom, String niveau) {
        this.id_etd = id_etd;
        this.nom = nom;
        this.prenom = prenom;
        this.niveau = niveau;
        this.notes = new ArrayList<>();
    }

    public String getId() { return id_etd; }
    public void setId(String id_etd) { this.id_etd = id_etd; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getNiveau() { return niveau; }
    public void setNiveau(String niveau) { this.niveau = niveau; }

    public List<Note> getNotes() { return notes; }
    public void addNote(Note note) { this.notes.add(note); }

    public double calculerMoyenne() {
        double total = 0;
        double sommeCoefficients = 0;

        for (Note note : notes) {
            total += note.getNote() * note.getCoefficient();
            sommeCoefficients += note.getCoefficient();
        }

        return sommeCoefficients == 0 ? 0 : total / sommeCoefficients;
    }
}
