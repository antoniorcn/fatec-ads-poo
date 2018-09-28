package edu.arkanoid;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Cenario extends Container implements KeyListener {
	private static final long serialVersionUID = 2657183153873526078L;

	private int barra_x = 375;
	private int barra_vel_x = 0;
	private int bola_x = 10;
	private int bola_y = 10;
	private int bola_vel_x = 1;
	private int bola_vel_y = 1;
	private int angulo = 0;
	private int angulo_vel = 1;

	private int barra_y = 500;
	
	public boolean overlap(int minA, int maxA, int minB, int maxB) { 
		return minB <= maxA && minA <= maxB;
	}
	
	public boolean rectColide(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2 ){
		boolean ox = overlap(ax1, ax2, bx1, bx2);
		boolean oy = overlap(ay1, ay2, by1, by2);
		return ox && oy;
	}
	
	@Override
	public void paint(Graphics g) { 
		g.drawRect(5, 5, 790, 590);
		g.fillRect(barra_x, barra_y , 50, 10);
		g.fillOval(bola_x, bola_y, 20, 20);
		g.fillArc(200, 200, 50, 50, angulo, 360 - angulo);
		
		angulo += angulo_vel;
		if (angulo > 90) { 
			angulo_vel = -1;
		}
		if (angulo < 0) { 
			angulo_vel = 1;
		}
	}
	
	public void calcularRegras() { 
		
		barra_x = barra_x + barra_vel_x;
		bola_x = bola_x + bola_vel_x;
		bola_y = bola_y + bola_vel_y;
		if (bola_x > 790) { 
			bola_vel_x = -1;
		}
		if (bola_x < 0) { 
			bola_vel_x = 1;
		}
		if (bola_y > 590) { 
			bola_vel_y = -1;
		}
		if (bola_y < 0) { 
			bola_vel_y = 1;
		}		
		
		if (rectColide(barra_x, barra_y, barra_x + 50, barra_y + 10,
						bola_x, bola_y, bola_x + 20, bola_y + 20)) { 
			bola_vel_y = -1;
		}
			
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
