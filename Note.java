public class Note {
    private int idcours;
    private int idEtudiant;
    private double tp;
    private double controle;
    private double examen;
    private int coeftp;
    private int coefcontrole;
    private int coefexamen;



    Note(int idcours, int idEtudiant, double tp,double controle,double examen,int coeftp,int coefcontrole,int coefexamen) {
        this.idcours = idcours;
        this.idEtudiant = idEtudiant;
        this.tp=tp;
        this.controle=controle;
        
        this.examen=examen;
	    this.coeftp=coeftp;
	    this.coefcontrole=coefcontrole;
	    this.coefexamen=coefexamen;
    }

    public int getCodeCours() { return idcours; }
    public void setCodeCours(int idcours) { this.idcours = idcours; }

    public int getIdEtudiant() { return idEtudiant; }
    public void setIdEtudiant(int idEtudiant) { this.idEtudiant = idEtudiant; }
    public double getTp() {
		return tp;
	}

	public void setTp(double tp) {
		this.tp = tp;
	}

	public double getControle() {
		return controle;
	}

	public void setControle(double controle) {
		this.controle = controle;
	}

	public double getExamen() {
		return examen;
	}

	public void setExamen(double examen) {
		this.examen = examen;
	}
	public float moyenne(){
		return (float) ((tp*coeftp+examen*coefexamen+controle*coefcontrole)/(coeftp+coefexamen+coefcontrole));
	}
}
