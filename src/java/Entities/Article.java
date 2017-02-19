/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Foxlight
 */
@Entity
@XmlRootElement
public class Article implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titre;
    private String motCles;
    private Boolean publierActif;
    // http://stackoverflow.com/questions/35190467/increase-the-size-of-elements-in-a-elementcollection
    @Column(length=10000)
    private String contenu;
    private byte[] photo;
    private float positionLongitude;
    private float positionLatitude;
    private String positionNom;
    private Status status;
    @ManyToOne
    private Utilisateur utilisateur;
    //http://stackoverflow.com/questions/9108224/can-someone-please-explain-mappedby-in-hibernate
    @OneToMany(cascade=ALL, mappedBy = "article")
    private List<Commentaire> commentaire;
    
        
    /**
     * CONSTRUCTEUR
     */
    public Article() {};
    
    public Article(String titre, String motCles, Boolean publierActif, String contenu, byte[] photo,
            float posLon,float posLat,String posNom, Status status, Utilisateur utilisateur ) {
        this.titre = titre;
        this.motCles = motCles;
        this.publierActif = publierActif;
        this.contenu = contenu;
        this.photo = photo;
        this.positionLongitude = posLon;
        this.positionLatitude = posLat;
        this.positionNom = posNom;
        this.status = status;
        this.utilisateur = utilisateur;
    }
    
    /**
     * GETTEUR 
     * SETTEUR
     */
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Article)) {
            return false;
        }
        Article other = (Article) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Article[ id=" + id + " ]";
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getMotCles() {
        return motCles;
    }

    public void setMotCles(String motCles) {
        this.motCles = motCles;
    }

    public Boolean getPublier_actif() {
        return publierActif;
    }

    public void setPublier_actif(Boolean publierActif) {
        this.publierActif = publierActif;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public float getPositionLongitude() {
        return positionLongitude;
    }

    public void setPositionLongitude(float positionLongitude) {
        this.positionLongitude = positionLongitude;
    }

    public float getPositionLatitude() {
        return positionLatitude;
    }

    public void setPositionLatitude(float positionLatitude) {
        this.positionLatitude = positionLatitude;
    }

    public String getPositionNom() {
        return positionNom;
    }

    public void setPositionNom(String positionNom) {
        this.positionNom = positionNom;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @XmlTransient
    public List<Commentaire> getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(List<Commentaire> commentaire) {
        this.commentaire = commentaire;
    }
    
}
