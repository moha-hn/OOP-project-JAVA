import java.util.List;

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
