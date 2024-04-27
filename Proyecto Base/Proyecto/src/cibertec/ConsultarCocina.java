package cibertec;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarCocina extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblModelo;
	private JLabel lblPrecio;
	private JLabel lblAncho;
	private JLabel lblAlto;
	private JLabel lblFondo;
	private JLabel lblQuemadores;
	private JComboBox comboBoxModelo;
	private JTextField textPrecio;
	private JTextField textAncho;
	private JTextField textAlto;
	private JTextField textFondo;
	private JTextField textQuemadores;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarCocina frame = new ConsultarCocina();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	 private static final Object[][] datosCocinas = {
		        { "Mabe EMP6120PG0", 949.0, 60.0, 91.0, 58.6, 4 },
		        { "Indurama Parma", 1089.0, 80.0, 94.0, 67.5, 6 },
		        { "Sole COSOL027", 850.0, 60.0, 90.0, 50.0, 4 },
		        { "Coldex CX602", 629.0, 61.6, 95.0, 51.5, 5 },
		        { "Reco Dakota", 849.0, 75.4, 94.5, 66.0, 5 }
		    };


	/**
	 * Create the frame.
	 */
	public ConsultarCocina() {
		setTitle("Consultar Cocina");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblModelo.setBounds(26, 33, 75, 13);
		contentPane.add(lblModelo);
		
		lblPrecio = new JLabel("Precio (S/.)");
		lblPrecio.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecio.setBounds(26, 56, 75, 13);
		contentPane.add(lblPrecio);
		
		lblAncho = new JLabel("Ancho (cm)");
		lblAncho.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAncho.setBounds(26, 79, 75, 13);
		contentPane.add(lblAncho);
		
		lblAlto = new JLabel("Alto (cm)");
		lblAlto.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAlto.setBounds(26, 102, 75, 13);
		contentPane.add(lblAlto);
		
		lblFondo = new JLabel("Fondo (cm)");
		lblFondo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFondo.setBounds(26, 125, 75, 13);
		contentPane.add(lblFondo);
		
		lblQuemadores = new JLabel("Quemadores");
		lblQuemadores.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblQuemadores.setBounds(26, 151, 88, 13);
		contentPane.add(lblQuemadores);
		
		comboBoxModelo = new JComboBox();
		comboBoxModelo.setFont(new Font("Tahoma", Font.BOLD, 13));
		comboBoxModelo.setModel(new DefaultComboBoxModel(new String[] {"MabeEMP6120PG0", "InduramaParma", "SoleCOSOL027", "ColdexCX602", "RecoDakota"}));
		
		comboBoxModelo.addActionListener(e -> {
            String seleccion = (String) comboBoxModelo.getSelectedItem();
            mostrarDatosCocina(seleccion);
        });
		
		mostrarDatosCocina("MabeEMP6120PG0");
		
		comboBoxModelo.setBounds(144, 30, 163, 21);
		contentPane.add(comboBoxModelo);
		
		textPrecio = new JTextField();
		textPrecio.setBounds(144, 54, 163, 19);
		contentPane.add(textPrecio);
		textPrecio.setColumns(10);
		
		textAncho = new JTextField();
		textAncho.setBounds(144, 77, 163, 19);
		contentPane.add(textAncho);
		textAncho.setColumns(10);
		
		textAlto = new JTextField();
		textAlto.setBounds(144, 100, 163, 19);
		contentPane.add(textAlto);
		textAlto.setColumns(10);
		
		textFondo = new JTextField();
		textFondo.setBounds(144, 123, 163, 19);
		contentPane.add(textFondo);
		textFondo.setColumns(10);
		
		textQuemadores = new JTextField();
		textQuemadores.setBounds(144, 151, 163, 19);
		contentPane.add(textQuemadores);
		textQuemadores.setColumns(10);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCerrar.setBounds(326, 33, 85, 21);
		contentPane.add(btnCerrar);
		
		// Mostrar automáticamente los datos de la primera cocina al iniciar la ventana
        mostrarDatosCocina((String) datosCocinas[0][0]);
	}
	
	private void mostrarDatosCocina(String seleccion) {
		for (Object[] datos : datosCocinas) {
            String modelo = (String) datos[0];
            if (modelo.equals(seleccion)) {
                double precio = (double) datos[1];
                double ancho = (double) datos[2];
                double alto = (double) datos[3];
                double fondo = (double) datos[4];
                int quemadores = (int) datos[5];

                textPrecio.setText(String.valueOf(precio));
                textAncho.setText(String.valueOf(ancho));
                textAlto.setText(String.valueOf(alto));
                textFondo.setText(String.valueOf(fondo));
                textQuemadores.setText(String.valueOf(quemadores));
                break;
            }
        }
    }
	
	
	@Override
	public void actionPerformed(ActionEvent e)   {
        if (e.getSource() == btnCerrar) {
            dispose();
        } else if (e.getSource() == comboBoxModelo) {
            String seleccion = (String) comboBoxModelo.getSelectedItem();
            mostrarDatosCocina(seleccion);
        }
    }
	
}
