package n7.fr.metier;

import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.function.Predicate;

@Singleton
public class Facade {
	/*added by Ouassel*/
	//private static final Facade facade = new Facade();
	
    @PersistenceContext
    private EntityManager em;
    public final static int totalTypeNumber = 7;
    /* Ajout d'un hashmap pour maper les keytype vers leurs noms*/
    public static final Map<Integer,String> itemsAndType = new HashMap<Integer,String>(){private static final long serialVersionUID = 1L;

	{
    		put(0,"Ordinateur");
    		put(1,"Telephone");
    		put(2,"Tablette");
    		put(3,"Television");
    		put(4,"Calculatrice");
    		put(5,"Camera");
    		put(6,"Imprimante");
    }};
    
    
    public void creerEmprunt(int emprunteurId, List<Integer> MaterielIds, int dureeEmprunt) {
        Emprunt emprunt = new Emprunt();
        emprunt.setEmprunteur(em.find(Utilisateur.class, emprunteurId));
        List<Materiel> materiels = new ArrayList<Materiel>();
        for (int materielId : MaterielIds) {
            Materiel materiel = em.find(Materiel.class, materielId);
            materiel.setDisponible(false);
            materiels.add(materiel);
        }
        emprunt.setMateriel(materiels);
        // calculer la date de retour
        emprunt.setDateEmprunt(new Date());
        emprunt.setDateRetour(new Date(System.currentTimeMillis() + dureeEmprunt * 24 * 60 * 60 * 1000));
        em.persist(emprunt);
    }


    public void supprimerEmprunt(int empruntId) {
        Emprunt emprunt = em.find(Emprunt.class, empruntId);
        // rendre le matériel disponible
        if (emprunt!=null) {
            for (Materiel materiel : emprunt.getMateriels()) {
                materiel.setDisponible(true);
                em.merge(materiel);
            }
            em.remove(emprunt);
        }
    }

    // A utiliser si demande d'extension de l'emprunt
    public void mettreAJourEmprunt(int EmpruntId, int DureeExtension) {
        Emprunt emprunt = em.find(Emprunt.class, EmpruntId);
        if (emprunt!=null) {
            emprunt.setDateRetour(new Date(emprunt.getDateRetour().getTime() + DureeExtension * 24 * 60 * 60 * 1000));
            em.merge(emprunt);
        }
    }

    public Emprunt trouverEmpruntParId(int id) {
        return em.find(Emprunt.class, id);
    }


    public List<Emprunt> trouverTousLesEmprunts() {
        Query query = em.createQuery("SELECT e FROM Emprunt e");
        return query.getResultList();
    }
    /*Changed by Ouassel for handling valid emails (1 good else not good) */
    public int creerUtilisateur(String nom, String prenom, String email, String motDePasse) {
    	if (isMailValid(email)) {
    		Utilisateur utilisateur = new Utilisateur();
    		utilisateur.setNom(nom);
    		utilisateur.setPrenom(prenom);
    		utilisateur.setEmail(email);
    		utilisateur.setMotDePasse(motDePasse);
    		em.persist(utilisateur);
    		return 1;
    	} else {
    		return -1;
    	}
    }

    public void mettreAJourUtilisateur(String nom, String prenom, String email, String motDePasse) {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom(nom);
        utilisateur.setPrenom(prenom);
        utilisateur.setEmail(email);
        utilisateur.setMotDePasse(motDePasse);
        em.merge(utilisateur);
    }

    public void supprimerUtilisateur(int id) {
        Utilisateur utilisateur = em.find(Utilisateur.class, id);
        em.remove(utilisateur);
    }

    public Utilisateur trouverUtilisateurParId(int id) {
        return em.find(Utilisateur.class, id);
    }

    public List<Utilisateur> trouverTousLesUtilisateurs() {
        Query query = em.createQuery("SELECT u FROM Utilisateur u",Utilisateur.class);
        return query.getResultList();
    }

    public void creerMateriel(String nom, String description, int type, float prix, String imagePath, boolean disponible) {
        Materiel materiel = new Materiel();
        materiel.setNom(nom);
        materiel.setDescription(description);
        materiel.setDisponible(disponible);
        materiel.setObjectType(type);
        materiel.setPrix(prix);
        materiel.setImagePath(imagePath);
        em.persist(materiel);
    }

    public void mettreAJourMateriel(int id, String nom, String description, boolean disponible) {
        Materiel materiel = em.find(Materiel.class, id);
        materiel.setNom(nom);
        materiel.setDescription(description);
        materiel.setDisponible(disponible);
        em.merge(materiel);
    }

    public void supprimerMateriel(int id) {
        Materiel materiel = em.find(Materiel.class, id);
        em.remove(materiel);
    }

    public Materiel trouverMaterielParId(int id) {
        return em.find(Materiel.class, id);
    }

    public List<Materiel> trouverTousLesMateriels() {
        Query query = em.createQuery("SELECT m FROM Materiel m");
        return (List<Materiel>)query.getResultList();
    }
    
    public List<Materiel> trouverMaterielParType(int type) {
        Query query = em.createQuery("SELECT m FROM Materiel m WHERE m.objectType = :type");
        query.setParameter("type", type);
        return (List<Materiel>)query.getResultList();
    }


    public List<Materiel> trouverMaterielDisponible() {
        Query query = em.createQuery("SELECT m FROM Materiel m WHERE m.disponible = true");
        return (List<Materiel>)query.getResultList();
    }


    /*Added by Ouassel */
	public boolean checkLoginInfo(String userMail, String password) {
		// TODO Auto-generated method stub
		boolean yesThereIs = false;
		List<Utilisateur> users = em.createQuery("SELECT u FROM Utilisateur u",Utilisateur.class).getResultList();
		for (Utilisateur x : users) {
			String xMail = x.getEmail();
			String xPass = x.getMotDePasse();
			if (xMail.equals(userMail)&&xPass.equals(password)) {
				yesThereIs = true;
				break;
			}
		}
		return yesThereIs;
	}
	
	
	public void ajouterArticlePanier(int UtilisateurId, int materielId) {
        Utilisateur utilisateur = em.find(Utilisateur.class, UtilisateurId);
        Materiel materiel = em.find(Materiel.class, materielId);
        Panier panier = utilisateur.getPanier();
        if (panier==null) {
            panier = new Panier();
            panier.setUtilisateur(utilisateur);
            utilisateur.setPanier(panier);
            panier.setMateriels(new ArrayList<Materiel>());
            em.persist(panier);
        } 
        List<Materiel> materiels = panier.getMateriels();
        materiels.add(materiel);
        panier.setMateriels(materiels);
        // update prix total
        int prixTotal = panier.getPrixTotal();
        prixTotal += materiel.getPrix();
        panier.setPrixTotal(prixTotal);
        em.merge(panier);
        em.merge(utilisateur);
    }

    public void clearPanier(int UtilisateurId) {
        Utilisateur utilisateur = em.find(Utilisateur.class, UtilisateurId);
        Panier panier = utilisateur.getPanier();
        if (panier!=null) {
            panier.setMateriels(new ArrayList<Materiel>());
            em.merge(panier);
        }
    }


	/* Checking the mail validity
	 */
	public static boolean isMailValid(String email) {
		//The mail regex
		String regex = "^(.+)@(.+)$";
		return Pattern.matches(regex,email);
	}
	
	public static List<Materiel> filtrerParType(List<Materiel> matos, int type) {
		Predicate<Materiel> byType = mat -> mat.getObjectType()==type;
		return matos.stream().filter(byType).collect(Collectors.toList()); 
	}
	
	public static List<Materiel> filtrerParPrix(List<Materiel> matos, int maxPrix) {
		// On suppose pour le moment que l'utilisateur est contraint a donner maxPrix
		Predicate<Materiel> byPrix = mat -> mat.getPrix() <= maxPrix;
		return matos.stream().filter(byPrix).collect(Collectors.toList());
	}
	
	//get idUtilisateur à partir de son mail
	public Utilisateur getUserParMail(String userMail) {
		TypedQuery query = em.createQuery("SELECT u FROM Utilisateur u WHERE u.email= :userMail",Utilisateur.class);
		query.setParameter("userMail", userMail);
		List<Utilisateur> users = (List<Utilisateur>)query.getResultList();
		if ( users.size()==0) {
			return null;
		} else {
			return users.get(0);
		}
	}

}

