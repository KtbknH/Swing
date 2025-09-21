package edu.mermet.tp5.fenetres;

import java.awt.FlowLayout;

import javax.swing.Action;
import javax.swing.JButton;

import edu.mermet.tp5.Application;
import edu.mermet.tp5.GestionnaireRessources;
import edu.mermet.tp5.Ressources;

/**
 *
 * @author brunomermet
 */
public class FenetreBoutons extends AbstractFenetreInterne {
    private JButton boutonTexte;
    private JButton boutonDiaporama;
    private JButton boutonDegres;
    private static GestionnaireRessources gestionnaire = GestionnaireRessources.getGestionnaireRessources();
    
    public FenetreBoutons(Application appli, Action action) {
        super(appli, action, "Boutons");
        setTitle("Boutons");
        setLayout(new FlowLayout());
        boutonTexte = new JButton(appli.getActionAfficherTexte());
        boutonDiaporama = new JButton(appli.getActionAfficherDiaporama());
        boutonDegres = new JButton(appli.getActionAfficherConversion());
        add(boutonDegres);
        add(boutonTexte);
        add(boutonDiaporama);
        pack();
    }

	@Override
	public void traduire() {
		// TODO Auto-generated method stub
		setTitle(gestionnaire.getString(Ressources.FEN_BOUTONS_TITRE));		
	}

}
