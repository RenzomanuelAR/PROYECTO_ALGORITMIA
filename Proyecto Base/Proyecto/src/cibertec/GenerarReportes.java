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

public class FrmGenerarReporte extends JDialog implements ActionListener, ItemListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scpScroll;
	private JLabel btnReporte;
	private JButton btnCerrar;
	private JComboBox cboReporte;
	private JTextArea txtS;
	
	int cven0, cven1, cven2, cven3, cven4;
	int canoptim0,canoptim1, canoptim2, canoptim3, canoptim4;
	double cuodia0, cuodia1, cuodia2, cuodia3, cuodia4;
	int cuniven0, cuniven1, cuniven2, cuniven3, cuniven4;
	double imptot0, imptot1, imptot2, imptot3, imptot4;
	String model0, model1, model2, model3, model4;
	String textos0, textos1, textos2, textos3, textos4;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			FrmGenerarReporte dialog = new FrmGenerarReporte();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FrmGenerarReporte() {
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
		FrmVender ven=new FrmVender();
		Proyecto prin=new Proyecto();
		int tipo;
		
		tipo= tiporeporte();
			mostrarmodelo();
		    mostrarventas();
			cantidadunidadesvendidas();
	        importetotal();
			aportecuotadiaria();
			mostrarrresultados(tipo);
			
			if (FrmVender.conuniven0 == 0)
			    canoptim0 = 0;
	else if (FrmVender.conuniven4 > Proyecto.cantidadOptima)
			    canoptim0 = (FrmVender.conuniven0 - Proyecto.cantidadOptima);
	else if (FrmVender.conuniven4 < Proyecto.cantidadOptima)
		    canoptim0 = (Proyecto.cantidadOptima - FrmVender.conuniven0);
	else
		canoptim0 = (FrmVender.conuniven4 - Proyecto.cantidadOptima);
	 	
	 	if (FrmVender.conuniven1 == 0)
		    canoptim1 = 0;
	else if (FrmVender.conuniven1 > Proyecto.cantidadOptima)
		    canoptim1 = (FrmVender.conuniven1 - Proyecto.cantidadOptima);
	else if (FrmVender.conuniven1 < Proyecto.cantidadOptima)
		    canoptim1 = (Proyecto.cantidadOptima - FrmVender.conuniven1);
	else
		canoptim1 = (FrmVender.conuniven1 - Proyecto.cantidadOptima);
   
	 	if (FrmVender.conuniven2 == 0)
		    canoptim2 = 0;
	else if (FrmVender.conuniven2 > Proyecto.cantidadOptima)
		    canoptim2 = (FrmVender.conuniven2 - Proyecto.cantidadOptima);
	else if (FrmVender.conuniven0 < Proyecto.cantidadOptima)
		    canoptim2 = (Proyecto.cantidadOptima - FrmVender.conuniven2);
	else
		canoptim2 = (FrmVender.conuniven2 - Proyecto.cantidadOptima);
   
	 	if (FrmVender.conuniven3 == 0)
		    canoptim3 = 0;
	else if (FrmVender.conuniven3 > Proyecto.cantidadOptima)
		    canoptim3 = (FrmVender.conuniven3 - Proyecto.cantidadOptima);
	else if (FrmVender.conuniven3 < Proyecto.cantidadOptima)
		    canoptim3 = (Proyecto.cantidadOptima - FrmVender.conuniven3);
	else
		canoptim3 = (FrmVender.conuniven3 - Proyecto.cantidadOptima);
  
	 	if (FrmVender.conuniven4 == 0)
		    canoptim4 = 0;
	else if (FrmVender.conuniven4 > Proyecto.cantidadOptima)
		    canoptim4 = (FrmVender.conuniven4 - Proyecto.cantidadOptima);
	else if (FrmVender.conuniven4 < Proyecto.cantidadOptima)
		    canoptim4 = (Proyecto.cantidadOptima - FrmVender.conuniven4);
	else
		canoptim4 = (FrmVender.conuniven4 - Proyecto.cantidadOptima);
			

			     if (FrmVender.conuniven0 == 0)
				     textos0 = "";
				 else if (FrmVender.conuniven0 > Proyecto.cantidadOptima)
					 textos0 = "más que la cantidad óptima";
				 else if (FrmVender.conuniven0 < Proyecto.cantidadOptima)
					 textos0 = "menos que la cantidad óptima";
				 else 
					 textos0 = "igual a la cantidad óptima";	     
			     if (FrmVender.conuniven1 == 0)
				     textos1 = "";
				 else if (FrmVender.conuniven1 > Proyecto.cantidadOptima)
					 textos1 = "más que la cantidad óptima";
				 else if (FrmVender.conuniven1 < Proyecto.cantidadOptima)
					 textos1 = "menos que la cantidad óptima";
				 else 
					 textos1 = "igual a la cantidad óptima";	 
			     if (FrmVender.conuniven2 == 0)
				     textos2 = "";
				 else if (FrmVender.conuniven2 > Proyecto.cantidadOptima)
					 textos2 = "más que la cantidad óptima";
				 else if (FrmVender.conuniven2 < Proyecto.cantidadOptima)
					 textos2 = "menos que la cantidad óptima";
				 else 
					 textos2 = "igual a la cantidad óptima";			 
			     if (FrmVender.conuniven3 == 0)
				     textos3 = "";
				 else if (FrmVender.conuniven3 > Proyecto.cantidadOptima)
					 textos3 = "más que la cantidad óptima";
				 else if (FrmVender.conuniven3 < Proyecto.cantidadOptima)
					 textos3 = "menos que la cantidad óptima";
				 else 
					 textos3 = "igual a la cantidad óptima";	 
			     if (FrmVender.conuniven4 == 0)
				     textos4 = "";
				 else if (FrmVender.conuniven4 > Proyecto.cantidadOptima)
					 textos4 = "más que la cantidad óptima";
				 else if (FrmVender.conuniven4 < Proyecto.cantidadOptima)
					 textos4 = "menos que la cantidad óptima";
				 else 
					 textos4 = "igual a la cantidad óptima";
	}
	int tiporeporte() {
		return cboReporte.getSelectedIndex();
	}
	void mostrarmodelo() {
		model0 =Proyecto.modelo0;
		model1 =Proyecto.modelo1;
		model2 =Proyecto.modelo2;
		model3 =Proyecto.modelo3;
		model4 =Proyecto.modelo4;
		}
	void mostrarventas() {
			cven0 = FrmVender.canven0;
			cven1 = FrmVender.canven1;
			cven2 = FrmVender.canven2;
		    cven3 = FrmVender.canven3;
			cven4 = FrmVender.canven4;
		}
	void cantidadunidadesvendidas() {
			cuniven0 = FrmVender.conuniven0;
			cuniven1 = FrmVender.conuniven1;
			cuniven2 = FrmVender.conuniven2;
			cuniven3 = FrmVender.conuniven3;
			cuniven4 = FrmVender.conuniven4;
		}
		void importetotal() {
			imptot0 =FrmVender.impcom0;
			imptot1 =FrmVender.impcom1;
			imptot2 =FrmVender.impcom2;
			imptot3 =FrmVender.impcom3;
			imptot4 =FrmVender.impcom4;
		}
		void aportecuotadiaria() {
			cuodia0 = (FrmVender.impcom0/5)/100;
			cuodia1 = (FrmVender.impcom1/5)/100;
			cuodia2 = (FrmVender.impcom2/5)/100;
			cuodia3 = (FrmVender.impcom3/5)/100;
			cuodia4 = (FrmVender.impcom4/5)/100;	
	}

	void mostrarrresultados(int tipo) {
		switch(tipo) {
		case 0 :
			txtS.setText("");
			imprimir(" VENTAS POR MODELO  :"+ "\n\n");
			imprimir(" Modelo                                                        : " + model0);
			imprimir(" Cantidad de ventas                                  : " + cven0);
			imprimir(" Cantidad total de unidades vendidas  : " + cuniven0);
			imprimir(" Importe total vendido                               : " + imptot0);
			imprimir(" Aporte a la cuota diaria                           : " + cuodia0 + "%"+"\n");
			imprimir(" Modelo                                                        : " + model1);
			imprimir(" Cantidad de ventas                                  : " + cven1);
			imprimir(" Cantidad total de unidades vendidas  : " + cuniven1);
			imprimir(" Importe total vendido                               : " + imptot1);
			imprimir(" Aporte a la cuota diaria                           : " + cuodia1 + "%"+"\n");
			imprimir(" Modelo                                                        : " + model2);
			imprimir(" Cantidad de ventas                                  : " + cven2);
			imprimir(" Cantidad total de unidades vendidas  : " + cuniven2);
			imprimir(" Importe total vendido                               : " + imptot2);
			imprimir(" Aporte a la cuota diaria                           : " + cuodia2 + "%"+"\n");	
		    imprimir(" Modelo                                                        : " + model3);
			imprimir(" Cantidad de ventas                                  : " + cven3);
			imprimir(" Cantidad total de unidades vendidas  : " + cuniven3);
			imprimir(" Importe total vendido                               : " + imptot3);
			imprimir(" Aporte a la cuota diaria                           : " + cuodia3 + "%"+"\n");
			imprimir(" Modelo                                                        : " + model4);
			imprimir(" Cantidad de ventas                                  : " + cven4);
			imprimir(" Cantidad total de unidades vendidas  : " + cuniven4);
			imprimir(" Importe total vendido                               : " + imptot4);
			imprimir(" Aporte a la cuota diaria                           : " + cuodia4 + "%");
			return;
		case 1 :
			txtS.setText("");
			imprimir(" VENTAS EN RELACIÓN A LA VENTA ÓPTIMA :"+ "\n\n");
			imprimir("  Modelo                                               : " + model0);
			imprimir(" Cantidad de unidades vendidas   : " + (cuniven0)+" "+"("+ (canoptim1)+ " " +(textos0)+")" +"\n");
			imprimir("  Modelo                                               : " + model1);
			imprimir(" Cantidad de unidades vendidas   : " + (cuniven1)+" "+"("+ (canoptim1)+ " " +(textos1)+")" +"\n");
			imprimir("  Modelo                                               : " + model2);
			imprimir(" Cantidad de unidades vendidas   : " + (cuniven2)+" "+"("+ (canoptim2)+ " " +(textos2)+")" +"\n");
			imprimir("  Modelo                                               : " + model3);
			imprimir(" Cantidad de unidades vendidas   : " + (cuniven3)+" "+"("+ (canoptim3)+ " " +(textos3)+")" +"\n");
			imprimir("  Modelo                                               : " + model4);
			imprimir(" Cantidad de unidades vendidas   : " + (cuniven4)+" "+"("+ (canoptim4)+ " " +(textos4)+")");
			return;
		case 2 :
			txtS.setText("");
			imprimir(" PRECIOS EN RELACIÓN AL PRECIO PROMEDIO :"+ "\n\n");
			imprimir(" Modelo : " + model0);
			imprimir(" Precio   : " +"S/ ."+" "+(Proyecto.precio0)+"(Mayor al promedio)"+"\n");
			imprimir(" Modelo : " + model1);
			imprimir(" Precio   : " +"S/ ."+" "+(Proyecto.precio1)+"(Mayor al promedio)"+"\n");
			imprimir(" Modelo : " + model2);
			imprimir(" Precio   : " +"S/ ."+" "+(Proyecto.precio2)+"(Menor al promedio)"+"\n");
			imprimir(" Modelo : " + model3);
			imprimir(" Precio   : " +"S/ ."+" "+(Proyecto.precio3)+"(Menor al promedio)"+"\n");
			imprimir(" Modelo : " + model4);
			imprimir(" Precio   : " +"S/ ."+" "+(Proyecto.precio4)+"(Menor al promedio)");
			return;
		default :
			txtS.setText("");
			imprimir(" PROMEDIOS, MENORES Y MAYORES :"+ "\n\n");
			imprimir(" Precio promedio             : " + "S/."+ Proyecto.precio0);
			imprimir(" Precio menor                   : " + "S/."+ Proyecto.precio3);
			imprimir(" Precio mayor                    : " + "S/."+ Proyecto.precio1 +"\n");
			imprimir(" Ancho promedio              : " + Proyecto.ancho4 +"  cm");
			imprimir(" Ancho menor                    : " + Proyecto.ancho0 +"  cm");
			imprimir(" Ancho mayor                    : " + Proyecto.ancho1 +"  cm" +"\n");
			imprimir(" Alto promedio                   : " + Proyecto.alto2 +"  cm");
			imprimir(" Alto menor                         : " + Proyecto.alto0 +"  cm");
			imprimir(" Alto mayor                          : " + Proyecto.alto3 +"  cm" +"\n");
			imprimir(" Fondo promedio               : " + Proyecto.fondo4 + "  cm");
			imprimir(" Fondo menor                    : " + Proyecto.fondo2 +"  cm");
			imprimir(" Fondo mayor                    : " + Proyecto.fondo1 +"  cm" +"\n");
			imprimir(" Quemadores promedio : " + Proyecto.quemadores3);
			imprimir(" Quemadores menor        : " + Proyecto.quemadores0);
			imprimir( "Quemadores mayor         : " + Proyecto.quemadores1);
		}
	
	}
		void imprimir(String cad) {
			txtS.append(cad+ "\n");
			
		}
	
}

