package es.poo.tiendaonline.metodo;

public class Tarjeta extends MetodoPago {
	private String tipoTarjeta;
	private String numTarjeta;
	private String caducidad;
	private int cvc;
	private String titular;

	/**
	 * Constructor de la clase Tarjeta. Inicializa el tipo de método de pago como
	 * "Tarjeta de crédito".
	 */
	public Tarjeta() {
		this.tipo = "Tarjeta de credito";
	}

	/**
	 * Obtiene el tipo de tarjeta de crédito.
	 * 
	 * @return El tipo de tarjeta de crédito.
	 */
	public String getTipoTarjeta() {
		return tipoTarjeta;
	}

	/**
	 * Establece el tipo de tarjeta de crédito.
	 * 
	 * @param tipoTarjeta El nuevo tipo de tarjeta de crédito a establecer.
	 */
	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}

	/**
	 * Obtiene el número de la tarjeta de crédito.
	 * 
	 * @return El número de la tarjeta de crédito.
	 */
	public String getNumTarjeta() {
		return numTarjeta;
	}

	/**
	 * Establece el número de la tarjeta de crédito.
	 * 
	 * @param numTarjeta El nuevo número de tarjeta de crédito a establecer.
	 */
	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	/**
	 * Obtiene la fecha de caducidad de la tarjeta de crédito.
	 * 
	 * @return La fecha de caducidad de la tarjeta de crédito.
	 */
	public String getCaducidad() {
		return caducidad;
	}

	/**
	 * Establece la fecha de caducidad de la tarjeta de crédito.
	 * 
	 * @param caducidad La nueva fecha de caducidad a establecer.
	 */
	public void setCaducidad(String caducidad) {
		this.caducidad = caducidad;
	}

	/**
	 * Obtiene el código de seguridad (CVC) de la tarjeta de crédito.
	 * 
	 * @return El código de seguridad (CVC) de la tarjeta de crédito.
	 */
	public int getCvc() {
		return cvc;
	}

	/**
	 * Establece el código de seguridad (CVC) de la tarjeta de crédito.
	 * 
	 * @param cvc El nuevo código de seguridad (CVC) a establecer.
	 */
	public void setCvc(int cvc) {
		this.cvc = cvc;
	}

	/**
	 * Obtiene el titular de la tarjeta de crédito.
	 * 
	 * @return El titular de la tarjeta de crédito.
	 */
	public String getTitular() {
		return titular;
	}

	/**
	 * Establece el titular de la tarjeta de crédito.
	 * 
	 * @param titular El nuevo titular de la tarjeta de crédito a establecer.
	 */
	public void setTitular(String titular) {
		this.titular = titular;
	}

	/**
	 * Comprueba la longitud del número de tarjeta de crédito.
	 * 
	 * @return true si la longitud es válida, false en caso contrario.
	 */
	public boolean comprobarLongitud() {
		if (getNumTarjeta().length() < 15 || getNumTarjeta().length() > 15) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Comprueba la validez del código de seguridad (CVC).
	 * 
	 * @return true si el CVC es válido, false en caso contrario.
	 */
	public boolean comprobarCvc() {
		if (getCvc() / 100 < 1 || getCvc() / 100 >= 10) {
			return false;
		} else {
			return true;
		}
	}

}
