package edu.arkanoid;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Cenario extends Container implements KeyListener {
	private static final long serialVersionUID = 2657183153873526078L;

	private int barra_x = 375;
	private int barra_vel_x = 0;
	@Override
	public void paint(Graphics g) { 
		g.drawRect(5, 5, 790, 590);
		g.fillRect(barra_x, 500, 50, 10);
	}
	
	public void calcularRegras() { 
		barra_x = barra_x + barra_vel_x;
	}
	
	@Override
	public void keyPressed(KeyEvent tecla) {
		int key = tecla.getKeyCode();
		if (key == 37) { 
			barra_vel_x = -1;
		} else if (key == 39) { 
			barra_vel_x = 1;
		}
	}

	@Override
	public void keyReleased(KeyEvent tecla) {
		int key = tecla.getKeyCode();
		if (key == 37) { 
			barra_vel_x = 0;
		} else if (key == 39) { 
			barra_vel_x = 0;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	} 
}
