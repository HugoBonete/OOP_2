package es.poo.tiendaonline.producto;

import java.util.ArrayList;

public class Producto {
	protected String codigo;
	protected String descripcion;
	protected double precioSinImp;
	protected double porcentajeImp;
	protected double precioFinal;
	protected static ArrayList<Producto> arrProducto = crearArray();

	public static ArrayList<Producto> getArrProducto() {
		return arrProducto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String string) {
		this.codigo = string;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioSinImp() {
		return precioSinImp;
	}

	public void setPrecioSinImp(double precioSinImp) {
		this.precioSinImp = precioSinImp;
	}

	public double getPorcentajeImp() {
		return porcentajeImp;
	}

	public void setPorcentajeImp(double porcentajeImp) {
		this.porcentajeImp = porcentajeImp;
	}

	public double getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(double precioFinal) {
		this.precioFinal = precioFinal;
	}

	/**
	 * Representación en formato de cadena de la información del producto.
	 *
	 * @return Cadena que representa el producto.
	 */
	private static ArrayList<Producto> crearArray() {
		ArrayList<Producto> arr = new ArrayList<Producto>();
		Producto jamon = new Alimentacion("17/09/2027");
		jamon.setCodigo("RM12");
		jamon.setDescripcion("Jamon de bellota");
		jamon.setPrecioSinImp(90);
		arr.add(jamon);

		Producto nutella = new Alimentacion("03/08/2025");
		nutella.setCodigo("RM14");
		nutella.setDescripcion("Nutella");
		nutella.setPrecioSinImp(10);
		arr.add(nutella);

		Producto llados = new Libro("9798857578285", "Llados f*cking fitness", "Llados panzota", "Llados industries");
		llados.setCodigo("RM22");
		llados.setDescripcion("Llados F*cking Fitness");
		llados.setPrecioSinImp(14);
		arr.add(llados);

		Producto geronimo = new Libro("9788408060994", "Geronimo Stilton", "Elissabeta Dami", "Planeta");
		geronimo.setCodigo("RM24");
		geronimo.setDescripcion("Geronimo Stilton");
		geronimo.setPrecioSinImp(18);
		arr.add(geronimo);

		Producto goodbye = new Disco("Rap", "Juice Wrld");
		goodbye.setCodigo("RM32");
		goodbye.setDescripcion("Goodbye & Good Riddance");
		goodbye.setPrecioSinImp(23);
		arr.add(goodbye);

		Producto melendi = new Disco("Rumbita", "Melendi");
		melendi.setCodigo("RM34");
		melendi.setDescripcion("Melendi");
		melendi.setPrecioSinImp(33);
		arr.add(melendi);

		return arr;
	}

	/**
	 * Metodo que muestra el contenido del array de productos
	 */
	public static void imprimirArrAlimentacion() {
		ArrayList<Producto> arr = getArrProducto();
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) instanceof Alimentacion) {
				Alimentacion al = (Alimentacion) arr.get(i);
				System.out.println(al.toString());
			}
		}
	}

	/**
	 * Metodo que muestra el contenido del array de productos
	 */
	public static void imprimirArrLibro() {
		ArrayList<Producto> arr = getArrProducto();
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) instanceof Libro) {
				Libro lib = (Libro) arr.get(i);
				System.out.println(lib.toString());
			}
		}
	}

	/**
	 * Metodo que muestra el contenido del array de productos
	 */
	public static void imprimirArrDisco() {
		ArrayList<Producto> arr = getArrProducto();
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) instanceof Disco) {
				Disco disc = (Disco) arr.get(i);
				System.out.println(disc.toString());
			}
		}
	}

}
