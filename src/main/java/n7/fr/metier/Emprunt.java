package n7.fr.metier;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Emprunt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    private Utilisateur emprunteur;
    
    @OneToMany
    private List<Materiel> materiels;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateEmprunt;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRetour;
    
    
    private int prixTotal;
    
    public Emprunt() {}
    
    public int getId() {
        return id;
    }
    
    public List<Materiel> getMateriels() {
        return materiels;
    }
    
    public Utilisateur getEmprunteur() {
        return emprunteur;
    }
    
    public Date getDateEmprunt() {
        return dateEmprunt;
    }
    
    public Date getDateRetour() {
        return dateRetour;
    }
    
    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public void setMateriel(List<Materiel> materiels) {
        this.materiels = materiels;
    }

    public void setEmprunteur(Utilisateur emprunteur) {
        this.emprunteur = emprunteur;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }
    
    public int getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(int prixTotal) {
        this.prixTotal = prixTotal;
    }


}