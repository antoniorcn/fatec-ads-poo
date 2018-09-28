package edu.arkanoid;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Arkanoid {
	private JFrame janela;
	public Arkanoid() { 
		janela = new JFrame("Jogo Arkanoid");
		Cenario scene = new Cenario();
		janela.setContentPane(scene);
		
		janela.setSize(800, 600);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		scene.setFocusable(true);
		scene.requestFocus();
		
		while (true) { 
			scene.calcularRegras();
			scene.repaint();
			scene.addKeyListener(scene);
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new Arkanoid();
	}
}
