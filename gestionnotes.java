import java.util.ArrayList;
import java.util.List;

// Classe Etudiant
class Etudiant {
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

// Classe Cours
class Cours {
    private String code_cours;
    private String nom;
    private double coefficient;

    public Cours(String code_cours, String nom, double coefficient) {
        this.code_cours = code_cours;
        this.nom = nom;
        this.coefficient = coefficient;
    }

    public String getCode() { return code_cours; }
    public void setCode(String code_cours) { this.code_cours = code_cours; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public double getCoefficient() { return coefficient; }
    public void setCoefficient(double coefficient) { this.coefficient = coefficient; }
}

// Classe Note
class Note {
    private String code_cours;
    private String id_etd;
    private double note;
    private double coefficient;

    public Note(String code_cours, String id_etd, double note, double coefficient) {
        this.code_cours = code_cours;
        this.id_etd = id_etd;
        this.note = note;
        this.coefficient = coefficient;
    }

    public String getCode() { return code_cours; }
    public void setCode(String code_cours) { this.code_cours = code_cours; }

    public String getIdEtudiant() { return id_etd; }
    public void setIdEtudiant(String id_etd) { this.id_etd = id_etd; }

    public double getNote() { return note; }
    public void setNote(double note) { this.note = note; }

    public double getCoefficient() { return coefficient; }
    public void setCoefficient(double coefficient) { this.coefficient = coefficient; }
}

// Classe Departement
class Departement {
    private String id_dept;
    private String nom;
    private List<Etudiant> etudiants;
    private List<Cours> cours;

    public Departement(String id_dept, String nom) {
        this.id_dept = id_dept;
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
}

// Classe principale
public class gestionnotes {
    public static void main(String[] args) {
        // Initialisation des données
        Departement info = new Departement("INF01", "Informatique");
        
        Cours java = new Cours("JAVA101", "Programmation Java", 1.5);
        Cours db = new Cours("DB201", "Bases de données", 1.0);

        info.addCours(java);
        info.addCours(db);

        Etudiant etudiant1 = new Etudiant("ETD001", "Boussayed", "Ilyes", "1ère année");
        info.addEtudiant(etudiant1);

        enregistrerNote(etudiant1, java, 15, 1.5);
        enregistrerNote(etudiant1, db, 12, 1.0);

        // Calculer la moyenne
        System.out.println("Moyenne de Ilyes Boussayed: " + etudiant1.calculerMoyenne());

        // Recherche des notes par étudiant
        List<Note> notes = info.rechercherNotes("ETD001");
        System.out.println("Notes de Ilyes Boussayed:");
        for (Note note : notes) {
            System.out.println("Cours: " + note.getCode() + ", Note: " + note.getNote());
        }
    }

    public static void enregistrerNote(Etudiant etudiant, Cours cours, double note, double coefficient) {
        Note newNote = new Note(cours.getCode(), etudiant.getId(), note, coefficient);
        etudiant.addNote(newNote);
    }
}
