package edu.mermet.tp5.actions;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

import edu.mermet.tp5.Application;
import edu.mermet.tp5.Ressources;

public class ActionAfficherConversion extends AbstractActionTraduisible {
    /**
	 * 
	 */
	private final Application application;

	public ActionAfficherConversion(Application application) {
        super(Ressources.ACTION_CONVERSION, application);
		this.application = application;
        putValue(Action.ACCELERATOR_KEY,KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
        putValue(Action.MNEMONIC_KEY,KeyEvent.VK_C);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        application.afficherConversion();
    }
}
