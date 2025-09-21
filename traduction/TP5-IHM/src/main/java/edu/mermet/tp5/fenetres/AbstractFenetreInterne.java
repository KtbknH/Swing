package edu.mermet.tp5.fenetres;

import javax.swing.Action;
import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import edu.mermet.tp5.Application;
import edu.mermet.tp5.GestionnaireRessources;
import edu.mermet.tp5.Traduisible;

/**
 *
 * @author brunomermet
 */
public abstract class AbstractFenetreInterne extends JInternalFrame implements Traduisible {
    private Action action;
    private static GestionnaireRessources gestionnaireRessources = GestionnaireRessources.getGestionnaireRessources();
    public AbstractFenetreInterne(Application appli, Action monAction, String nom) {
        super(nom, true,true,true,true);
        action = monAction;
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.addInternalFrameListener(new EcouteurFenetre());
        gestionnaireRessources.addTraduisible(this);
    }
    
    private class EcouteurFenetre extends InternalFrameAdapter {
        @Override
        public void internalFrameClosing(InternalFrameEvent ife) {
            action.setEnabled(true);
        }
        @Override
        public void internalFrameActivated(InternalFrameEvent ife) {
        	action.setEnabled(false);
        }
    }
}
