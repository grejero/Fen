package fen;

import java.awt.event.*; // importation des classes des evenements
import javax.swing.SwingUtilities; // importation des classes du language java swing

/**
 *
 * @author robert
 */
public class Ecouteur implements MouseListener, MouseMotionListener // implementation de l'interface mouselistener car mon ecouteur est un ecouteur d'evenements sur les actions sur les controles.
{

    private Fen fen; // creation de la frame

    Ecouteur(Fen f) // relie ecouteur et frame
    {
        fen = f; // nlle frame se nomme f
        fen.addMouseListener(this); // initialisation d'ecoute souris
        fen.addMouseMotionListener(this); // initialisation d'ecoute mouvement souris

    }

    @Override
    public void mouseClicked(MouseEvent e) // gere le clic souris de tous les boutons
    {
        if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) // bouton gauche
        {
            fen.resetLigne();

        } else if (e.getClickCount() == 1 && SwingUtilities.isRightMouseButton(e)) // bouton droit
        {

            fen.resetTrait();

        }

    }

    @Override
    public void mousePressed(MouseEvent e) // gere la pression de bouton sur la souris
    {
        if (SwingUtilities.isLeftMouseButton(e)) // bouton gauche
        {
            fen.debutTrait(e.getPoint());
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) // gere le relachement de bouton sur la souris
    {
        if (SwingUtilities.isLeftMouseButton(e))
        {
            fen.finTrait(e.getPoint());
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) // entrée dans la fenetre de la souris       
    {

    }

    @Override
    public void mouseExited(MouseEvent e) // sortie de la fenetre de la souris
    {

    }

    @Override
    public void mouseDragged(MouseEvent e)  // drag and drop de la souris
    {
        if (SwingUtilities.isLeftMouseButton(e))

        {
            fen.dessinerTrait(e.getPoint());
        }
    }

    @Override
    public void mouseMoved(MouseEvent e)    // mouvement de la souris en survol
    {

    }

}
