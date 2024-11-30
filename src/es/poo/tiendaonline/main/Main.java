package es.poo.tiendaonline.main;

import es.poo.tiendaonline.cliente.Registrado;
import es.poo.tiendaonline.miscelaneo.Miscelaneo;
import es.poo.tiendaonline.producto.Producto;

public class Main {

	public static void main(String[] args) {

		Miscelaneo.inicialPrograma();
		System.out.println("Adios");

		Registrado.imprimir();

	}

}
