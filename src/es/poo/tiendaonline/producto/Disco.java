package es.poo.tiendaonline.producto;

import java.util.ArrayList;

import es.poo.tiendaonline.interfaces.IMostrable;
import es.poo.tiendaonline.miscelaneo.Miscelaneo;

public class Disco extends Producto implements IMostrable {
	private String artista;
	private String genero;

	public Disco(String genero, String artista) {
		this.genero = genero;
		this.artista = artista;
		super.porcentajeImp = 21;
	}

	public double getPrecioFinal() {
		return super.getPrecioSinImp() + (super.getPrecioSinImp() * porcentajeImp / 100);
	}

	public String getGenero() {
		return genero;
	}

	public String getArtista() {
		return artista;
	}

	@Override
	public String toString() {
		return "|CODIGO: " + getCodigo() + "|  |DESCRIPCION: " + getDescripcion() + "| |GENERO: " + getGenero()
				+ "| |ARTISTA: " + getArtista() + "|  |PRECIO SIN IMPUESTOS: " + getPrecioSinImp()
				+ "€|  |PRECIO FINAL: " + getPrecioFinal() + "€|\n";

	}
}
