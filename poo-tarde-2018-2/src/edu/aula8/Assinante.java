package edu.aula8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class Assinante implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JLabel l = new JLabel();
		l.setText("Botão Apertado");
	}

}
