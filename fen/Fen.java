package fen;

import java.awt.event.*; // importation des classes des evenements
import java.awt.*; // importation des classes des composants
import java.awt.event.WindowAdapter; // importation winadapter

/**
 *
 * @author robert
 */
public class Fen extends Frame
{

    private Groupe gr = new Groupe();
    private Trait enCours;

    public Fen()

    {
        Ecouteur souris = new Ecouteur(this);   // on crée un ecouteur pour gerer les actions sur la souris
        Ecout fenetre = new Ecout();            // on crée un ecouter pour gerer les boutons de fenetre
        addWindowListener(fenetre);             // ajout d'un ecouteur fenetre
        setBounds(200, 200, 1200, 1200);          // taille et position de la fenetre
        setBackground(Color.BLACK);             // color de fond de fenetre
        setTitle("Je veux des ronds....");
        setVisible(true); // fenetre visible oui
    }

    public void debutTrait(Point p)             // initialistaion du trait en debut (clic souris)
    {
        enCours = new Trait(p);
        repaint();
    }

    public void finTrait(Point p)               // fin de trait release souris
    {

        enCours.setEnd(p);
        gr.add(enCours);
        enCours = null;

        repaint(); // reprend la fenetre au debut pour executer une nouvelle instruction

    }

    public void dessinerTrait(Point p) // dessine le trait en drag and drop
    {
        enCours.setEnd(p);
        repaint();
    }

    @Override
    public void paint(Graphics g) // permet de definir le graphic en java, position de lignes, couleurs, abscisses et ordonnées
    {

        Image brouillon;
        Graphics2D tampon; // double buffering permettant a l'objet de ne pas clignoter
        Dimension d = this.getSize();
        brouillon = createImage(d.width, d.height);
        tampon = (Graphics2D) brouillon.getGraphics();
        tampon.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); // antaliasing, permet l'anticrenelage des objets
        gr.paint(tampon);

        if (enCours != null)
        {
            enCours.paint(tampon);
        }
        g.drawImage(brouillon, 0, 0, null); // affichage effectif
    }

    public void resetLigne()    // permet d'effacer tous les traits en double clic gauche
    {
        gr.suppTout();
        repaint();
    }

    public void resetTrait()    // permet d'effacer les derniers traits un par un avec le clic droit
    {

        gr.suppDernier();
        System.out.println(gr.size());
        repaint();

    }

    class Ecout extends WindowAdapter // implémentation de l'interface WindowListener car mon écouteur est un écouteur d'événements  sur la gestion des fenêtres.

    {

        @Override
        public void windowClosing(WindowEvent e) // permet de fermer la fenetre par le bouton rouge
        {
            System.exit(0);
        }
    }
}
