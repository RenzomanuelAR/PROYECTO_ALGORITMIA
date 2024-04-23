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
			
			//	if (Vender.conuniven0 == 0)
			//   canoptim0 = 0;
			    //else if (Vender.conuniven4 > Tienda.cantidadOptima)
			    //	    canoptim0 = (Vender.conuniven0 - Tienda.cantidadOptima);
			    //else if (Vender.conuniven4 < Tienda.cantidadOptima)
			    //    canoptim0 = (Tienda.cantidadOptima - Vender.conuniven0);
			    //else
		//	canoptim0 = (Vender.conuniven4 - Tienda.cantidadOptima);
	 	
			//	if (Vender.conuniven1 == 0)
			//    canoptim1 = 0;
		    //else if (Vender.conuniven1 > Tienda.cantidadOptima)
			//   canoptim1 = (Vender.conuniven1 - Tienda.cantidadOptima);
			//else if (Vender.conuniven1 < Tienda.cantidadOptima)
			//	    canoptim1 = (Tienda.cantidadOptima - Vender.conuniven1);
			//else
			//	canoptim1 = (Vender.conuniven1 - Tienda.cantidadOptima);
   
			//	if (Vender.conuniven2 == 0)
			// canoptim2 = 0;
			//else if (Vender.conuniven2 > Tienda.cantidadOptima)
			//    canoptim2 = (Vender.conuniven2 - Tienda.cantidadOptima);
			//else if (Vender.conuniven0 < Tienda.cantidadOptima)
			//	    canoptim2 = (Tienda.cantidadOptima - Vender.conuniven2);
			//else
			//canoptim2 = (Vender.conuniven2 - Tienda.cantidadOptima);
   
			//	if (Vender.conuniven3 == 0)
			//   canoptim3 = 0;
			//else if (Vender.conuniven3 > Tienda.cantidadOptima)
			//    canoptim3 = (Vender.conuniven3 - Tienda.cantidadOptima);
			//else if (Vender.conuniven3 < Tienda.cantidadOptima)
			//	    canoptim3 = (Tienda.cantidadOptima - Vender.conuniven3);
			//else
			//	canoptim3 = (Vender.conuniven3 - Tienda.cantidadOptima);
  
			//	if (Vender.conuniven4 == 0)
			//    canoptim4 = 0;
			//else if (Vender.conuniven4 > Tienda.cantidadOptima)
			//  canoptim4 = (Vender.conuniven4 - Tienda.cantidadOptima);
			//else if (Vender.conuniven4 < Tienda.cantidadOptima)
			//canoptim4 = (Tienda.cantidadOptima - Vender.conuniven4);
			//else
			//canoptim4 = (Vender.conuniven4 - Tienda.cantidadOptima);
			

			// if (//Vender.conuniven0 == 0)
				     textos0 = "";
				     // else if (Vender.conuniven0 > Tienda.cantidadOptima)
					 textos0 = "más que la cantidad óptima";
					 // else if (Vender.conuniven0 < Tienda.cantidadOptima)
					 textos0 = "menos que la cantidad óptima";
					 //	 else 
					 textos0 = "igual a la cantidad óptima";	     
				 //  if (Vender.conuniven1 == 0)
				     textos1 = "";
				     // else if (Vender.conuniven1 > Tienda.cantidadOptima)
					 textos1 = "más que la cantidad óptima";
					 // else if (Vender.conuniven1 < Tienda.cantidadOptima)
					 textos1 = "menos que la cantidad óptima";
					 //	 else 
					 textos1 = "igual a la cantidad óptima";	 
				 //  if (Vender.conuniven2 == 0)
				     textos2 = "";
				     // else if (Vender.conuniven2 > Tienda.cantidadOptima)
					 textos2 = "más que la cantidad óptima";
					 // else if (Vender.conuniven2 < Tienda.cantidadOptima)
					 textos2 = "menos que la cantidad óptima";
					 // else 
					 textos2 = "igual a la cantidad óptima";			 
				 // if (Vender.conuniven3 == 0)
				     textos3 = "";
				     // else if (Vender.conuniven3 > Tienda.cantidadOptima)
					 textos3 = "más que la cantidad óptima";
					 // else if (Vender.conuniven3 < Tienda.cantidadOptima)
					 textos3 = "menos que la cantidad óptima";
					 // else 
					 textos3 = "igual a la cantidad óptima";	 
				 //  if (Vender.conuniven4 == 0)
				     textos4 = "";
				     // else if (Vender.conuniven4 > Tienda.cantidadOptima)
					 textos4 = "más que la cantidad óptima";
					 // else if (Vender.conuniven4 < Tienda.cantidadOptima)
					 textos4 = "menos que la cantidad óptima";
					 // else 
					 textos4 = "igual a la cantidad óptima";
	}
	int tiporeporte() {
		return cboReporte.getSelectedIndex();
	}
	void mostrarmodelo() {
		model0 =Tienda.marca0;
		model1 =Tienda.marca1;
		model2 =Tienda.marca2;
		model3 =Tienda.marca3;
		model4 =Tienda.marca4;
		}
	void mostrarventas() {
		    //cven0 = Vender.canven0;
			//cven1 = Vender.canven1;
			//cven2 = Vender.canven2;
			//cven3 = Vender.canven3;
		    //cven4 = Vender.canven4;
		}
	void cantidadunidadesvendidas() {
		//cuniven0 = Vender.conuniven0;
		//cuniven1 = Vender.conuniven1;
		//cuniven2 = Vender.conuniven2;
		//cuniven3 = Vender.conuniven3;
		//cuniven4 = Vender.conuniven4;
		}
		void importetotal() {
			//imptot0 =Vender.impcom0;
			//imptot1 =Vender.impcom1;
			//imptot2 =Vender.impcom2;
			//imptot3 =Vender.impcom3;
			//imptot4 =Vender.impcom4;
		}
		void aportecuotadiaria() {
			//cuodia0 = (Vender.impcom0/5)/100;
			//cuodia1 = (Vender.impcom1/5)/100;
			//cuodia2 = (Vender.impcom2/5)/100;
			//cuodia3 = (Vender.impcom3/5)/100;
			//cuodia4 = (Vender.impcom4/5)/100;	
	}

	void mostrarrresultados(int tipo) {
		switch(tipo) {
		case 0 :
			txtS.setText("");
			imprimir(" VENTAS POR MODELO  :"+ "\n\n");
			imprimir(" Marca                                                        : " + model0);
			imprimir(" Cantidad de ventas                                  : " + cven0);
			imprimir(" Cantidad total de unidades vendidas  : " + cuniven0);
			imprimir(" Importe total vendido                               : " + imptot0);
			imprimir(" Aporte a la cuota diaria                           : " + cuodia0 + "%"+"\n");
			imprimir(" Marca                                                        : " + model1);
			imprimir(" Cantidad de ventas                                  : " + cven1);
			imprimir(" Cantidad total de unidades vendidas  : " + cuniven1);
			imprimir(" Importe total vendido                               : " + imptot1);
			imprimir(" Aporte a la cuota diaria                           : " + cuodia1 + "%"+"\n");
			imprimir(" Marca                                                        : " + model2);
			imprimir(" Cantidad de ventas                                  : " + cven2);
			imprimir(" Cantidad total de unidades vendidas  : " + cuniven2);
			imprimir(" Importe total vendido                               : " + imptot2);
			imprimir(" Aporte a la cuota diaria                           : " + cuodia2 + "%"+"\n");	
		    imprimir(" Marca                                                        : " + model3);
			imprimir(" Cantidad de ventas                                  : " + cven3);
			imprimir(" Cantidad total de unidades vendidas  : " + cuniven3);
			imprimir(" Importe total vendido                               : " + imptot3);
			imprimir(" Aporte a la cuota diaria                           : " + cuodia3 + "%"+"\n");
			imprimir(" Marca                                                        : " + model4);
			imprimir(" Cantidad de ventas                                  : " + cven4);
			imprimir(" Cantidad total de unidades vendidas  : " + cuniven4);
			imprimir(" Importe total vendido                               : " + imptot4);
			imprimir(" Aporte a la cuota diaria                           : " + cuodia4 + "%");
			return;
		case 1 :
			txtS.setText("");
			imprimir(" VENTAS EN RELACIÓN A LA VENTA ÓPTIMA :"+ "\n\n");
			imprimir(" Marca                                               : " + model0);
			imprimir(" Cantidad de unidades vendidas   : " + (cuniven0)+" "+"("+ (canoptim1)+ " " +(textos0)+")" +"\n");
			imprimir(" Marca                                               : " + model1);
			imprimir(" Cantidad de unidades vendidas   : " + (cuniven1)+" "+"("+ (canoptim1)+ " " +(textos1)+")" +"\n");
			imprimir(" Marca                                               : " + model2);
			imprimir(" Cantidad de unidades vendidas   : " + (cuniven2)+" "+"("+ (canoptim2)+ " " +(textos2)+")" +"\n");
			imprimir(" Marca                                               : " + model3);
			imprimir(" Cantidad de unidades vendidas   : " + (cuniven3)+" "+"("+ (canoptim3)+ " " +(textos3)+")" +"\n");
			imprimir(" Marca                                               : " + model4);
			imprimir(" Cantidad de unidades vendidas   : " + (cuniven4)+" "+"("+ (canoptim4)+ " " +(textos4)+")");
			return;
		case 2 :
			txtS.setText("");
			imprimir(" PRECIOS EN RELACIÓN AL PRECIO PROMEDIO :"+ "\n\n");
			imprimir(" Marca    : " + model0);
			imprimir(" Precio   : " +"S/ ."+" "+(Tienda.precio0)+"(Mayor al promedio)"+"\n");
			imprimir(" Marca    : " + model1);
			imprimir(" Precio   : " +"S/ ."+" "+(Tienda.precio1)+"(Mayor al promedio)"+"\n");
			imprimir(" Marca    : " + model2);
			imprimir(" Precio   : " +"S/ ."+" "+(Tienda.precio2)+"(Menor al promedio)"+"\n");
			imprimir(" Marca    : " + model3);
			imprimir(" Precio   : " +"S/ ."+" "+(Tienda.precio3)+"(Menor al promedio)"+"\n");
			imprimir(" Marca    : " + model4);
			imprimir(" Precio   : " +"S/ ."+" "+(Tienda.precio4)+"(Menor al promedio)");
			return;
		default :
			txtS.setText("");
			imprimir(" PROMEDIOS, MENORES Y MAYORES :"+ "\n\n");
			imprimir(" Precio promedio                : " + "S/."+ Tienda.precio0);
			imprimir(" Precio menor                   : " + "S/."+ Tienda.precio3);
			imprimir(" Precio mayor                   : " + "S/."+ Tienda.precio1 + "\n");
			imprimir(" Garantia promedio              : " + Tienda.garantia4);
			imprimir(" Garantia menor                 : " + Tienda.garantia0);
			imprimir(" Garantia mayor                 : " + Tienda.garantia + "\n");
			imprimir(" Tamaño promedio                : " + Tienda.tamanio2);
			imprimir(" Tamaño menor                   : " + Tienda.tamanio0);
			imprimir(" Tamaño mayor                   : " + Tienda.tamanio3 + "\n");
			imprimir(" Material promedio              : " + Tienda.material0);
			imprimir(" Material menor                 : " + Tienda.material2);
			imprimir(" Material mayor                 : " + Tienda.material0);
		}
	
	}
		void imprimir(String cad) {
			txtS.append(cad+ "\n");
			
		}
	
}


