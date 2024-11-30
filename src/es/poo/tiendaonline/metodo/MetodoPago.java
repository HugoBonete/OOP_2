package es.poo.tiendaonline.metodo;

import java.util.ArrayList;

import es.poo.tiendaonline.miscelaneo.Miscelaneo;

public class MetodoPago {
	protected ArrayList<MetodoPago> arrMetodo = new ArrayList<MetodoPago>();
	protected String tipo;

	public ArrayList<MetodoPago> getArrMetodo() {
		return arrMetodo;
	}

	/**
	 * Establece la lista de métodos de pago.
	 * 
	 * @param arrMetodo La nueva lista de métodos de pago a establecer.
	 */
	public void setArrMetodo(ArrayList<MetodoPago> arrMetodo) {
		this.arrMetodo = arrMetodo;
	}

	/**
	 * Añade un método de pago de tipo PayPal a la lista.
	 */
	public void anadirPay() {
		// Obtiene la lista actual de métodos de pago
		ArrayList<MetodoPago> arr = getArrMetodo();

		// Pide al usuario que ingrese los detalles de PayPal
		MetodoPago met = Miscelaneo.pedirPaypal();

		// Añade el método de pago a la lista
		arr.add(met);

		// Actualiza la lista de métodos de pago
		setArrMetodo(arr);
	}

	/**
	 * Añade un método de pago de tipo tarjeta a la lista.
	 * 
	 * @return El método de pago de tipo tarjeta añadido, o null si la entrada fue
	 *         inválida.
	 */
	public MetodoPago anadirTarjeta() {
		// Obtiene la lista actual de métodos de pago
		ArrayList<MetodoPago> arr = getArrMetodo();

		// Pide al usuario que ingrese los detalles de la tarjeta
		MetodoPago met = Miscelaneo.pedirTarjeta();

		// Verifica si la entrada de la tarjeta es válida
		if (met != null) {
			// Añade el método de pago a la lista
			arr.add(met);

			// Actualiza la lista de métodos de pago
			setArrMetodo(arr);
		}

		// Devuelve el método de pago añadido (puede ser null si la entrada fue
		// inválida)
		return met;
	}

}
