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
 * @author Drakoun
 */
@Singleton
@Startup
public class initDB {
    @EJB
    private UtilisateurFacadeREST facadeUtilisateur;
    @EJB
    private ArticleFacadeREST facadeArticle;
    @EJB
    private RolesFacadeREST facadeRoles;
    @EJB
    private CommentaireFacadeREST facadeCommentaire;
    
    @PostConstruct
    public void remplirBaseAvecDonneesDeTest() {
        Roles admin = new Roles("Administrateur","L'administrateur a le rôle de gérer les comptes utilisateur ainsi que les publications");
        Roles membre = new Roles("Membre","Les membres du blog peuvent créer et commenter des articles");
        //Roles moderateur = new Roles("Modérateur","Les modérateurs du blog peuvent supprimer le message d'un commentaire"); ce serait cool de le faire, mais pas le temps
        facadeRoles.create(admin);
        facadeRoles.create(membre);
        byte[] photo = null; 
        Utilisateur admin1 = new Utilisateur("David","Boccara","Développeur coté serveur",photo,"drakoun","drakoun",StatusUtilisateur.ACTIF,admin);
        Utilisateur admin2 = new Utilisateur("Lorris","Spugna","Développeur coté client",photo,"fork","fork",StatusUtilisateur.ACTIF,admin);
        Utilisateur membre1 = new Utilisateur("Jean-Michel","Crapaud","C'est lui il est dans la river",photo,"jm","jm",StatusUtilisateur.ACTIF,membre);
        facadeUtilisateur.create(admin1);
        facadeUtilisateur.create(admin2);
        facadeUtilisateur.create(membre1);
        String ar =  "<div><p>La Faille de l’invocateur a vu s’enchaîner les matchs de la phase de groupe pendant trois semaines. Il est temps de "
                        + "revenir sur leurs parcours respectifs et sur la suite de la compétition.</p><p>Depuis le 30 janvier, les six meilleures"
                        + " équipes de France sont en course pour le titre de champion national. Huit journées ont permis à chacune d’entre elles "
                        + "d’affronter l’ensemble de ses adversaires, dans le but d’engranger un maximum de victoires et de se positionner dans le haut du "
                        + "classement final. Des parcours très différents selon les équipes, dont voici un résumé.</p><h2>Le parcours des équipes</h2><p><strong>"
                        + "Millenium et Team-LDLC au dessus du lot</strong></p><p>Finalistes de l’édition 2016, les équipes "
                        + "<a target=\"_blank\" href=\"http://eu.lolesports.com/fr/equipe/millenium\">Millenium</a>&nbsp;et"
                        + " <a target=\"_blank\" href=\"http://eu.lolesports.com/fr/equipe/team-ldlc\">Team-LDLC</a> se sont"
                        + " imposées assez logiquement dans cette phase de groupe, respectivement première et deuxième au classement."
                        + " Mais à l’inverse du Challenge France 2016, où Team-LDLC avait remporté ses 5 matchs de poule, c’est cette fois-ci "
                        + "Millenium qui termine sur le score de 5 à 0.</p><p>Leur match, joué en ouverture du <strong>Challenge France 2017</strong>,"
                        + " a montré un niveau de jeu excellent et s’est terminé sur un score de 2 à 1 pour Millenium. Nul doute que ces 2 équipes vont"
                        + " tout faire pour se retrouver à nouveau et nous offrir&nbsp;une finale d’anthologie.</p><p><strong>Un trio difficile à "
                        + "départager</strong></p><p>Les nouveaux arrivants sous les couleurs de <strong>GamersOrigin</strong> sont entrés en trombe"
                        + " dans la compétition, s’imposant face à Grosbill Esport et Oserv Esport. S’ils ont failli accrocher la Team-LDLC, ils s'inclineront"
                        + "finalement sur <a target=\"_blank\" "
                        + "href=\"http://eu.lolesports.com/fr/challenge-france/french_2017_winter/match/2017-02-06/team-ldlc-vs-gamers-origin\">le score "
                        + "de 2 à 1</a>.</p><p>Côté <a target=\"_blank\" href=\"http://eu.lolesports.com/fr/equipe/oserv-esport\">Oserv Esport</a>, les outsiders "
                        + "de la compétition, <a target=\"_blank\" "
                        + "href=\"http://eu.lolesports.com/fr/challenge-france/french_2017_winter/match/2017-02-08/oserv-esport-vs-grosbill-esport\">une "
                        + "victoire 2 à 0 face à Grosbill</a> a permis de remettre les joueurs en course. Le match contre E-Corp n’aura finalement pas lieu "
                        + "suite à un problème technique d’un des joueurs, ce qui déclarera l’équipe de Brosak forfait.</p><p>Par conséquent, <a target=\"_blank\""
                        + " href=\"http://eu.lolesports.com/fr/equipe/ecorp-gentle\">E-Corp Gentle</a>, qui a remporté ses matchs contre Grosbill et "
                        + "GamersOrigin,&nbsp;terminera également la phase de groupe avec deux victoires&nbsp;et trois défaites.</p><p><strong>La déception "
                        + "Grosbill Esport</strong></p><p>Troisième du Challenge France 2016, "
                        + "les <a target=\"_blank\" href=\"http://eu.lolesports.com/fr/equipe/grosbill-esport\">Grosbill Esport</a> n'ont pas brillé "
                        + "sur cette édition. En effet, ils n’auront pas su prendre l'avantage face à leurs adversaires et terminent la phase de groupe"
                        + " avec 5 défaites,en dernière position.</p><p><strong>Les patchs 7.1 et 7.2</strong> ont provoqué nombreux changements sur la"
                        + " scène compétitive et c’est peut-être l’une des explications de cette performance en dessous des attentes de la communauté. Le"
                        + " sursaut lors de l'avant-dernière journée, où ils ont accroché "
                        + "<a target=\"_blank\" href=\"http://eu.lolesports.com/fr/challenge-france/french_2017_winter/match/2017-02-13/grosbill-esport-vs-gamers-origin\">une manche aux GamersOrigin</a>, n’aura malheureusement"
                        + " pas suffit.</p><h2>Départager les équipes : l'épreuve des Tie-Break</h2><p>Les équipes <strong>E-Corp Gentle</strong>, "
                        + "<strong>Oserv Esport</strong> et <strong>GamersOrigin</strong> ont&nbsp;donc dû passer l’épreuve du Tie-Break (BO1) pour être "
                        + "départagées. En une manche, chaque club s’est affronté et contre toute attente, l'équipe d'Eyrho s'est imposée face à ses deux adversaires."
                        + " Oserv Esport a donc sécurisé la première place en demi-finale.</p><p>GamersOrigin et E-Corp Gentle ont donc joué un ultime match, et c'est "
                        + "le groupe de Shemek qui s'est imposé. Les <strong>E-Corp Gentle</strong> terminent <strong>5e du Challenge France</strong>, tandis que GamersOrigin "
                        + "rejoint Millenium, Team-LDLC et Oserv Esport en demi-finales.&nbsp;</p><img sizes=\"(max-width: 767px) 700px, (min-width: 768px) and (max-width: 1023px)"
                        + " 940px, (min-width: 1024px) 940px\" alt=\"classement-fin-groupe-cflol17\" srcset=\"https://eu.lolesports.com/darkroom/200/199a5c6da066656b9f35e4cccfd5244a:cd3ef3186e135fdf180dfcadfbbd6010 200w, https://eu.lolesports.com/darkroom/245/199a5c6da066656b9f35e4cccfd5244a:e3f0be7b7478babf10f932cbfad145db 245w, https://eu.lolesports.com/darkroom/315/199a5c6da066656b9f35e4cccfd5244a:fee7ee9a113e675fefb4ccbd022ce338 315w, https://eu.lolesports.com/darkroom/430/199a5c6da066656b9f35e4cccfd5244a:b2bfbbbd0e47c5f197ae0025c8936145 430w, https://eu.lolesports.com/darkroom/640/199a5c6da066656b9f35e4cccfd5244a:5ad8676b53bdb60f8e074b2cc75f3964 640w, "
                        + "https://eu.lolesports.com/darkroom/940/199a5c6da066656b9f35e4cccfd5244a:0af1baa9be3605ca43ba6b742c84771f 940w\"><h2>Les demi-finales "
                        + "du Challenge France</h2><p>Les 4 équipes encore en lice vont s’affronter <strong>mardi 22 et mercredi 23 février</strong> dans un nouveau"
                        + " format, puisque ce sont maintenant <strong>3 manches</strong> qu’il faudra remporter (BO5) pour obtenir son ticket vers la grande finale du "
                        + "<strong>Challenge France 2017</strong>.</p><img sizes=\"(max-width: 767px) 700px, (min-width: 768px) and (max-width: 1023px) 940px, (min-width: 1024px) "
                        + "940px\" alt=\"bracket-final-cflol17\" srcset=\"https://eu.lolesports.com/darkroom/200/29c1906935bffdf545cf0a6b1c92607d:aec1c088cf94cdb9327350b4c8dfe178 200w,"
                        + " https://eu.lolesports.com/darkroom/245/29c1906935bffdf545cf0a6b1c92607d:388c2a1fb6f35595d67bc4d81771e104 245w, https://eu.lolesports.com/darkroom/315/29c1"
                        + "906935bffdf545cf0a6b1c92607d:4bed27191fb61a3e338c0fac8c9810d7 315w, https://eu.lolesports.com/darkroom/430/29c190"
                        + "6935bffdf545cf0a6b1c92607d:929153279f2ebc01d01dd23d8dec2699 430w, https://eu.lolesports.com/darkroom/640/29c19069"
                        + "35bffdf545cf0a6b1c92607d:8fb55fa01cf26def7013d39e0897d7d2 640w, https://eu.lolesports.com/darkroom/940/29c1906935bf"
                        + "fdf545cf0a6b1c92607d:d7b5f57ff8de4d5a5fdc557fbafdc55f 940w\"><h2>Rejoignez-nous pour la grande finale à Lyon</h2><p>L"
                        + "a finale du Challenge France, qui couronnera la meilleure équipe League of Legends du pays, aura lieu à Lyon <a target="
                        + "\"_blank\" href=\"http://eu.lolesports.com/fr/articles/finale-challengefrance-lyon\">en ouverture de la Lyon e-Sport #10"
                        + "</a>. Si vous souhaitez participer au spectacle, réservez dès à présent votre billet sur la billetterie prévue à cet eff"
                        + "et.</p><p>Sont prévus au programme&nbsp;<strong>de nombreux commentateurs et analystes</strong>, une&nbsp;<strong>grande "
                        + "scène professionnelle et des écrans géants</strong>&nbsp;pour ne rien rater du match et bien d’autres&nbsp;<strong>animat"
                        + "ions&nbsp;</strong>autour du jeu, pour que la soirée soit inoubliable ! On espère vous voir nombreux !</p><p>Source : <a t"
                        + "arget=\"_blank\" href=\"http://eu.lolesports.com/fr/articles/bilan-phase-groupe-challenge-france-2017\">http://eu.lolesport"
                        + "s.com/fr/articles/bilan-phase-groupe-challenge-france-2017</a></p></div>";
        
        float lat = -1;
        float longi = -1;
        String posNom = null;
        Article article = new Article("LES QUATRE DEMI-FINALISTES DE LA COUPE DE FRANCE", "#LoL #ChallengeFrance",
                true, ar,photo,lat,longi,posNom,Status.PUBLIER,admin1);
        String ar2 =  "<div><p>Vous pouvez désormais utiliser l'outil d'entraînement sur le serveur euw !</p><p><iframe width=\"640\" height=\"360\" src=\"https://www.youtube.com/embed/iujphqj4O9o\" frameborder=\"0\" allowfullscreen></iframe></p><p>Source : <a target=\\\"_blank\\\" href=\\\"http://euw.leagueoflegends.com/fr\">http://euw.leagueoflegends.com/fr</a> <a target=\\\"_blank\\\" href=\\\"https://www.youtube.com/watch?v=iujphqj4O9o&feature=youtu.be\">https://www.youtube.com/watch?v=iujphqj4O9o&feature=youtu.be</a></p></div>";
        
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
