package edu.aula8;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
public class Ouvinte implements ActionListener {
	
	private JLabel label;	
	
	public Ouvinte(JLabel value) { 
		label = value;
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println("Botão apertado");
		label.setText("Botão Apertado");
	}
}
