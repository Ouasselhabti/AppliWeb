package n7.fr.metier;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nom;
    private String prenom;
    private String email;
    private String motDePasse;
    
    @OneToOne
    @JoinColumn(name = "panier_id")
    private Panier panier;

    
    @OneToMany
    private List<Emprunt> emprunts;
    
    protected void setPanier(Panier panier) {
    	this.panier = panier;
    }

    public Utilisateur(){}
    
    
    public int getId() {
        return id;
    }
    
    public String getNom() {
        return nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getMotDePasse() {
        return motDePasse;
    }
    
    public List<Emprunt> getEmprunts() {
        return emprunts;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMotDePasse(String mdp) {
        this.motDePasse = mdp;
    }

    public void setEmprunts(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }
    @Override
    public String toString() {
		return "First Name : "+nom+"\n"+"First Name : "+prenom+"\n"+"Mail : "+email+"\n";
    }


	public Panier getPanier() {
		// TODO Auto-generated method stub
		return panier;
	}
}