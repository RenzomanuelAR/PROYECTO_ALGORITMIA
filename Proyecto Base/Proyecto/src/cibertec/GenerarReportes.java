package cibertec;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class GenerarReportes extends JDialog implements ActionListener, ItemListener {
	

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scpScroll;
	private JLabel btnReporte;
	private JButton btnCerrar;
	private JComboBox cboReporte;
	private JTextArea txtS;
	
	
	
	
	String model0, model1, model2, model3, model4;;
	int cantidad;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GenerarReportes dialog = new GenerarReportes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GenerarReportes() {
		setTitle("Generar reportes");
		setBounds(100, 100, 666, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scpScroll = new JScrollPane();
		scpScroll.setBounds(10, 55, 630, 195);
		contentPanel.add(scpScroll);
		
		txtS = new JTextArea();
		scpScroll.setViewportView(txtS);
		
		btnReporte = new JLabel("tipo de reportes");
		btnReporte.setBounds(10, 24, 93, 14);
		contentPanel.add(btnReporte);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(551, 20, 89, 23);
		contentPanel.add(btnCerrar);
		
		cboReporte = new JComboBox();
		cboReporte.addItemListener(this);
		cboReporte.setModel(new DefaultComboBoxModel(new String[] {"Ventas por modelo", "Ventas en relación a la venta óptima", "Precios en relación al precio promedio", "Promedios, menores y mayores"}));
		cboReporte.setBounds(113, 20, 336, 22);
		contentPanel.add(cboReporte);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnNewButton(e);
		}
	}
	protected void actionPerformedBtnNewButton(ActionEvent e) {
		dispose();
	}
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboReporte) {
			itemStateChangedCboReporte(e);
		}
	}
	protected void itemStateChangedCboReporte(ItemEvent e) {
		Vender ven=new Vender();
		Tienda prin=new Tienda();
		
		int tipo;
		tipo= tiporeporte();
			mostrarmodelo();
		    mostrarventas();
			cantidadunidadesvendidas();
	        importetotal();
			aportecuotadiaria();
			mostrarrresultados(tipo);
			
		
	}
	int tiporeporte() {
		return cboReporte.getSelectedIndex();
	}
	void mostrarmodelo() {
		model0 =Tienda.modelo0;
		model1 =Tienda.modelo1;
		model2 =Tienda.modelo2;
		model3 =Tienda.modelo3;
		model4 =Tienda.modelo4;
		}
	void mostrarventas() {
		  
		
		}
	void cantidadunidadesvendidas() {
	
		
		
		}
		void importetotal() {
		
		}
		void aportecuotadiaria() {
		
	}

	void mostrarrresultados(int tipo) {
		switch(tipo) {
		case 0 :
			txtS.setText("");
			imprimir(" VENTAS POR MODELO  :"+ "\n\n");
			imprimir(" Modelo                                      : " + model0);
			imprimir(" Cantidad de ventas                          : ");
			imprimir(" Cantidad total de unidades vendidas         : ");
			imprimir(" Importe total vendido                       : ");
			imprimir(" Aporte a la cuota diaria                    : " +"%");
			imprimir(" Modelo                                      : " + model1);
			imprimir(" Cantidad de ventas                          : ");
			imprimir(" Cantidad total de unidades vendidas         : ");
			imprimir(" Importe total vendido                       : "  );
			imprimir(" Aporte a la cuota diaria                    : "+"%");
			imprimir(" Modelo                                      : " + model2);
			imprimir(" Cantidad de ventas                          : " );
			imprimir(" Cantidad total de unidades vendidas         : " );
			imprimir(" Importe total vendido                       : " );
			imprimir(" Aporte a la cuota diaria                    : " + "%");	
		    imprimir(" Modelo                                      : " + model3);
			imprimir(" Cantidad de ventas                          : " );
			imprimir(" Cantidad total de unidades vendidas         : " );
			imprimir(" Importe total vendido                       : " );
			imprimir(" Aporte a la cuota diaria                    : " + "%");
			imprimir(" Modelo                                      : " + model4);
			imprimir(" Cantidad de ventas                          : " );
			imprimir(" Cantidad total de unidades vendidas         : " );
			imprimir(" Importe total vendido                       : "  );
			imprimir(" Aporte a la cuota diaria                    : " + "%");
			return;
		case 1 :
			txtS.setText("");
			imprimir(" VENTAS EN RELACIÓN A LA VENTA ÓPTIMA   :");
			imprimir(" Modelo                                 : " + model0);
			imprimir(" Cantidad de unidades vendidas          : ");
			imprimir(" Modelo                                 : " + model1);
			imprimir(" Cantidad de unidades vendidas          : ");
			imprimir(" Modelo                                 : " + model2);
			imprimir(" Cantidad de unidades vendidas          : " );
			imprimir(" Modelo                                 : " + model3);
			imprimir(" Cantidad de unidades vendidas          : ");
			imprimir(" Modelo                                 : " + model4);
			imprimir(" Cantidad de unidades vendidas          : ");
			return;
		case 2 :
			txtS.setText("");
			imprimir(" PRECIOS EN RELACIÓN AL PRECIO PROMEDIO :");
			imprimir(" Modelo    : " + model0);
			imprimir(" Precio    : " +"S/ ."+" "+(Tienda.precio0)+"(Mayor al promedio)");
			imprimir(" Modelo    : " + model1);
			imprimir(" Precio    : " +"S/ ."+" "+(Tienda.precio1)+"(Mayor al promedio)");
			imprimir(" Modelo    : " + model2);
			imprimir(" Precio    : " +"S/ ."+" "+(Tienda.precio2)+"(Menor al promedio)");
			imprimir(" Modelo    : " + model3);
			imprimir(" Precio    : " +"S/ ."+" "+(Tienda.precio3)+"(Menor al promedio)");
			imprimir(" Modelo    : " + model4);
			imprimir(" Precio    : " +"S/ ."+" "+(Tienda.precio4)+"(Menor al promedio)");
			return;
		default :
			txtS.setText("");
			imprimir(" PROMEDIOS, MENORES Y MAYORES  : ");
			imprimir("");
			imprimir(" Precio promedio               : " + "S/."+ Tienda.precio0);
			imprimir(" Precio menor                  : " + "S/."+ Tienda.precio3);
			imprimir(" Precio mayor                  : " + "S/."+ Tienda.precio1);
			imprimir("");
			imprimir(" Ancho promedio                : " + Tienda.ancho4);
			imprimir(" Ancho menor                   : " + Tienda.ancho0);
			imprimir(" Ancho mayor                   : " + Tienda.ancho1);
			imprimir("");
			imprimir(" Fondo promedio                : " + Tienda.fondo4);
			imprimir(" Fondo menor                   : " + Tienda.fondo2);
			imprimir(" Fondo mayor                   : " + Tienda.fondo1);
			imprimir("");
			imprimir(" Alto promedio                 : " + Tienda.alto4);
			imprimir(" Alto menor                    : " + Tienda.alto2);
			imprimir(" Alto mayor                    : " + Tienda.alto3);
			imprimir("");
			imprimir(" Quemadores promedio           : " + Tienda.quemadores3);
			imprimir(" Quemadores menor              : " + Tienda.quemadores0);
			imprimir(" Quemadores mayor              : " + Tienda.quemadores1);
		}
	
	}
		void imprimir(String cad) {
			txtS.append(cad+ "\n");
			
		}
	
}





