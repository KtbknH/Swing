package edu.mermet.tp5.fenetres;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.mermet.tp5.Application;
import edu.mermet.tp5.GestionnaireRessources;
import edu.mermet.tp5.Ressources;

/**
 *
 * @author brunomermet
 */
public class FenetreConversion extends AbstractFenetreInterne {
    private JTextField champCelsius;
    private JTextField champFarenheit;
    private JButton boutonConvertir;
    private Action actionConvertir;
    private boolean celsiusAFocus;
    private static GestionnaireRessources gestionnaire = GestionnaireRessources.getGestionnaireRessources();
    public FenetreConversion(Application appli, Action action) {
        super(appli, action, "Conversion celsius/Farenheit");
        setTitle("Conversion Celsius/Farenheit");
        this.setSize(new Dimension(100,50));
        this.setLayout(new GridLayout(3,1));
        JPanel ligneCelsius = new JPanel();
        ligneCelsius.setLayout(new FlowLayout(FlowLayout.TRAILING));
        JLabel labCelsius = new JLabel("Celsius :");
        champCelsius = new JTextField(15);
        labCelsius.setLabelFor(champCelsius);
        ligneCelsius.add(labCelsius);
        ligneCelsius.add(champCelsius);
        this.add(ligneCelsius);
        celsiusAFocus = true;
        champCelsius.addFocusListener(new EcouteurFocus(true));
        JPanel ligneFarenheit = new JPanel();
        ligneFarenheit.setLayout(new FlowLayout(FlowLayout.TRAILING));
        JLabel labFarenheit = new JLabel("Farenheit :");
        champFarenheit = new JTextField(15);
        labFarenheit.setLabelFor(champFarenheit);
        ligneFarenheit.add(labFarenheit);
        ligneFarenheit.add(champFarenheit);
        this.add(ligneFarenheit);
        champFarenheit.addFocusListener(new EcouteurFocus(false));
        JPanel ligneValider = new JPanel();
        ligneValider.setLayout(new FlowLayout(FlowLayout.CENTER));
        actionConvertir = new ActionConvertir();
        boutonConvertir = new JButton(actionConvertir);
        ligneValider.add(boutonConvertir);
        this.add(ligneValider);
        pack();
        getRootPane().setDefaultButton(boutonConvertir);
    }

    private class EcouteurFocus implements FocusListener {
        private boolean aStocker;

        public EcouteurFocus(boolean b) {
            aStocker = b;
        }

        @Override
        public void focusGained(FocusEvent fe) {
            celsiusAFocus = aStocker;
        }

        @Override
        public void focusLost(FocusEvent fe) {
            return;
        }
    }

    private class ActionConvertir extends AbstractAction {

        public ActionConvertir() {
            super("Convertir");
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            double tempCelsius = 0;
            double tempFarenheit = 0;
            if (celsiusAFocus) {
                try {
                    tempCelsius = Double.parseDouble(champCelsius.getText());
                tempFarenheit = 9./5*tempCelsius+32;
                champFarenheit.setText(""+tempFarenheit);
                }
                catch (NumberFormatException nfe) {
                    champFarenheit.setText(gestionnaire.getString(Ressources.FEN_CONV_ERR_FORMAT));
                }
                }
            else {
                try {
                    tempFarenheit = Double.parseDouble(champFarenheit.getText());
                    tempCelsius = (tempFarenheit - 32) *5./9;
                    champCelsius.setText(""+tempCelsius);
                }
                catch (NumberFormatException nfe) {
                    champCelsius.setText(gestionnaire.getString(Ressources.FEN_CONV_ERR_FORMAT));
                }
                
            }
        }
    }

	@Override
	public void traduire() {
		setTitle(gestionnaire.getString(Ressources.FEN_CONV_TITRE));
		actionConvertir.putValue(Action.NAME, gestionnaire.getString(Ressources.FEN_CONV_CONVERTIR));		
	}

}
