package edu.aula8;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Ouvinte implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Botão apertado");
	}
}
