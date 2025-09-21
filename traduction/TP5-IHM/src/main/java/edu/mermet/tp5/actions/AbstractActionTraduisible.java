package edu.mermet.tp5.actions;

import javax.swing.AbstractAction;
import javax.swing.Action;

import edu.mermet.tp5.Application;
import edu.mermet.tp5.GestionnaireRessources;
import edu.mermet.tp5.Ressources;
import edu.mermet.tp5.Traduisible;

public abstract class AbstractActionTraduisible extends AbstractAction implements Traduisible {
	private Ressources clef;
	private Application appli;
	private static GestionnaireRessources gestionnaire = GestionnaireRessources.getGestionnaireRessources();
	
	public AbstractActionTraduisible(Ressources clef, Application appli) {
		super(gestionnaire.getString(clef));
		this.appli = appli;
		this.clef = clef;
		gestionnaire.addTraduisible(this);
	}
	
	
	@Override
	public void traduire() {
		putValue(Action.NAME, gestionnaire.getString(clef));		
	}
}
