package cibertec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Tienda extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	// Datos m�nimos del primer colch�n
	public static String marca0 = "Suavestar";
	public static double precio0 = 499.0;
	public static int garantia0 = 7;
	public static String tamanio0 = "1 1/2 Plaza";
	public static String material0 = "Tela Tricot Acolchada";
	
	// Datos m�nimos del segundo colch�n
	public static String marca1 = "Springwall";
	public static double precio1 = 679.0;
	public static int garantia = 10;
	public static String tamanio1 = "2 Plazas";
	public static String material1 = "Tejido de Punto con Algodón Orgánico";
	
	// Datos m�nimos del tercer colch�n
	public static String marca2 = "Paraiso";
	public static double precio2 = 479.0;
	public static int garantia2 = 5;
	public static String tamanio2 = "1 1/2 Plazas";
	public static String material2 = "Tejido de Punto";
	
	// Datos m�nimos del cuarto colch�n
	public static String marca3 = "Drimer";
	public static double precio3 = 749.0;
	public static int garantia3 = 4;
	public static String tamanio3 = "Queen";
	public static String material3 = "Jacquard";
	
	// Datos m�nimos del quinto colch�n
	public static String marca4 = "Cisne";
	public static double precio4 = 389.0;
	public static int garantia4 = 2;
	public static String tamanio4 = "1 1/2 Plazas";
	public static String material4 = "Tejido de Punto";
	
	// Porcentajes de descuento
	public static double porcentaje1 = 7.5;
	public static double porcentaje2 = 10.0;
	public static double porcentaje3 = 12.5;
	public static double porcentaje4 = 15.0;
	
	// Cantidad �ptima de colchones vendidos
	public static int cantidadOptima = 10;
	
	// Cantidad m�nima de colchones adquiridos para acceder al obsequio
	public static int cantidadMinimaObsequiable = 3;
		
	// Obsequio por cantidad m�nima de colchones adquiridos
	public static String obsequio = "USB";
	
	// N�mero de cliente que recibe el premio sorpresa
	public static int numeroClienteSorpresa = 5;
	
	// Premio sorpresa
	public static String premioSorpresa = "Un polo";
	private JMenuBar menuBar;
	private JMenu mnArchivo;
	private JMenu mnMantenimiento;
	private JMenuItem mntmMantConsultar;
	private JMenuItem mntmMantModificar;
	private JMenuItem mntmMantListar;
	private JMenu mnVentas;
	private JMenuItem mntmVentVender;
	private JMenuItem mntmVentGenerar;
	private JMenu mnConfiguracion;
	private JMenuItem mntmConfDescuento;
	private JMenuItem mntmConfObsequio;
	private JMenuItem mntmConfCantidad;
	private JMenuItem mntmConfCuota;
	private JMenu mnAyuda;
	private JMenuItem mntmAyudaAcerca;
	private JMenuItem mntmArchSalir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda frame = new Tienda();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tienda() {
		setTitle("Tienda 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 762, 465);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnArchivo = new JMenu("Archivo");		
		menuBar.add(mnArchivo);
		
		mntmArchSalir = new JMenuItem("Salir");
		mntmArchSalir.addActionListener(this);
		mnArchivo.add(mntmArchSalir);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmMantConsultar = new JMenuItem("Consultar Cocina");
		mntmMantConsultar.addActionListener(this);
		mnMantenimiento.add(mntmMantConsultar);
		
		mntmMantModificar = new JMenuItem("Modificar Cocina");
		mntmMantModificar.addActionListener(this);
		mnMantenimiento.add(mntmMantModificar);
		
		mntmMantListar = new JMenuItem("Lista Cocinas");
		mntmMantListar.addActionListener(this);
		mnMantenimiento.add(mntmMantListar);
		
		mnVentas = new JMenu("Ventas");		
		menuBar.add(mnVentas);
		
		mntmVentVender = new JMenuItem("Vender");
		mntmVentVender.addActionListener(this);
		mnVentas.add(mntmVentVender);
		
		mntmVentGenerar = new JMenuItem("Generar Reportes");
		mntmVentGenerar.addActionListener(this);
		mnVentas.add(mntmVentGenerar);
		
		mnConfiguracion = new JMenu("Configuración");
		menuBar.add(mnConfiguracion);
		
		mntmConfDescuento = new JMenuItem("Configurar Descuentos");
		mntmConfDescuento.addActionListener(this);
		mnConfiguracion.add(mntmConfDescuento);
		
		mntmConfObsequio = new JMenuItem("Configurar Obsequios");
		mntmConfObsequio.addActionListener(this);
		mnConfiguracion.add(mntmConfObsequio);
		
		mntmConfCantidad = new JMenuItem("Configurar Cantidad Optima");
		mntmConfCantidad.addActionListener(this);
		mnConfiguracion.add(mntmConfCantidad);
		
		mntmConfCuota = new JMenuItem("Configurar Cuota Diaria");
		mntmConfCuota.addActionListener(this);
		mnConfiguracion.add(mntmConfCuota);
		
		mnAyuda = new JMenu("Ayuda");
		menuBar.add(mnAyuda);
		
		mntmAyudaAcerca = new JMenuItem("Acerca de la Tienda");
		mntmAyudaAcerca.addActionListener(this);
		mnAyuda.add(mntmAyudaAcerca);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public void actionPerformed(ActionEvent e) {

        if (e.getSource()==mntmArchSalir) {
        	System.exit(0);
        	 
        }
        
        if (e.getSource()==mntmMantConsultar) {
        	ConsultarCocina frame = new ConsultarCocina();
			frame.setVisible(true);
        }
        
        if (e.getSource()==mntmVentVender) {
        	Vender frame = new Vender();
			frame.setVisible(true);
        }
        if (e.getSource()==mntmVentGenerar) {
        	GenerarReportes frame = new GenerarReportes();
			frame.setVisible(true);
        }
 
	}
}
