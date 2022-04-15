package com.swing.blog;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.event.MouseInputAdapter;

public class VentanaOyenteAdaptador extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea areaTexto;
	public JButton boton;

	public VentanaOyenteAdaptador() throws HeadlessException {
		boton = new JButton("Limpiar");
		areaTexto = new JTextArea(12, 30);
		JPanel panel = new JPanel();
		panel.add(boton);
		panel.add(areaTexto);
		add(panel);

		ActionListener oyenteBoton = new OyenteAccion();
		// Se crea un oyente de ratón que se asocia al área de texto
		MouseListener oyenteRaton = new OyenteRaton();
		areaTexto.addMouseListener(oyenteRaton);

	}

	class OyenteRaton extends MouseInputAdapter {
		@Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			areaTexto.append("Se ha hecho click \n");
			areaTexto.append(" Posición X: " + e.getX());
			areaTexto.append(" Posicion Y: " + e.getY());
		}

		@Override
		public void mousePressed(MouseEvent e) {
			if ((e.getModifiers() & InputEvent.BUTTON3_MASK) != 0) {
				areaTexto.append("Se ha pulsado el botón de ratón\n");
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			areaTexto.append("Se ha soltado el botón del ratón\n");
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			areaTexto.append("El ratón ha entrado en el componente\n");

		}

		@Override
		public void mouseExited(MouseEvent e) {
			areaTexto.append("El ratón ha salido del componente\n");

		}
	}

	// Oyente de acciones que limpia el contenido del área de texto
	class OyenteAccion implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == boton) {

				areaTexto.setText("");
			}

		}
	}

	public static void main(String[] args) {
		VentanaOyenteAdaptador ventana = new VentanaOyenteAdaptador();
		// En este caso, las propiedades de ventana de la aplicación se establecen en el
		// programa principal
		ventana.setTitle("Eventos del ratón");
		ventana.pack();
		ventana.setVisible(true);
	}
}
