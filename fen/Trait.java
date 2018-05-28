package fen;

import java.awt.*; // importation des classes des composants
import static java.awt.geom.Point2D.distance;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Vector;

/**
 *
 * @author robert
 */
public class Trait // chaque trait se gere seul et se paint seul

{

    private Point start;    // point de départ
    private Point end;      // point d'arrivée
    private Color couleur = new Color((int) (Math.random() * 0xFFFFFF)); // produit la couleur aleatoirement grace a la fonction
 
            
    public Trait(Point ligne) // debut du dessin du trait au point
    {

        if (ligne == null)
        {
            ligne = new Point();

        }
        start = ligne;
        end = ligne;

    }

    public void setEnd(Point finligne) // fin du dessin du trait au point
    {
        if (finligne == null)
        {
            finligne = new Point();

        }
        end = finligne;

    }

    public void paint(Graphics g) // parametres graphic du trait, couleur, rayon, taille du cercle
    {
        g.setColor(couleur);
        int rayon = rayon();
        //g.drawLine(start.x, start.y, end.x, end.y);
        g.fillOval(start.x - rayon, start.y - rayon, rayon * 2, rayon * 2);
    }

    private int rayon()
    {
        int rayon = (int) distance(start.x, start.y, end.x, end.y);
        return rayon;
    }

}
