package edu.aula8;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class JanelaTeste {
	public static void main(String[] args) {
		JFrame janela = new JFrame("Teste de Botão");
		JPanel painel = new JPanel();
		JLabel lblTexto = new JLabel("Texto para ser mudado");
		JButton btnOk = new JButton("Aperte aqui");
		painel.add(lblTexto);
		painel.add(btnOk);
		
		janela.setContentPane(painel);
		
		btnOk.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lblTexto.setText("Botão apertado por meio de Classe anonima");
			}
		});
		
//		Ouvinte ouv = new Ouvinte(lblTexto);
//		ouv.setLabel(lblTexto);
		// btnOk.addActionListener( ouv );
		janela.setSize(400, 300);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
