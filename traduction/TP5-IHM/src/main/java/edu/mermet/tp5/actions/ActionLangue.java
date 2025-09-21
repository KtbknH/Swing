package edu.mermet.tp5.actions;

import java.awt.event.ActionEvent;
import java.util.Locale;

import edu.mermet.tp5.Application;
import edu.mermet.tp5.GestionnaireRessources;
import edu.mermet.tp5.Ressources;

public class ActionLangue extends AbstractActionTraduisible {
	/**
	 * 
	 */
	private final Application application;
	private static GestionnaireRessources gestionnaire = GestionnaireRessources.getGestionnaireRessources();
	private Ressources clef;
	private Locale lieu;

	public ActionLangue(Application lApplication, Ressources clef) {
		super(clef, lApplication);
		application = lApplication;
		switch (clef) {
			case LANGUE_FRANCAIS:
				lieu = Locale.FRENCH;
				break;
			case LANGUE_ANGLAIS:
				lieu = Locale.ENGLISH;
				break;		
			default:
				lieu = Locale.getDefault();
				break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		System.err.println("changement de langue on passe de "+gestionnaire.getLieu()+" à "+lieu);
		gestionnaire.definirLieu(lieu);
	}
}
