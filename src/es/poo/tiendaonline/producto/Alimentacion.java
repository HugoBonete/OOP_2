package es.poo.tiendaonline.producto;

import java.util.ArrayList;

import es.poo.tiendaonline.interfaces.IMostrable;
import es.poo.tiendaonline.miscelaneo.Miscelaneo;

public class Alimentacion extends Producto implements IMostrable {
	private String fechaCad;

	/**
	 * Constructor de la clase Alimentacion.
	 *
	 * @param fechaCad Fecha de caducidad del producto.
	 */
	public Alimentacion(String fechaCad) {
		this.fechaCad = fechaCad;
		super.porcentajeImp = 4;
	}

	/**
	 * Obtiene el precio final del producto de alimentación, incluyendo impuestos.
	 *
	 * @return Precio final del producto.
	 */
	public double getPrecioFinal() {
		return super.getPrecioSinImp() + (super.getPrecioSinImp() * porcentajeImp / 100);
	}

	/**
	 * Obtiene la fecha de caducidad del producto de alimentación.
	 *
	 * @return Fecha de caducidad del producto.
	 */
	public String getFechaCad() {
		return fechaCad;
	}

	/**
	 * Representación en formato de cadena de la información del producto de
	 * alimentación.
	 *
	 * @return Cadena que representa el producto de alimentación.
	 */
	@Override
	public String toString() {
		return "|CODIGO: " + getCodigo() + "|  |DESCRIPCION: " + getDescripcion() + "| |FECHA DE CADUCIDAD: "
				+ getFechaCad() + "|  |PRECIO SIN IMPUESTOS: " + getPrecioSinImp() + "€|  |PRECIO FINAL: "
				+ getPrecioFinal() + "€|\n";
	}

}
