package es.poo.tiendaonline.producto;

import java.util.ArrayList;

import es.poo.tiendaonline.envio.FormaEnvio;
import es.poo.tiendaonline.interfaces.IMostrable;
import es.poo.tiendaonline.metodo.MetodoPago;

public class Cesta implements IMostrable {
	private static final String error = "Error el objeto seleccionado no existe";
	private static final String errorVacio = "La cesta esta vacia";
	private ArrayList<Producto> arrCesta = new ArrayList<Producto>();
	private FormaEnvio envio = new FormaEnvio();
	private MetodoPago metodo = new MetodoPago();
	private double precioNetoTotal;
	private double impTotal;
	private double precioTotal;
	private static ArrayList<Cesta> arrHistorial = new ArrayList<>();

	public static ArrayList<Cesta> getArrHistorial() {
		return arrHistorial;
	}

	public void setArrHistorial(ArrayList<Cesta> arrHistorial) {
		Cesta.arrHistorial = arrHistorial;
	}

	public double getPrecioNetoTotal() {
		return precioNetoTotal;
	}

	public void setPrecioNetoTotal(double precioNetoTotal) {
		this.precioNetoTotal = precioNetoTotal;
	}

	public double getImpTotal() {
		return impTotal;
	}

	public void setImpTotal(double impTotal) {
		this.impTotal = impTotal;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public static String getError() {
		return error;
	}

	public static String getErrorvacio() {
		return errorVacio;
	}

	public void setEnvio(FormaEnvio envio) {
		this.envio = envio;
	}

	public FormaEnvio getEnvio() {
		return envio;
	}

	public MetodoPago getMetodo() {
		return metodo;
	}

	public void setMetodo(MetodoPago metodo) {
		this.metodo = metodo;
	}

	public ArrayList<Producto> getArrCesta() {
		return arrCesta;
	}

	public void setArrCesta(ArrayList<Producto> arrCesta) {
		this.arrCesta = arrCesta;
	}

	/**
	 * Metodo que agrega un producto a la cesta
	 * 
	 * @param auxID       ID del producto
	 * @param auxCantidad Cantidad del producto
	 */
	public void agregarCesta(String auxID, int auxCantidad) {
		ArrayList<Producto> arr = getArrCesta();
		ArrayList<Producto> arrProd = Producto.getArrProducto();
		int contador = 0;
		for (int i = 0; i < arrProd.size(); i++) {
			if (auxID.compareTo(arrProd.get(i).getCodigo().toUpperCase()) == 0) {
				contador++;
				for (int l = auxCantidad; l > 0; l--) {
					arr.add(arrProd.get(i));
				}
				break;
			}
		}
		if (contador == 0) {
			System.out.println(error);
		}
		setArrCesta(arr);
	}

	/**
	 * Metodo que elimina todos los productos de la cesta
	 */
	public void eliminarCesta() {
		ArrayList<Producto> arr = getArrCesta();
		arr.clear();
		setArrCesta(arr);
	}

	/**
	 * Metodo que calcula el precio total de la cesta
	 */
	public void calcularPrecio() {
		ArrayList<Producto> arr = getArrCesta();
		double auxNo = 0;
		double auxCon = 0;
		double imp = 0;
		for (int i = 0; i < arr.size(); i++) {
			auxNo += arr.get(i).getPrecioSinImp();
			imp += (arr.get(i).getPrecioSinImp() * arr.get(i).getPorcentajeImp() / 100);
			auxCon += (arr.get(i).getPrecioSinImp()
					+ (arr.get(i).getPrecioSinImp() * arr.get(i).getPorcentajeImp() / 100));
		}
		setPrecioTotal(auxCon + getEnvio().getPrecioEnvio());
		setPrecioNetoTotal(auxNo);
		setImpTotal(imp);
	}

	/**
	 * Metodo que elimina un producto de la cesta
	 * 
	 * @param auxID       ID del producto
	 * @param auxCantidad Cantidad del producto
	 */
	public void eliminarSeleccionado(String auxID, int auxCantidad) {
		ArrayList<Producto> arr = getArrCesta();
		for (int i = 0; i < arr.size(); i++) {
			if (auxID.compareTo(arr.get(i).getCodigo().toUpperCase()) == 0) {
				for (int l = auxCantidad; l > 0; l--) {
					arr.remove(i);
				}
			} else {
				System.out.println(error);
				break;
			}
		}
	}

	/**
	 * Metodo que muestra el contenido de la cesta
	 */
	@Override
	public String toString() {
		String total = "";
		ArrayList<Producto> arr = getArrCesta();
		if (arr.isEmpty()) {
			System.out.println(errorVacio);
		} else {
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i) instanceof Libro) {
					Libro lib = (Libro) arr.get(i);
					total += lib.toString();
				} else if (arr.get(i) instanceof Alimentacion) {
					Alimentacion al = (Alimentacion) arr.get(i);
					total += al.toString();
				} else if (arr.get(i) instanceof Disco) {
					Disco disc = (Disco) arr.get(i);
					total += disc.toString();
				}
			}
		}
		return total;
	}

	/**
	 * Metodo que comprueba el contenido de la cesta
	 */
	public void comprobarArr() {
		getArrCesta().get(0);
	}

	/**
	 * Metodo que añade la cesta al historial
	 * 
	 * @param cesta Cesta que se va a añadir al historial
	 */
	public void anadirHistorial(Cesta cesta) {
		ArrayList<Cesta> arr = getArrHistorial();

		arr.add(cesta);
		setArrHistorial(arr);
	}

}
