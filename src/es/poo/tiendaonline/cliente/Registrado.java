package es.poo.tiendaonline.cliente;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import es.poo.tiendaonline.miscelaneo.Miscelaneo;

public class Registrado extends Cliente {
	private static final String errorUsuario = "Error el usuario no ha sido encontrado";
	private String contrasena;
	private String fechaNac;
	private String correo;

	private static ArrayList<Registrado> arrRegistrado = mockUp();

	public Registrado() {

	}

	public Registrado(String con, String nac, int list) {
		this.contrasena = con;
		this.fechaNac = nac;
		this.listado = list;
	}
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public static ArrayList<Registrado> getArrRegistrado() {
		return arrRegistrado;
	}

	public static void setArrRegistrado(ArrayList<Registrado> arrRegistrado) {
		Registrado.arrRegistrado = arrRegistrado;
	}

	/**
	 * Metodo que crea un mockup de usuarios registrados
	 * 
	 * @return devuelve un ArrayList de usuarios registrados
	 */
	private static ArrayList<Registrado> mockUp() {

		ArrayList<Registrado> arrRegistrado = new ArrayList<Registrado>();
		Registrado r1 = new Registrado("12345", "19/08/2004", 2);
		r1.setNombre("Paquito");
		r1.setApellido1("Lopez");
		r1.setApellido2("Sanchez");
		r1.setCorreo("Miau@miau.com");
		arrRegistrado.add(r1);

		Registrado r2 = new Registrado("abcde", "19/08/2004", 54);
		r2.setNombre("Josito");
		r2.setApellido1("Miau");
		r2.setApellido2("Fedez");
		r2.setCorreo("ola@ola.com");
		arrRegistrado.add(r2);

		return arrRegistrado;
	}

	/**
	 * Metodo que registra un usuario
	 */
	public static void registrarCliente() {
		ArrayList<Registrado> arr = getArrRegistrado();
		Registrado r1 = Miscelaneo.pedirDatos();
		boolean prueba = comprobarDisponible(r1);
		if(r1.validarFecha() == false)
		{
			System.out.println("Error la fecha introducida es incorrecta");
		}if(validarEmail(r1.getCorreo()) == false)
		{
			System.out.println("Error el email introducido no es valido");
		}
		else if (prueba == false)
		{
			System.out.println("La cuenta con este correo ya existe, porfavor prueba otro o inicia sesion.");
		
		}else
		{
			arr.add(r1);
			System.out.println("Usted ha sido registrado correctamente, ahora pruebe a iniciar sesion.");
			Registrado.setArrRegistrado(arr);
		}
	}

	/***
	 * Metodo que comprueba si un usuario esta disponible
	 * 
	 * @param r1 usuario a comprobar
	 * @return devuelve un booleano de verdadero si esta disponible o falso si no lo
	 *         esta
	 */
	public static boolean comprobarDisponible(Registrado r1) {

		for (int i = 0; i < getArrRegistrado().size(); i++) {
			if (getArrRegistrado().get(i).getCorreo().toUpperCase().compareTo(r1.getCorreo().toUpperCase()) == 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Metodo que comprueba si un usuario esta disponible
	 * 
	 * @param r1 usuario a comprobar
	 * @return devuelve un booleano de verdadero si esta disponible o falso si no lo
	 *         esta
	 */
	public static Registrado comprobarRegistrado(String corr, String contr) {
		Registrado aux = null;
		ArrayList<Registrado> arrRegs = getArrRegistrado();

		for (int i = 0; i < arrRegs.size() && aux == null; i++) {
			if (arrRegs.get(i).getCorreo().toUpperCase().compareTo(corr.toUpperCase()) == 0
					&& arrRegs.get(i).getContrasena().compareTo(contr) == 0) {
				aux = arrRegs.get(i);
				System.out.println(
						"Bienvenido: " + aux.getApellido1() + " " + aux.getApellido2() + ", " + aux.getNombre());
			}
		}
		if (aux == null) {
			System.out.println(errorUsuario);
		}
		return aux;
	}

	/***
	 * Metodo que imprime los usuarios registrados
	 */
	public static void imprimir() {
		for (int i = 0; i < getArrRegistrado().size(); i++) {

			System.out.println(getArrRegistrado().get(i).toString());
		}
	}

	/**
	 * La funcion 'validarFecha()' se encarga de que el usuario introduzca una fecha
	 * valida y con el formato correcto '(dd/MM/yyyy)'.
	 * 
	 * @return Este metodo devuelve un valor booleano de verdadero si la fecha es
	 *         valida o falso si no lo es.
	 */
	public boolean validarFecha() {
		try {
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
			formatoFecha.setLenient(false);
			formatoFecha.parse(getFechaNac());
		} catch (ParseException e) {
			return false;
		}
		return true;
	}


	/**
	 * Valida la forma de una dirección de correo
	 * @param email cadena de texto con el email a validar
	 * @return
	 */
	public static Boolean validarEmail (String email) {
		Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	@Override
	public String toString() {
		return "getCorreo()=" + getCorreo() + ", getNombre()=" + getNombre() + ", getApellido1()=" + getApellido1()
				+ ", getApellido2()=" + getApellido2() + "]";
	}

}
