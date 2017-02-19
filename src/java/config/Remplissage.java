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
        Roles admin = new Roles("Administrateur","L'administrateur a le rôle de gérer les comptes utilisateur ainsi que les publications");
        Roles membre = new Roles("Membre","Les membres du blog peuvent créer et commenter des articles");
        //Roles moderateur = new Roles("Modérateur","Les modérateurs du blog peuvent supprimer le message d'un commentaire"); ce serait cool de le faire, mais pas le temps
        facadeRoles.create(admin);
        facadeRoles.create(membre);
        byte[] photo = null; 
        Utilisateur admin1 = new Utilisateur("Lorep","Ipsum","dolor sir amet",photo,"gravida","Nam",StatusUtilisateur.ACTIF,admin);
        Utilisateur admin2 = new Utilisateur("Phasellus","a","a",photo,"ligula","rutrum",StatusUtilisateur.ACTIF,admin);
        Utilisateur membre1 = new Utilisateur("Jean-Michel","Crapaud","C'est lui il est dans la river",photo,"jm","jm",StatusUtilisateur.ACTIF,membre);
        facadeUtilisateur.create(admin1);
        facadeUtilisateur.create(admin2);
        facadeUtilisateur.create(membre1);
        String ar1 ="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam vitae gravida orci, non euismod ipsum. Donec tristique scelerisque mi id elementum. Curabitur pellentesque sapien ac efficitur dapibus. Vestibulum ut mauris justo. Quisque viverra orci eros, non tincidunt sem pellentesque vel. Sed faucibus metus dui, eget scelerisque dui aliquam sit amet. Fusce consectetur metus tortor, vel sollicitudin tortor sodales eget. Suspendisse tristique fermentum ornare. Quisque a porttitor ante. Fusce nec mi est.";
        String ar2 ="Phasellus a ante vel ligula vehicula rutrum nec eu purus. Praesent suscipit ante vel risus dictum condimentum. Integer vel metus malesuada justo rhoncus accumsan. Donec sodales neque ultricies viverra elementum. Nulla non urna velit. Nulla non justo eu eros dapibus interdum. Nam non quam non lacus varius porttitor vestibulum sit amet velit. Nullam vestibulum urna consectetur sem pretium, fringilla lobortis eros posuere. Mauris tristique erat neque, sit amet accumsan nulla posuere ut. Aenean libero nisl, auctor a justo et, pulvinar varius justo. Sed dapibus felis maximus, malesuada leo vitae, mattis urna. Nam in lacinia quam, quis suscipit risus. Nunc eget erat est. Cras fermentum, magna vitae elementum vulputate, erat ligula vestibulum metus, eu ornare orci dui et purus.";
        String ar3 ="Vivamus venenatis dolor id ullamcorper ornare. Duis tincidunt malesuada nulla sit amet euismod. Aliquam erat volutpat. Sed interdum eu lacus ullamcorper sagittis. Sed dignissim tortor ac elit ultrices, eget ultrices sem fringilla. Morbi venenatis nisl ac risus convallis rutrum. Praesent eget est nec lacus facilisis sollicitudin. Sed facilisis quam sit amet fermentum bibendum. Quisque vel convallis libero. Aliquam venenatis, nisl tempus ullamcorper iaculis, ligula odio commodo ligula, eu bibendum orci diam at neque. Nunc efficitur elit in ante tempus volutpat.";
        String ar4 ="Maecenas viverra felis risus, non imperdiet urna dapibus sed. Donec in accumsan ligula. Mauris consequat elementum tortor eu venenatis. Nulla at varius lacus. Nulla ac condimentum ligula, a ultricies lectus. Morbi et felis vulputate, pellentesque dui non, eleifend nunc. In faucibus, purus quis tempus pharetra, justo neque feugiat sem, a congue velit massa quis massa.";
        String ar5 ="Etiam mi eros, aliquam sit amet maximus vitae, tristique et augue. Donec vestibulum dignissim quam non rutrum. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Ut ultricies ipsum ex, id euismod lorem volutpat sit amet. Praesent leo ligula, luctus sed dictum et, semper quis purus. Quisque a vestibulum ex, vitae sagittis est. Pellentesque nisi eros, aliquet ultrices nulla vel, volutpat venenatis ante.";
        
        float lat = -1;
        float longi = -1;
        String posNom = null;
        Article article = new Article("LES QUATRE DEMI-FINALISTES DE LA COUPE DE FRANCE", "#LoL #ChallengeFrance",
                true, ar1,photo,lat,longi,posNom,Status.PUBLIER,admin1);
        String ar22 =  "<div><p>Vous pouvez désormais utiliser l'outil d'entraînement sur le serveur euw !</p><p><iframe width=\"640\" height=\"360\" src=\"https://www.youtube.com/embed/iujphqj4O9o\" frameborder=\"0\" allowfullscreen></iframe></p><p>Source : <a target=\\\"_blank\\\" href=\\\"http://euw.leagueoflegends.com/fr\">http://euw.leagueoflegends.com/fr</a> <a target=\\\"_blank\\\" href=\\\"https://www.youtube.com/watch?v=iujphqj4O9o&feature=youtu.be\">https://www.youtube.com/watch?v=iujphqj4O9o&feature=youtu.be</a></p></div>";
        
        Article article2 = new Article("L'outil d'entraînement est disponible !", "#LoL #entraînement #enfin", true,ar2,photo,lat,longi,posNom, Status.PUBLIER, admin2);
        facadeArticle.create(article);
        facadeArticle.create(article2);
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, -2);
        Commentaire c1 = new Commentaire("C'est Millenium qui va gagner la coupe ! A Quand l'entrée en LCS EU ?", c, membre1, article);
        c.add(Calendar.DAY_OF_MONTH, -2);
        Commentaire c2 = new Commentaire("Trololol on peut enfin faire n'importe quoi sans devoir lancer une vraie partie", c, admin2, article2);
        c.add(Calendar.DAY_OF_MONTH, -1);c.add(Calendar.HOUR_OF_DAY, -2);
        Commentaire c3 = new Commentaire("LA DOMINGO !!!", c, admin1, article2);
        facadeCommentaire.create(c1);
        facadeCommentaire.create(c2);
        facadeCommentaire.create(c3);
    }
}
