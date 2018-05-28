package fen;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author robert
 */
public class Groupe
{

    private ArrayList<Trait> dessin = new ArrayList(); // tableau qui n'as pas de fin

    public boolean isFull() // si plein, retourne faux
    {
        return false;
    }

    public void add(Trait t) // commence le trait
    {
        if (t != null)
        {
            dessin.add(t);
        }

    }

    public void suppDernier() // supprime le dernier trait
    {
        if (dessin.size() > 0)
        {
            dessin.remove(dessin.size() - 1);
        }
    }

    public void suppTout() // supprime tout les traits
    {
        dessin.clear();
    }

    public void paint(Graphics g) // parametres graphic du trait
    {
        for (Trait b : dessin)
        {
            b.paint(g);
        }

    }

    public int size()
    {
        return dessin.size();
    }
}
