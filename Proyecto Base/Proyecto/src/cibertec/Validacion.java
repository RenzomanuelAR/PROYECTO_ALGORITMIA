package cibertec;

import javax.swing.JOptionPane;

public class Validacion {
	
	//metodo validacionEsVacioEsCero: para validar si el dato ingresado es 0 o esta vacio
	//--Parametros: 
	//----datoEntrada: es el contenido a evaluar
	//----mensaje: es lo que se mostrará en el cuadro de dialogo
	public boolean validacionEsVacioEsCero(String datoEntrada,String mensaje) {
		//Eliminar los espacios en blanco antes y despues de una cadena de texto
		datoEntrada = datoEntrada.trim();
		
		//Si el contenido de la variable datoEntrada es igual a '0' o vacio 
		if (datoEntrada.equals("0") || datoEntrada.equals("")) {
			//muestra el cuadro dialogo de validación
			JOptionPane.showMessageDialog(null, mensaje, "Mensaje de Vadilación",  JOptionPane.ERROR_MESSAGE);
			return true;
		}
		return false;
	}
	
	//metodo esNumero: para validar si el dato ingresado es un numero
	//--Parametros: 
	//----datoEntrada: es el contenido a evaluar
	public boolean esNumero(String datoEntrada) {
		boolean retornar = true;
		//Validad que los datos ingresados sean de tipo numéricos
		try {
			//si el contenido es diferente de nulo
			if (datoEntrada != null) {
				//convertir a entero
				Integer.parseInt(datoEntrada);
			}
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "Debe ingresar un número entero.", "Mensaje de Vadilación",  JOptionPane.ERROR_MESSAGE);
			retornar = false;
		}
		
		return retornar;
	}
	

}
