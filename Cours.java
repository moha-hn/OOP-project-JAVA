public class Cours {
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
