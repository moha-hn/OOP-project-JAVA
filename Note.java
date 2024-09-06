public class Note {
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
