package es.poo.tiendaonline.cliente;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.poo.tiendaonline.interfaces.IMostrable;
import es.poo.tiendaonline.producto.Cesta;

public class Cliente {
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String direccion;
	protected int listado = 0;
	private Cesta cesta = new Cesta();

	public Cliente() {

	}

	public Cliente(String nombre, String apellido, String apellido2) {
		this.nombre = nombre;
		this.apellido1 = apellido;
		this.apellido2 = apellido2;
	}

	public int getListado() {
		return listado;
	}

	public void setListado(int listado) {
		this.listado = listado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Cesta getCesta() {
		return cesta;
	}

	public void setCesta(Cesta cesta) {
		this.cesta = cesta;
	}

	/**
	 * 
	 * Metodo para validar el nombre del cliente**
	 * 
	 * @param nombre Nombre del cliente*@return true si el nombre es valido,false si
	 *               no lo es
	 */
	public String imprimirPedido() {
		String aux = "\n|NUMERO DE PEDIDO: " + (getListado() + 1) + "|\n" + "|USUARIO: " + getNombre() + " "
				+ getApellido1() + " " + getApellido2() + "|\n" + "|OPCION DE ENVIO: "
				+ getCesta().getEnvio().getTipoEnvio() + " " + getCesta().getEnvio().getPrecioEnvio() + "€|\n"
				+ "|DIRECCION DE ENVIO: " + getDireccion() + "|\n" + "\n|LISTA DE LA COMPRA: \n";
		aux += getCesta().toString();
		aux += "\n|IMPORTE NETO TOTAL: " + getCesta().getPrecioNetoTotal() + "|\n" + "|IMPUESTOS: "
				+ getCesta().getImpTotal() + "|\n" + "|GASTOS DE ENVIO: " + getCesta().getEnvio().getPrecioEnvio()
				+ "|\n" + "|PRECIO TOTAL: " + getCesta().getPrecioTotal() + "|\n";

		return aux;
	}

	/**
	 * Metodo para validar el nombre del cliente
	 * 
	 * @param nombre Nombre del cliente
	 * @return true si el nombre es valido,false si no lo es
	 */
	public static Cliente crearInvitado() {
		Cliente inv = new Cliente("Invitado", "Invitado", "Invitado");
		return inv;
	}
}
