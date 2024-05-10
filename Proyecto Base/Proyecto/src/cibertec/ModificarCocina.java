package cibertec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarCocina extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblAncho;
	private JLabel lblAlto;
	private JLabel lblFondo;
	private JLabel lblQuemadores;
	private JTextField textPrecio;
	private JTextField textAncho;
	private JTextField textAlto;
	private JTextField textFondo;
	private JTextField textQuemadores;
	private JComboBox comboBoxModelo;
	private JButton btnGrabar;
	private JButton btnCerrar;
	
<<<<<<< HEAD

=======
//	public static Object[][] datosCocinas = {
//	        { "Mabe EMP6120PG0", 949.0, 60.0, 91.0, 58.6, 4 },
//	        { "Indurama Parma", 1089.0, 80.0, 94.0, 67.5, 6 },
//	        { "Sole COSOL027", 850.0, 60.0, 90.0, 50.0, 4 },
//	        { "Coldex CX602", 629.0, 61.6, 95.0, 51.5, 5 },
//	        { "Reco Dakota", 849.0, 75.4, 94.5, 66.0, 5 }
// };
>>>>>>> 1c1794877c01b72473f11db8ff333db7354b1bde
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarCocina frame = new ModificarCocina();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ModificarCocina() {
		setTitle("Modificar Cocina");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblModelo.setBounds(32, 42, 96, 13);
		contentPane.add(lblModelo);
		
		lblPrecio = new JLabel("Precio (S/.)");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecio.setBounds(32, 65, 96, 13);
		contentPane.add(lblPrecio);
		
		lblAncho = new JLabel("Ancho");
		lblAncho.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAncho.setBounds(32, 88, 96, 13);
		contentPane.add(lblAncho);
		
		lblAlto = new JLabel("Alto (cm)");
		lblAlto.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAlto.setBounds(32, 111, 96, 13);
		contentPane.add(lblAlto);
		
		lblFondo = new JLabel("Fondo (cm)");
		lblFondo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFondo.setBounds(32, 134, 96, 13);
		contentPane.add(lblFondo);
		
		lblQuemadores = new JLabel("Quemadores");
		lblQuemadores.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQuemadores.setBounds(32, 157, 96, 13);
		contentPane.add(lblQuemadores);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(156, 63, 154, 19);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);
		
		textAncho = new JTextField();
		textAncho.setBounds(156, 86, 154, 19);
		contentPane.add(textAncho);
		textAncho.setColumns(10);
		
		textAlto = new JTextField();
		textAlto.setBounds(156, 109, 154, 19);
		contentPane.add(textAlto);
		textAlto.setColumns(10);
		
		textFondo = new JTextField();
		textFondo.setBounds(156, 132, 154, 19);
		contentPane.add(textFondo);
		textFondo.setColumns(10);
		
		textQuemadores = new JTextField();
		textQuemadores.setBounds(156, 155, 154, 19);
		contentPane.add(textQuemadores);
		textQuemadores.setColumns(10);
		
		comboBoxModelo = new JComboBox();
		comboBoxModelo.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBoxModelo.setModel(new DefaultComboBoxModel(new String[] {"Mabe EMP6120PG0", "Indurama Parma", "Sole COSOL027", "Coldex CX602", "Reco Dakota"}));
		
		comboBoxModelo.addActionListener(e -> {
            String seleccion = (String) comboBoxModelo.getSelectedItem();
            mostrarDatosCocina(seleccion);
        });
		
		mostrarDatosCocina("MabeEMP6120PG0");
		
		comboBoxModelo.setBounds(156, 39, 154, 21);
		contentPane.add(comboBoxModelo);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCerrar.setBounds(341, 39, 85, 21);
		contentPane.add(btnCerrar);
		
		btnGrabar = new JButton("Grabar");
		btnGrabar.addActionListener(this);
		btnGrabar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGrabar.setBounds(341, 62, 85, 21);
		contentPane.add(btnGrabar);
		
		// Mostrar automáticamente los datos de la primera cocina al iniciar la ventana
        mostrarDatosCocina((String) Tienda.datosCocinas[0][0]);
        
	}
	
    private void mostrarDatosCocina(String modeloSeleccionado) {
        // Buscar el modelo seleccionado en los datos de cocinas
        for (Object[] cocina : Tienda.datosCocinas) {
            if (cocina[0].equals(modeloSeleccionado)) {
                // Mostrar los datos en los campos de texto
                textPrecio.setText(String.valueOf(cocina[1]));
                textAncho.setText(String.valueOf(cocina[2]));
                textAlto.setText(String.valueOf(cocina[3]));
                textFondo.setText(String.valueOf(cocina[4]));
                textQuemadores.setText(String.valueOf(cocina[5]));
                break;
            }
        }
    }
    
    
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnGrabar) {		
			actionPerformedBtnGrabar(e);
			dispose ();
		}
	}
	protected void actionPerformedBtnGrabar(ActionEvent e) {
		
<<<<<<< HEAD
		// Obtener el modelo seleccionado
	    String modeloSeleccionado = (String) comboBoxModelo.getSelectedItem();
	    
	    // Obtener los valores de los campos de texto
	    double precio;
	    double ancho;
	    double alto;
	    double fondo;
	    int quemadores;
	    
	    try {
	        precio = Double.parseDouble(textPrecio.getText());
	        ancho = Double.parseDouble(textAncho.getText());
	        alto = Double.parseDouble(textAlto.getText());
	        fondo = Double.parseDouble(textFondo.getText());
	        quemadores = Integer.parseInt(textQuemadores.getText());
	    } catch (NumberFormatException ex) {
	        System.err.println("Error al convertir valores numéricos: " + ex.getMessage());
	        // Puedes mostrar un mensaje de error al usuario aquí si la conversión falla
	        return; // Salir del método si hay un error de conversión
	    }
	    
	    // Buscar la cocina correspondiente en los datosCocinas
=======
		//Obtener el modelo seleccionado
		String modeloSeleccionado = (String) comboBoxModelo.getSelectedItem();
		
		// Buscar la cocina correspondiente en los datosCocinas
>>>>>>> 1c1794877c01b72473f11db8ff333db7354b1bde
	    for (Object[] cocina : Tienda.datosCocinas) {
	        if (cocina[0].equals(modeloSeleccionado)) {
	            // Actualizar los datos con los valores de los campos de texto convertidos
	            cocina[1] = precio;
	            cocina[2] = ancho;
	            cocina[3] = alto;
	            cocina[4] = fondo;
	            cocina[5] = quemadores;
	            break;
	        }
	    }
	    
	    // Mostrar un mensaje indicando que los cambios se han guardado
	    System.out.println("Cambios guardados para " + modeloSeleccionado);
		
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		
		 //Cierra la ventana 
		
		 dispose();
	}
	
}
