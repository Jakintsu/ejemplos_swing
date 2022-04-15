package com.swing.blog;

import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;

public class VentanaOyente extends JFrame implements WindowListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextArea areaTexto;
	private JLabel etiqueta;
	private JPanel panel;
	private final String FIN = "\n";
	
	
	public VentanaOyente() throws HeadlessException {
		
		this.areaTexto = new JTextArea(15, 45);
		this.etiqueta = new JLabel("Eventos");
		areaTexto.setText("Texto inicial en el área de texto");
		this.panel = new JPanel();
		
		panel.add(etiqueta);
		panel.add(areaTexto);
		add(panel);
		//Con this es la propia ventana la que se registra a sí misma como oyente de eventos de ventana
		addWindowListener(this);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Ventana oyente");
		setVisible(true);
		pack();
	}

	//En los métodos de la interfaz WindowListener se añade una linea al contenido
	//del área del texto con la indicación del evento producido
	@Override
	public void windowOpened(WindowEvent e) {
		areaTexto.append(FIN +"Ventana abierta");

	}

	@Override
	public void windowClosing(WindowEvent e) {
		areaTexto.append(FIN +"Ventana cerrándose");

	}

	@Override
	public void windowClosed(WindowEvent e) {
		areaTexto.append(FIN +"cerrada");

	}

	@Override
	public void windowIconified(WindowEvent e) {
		areaTexto.append(FIN +"Ventana iconizada");

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		areaTexto.append(FIN +"Ventana desiconizada");

	}

	@Override
	public void windowActivated(WindowEvent e) {
		areaTexto.append(FIN +"Ventana activada");

	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		areaTexto.append(FIN +"Ventana desactivada");

	}
	
	public static void main(String[] args) {
		VentanaOyente ventana = new VentanaOyente();
	}

}
