package edu.mermet.tp5.actions;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

import edu.mermet.tp5.Application;
import edu.mermet.tp5.Ressources;

public class ActionAfficherBoutons extends AbstractActionTraduisible {
    /**
	 * 
	 */
	private final Application application;

	public ActionAfficherBoutons(Application application) {
        super(Ressources.ACTION_BOUTONS, application);
		this.application = application;
        putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_DOWN_MASK));
        putValue(Action.MNEMONIC_KEY,KeyEvent.VK_B);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        application.afficherBoutons();
    }
    
}
