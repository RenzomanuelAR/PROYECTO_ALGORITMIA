package cibertec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Tienda extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	// Datos mínimos de la primera cocina 
	
	public static String modelo0 = "Mabe EMP6120PG0"; 
	public static double precio0 = 949.0;
	
	public static double fondo0 = 58.6; 
	public static double ancho0 = 60.0; 
	public static double alto0 = 91.0; 
	public static int quemadores0 = 4; 
	// Datos mínimos de la segunda cocina 
	public static String modelo1 = "Indurama Parma"; 
	public static double precio1 = 1089.0; 
	public static double ancho1 = 80.0; 
	public static double alto1 = 94.0;  
	public static double fondo1 = 67.5; 
	public static int quemadores1 = 6; 
	// Datos mínimos de la tercera cocina 
	public static String modelo2 = "Sole COSOL027"; 
	public static double precio2 = 850.0; 
	public static double ancho2 = 60.0; 
	public static double alto2 = 90.0; 
	public static double fondo2 = 50.0; 
	public static int quemadores2 = 4; 
	// Datos mínimos de la cuarta cocina 
	public static String modelo3 = "Coldex CX602"; 
	public static double precio3 = 629.0; 
	public static double ancho3 = 61.6; 
	public static double alto3 = 95.0; 
	public static double fondo3 = 51.5; 
	public static int quemadores3 = 5; 
	// Datos mínimos de la quinta cocina 
	public static String modelo4 = "Reco Dakota"; 
	public static double precio4 = 849.0; 
	public static double ancho4 = 75.4; 
	public static double alto4 = 94.5; 
	public static double fondo4 = 66.0; 
	public static int quemadores4 = 5; 
	// Porcentajes de descuento 
	public static double porcentaje1 = 7.5; 
	public static double porcentaje2 = 10.0; 
	public static double porcentaje3 = 12.5; 
	public static double porcentaje4 = 15.0; 
	// Obsequios 
	public static String obsequio1 = "Cafetera"; 
	public static String obsequio2 = "Licuadora"; 
	public static String obsequio3 = "Extractor"; 
	// Cantidad óptima de unidades vendidas 
	public static int cantidadOptima = 30; 
	// Cuota diaria 
	public static double cuotaDiaria = 75000;
	

	public static Object[][] datosCocinas = {
		        { "Mabe EMP6120PG0", 949.0, 60.0, 91.0, 58.6, 4 },
		        { "Indurama Parma", 1089.0, 80.0, 94.0, 67.5, 6 },
		        { "Sole COSOL027", 850.0, 60.0, 90.0, 50.0, 4 },
		        { "Coldex CX602", 629.0, 61.6, 95.0, 51.5, 5 },
		        { "Reco Dakota", 849.0, 75.4, 94.5, 66.0, 5 }
	 };
	 
	public static List<Object[]> datosVentas = new ArrayList<Object[]>();
	
	// contador de ventas
	public static int contarVentas = 0; 
	//Acumulador Total Ventas
	public static Double totalVentas = 0.0;
	public static Double porcentajeVentas = 0.0;
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
	private JMenuItem mntmEjemploReporte;

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
		
		mntmEjemploReporte = new JMenuItem("Ejemplo Reporte");
		mntmEjemploReporte.addActionListener(this);
		mnVentas.add(mntmEjemploReporte);
		
		
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
        
        if (e.getSource()==mntmMantModificar) {
        	ModificarCocina frame = new ModificarCocina();
			frame.setVisible(true);
        }
        
        if (e.getSource()==mntmMantListar) {
        	ListaCocina frame = new ListaCocina();
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
        
        if (e.getSource()==mntmConfDescuento) {
        	ConfigurarDescuentos frame = new ConfigurarDescuentos();
			frame.setVisible(true);
        }
        
        if (e.getSource()==mntmConfObsequio) {
        	ConfigurarObsequios frame = new ConfigurarObsequios();
			frame.setVisible(true);
        }
        
        if (e.getSource()==mntmConfCantidad) {
        	ConfigurarCantidadOptima frame = new ConfigurarCantidadOptima();
			frame.setVisible(true);
        }
        
        if (e.getSource()==mntmConfCuota) {
        	ConfigurarCuotaDiaria frame = new ConfigurarCuotaDiaria();
			frame.setVisible(true);
        }
        
        if (e.getSource()==mntmAyudaAcerca) {
        	AcercaTienda frame = new AcercaTienda();
			frame.setVisible(true);
        }
 
        if (e.getSource()==mntmEjemploReporte) {
        	EjemploReporte frame = new EjemploReporte();
			frame.setVisible(true);
        }
 
	}
}
