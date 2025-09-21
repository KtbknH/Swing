package edu.mermet.tp5;

import java.awt.event.KeyEvent;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

import edu.mermet.tp5.actions.ActionAfficherBoutons;
import edu.mermet.tp5.actions.ActionAfficherConversion;
import edu.mermet.tp5.actions.ActionAfficherDiaporama;
import edu.mermet.tp5.actions.ActionAfficherTexte;
import edu.mermet.tp5.actions.ActionLangue;
import edu.mermet.tp5.actions.ActionQuitter;
import edu.mermet.tp5.fenetres.AbstractFenetreInterne;
import edu.mermet.tp5.fenetres.FenetreBoutons;
import edu.mermet.tp5.fenetres.FenetreConversion;
import edu.mermet.tp5.fenetres.FenetreDiaporama;
import edu.mermet.tp5.fenetres.FenetreTexte;

/**
 *
 * @author brunomermet
 */
public class Application extends JFrame implements Traduisible {
	AbstractFenetreInterne conversion;
	AbstractFenetreInterne texte;
	AbstractFenetreInterne diaporama;
	AbstractFenetreInterne boutons;
	private Action actionQuitter;
	private Action actionAfficherConversion;
	private Action actionAfficherTexte;
	private Action actionAfficherDiaporama;
	private Action actionAfficherBoutons;
	private ActionLangue actionLangueParDefaut;
	private ActionLangue actionLangueFrancais;
	private ActionLangue actionLangueAnglais;
	private JMenu menuFichier;
	private JMenu menuApplications;
	private JMenu menuLangues;
	private ButtonGroup groupeLangues;
	private static GestionnaireRessources gestionnaire = GestionnaireRessources.getGestionnaireRessources();

	public Application() {
		gestionnaire.addTraduisible(this);
		
		setTitle(gestionnaire.getString(Ressources.TITRE));
		init();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 300);
		this.setLocationRelativeTo(null);
		gestionnaire.definirLieu(getLocale());
		setVisible(true);
	}

	private void initActions() {
		actionQuitter = new ActionQuitter(this);
		actionAfficherConversion = new ActionAfficherConversion(this);
		actionAfficherTexte = new ActionAfficherTexte(this);
		actionAfficherDiaporama = new ActionAfficherDiaporama(this);
		actionAfficherBoutons = new ActionAfficherBoutons(this);
		actionLangueParDefaut = new ActionLangue(this, Ressources.LANGUE_DEFAUT);
		actionLangueFrancais = new ActionLangue(this, Ressources.LANGUE_FRANCAIS);
		actionLangueAnglais = new ActionLangue(this, Ressources.LANGUE_ANGLAIS);
	}

	private void init() {
		initActions();
		initMenus();
		initFenetres();
	}

	private void initFenetres() {
		this.setContentPane(new JDesktopPane());
		// ------ fenêtre conversion ------
		conversion = new FenetreConversion(this, actionAfficherConversion);
		this.add(conversion);
		// ------ fenêtre texte ------
		texte = new FenetreTexte(this, actionAfficherTexte);
		this.add(texte);
		// ------ fenêtre diaporama ------
		diaporama = new FenetreDiaporama(this, actionAfficherDiaporama);
		this.add(diaporama);
		// ------ fenêtre boutons ------
		boutons = new FenetreBoutons(this, actionAfficherBoutons);
		this.add(boutons);
	}

	private void initMenus() {
		JMenuBar barre = new JMenuBar();
		// ------ menu Fichier ------
		menuFichier = new JMenu(gestionnaire.getString(Ressources.MENU_FICHIER));
		menuFichier.setMnemonic(KeyEvent.VK_F);

		JMenuItem quitter = new JMenuItem(actionQuitter);
		menuFichier.add(quitter);
		barre.add(menuFichier);
		this.setJMenuBar(barre);

		// ------ menu Applications ------
		menuApplications = new JMenu(gestionnaire.getString(Ressources.MENU_APPLICATIONS));
		menuApplications.setMnemonic(KeyEvent.VK_A);

		JMenuItem itemConversion = new JMenuItem(actionAfficherConversion);
		menuApplications.add(itemConversion);

		JMenuItem itemTexte = new JMenuItem(actionAfficherTexte);
		menuApplications.add(itemTexte);

		JMenuItem itemDiaporama = new JMenuItem(actionAfficherDiaporama);
		menuApplications.add(itemDiaporama);

		JMenuItem itemBoutons = new JMenuItem(actionAfficherBoutons);
		menuApplications.add(itemBoutons);
		barre.add(menuApplications);

		// ------ menu Langues ------
		menuLangues = new JMenu(gestionnaire.getString(Ressources.MENU_LANGUES));
		JRadioButtonMenuItem boutonLangDefaut = new JRadioButtonMenuItem(actionLangueParDefaut);
		JRadioButtonMenuItem boutonLangFr = new JRadioButtonMenuItem(actionLangueFrancais);
		JRadioButtonMenuItem boutonLangEn = new JRadioButtonMenuItem(actionLangueAnglais);
		groupeLangues = new ButtonGroup();
		groupeLangues.add(boutonLangDefaut);
		groupeLangues.add(boutonLangFr);
		groupeLangues.add(boutonLangEn);
		menuLangues.add(boutonLangDefaut);
		menuLangues.add(boutonLangFr);
		menuLangues.add(boutonLangEn);
		barre.add(menuLangues);
	}

	public void enableConversion(boolean b) {
		actionAfficherConversion.setEnabled(b);
	}

	public void enableTexte(boolean b) {
		actionAfficherTexte.setEnabled(b);
	}

	public void enableDiaporama(boolean b) {
		actionAfficherDiaporama.setEnabled(b);
	}

	public void enableBoutons(boolean b) {
		actionAfficherBoutons.setEnabled(b);
	}

	public Action getActionAfficherConversion() {
		return actionAfficherConversion;
	}

	public Action getActionAfficherTexte() {
		return actionAfficherTexte;
	}

	public Action getActionAfficherDiaporama() {
		return actionAfficherDiaporama;
	}

	public void afficherBoutons() {
		boutons.setVisible(true);
	}

	public void afficherConversion() {
		conversion.setVisible(true);
	}

	public void afficherDiaporama() {
		diaporama.setVisible(true);
	}

	public void afficherTexte() {
		texte.setVisible(true);
	}

	@Override
	public void traduire() {
		setVisible(false);
		setTitle(gestionnaire.getString(Ressources.TITRE));
		System.err.println("nouveau titre : " + gestionnaire.getString(Ressources.TITRE));
		menuFichier.setText(gestionnaire.getString(Ressources.MENU_FICHIER));
		menuApplications.setText(gestionnaire.getString(Ressources.MENU_APPLICATIONS));
		menuLangues.setText(gestionnaire.getString(Ressources.MENU_LANGUES));
		setVisible(true);
	}

}
