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
import java.util.List;
import java.awt.event.ItemEvent;

public class GenerarReportes extends JDialog implements ActionListener, ItemListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JScrollPane scpScroll;
	private JLabel btnReporte;
	private JButton btnCerrar;
	private JComboBox cboReporte;
	private JTextArea txtS;
	
    public static Object[][] datosReportes = {
	        { "Mabe EMP6120PG0", 0, 0, 0 },
	        { "Indurama Parma", 0, 0, 0 },
	        { "Sole COSOL027", 0, 0, 0 },
	        { "Coldex CX602", 0, 0, 0  },
	        { "Reco Dakota",0, 0, 0 }
    };
    
	//Declaracion de variables globales
	String reportVenta, reportveoptm, txtcanopt, model;
	Integer canunven, canvenopt;
	Double imptoven, aportcuodiaria;
	//Es una lista de ventas guardadas (Variable Global)
	List<Object[]> listaVentas = Tienda.datosVentas;

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
		cboReporte.setModel(
				new DefaultComboBoxModel(new String[] { "Ventas por modelo", "Ventas en relación a la venta óptima",
						"Precios en relación al precio promedio", "Promedios, menores y mayores" }));
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
		//Declaracion de variables locales
		int tipo;
		//Entrada de datos
		tipo = tiporeporte();
		reportedeVentas();
		reporteVentaOptima();
		imprimirDatos(tipo);
	}
	int tiporeporte() {
		return cboReporte.getSelectedIndex();
	}
	//Metodo de reporte de ventas
	void reportedeVentas() {
		 reportVenta = "VENTAS POR MODELO :\n\n";
		 int cantidadCocinas = datosReportes.length;
		 
		 for(Object[] filaReporte : datosReportes) {
			 filaReporte[1] = 0 ;
			 filaReporte[2] = 0 ;
			 filaReporte[3] = 0 ;
				//recorrer cada fila de ventas
				for (Object[] filaVenta : listaVentas) {
					 if(filaReporte[0].equals(filaVenta[0])) {
						 filaReporte[1] = Integer.parseInt(filaReporte[1].toString()) + Integer.parseInt(filaVenta[2].toString()) ;
						 filaReporte[2] = Double.parseDouble(filaReporte[1].toString()) + Double.parseDouble(filaVenta[5].toString()) ;
						 filaReporte[3] = Double.parseDouble(filaReporte[2].toString()) / cantidadCocinas /100 ;
					 }
					
				}
				
		 }
			
		//Imprimir acumulado de ventas por cada cocina
		for (Object[] filaReporte : datosReportes) {
			//Guardar los datos respectivamente
			reportVenta += "Modelo                            : " + filaReporte[0] + "\n";
			reportVenta += "Cantidad de unidades vendidas     : " + filaReporte[1] + "\n";
			reportVenta += "Importe total vendido             : " + "S/." + filaReporte[2] + "\n";
			reportVenta += "Aporte a la cuota diaria          : " + filaReporte[3] + "%" + "\n";
			reportVenta += "\n";
			
		}
	}
	
	
	//Metodo de ventas en relacion a la venta optima
	void reporteVentaOptima() {
		 
		 for(Object[] filaReporte : datosReportes) {
			 filaReporte[1] = 0 ;
			 filaReporte[2] = 0 ;
			 filaReporte[3] = 0 ;
				//recorrer cada fila de ventas
				for (Object[] filaVenta : listaVentas) {
					 if(filaReporte[0].equals(filaVenta[0])) {
						 filaReporte[1] = Integer.parseInt(filaReporte[1].toString()) + Integer.parseInt(filaVenta[2].toString()) ;
					 }
					
				}
				
		 }		
		
		reportveoptm = "VENTAS EN RELACIÓN A LA VENTA ÓPTIMA :\n\n";
			//Utilizar datos de las ventas guardadas  
		for (Object[] fila : datosReportes) {
			String cantidadStr="";
			//Asignar una variable a respectiva fila de datos
			canunven = Integer.parseInt(fila[1].toString());
			model = String.valueOf(fila[0].toString());
            //Calcular venta en relacion a la venta optima
			if (canunven > Tienda.cantidadOptima) {
				canvenopt = (canunven - Tienda.cantidadOptima);
				txtcanopt = "más que la cantidad óptima";
			} else if (canunven < Tienda.cantidadOptima) {
				canvenopt = (Tienda.cantidadOptima - canunven);
				txtcanopt = "menos que la cantidad óptima";
			} else {
				canvenopt = (canunven - Tienda.cantidadOptima);
				txtcanopt = "igual a la cantidad óptima";
			}
			
			if(canvenopt==0) {
				cantidadStr="";
			}else {
				cantidadStr = canvenopt.toString();
			}
			reportveoptm += "Modelo                          : " + model + "\n";
			reportveoptm += "Cantidad de unidades vendidas   : " + canunven + "(" + cantidadStr + " " + txtcanopt + ")" + "\n";
			reportveoptm += "\n";
		}
	}
    //Mostrar reporte respectivamente
	void imprimirDatos(int tipo) {
		switch (tipo) {
		case 0:
			txtS.setText("");
			imprimir(reportVenta);
			imprimir("CANTIDAD DE VENTAS  : " + Tienda.contarVentas  + "\n");
			break;
		case 1:
			txtS.setText("");
			imprimir(reportveoptm);
			break;
		case 2:
			double promedioPrecio =0,sumaPrecios=0;
			int cantidadCocinas = Tienda.datosCocinas.length;
			
			 for(Object[] filaCocina : Tienda.datosCocinas) {
				sumaPrecios += Double.parseDouble(filaCocina[1].toString());
			 }		
			
			promedioPrecio = sumaPrecios / cantidadCocinas;
			 
			txtS.setText("");
			imprimir(" PRECIOS EN RELACIÓN AL PRECIO PROMEDIO  : ");
			imprimir(" Precio promnedio de una Cocina  : S/. " + promedioPrecio);
			imprimir("");
			for(Object[] fila : Tienda.datosCocinas) {
				String descripcion="";
				if(Double.parseDouble(fila[1].toString()) > promedioPrecio) {
					descripcion = " (Mayor al promedio)";
				}else if(Double.parseDouble(fila[1].toString()) < promedioPrecio) {
					descripcion = " (Menor al promedio)";
				}else {
					descripcion = " (Igual al promedio)";
				}				
				imprimir("");
				imprimir(" Modelo     : " + fila[0]);
				imprimir(" Precio     : " + "S/ ." + " " + fila[1] + descripcion);
				
			}
			break;
		default:
			txtS.setText("");
			imprimir(" PROMEDIOS, MENORES Y MAYORES  : ");
			
			//Inicio Promedio, mayor, menor del Precio
			double precioPromedio = 0, precioMenor = 0, precioMayor = 0, sumaPrecio = 0;
			double precioActual=0;
			
			int flat=0;
			for(Object[] fila : Tienda.datosCocinas) {
				precioActual = Double.parseDouble(fila[1].toString());
				sumaPrecio += precioActual;
				if(flat == 0) {
					precioMenor = precioActual;
					precioMayor = precioActual;
					flat = 1;
				}
				
				//Hallar el precio menor
				if (precioActual < precioMenor) {
					precioMenor = precioActual;
				}
				
				//Hallar el precio mayor
				if (precioActual > precioMayor) {
					precioMayor = precioActual;
				}
			}
			precioPromedio = sumaPrecio / 5;
			
			imprimir("");
			imprimir(" Precio promedio               : " + "S/." + precioPromedio);
			imprimir(" Precio menor                  : " + "S/." + precioMenor);
			imprimir(" Precio mayor                  : " + "S/." + precioMayor);
			//fin
			
//			imprimir("");
//			imprimir(" Ancho promedio                : " + Tienda.ancho4);
//			imprimir(" Ancho menor                   : " + Tienda.ancho0);
//			imprimir(" Ancho mayor                   : " + Tienda.ancho1);
			
			
//			imprimir("");
//			imprimir(" Fondo promedio                : " + Tienda.fondo4);
//			imprimir(" Fondo menor                   : " + Tienda.fondo2);
//			imprimir(" Fondo mayor                   : " + Tienda.fondo1);
//			imprimir("");
			
//			imprimir(" Alto promedio                 : " + Tienda.alto4);
//			imprimir(" Alto menor                    : " + Tienda.alto2);
//			imprimir(" Alto mayor                    : " + Tienda.alto3);
//			imprimir("");
			
//			imprimir(" Quemadores promedio           : " + Tienda.quemadores3);
//			imprimir(" Quemadores menor              : " + Tienda.quemadores0);
//			imprimir(" Quemadores mayor              : " + Tienda.quemadores1);
		}
	}
	void imprimir(String cad) {
		txtS.append(cad + "\n");
	}
}
