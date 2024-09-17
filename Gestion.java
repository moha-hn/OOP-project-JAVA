import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.SwingUtilities;

public class Gestion {
	 public static Cours getCoursByid(List<Cours> coursList, int id) {
	        for (Cours cours : coursList) {
	            if (cours.getCode() == id) {
	                return cours;
	            }
	        }
	        return null; // Return null if no object is found with the given ID
	 }
	 public static Departement getdeptByid(List<Departement> deptlist, int id) {
	        for (Departement depts : deptlist) {
	            if (depts.getId() == id) {
	                return depts;
	            }
	        }
	        return null; // Return null if no object is found with the given ID
	  }
	 public static Etudiant getetdByid(List<Etudiant> etdlist, int id) {
	        for (Etudiant etd : etdlist) {
	            if (etd.getId() == id) {
	                return etd;
	            }
	        }
	        return null; // Return null if no object is found with the given ID
	  }
	 public static Etudiant getetdByname(List<Etudiant> etdlist, String nom) {
	        for (Etudiant etd : etdlist) {
	            if (etd.getNom() == nom) {
	                return etd;
	            }
	        }
	        return null; // Return null if no object is found with the given ID
	  }
	 public static boolean noteExists(Etudiant etudiant, int courseId) {
	        for (Note note : etudiant.getNotes()) {
	            if (note.getCodeCours() == courseId) {
	                return true;
	            }
	        }
	        return false;
	    }

	    // Check if the ID is unique for students and courses
	  public static boolean idExists(List<?> list, int id) {
	        if (list.get(0) instanceof Etudiant) {
	            for (Object obj : list) {
	                if (((Etudiant) obj).getId() == id) {
	                    return true;
	                }
	            }
	        } else if (list.get(0) instanceof Cours) {
	            for (Object obj : list) {
	                if (((Cours) obj).getCode() == id) {
	                    return true;
	                }
	            }
	        }
	        return false;
	    }
	  public static void checkIntRange(int value) throws Invalidrangeexception {
	        if (value < 1 || value > 5) {
	            throw new Invalidrangeexception("Le coeff  " + value + " doit etre entre 1 et 5.");
	        }
	    }
	  public static void checkDoubleRange(double value) throws Invalidrangeexception {
	        if (value < 0 || value > 100) {
	            throw new Invalidrangeexception("La note " + value + " doit etre entre 0 et 100.");
	        }
	    }
	public static void main(String[] args) {
		/*creation */
		Etudiant etd1 = new Etudiant(1, "Mendil", "Imad",1);
		Etudiant etd2 = new Etudiant(2, "Hanou", "Mohamed",2);
		Etudiant etd3 = new Etudiant(3, "Abde", "Sam",2);
		Etudiant etd4 = new Etudiant(4, "Bouha", "Fafa",2);
		Etudiant etd5 = new Etudiant(5, "narvalo", "Egliseias",5);


		Cours cr1=new Cours(1,"Base de données");
		Cours cr2=new Cours(2,"Programmation web");
		Cours cr3=new Cours(3,"Algorithmique");
		Cours cr4=new Cours(4,"Mathématiques");
		
		cr1.addEtudiant(etd1);
		cr1.addEtudiant(etd2);
		cr1.addEtudiant(etd5);


		Departement dp1=new Departement(1,"programmation imformatique");
		Departement dp2=new Departement(2,"AUDIOVISUEL ET MULTIMÉDIA");
		Departement dp3=new Departement(3,"Mathémathiques");
		
		/*ajout dans des list*/
		List<Etudiant> etdList = new ArrayList<>();
		etdList.add(etd1);
		etdList.add(etd2);
		etdList.add(etd3);
		etdList.add(etd4);
		etdList.add(etd5);
        
		List<Cours> coursList = new ArrayList<>();
		coursList.add(cr1);
        coursList.add(cr2);
        coursList.add(cr3);
        coursList.add(cr4);
        
        List<Departement> deptlist = new ArrayList<>();
        deptlist.add(dp1);
        deptlist.add(dp2);
        deptlist.add(dp3);
       
		boolean continuer=true;
		int choix;
		Scanner scanner = new Scanner(System.in);
		while(continuer) {
			System.out.println("--------------Systeme de gestion de l'ecole--------------\n ");
			System.out.println("1.Gestion des notes");
			System.out.println("2.Gestion des etudiants");
			System.out.println("3.Gestion des cours\n");
			System.out.println("Entrer votre choix : ");
			choix=scanner.nextInt();
			scanner.nextLine();
			switch(choix) {
			case 1:
				System.out.println("--------------Systeme de gestion de note--------------\n ");
				System.out.println("1.Ajouter les notes d'un cours");
				System.out.println("2.Ajouter note d'un etudiant");
				System.out.println("3.Afficher moyenne d'un etudiant");
				System.out.println("4.Afficher les notes d'un etudiant");
				System.out.println("5.Afficher les notes par cours");
				choix=scanner.nextInt();
				scanner.nextLine();
				switch(choix) {
				  case 1:
					  System.out.println("--------------Ajout par cours--------------\n ");
					  System.out.println("Donner le code du cours");
					  int code = scanner.nextInt();
					  scanner.nextLine();
					  Cours cr = getCoursByid(coursList, code);
					  if (cr != null) {
						  try{
							  System.out.println("--------------"+cr.getNom()+"--------------\n ");
							  System.out.println("Donner le coeff du TP");
							  int coeftp = scanner.nextInt();
							  scanner.nextLine();
							  checkIntRange(coeftp);
							  System.out.println("Donner le coeff du controle");
							  int coefcontrole = scanner.nextInt();
							  scanner.nextLine();
							  checkIntRange(coefcontrole);
							  System.out.println("Donner le coeff de l'examen");
							  int coefexam = scanner.nextInt();
							  scanner.nextLine();
							  checkIntRange(coefexam);
						      for (Etudiant etd : cr.getetudiant()) {  
						          System.out.println("-------- " + etd.getPrenom() + " " + etd.getNom() + " ------------");
						          System.out.println("Donner la note du TP");
						          double tp = scanner.nextDouble();
						          scanner.nextLine();
						          checkDoubleRange(tp);
						          System.out.println("Donner la note du controle");
						          double controle = scanner.nextDouble();
						          scanner.nextLine();
						          checkDoubleRange(controle);
						          System.out.println("Donner la note de l'examen");
						          double exam = scanner.nextDouble();
						          scanner.nextLine();
						          checkDoubleRange(exam);
						          Note nt = new Note(cr.getCode(), etd.getId(), tp, controle, exam, coeftp, coefcontrole, coefexam);
						          etd.addNote(nt); 
						          System.out.println("Note ajoutée avec succès");
						      }
						  }catch (Invalidrangeexception e) {
						            System.out.println(e.getMessage());
					      }
					  } else {
					      System.out.println("Cours avec le code " + code + " non trouvé.");
					  }
					  break;
				  case 2:
					  System.out.println("--------------Ajout par cours pour un etudiant--------------\n ");
					  System.out.println("Donner le code du cours");
					  code = scanner.nextInt();
					  scanner.nextLine();
					  Cours crr = getCoursByid(coursList, code);
					  if (crr != null) {
						  /*ask for the information*/
						  try{
							  System.out.println("--------------"+crr.getNom()+"--------------\n ");
							  System.out.println("Donner le coeff du TP");
							  int coeftp = scanner.nextInt();
							  scanner.nextLine();
							  checkIntRange(coeftp);
							  System.out.println("Donner le coeff du controle");
							  int coefcontrole = scanner.nextInt();
							  scanner.nextLine();
							  checkIntRange(coefcontrole);
							  System.out.println("Donner le coeff de l'examen");
							  int coefexam = scanner.nextInt();
							  scanner.nextLine();
							  checkIntRange(coefexam);
							  System.out.println("Donner le matricule de l'etudiant");
							  int idetd = scanner.nextInt();
							  scanner.nextLine();
							  Etudiant etdd = getetdByid(etdList, idetd);
							  if (etdd != null) {/*check if l'etudiant exists*/
						          System.out.println("-------- " + etdd.getPrenom() + " " + etdd.getNom() + " ------------");
						          System.out.println("Donner la note du TP");
						          double tp = scanner.nextDouble();
						          scanner.nextLine();
						          checkDoubleRange(tp);
						          System.out.println("Donner la note du controle");
						          double controle = scanner.nextDouble();
						          scanner.nextLine();
						          checkDoubleRange(controle);
						          System.out.println("Donner la note de l'examen");
						          double exam = scanner.nextDouble();
						          scanner.nextLine();
						          checkDoubleRange(exam);
						          Note nt = new Note(crr.getCode(), etdd.getId(), tp, controle, exam, coeftp, coefcontrole, coefexam);
						          etdd.addNote(nt); 
						          System.out.println("Note ajoutée avec succès");
						         
						     }else System.out.println("Etudiant avec le matricule "+idetd+ " non trouvé.");
						  }catch (Invalidrangeexception e) {
					            System.out.println(e.getMessage());
				      }
					  } else {
					      // Display a message if the course doesn't exist
					      System.out.println("Cours avec le code " + code + " non trouvé.");
					  }
					  break;
				  case 3:
					  System.out.println("--------------Affichage des moyenne--------------\n ");
					  System.out.println("1.Filtrer par matricule ");
					  System.out.println("2.Filtrer par nom");
					  choix=scanner.nextInt();
					  scanner.nextLine();
					  switch(choix) {
					  case 1:
						  System.out.println("Donner le matricule de l'etudiant");
						  int idetd = scanner.nextInt();
						  scanner.nextLine();
						  Etudiant etd=getetdByid(etdList, idetd);
						  System.out.println("la moyenne de "+etd.getNom()+" "+etd.getPrenom()+" est "+etd.calculermoyenne());
						  break;
					  case 2:
						  System.out.println("Donner le nom de l'etudiant");
						  String nom = scanner.nextLine();
						  scanner.nextLine();
						  etd=getetdByname(etdList, nom);
						  System.out.println("la moyenne de "+etd.getNom()+" "+etd.getPrenom()+" est "+etd.calculermoyenne());
						  break;
					  }
					  break;
				  case 4:
					  System.out.println("Donner le matricule de l'etudiant");
					  int idetd = scanner.nextInt();
					  scanner.nextLine();
					  Etudiant etd=getetdByid(etdList, idetd);
					  etd.displaynoteetd();
					  break;
				  case 5:
					  System.out.println("Donner le code du cours");
					  int idcours = scanner.nextInt();
					  scanner.nextLine();
					  Cours cours=getCoursByid(coursList, idcours);
					  System.out.println("----------"+cours.getNom()+"---------");
					  for(Etudiant etudiant: cours.getetudiant()) {
						  for(Note note: etudiant.getNotes()) {
							  if(note.getCodeCours()==idcours) {
								 System.out.println(etudiant.getNom()+" "+etudiant.getPrenom()+" || "+note.moyenne());  
							  }
					    	}	
				      }
					  break;
				}
				break;
			case 2:
			  System.out.println("--------------Gestion des etudiant--------------\n ");
			  System.out.println("1.Ajouter un étudiant ");
			  System.out.println("2.Supprimer un étudiant");
			  choix=scanner.nextInt();
			  scanner.nextLine();
			  switch(choix) {
			  case 1:
				    System.out.print("Entrez l'ID de l'étudiant: ");
				    int id = scanner.nextInt();
				    scanner.nextLine(); // Consomme la ligne restante
				    System.out.print("Entrez le nom de l'étudiant: ");
				    String nom = scanner.nextLine();
				    System.out.print("Entrez le prénom de l'étudiant: ");
				    String prenom = scanner.nextLine();
				    System.out.print("Entrez le niveau de l'étudiant: ");
				    int niveau = scanner.nextInt();
				    scanner.nextLine();
				    Etudiant etd = new Etudiant(id, nom, prenom, niveau);
				    System.out.println(etd.getNom() + " " + etd.getPrenom() + " a été créé avec succès.");
				    etdList.add(etd);
				    break;
			  case 2:
				  System.out.print("Entrez l'ID de l'étudiant: ");
			      id = scanner.nextInt();
			      scanner.nextLine();
			      etd=getetdByid(etdList, id);
			      if (etd != null) {
			    	  System.out.print(etd.getNom()+" "+etd.getPrenom()+" a  été supprimé avec succés.");
				      etdList.remove(etd);
	                } else {
	                    System.out.println("Etudiant non trouvé.");
	                }
			      break;
			  }
			  break;
			case 3:
				  System.out.println("--------------Gestion des cours--------------\n ");
				  System.out.println("1.Ajouter un cours ");
				  System.out.println("2.Supprimer un cours");
				  System.out.println("3.Inscrire un etudiant a un cours");
				  System.out.println("4.Desinscrire un etudiant a un cours");
				  choix=scanner.nextInt();
				  scanner.nextLine();
				  switch(choix) {
				  case 1:
					    System.out.print("Entrez l'ID du cours: ");
		                int id = scanner.nextInt();
		                scanner.nextLine();
		                System.out.print("Entrez le nom du cours: ");
		                String nom = scanner.nextLine();
		                Cours cours = new Cours(id, nom);
		                System.out.println("Le cours " + cours.getNom() + " a été créé avec succès.");
		                coursList.add(cours);
		                break;
				  case 2:
					    System.out.print("Entrez l'ID du cours: ");
		                id = scanner.nextInt();
		                scanner.nextLine();
		                cours = getCoursByid(coursList, id);
		                if (cours != null) {
		                    System.out.println("Le cours " + cours.getNom() + " a été supprimé avec succès.");
		                    coursList.remove(cours);
		                } else {
		                    System.out.println("Cours non trouvé.");
		                }
		                break;
				  case 3:
					  System.out.print("Entrez l'ID de l'étudiant: ");
				      id = scanner.nextInt();
				      scanner.nextLine();
				      Etudiant etd=getetdByid(etdList, id);
				      System.out.print("Entrez l'ID du cours: ");
		              id = scanner.nextInt();
		              scanner.nextLine();
		              cours = getCoursByid(coursList, id);
		              if (cours != null && etd != null  ) {
		                    System.out.println(etd.getNom()+" "+etd.getPrenom()+" a été inscris au cours " + cours.getNom());
		                    cours.getetudiant().add(etd);
		                } else {
		                    System.out.println("Cours ou etudiant non trouvé.");
		                }
				  case 4:
					  System.out.print("Entrez l'ID de l'étudiant: ");
					  id = scanner.nextInt();
					  scanner.nextLine();
					  etd = getetdByid(etdList, id);
					  System.out.print("Entrez l'ID du cours: ");
					  id = scanner.nextInt();
					  scanner.nextLine();
					  cours = getCoursByid(coursList, id);
					  if (cours != null && etd != null) {
					      if (cours.getetudiant().contains(etd)) {
					    	  System.out.println(etd.getNom()+" "+etd.getPrenom()+" a été supprimé du cours " + cours.getNom());
					          cours.getetudiant().remove(etd);
					      } else {
					          System.out.println(etd.getNom()+" "+etd.getPrenom()+" n'est pas inscrit au cours " + cours.getNom());
					      }
					  } else {
					      System.out.println("Cours ou étudiant non trouvé.");
					  }
					  
				  }
				  break;
				 	
			}
			System.out.println("Voulez vous continuer\n");
			System.out.println("1. continuer 0.quitter");
			choix=scanner.nextInt();		
			if(choix==0) {
				continuer=false;
				System.out.print("Merci d'avoir utiliser notre application");
			}
			
	
				
			}
		scanner.close();
    }
		
}
