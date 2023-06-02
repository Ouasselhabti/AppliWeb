package n7.fr.metier;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @OneToOne(mappedBy = "panier")
    private Utilisateur utilisateur;
    
    @OneToMany
    private List<Materiel> materiels;

    private int prixTotal;


    
    public Panier() {
    }
    
    public int getId() {
        return id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public List<Materiel> getMateriels() {
        return materiels;
    }

    public int getPrixTotal() {
        return prixTotal;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setMateriels(List<Materiel> materiels) {
        this.materiels = materiels;
    }

    public void setPrixTotal(int prixTotal) {
        this.prixTotal = prixTotal;
    }
    
}
