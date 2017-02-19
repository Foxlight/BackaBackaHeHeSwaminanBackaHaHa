/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Foxlight
 */
@Entity
@XmlRootElement
public class Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String prenom;
    private String nom;
    private String info;
    private byte[] photo;
    private String nomUtilisateur;
    private String motDePasse;
    private StatusUtilisateur status;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar derninereConnection;
     @OneToMany(cascade=ALL, mappedBy = "utilisateur")
    public List<Article> article;
    @OneToMany(cascade=ALL, mappedBy = "utilisateur")
    public List<Commentaire> listeCommentaires;
    @ManyToOne
    public Roles role;
    
    
    /**
     * CONSTRUCTEUR
     */
    public Utilisateur() {};
    
    public Utilisateur(String prenom, String nom, String info,
           byte[] photo, String nomUtilisateur, String motDePasse, StatusUtilisateur statusUtilisateur, Roles role) {
        this.prenom = prenom;
        this.nom = nom;
        this.info = info;
        this.nomUtilisateur = nomUtilisateur;
        this.motDePasse = motDePasse;
        this.status = statusUtilisateur;
        this.role = role;
        
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
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Utilisateur[ id=" + id + " ]";
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Calendar getDerninereConnection() {
        return derninereConnection;
    }

    public void setDerninereConnection(Calendar derninereConnection) {
        this.derninereConnection = derninereConnection;
    }

    public StatusUtilisateur getStatus() {
        return status;
    }

    public void setStatus(StatusUtilisateur status) {
        this.status = status;
    }

    @XmlTransient
    public List<Article> getArticle() {
        return article;
    }

    public void setArticle(List<Article> article) {
        this.article = article;
    }

    @XmlTransient
    public List<Commentaire> getListeCommentaires() {
        return listeCommentaires;
    }

    public void setListeCommentaires(List<Commentaire> listeCommentaires) {
        this.listeCommentaires = listeCommentaires;
    }

    public Roles getRoleUtilisateur() {
        return role;
    }

    public void setRoleUtilisateur(Roles role) {
        this.role = role;
    }
    
}
