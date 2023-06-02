package n7.fr.metier;


import java.util.*;
import javax.persistence.*;

@Entity
public class Materiel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private int objectType; // 0 = ordinateur, 1 = telephone, 2 = tablette, 3 = television, 4 = calculatrice, 5 = appareil photo, 6 = imprimantes, 7 = accessoires;
    private float prix; // en euros, par jour

    private String nom;
    private String description;
    private boolean disponible;
    
    /* Ajoute par moi*/
    private String imagePath;


	@ManyToOne
    private Emprunt emprunt;
	
    
    public Materiel() {}

    public int getId() {
        return id;
    }
    
    public String getNom() {
        return nom;
    }
    
    public String getDescription() {
        return description;
    }
    
    public boolean isDisponible() {
        return disponible;
    }
    
    public Emprunt getEmprunt() {
        return emprunt;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setEmprunt(Emprunt emprunt) {
        this.emprunt = emprunt;
    }

    public void setObjectType(int objectType) {
        this.objectType = objectType;
    }

    public int getObjectType() {
        return objectType;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public float getPrix() {
        return prix;
    }

    public String getImagePath() {
    	return imagePath;
    }
    
    protected void setImagePath(String imagePath) {
    	this.imagePath = imagePath;
    }
}