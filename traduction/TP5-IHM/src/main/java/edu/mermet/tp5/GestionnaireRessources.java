package edu.mermet.tp5;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class GestionnaireRessources {
	private ArrayList<Traduisible> traduisibles;
	private ResourceBundle bundle;
	private Locale lieu;
	private static GestionnaireRessources gestionnaire;

	private GestionnaireRessources() {
		lieu = Locale.getDefault();
		bundle = ResourceBundle.getBundle("bundle", lieu);
		traduisibles = new ArrayList<Traduisible>();
	}

	private static class Detenteur {
		private static final GestionnaireRessources instance = new GestionnaireRessources();
	}

	public String getString(Ressources res) {
		return bundle.getString(res.getNom());
	}

	public static GestionnaireRessources getGestionnaireRessources() {
		gestionnaire = Detenteur.instance;
		return gestionnaire;
	}

	public void definirLieu(Locale lieu) {
		this.lieu = lieu;
		bundle = ResourceBundle.getBundle("bundle", lieu);
		fireTraduire();
	}

	public Locale getLieu() {
		return lieu;
	}

	public void addTraduisible(Traduisible trad) {
		traduisibles.add(trad);
	}

	public void removeTraduisible(Traduisible trad) {
		traduisibles.remove(trad);
	}

	private void fireTraduire() {
		for (Traduisible trad : traduisibles)
			trad.traduire();
	}

}
