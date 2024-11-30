package es.poo.tiendaonline.metodo;

import java.util.ArrayList;

import es.poo.tiendaonline.miscelaneo.Miscelaneo;

public class Paypal extends MetodoPago {
	private String usuario;
	private String contrPay;

	/**
	 * Constructor de la clase Paypal. Inicializa el tipo de método de pago como
	 * "Paypal".
	 */
	public Paypal() {
		this.tipo = "Paypal";
	}

	/**
	 * Obtiene la contraseña asociada a la cuenta de Paypal.
	 * 
	 * @return La contraseña de la cuenta de Paypal.
	 */
	public String getContrPay() {
		return contrPay;
	}

	/**
	 * Establece la contraseña de la cuenta de Paypal.
	 * 
	 * @param contrPay La nueva contraseña de la cuenta de Paypal a establecer.
	 */
	public void setContrPay(String contrPay) {
		this.contrPay = contrPay;
	}

	/**
	 * Obtiene el nombre de usuario asociado a la cuenta de Paypal.
	 * 
	 * @return El nombre de usuario de la cuenta de Paypal.
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Establece el nombre de usuario de la cuenta de Paypal.
	 * 
	 * @param usuario El nuevo nombre de usuario de la cuenta de Paypal a
	 *                establecer.
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
