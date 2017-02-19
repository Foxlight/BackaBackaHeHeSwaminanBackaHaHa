/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import javax.ejb.Singleton;
import javax.ejb.Startup;
import Entities.Article;
import Entities.Commentaire;
import Entities.Roles;
import Entities.Status;
import Entities.StatusUtilisateur;
import Entities.Utilisateur;
import java.util.Calendar;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import service.ArticleFacadeREST;
import service.CommentaireFacadeREST;
import service.RolesFacadeREST;
import service.UtilisateurFacadeREST;

/**
 *
 * @author Foxlight
 */
@Singleton
@Startup
public class Remplissage {
    @EJB
    private CommentaireFacadeREST facadeCommentaire;
    @EJB
    private UtilisateurFacadeREST facadeUtilisateur;
    @EJB
    private ArticleFacadeREST facadeArticle;
    @EJB
    private RolesFacadeREST facadeRoles;
    
    
    @PostConstruct
    public void remplirBaseAvecDonneesDeTest() {
        Roles admin = new Roles("Administrateur","Administrateur");
        Roles peon = new Roles("Membre","Membre");
        
        facadeRoles.create(admin);
        facadeRoles.create(peon);
        
        byte[] photo = null; 
        
        
        Utilisateur admin1 = new Utilisateur("Lorep","Ipsum","dolor sir amet",photo,"gravida","Nam",StatusUtilisateur.ACTIF,admin);
        Utilisateur admin2 = new Utilisateur("Phasellus1","a","a",photo,"ligula","rutrum",StatusUtilisateur.ACTIF,admin);
        Utilisateur admin3 = new Utilisateur("Phasellus2","a","a",photo,"ligula","rutrum",StatusUtilisateur.ACTIF,admin);
        Utilisateur admin4 = new Utilisateur("Phasellus3","a","a",photo,"ligula","rutrum",StatusUtilisateur.ACTIF,admin);
        Utilisateur admin5 = new Utilisateur("Phasellus","a","a",photo,"ligula","rutrum",StatusUtilisateur.ACTIF,admin);
        
        
        Utilisateur lambda1 = new Utilisateur("lambda1","a","a",photo,"ligula","rutrum",StatusUtilisateur.ACTIF,peon);
        Utilisateur lambda2 = new Utilisateur("lambda2","a","a",photo,"ligula","rutrum",StatusUtilisateur.ACTIF,peon);
        Utilisateur lambda3 = new Utilisateur("lambda3","a","a",photo,"ligula","rutrum",StatusUtilisateur.ACTIF,peon);
        Utilisateur lambda4 = new Utilisateur("lambda4","a","a",photo,"ligula","rutrum",StatusUtilisateur.ACTIF,peon);
        Utilisateur lambda5 = new Utilisateur("lambda5","a","a",photo,"ligula","rutrum",StatusUtilisateur.ACTIF,peon);
        
        facadeUtilisateur.create(admin1);
        facadeUtilisateur.create(admin2);
        facadeUtilisateur.create(admin3);
        facadeUtilisateur.create(admin4);
        facadeUtilisateur.create(admin5);
        
        facadeUtilisateur.create(lambda1);
        facadeUtilisateur.create(lambda2);
        facadeUtilisateur.create(lambda3);
        facadeUtilisateur.create(lambda4);
        facadeUtilisateur.create(lambda5);
        
        
        String contenu1 ="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam vitae gravida orci, non euismod ipsum. Donec tristique scelerisque mi id elementum. Curabitur pellentesque sapien ac efficitur dapibus. Vestibulum ut mauris justo. Quisque viverra orci eros, non tincidunt sem pellentesque vel. Sed faucibus metus dui, eget scelerisque dui aliquam sit amet. Fusce consectetur metus tortor, vel sollicitudin tortor sodales eget. Suspendisse tristique fermentum ornare. Quisque a porttitor ante. Fusce nec mi est.";
        String contenu2 ="Phasellus a ante vel ligula vehicula rutrum nec eu purus. Praesent suscipit ante vel risus dictum condimentum. Integer vel metus malesuada justo rhoncus accumsan. Donec sodales neque ultricies viverra elementum. Nulla non urna velit. Nulla non justo eu eros dapibus interdum. Nam non quam non lacus varius porttitor vestibulum sit amet velit. Nullam vestibulum urna consectetur sem pretium, fringilla lobortis eros posuere. Mauris tristique erat neque, sit amet accumsan nulla posuere ut. Aenean libero nisl, auctor a justo et, pulvinar varius justo. Sed dapibus felis maximus, malesuada leo vitae, mattis urna. Nam in lacinia quam, quis suscipit risus. Nunc eget erat est. Cras fermentum, magna vitae elementum vulputate, erat ligula vestibulum metus, eu ornare orci dui et purus.";
        String contenu3 ="Vivamus venenatis dolor id ullamcorper ornare. Duis tincidunt malesuada nulla sit amet euismod. Aliquam erat volutpat. Sed interdum eu lacus ullamcorper sagittis. Sed dignissim tortor ac elit ultrices, eget ultrices sem fringilla. Morbi venenatis nisl ac risus convallis rutrum. Praesent eget est nec lacus facilisis sollicitudin. Sed facilisis quam sit amet fermentum bibendum. Quisque vel convallis libero. Aliquam venenatis, nisl tempus ullamcorper iaculis, ligula odio commodo ligula, eu bibendum orci diam at neque. Nunc efficitur elit in ante tempus volutpat.";
        String contenu4 ="Maecenas viverra felis risus, non imperdiet urna dapibus sed. Donec in accumsan ligula. Mauris consequat elementum tortor eu venenatis. Nulla at varius lacus. Nulla ac condimentum ligula, a ultricies lectus. Morbi et felis vulputate, pellentesque dui non, eleifend nunc. In faucibus, purus quis tempus pharetra, justo neque feugiat sem, a congue velit massa quis massa.";
        String contenu5 ="Etiam mi eros, aliquam sit amet maximus vitae, tristique et augue. Donec vestibulum dignissim quam non rutrum. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Ut ultricies ipsum ex, id euismod lorem volutpat sit amet. Praesent leo ligula, luctus sed dictum et, semper quis purus. Quisque a vestibulum ex, vitae sagittis est. Pellentesque nisi eros, aliquet ultrices nulla vel, volutpat venenatis ante.";
        
        float lat1 = 47.4299208f;float longi1 = 2.738950799999998f;
        float lat2 = 36.53226490000001f;float longi2 = -116.93254079999997f;
        float lat3 = 32.77903f;float longi3 = -96.80867f;
        float lat4 = 34.3965603f;float longi4 = 132.45962250000002f;
        float lat5 = 40.711667f;float longi5 = -74.0125f;
        
        String titre1 = "Plein de fun a miage !";
        String titre2 = "Oasis de bonheur";
        String titre3 = "Des idées plein la tête";
        String titre4 = "Déborder d'énergie ! ";
        String titre5 = "Fly trip en amoureux <3";
        
        String posNom1 ="Nice";
        String posNom2 ="Roubais";
        String posNom3 ="Tourcoin";
        String posNom4 ="Paris";
        String posNom5 ="Lille";
        
        String motCle1 ="banane";
        String motCle2 ="jambon";
        String motCle3 ="saucisse";
        String motCle4 ="FEED THE DEV !";
        String motCle5 ="Autriche";
        
        Article article1 = new Article(titre1, motCle1,true, contenu1,photo,lat1,longi1,posNom1,Status.PUBLIER,admin1);
        Article article2 = new Article(titre2, motCle2,true, contenu2,photo,lat1,longi2,posNom2,Status.PUBLIER,admin2);
        Article article3 = new Article(titre3, motCle3,true, contenu3,photo,lat1,longi3,posNom3,Status.PUBLIER,admin3);
        Article article4 = new Article(titre4, motCle4,true, contenu4,photo,lat1,longi4,posNom4,Status.PUBLIER,admin4);
        Article article5 = new Article(titre5, motCle5,true, contenu5,photo,lat1,longi5,posNom5,Status.PUBLIER,admin5);
 
        facadeArticle.create(article1);
        facadeArticle.create(article2);
        facadeArticle.create(article3);
        facadeArticle.create(article4);
        facadeArticle.create(article5);
        
        System.err.println("JE SUIS UNE LICORNE? OUIIIIIIIIIIIIIIIIIIIIII");
        
        String textCom1 = "Praesent fermentum justo ac arcu rutrum bibendum. Ut id ipsum a nibh laoreet faucibus eget nec purus. Cras consequat, velit id fermentum porttitor, ante lorem semper ante, at malesuada lectus justo nec lectus. Etiam aliquet ultrices sollicitudin. Donec id nunc cursus, elementum nulla sit amet, vehicula lacus. Phasellus ac tellus consequat, porttitor nibh non, venenatis nisl. Nulla nec nisi sit amet nisi dapibus pharetra semper at nisi. Aliquam pharetra vel arcu ac dictum.";
        String textCom2 = "Cras hendrerit vitae arcu non viverra. In ornare mollis lorem, id varius nibh. Quisque sit amet blandit orci, suscipit efficitur dolor. Mauris porttitor augue in nisl finibus, id sodales diam vestibulum. Nulla vestibulum felis nec sem vehicula, sagittis pharetra justo finibus. Aenean eget ipsum eros. Cras at rutrum est, a lobortis nisl. Suspendisse scelerisque augue nec tincidunt venenatis.";
        String textCom3 = "Nulla facilisi. Fusce sodales, metus vel hendrerit accumsan, orci elit interdum neque, nec lobortis justo felis in mi. Quisque bibendum ante et nisi vestibulum mollis. Maecenas eget consequat velit. Integer luctus feugiat eros gravida congue. Cras eget ipsum a odio semper tempus. Aliquam laoreet sem in auctor semper. In quis lorem tortor. In lorem nulla, maximus ac interdum eget, fringilla sed neque. Aenean eu ligula nec justo maximus condimentum. Sed condimentum dui eget leo sagittis, nec lobortis felis ornare. Praesent dolor nunc, ullamcorper a imperdiet ac, posuere sed nisi.";
        String textCom4 = "Integer eu rutrum purus, nec dignissim ex. Praesent sit amet purus ex. Mauris justo tortor, varius a suscipit at, tincidunt eget magna. Praesent sed mauris quis nisi elementum porttitor a blandit nunc. Praesent quis nunc arcu. Suspendisse interdum rhoncus tincidunt. Vestibulum id neque et diam tempus fermentum. Donec eget sodales purus. Vestibulum id consectetur enim.";
        String textCom5 = "Nulla facilisi. Vestibulum sed justo id tortor sodales semper. Vestibulum arcu elit, scelerisque et lacinia a, placerat a sem. Maecenas quis tincidunt libero. Quisque sed ipsum nec lorem varius varius. Quisque et tellus odio. Aliquam non vestibulum mi. Donec viverra, dolor sed lobortis bibendum, magna urna eleifend leo, facilisis feugiat nisi eros ac augue. Phasellus dignissim nunc id lectus semper ultricies.";
        
        Commentaire c1 = new Commentaire(textCom1, Calendar.getInstance(), lambda1, article1);
        Commentaire c2 = new Commentaire(textCom2, Calendar.getInstance(), lambda2, article2);
        Commentaire c3 = new Commentaire(textCom3, Calendar.getInstance(), lambda3, article3);
        Commentaire c4 = new Commentaire(textCom4, Calendar.getInstance(), lambda4, article4);
        Commentaire c5 = new Commentaire(textCom5, Calendar.getInstance(), lambda5, article5);
        
        facadeCommentaire.create(c1);
        facadeCommentaire.create(c2);
        facadeCommentaire.create(c3);
        facadeCommentaire.create(c4);
        facadeCommentaire.create(c5);
    }
}
