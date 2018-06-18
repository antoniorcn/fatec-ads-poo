package edu.curso.aula10;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
public class Boundary implements ActionListener {
	private JLabel lblTexto;

	public Boundary() { 
		JFrame janela = new JFrame("Teste de Botão");
		JPanel painel = new JPanel();
		JButton btnOk = new JButton("Ok");
		lblTexto = new JLabel("Texto");
		janela.setContentPane( painel );
		painel.add(lblTexto);
		painel.add( btnOk );
		btnOk.addActionListener( this );
		janela.setSize(200, 200);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Boundary();
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		lblTexto.setText( "Pressionado" );
	}
}
