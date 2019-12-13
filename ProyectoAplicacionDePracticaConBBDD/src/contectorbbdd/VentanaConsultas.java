package contectorbbdd;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class VentanaConsultas extends JFrame implements ActionListener{

	public DialogoAutenticar autenticador;
	public TablaResultados resultados;
	public AreaConsulta area;
	public PanelBotonesConsulta botones;
	public Controlador controlDe;
	
	public VentanaConsultas() {
		iniciaComponentes();
		agregaComponentes();
		agregaListeners();
		inicio();
	}
	
	private void iniciaComponentes() {
		autenticador = new DialogoAutenticar();
		resultados = new TablaResultados();
		area = new AreaConsulta();
		botones = new PanelBotonesConsulta();
	}
	
	private void agregaComponentes() {
		add(resultados, "South");
		add(area, "West");
		add(botones, "East");
		pack();
		setLocation(100, 100);
	}
	
	private void agregaListeners() {
		this.autenticador.panel.aceptar.addActionListener(this);
		this.autenticador.panel.cancelar.addActionListener(this);
		botones.consultar.addActionListener(this);
		botones.salir.addActionListener(this);
	}
	
	private void inicio() {
		controlDe = new Controlador();
		setVisible(true);
		autenticador.setLocationRelativeTo(this);
		autenticador.setModal(true);
		autenticador.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent evt) {
		controlDe.acciones(this, evt);
	}
}
