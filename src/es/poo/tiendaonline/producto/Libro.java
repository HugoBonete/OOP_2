package es.poo.tiendaonline.producto;

import java.util.ArrayList;

import es.poo.tiendaonline.miscelaneo.Miscelaneo;

public class Libro extends Producto {
	private String isbn;
	private String titulo;
	private String autor;
	private String editorial;

	public Libro(String isbn, String titulo, String autor, String editorial) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		super.porcentajeImp = 10;
	}

	public double getPrecioFinal() {
		return super.getPrecioSinImp() + (super.getPrecioSinImp() * porcentajeImp / 100);
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getEditorial() {
		return editorial;
	}

	@Override
	public String toString() {
		return "|CODIGO: " + getCodigo() + "|  |DESCRIPCION: " + getDescripcion() + "| |ISBN: " + getIsbn()
				+ "| |TITULO: " + getTitulo() + "| |AUTOR: " + getAutor() + "| |EDITORIAL: " + getEditorial()
				+ "|  |PRECIO SIN IMPUESTOS: " + getPrecioSinImp() + "€|  |PRECIO FINAL: " + getPrecioFinal() + "€|\n";

	}

}
