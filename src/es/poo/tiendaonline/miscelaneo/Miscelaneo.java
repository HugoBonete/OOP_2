package es.poo.tiendaonline.miscelaneo;

import java.util.Scanner;
import es.poo.tiendaonline.cliente.Cliente;
import es.poo.tiendaonline.cliente.Registrado;
import es.poo.tiendaonline.metodo.Paypal;
import es.poo.tiendaonline.metodo.Tarjeta;
import es.poo.tiendaonline.producto.Producto;

public class Miscelaneo {
	private static final Scanner scanIn = new Scanner(System.in);
	private static Cliente usuario = null;
	private static final String id = "Introduzca el id del producto que desea anyadir: \n";
	private static final String cantidad = "Introduzca la cantidad del producto que desea";
	private static final String idElim = "Introduzca el id del producto que desea eliminar: \n";
	private static final String primApellido = "Introduzca su segundo apellido:";
	private static final String segApellido = "Introduzca su segundo apellido:";
	private static final String nombre = "Introduzca su nombre:";
	private static final String contrasenya = "Introduzca su Contrasenya:\n";
	private static final String fechaNacimiento = "Introduzca su fecha de nacimiento en formato 'dd/mm/aaaa':";
	private static final String correo = "Introduzca su correo:\n";
	private static final String usuPay = "Usuario de paypal:\n";
	private static final String contrPay = "Contrasenya de paypal:\n";
	private static final String tipoTar = "Tipo de la tarjeta:\n";
	private static final String numTar = "Numero de la  tarjeta sin espacios:\n";
	private static final String titularTar = "Titular de la tarjeta:\n";
	private static final String caduTar = "Fecha de caducidad de la tarjeta:\n";
	private static final String cvcTar = "CVC de la tarjeta:\n";
	private static final String direccion = "Introduzca la direccion del envio: ";
	private static final String adios = "Gracias por su compra vuelva pronto";
	private static final String errorElec = "La opcion seleccionada no existe porfavor escoja de nuevo";
	private static final String cancelao = "Usted ha cancelado la compra";
	private static final String errorCadena = "Error la cadena esta vacia no puede finalizar la compra";
	private static final String errorTar = "La tarjeta introducida no es valida";

	/**
	 * Metodo que inicializa el programa
	 */
	public static void inicialPrograma() {

		Miscelaneo.imprimirMenuPrincipal();
		Miscelaneo.imprimirMenuAcceder();
		String elec;
		elec = Escanear("").toUpperCase();
		switch (elec) {
		case "R":
			Registrado.registrarCliente();
			inicialPrograma();
		case "A":
			String corr = Escanear(correo);
			String contr = Escanear(contrasenya);
			usuario = (Registrado) Registrado.comprobarRegistrado(corr, contr);

			if (usuario == null) {
				inicialPrograma();
			} else {
				segundoMenu();
			}

		case "I":
			usuario = Cliente.crearInvitado();
			segundoMenu();
		case "S":
			System.out.println("Usted ha cerrado el programa");
			System.exit(0);
		default:
			System.out.println(errorElec);
		}
		inicialPrograma();
	}

	/**
	 * Metodo que muestra el segundo menu
	 */
	public static void segundoMenu() {
		Miscelaneo.imprimirMenuSecundario();
		String elec;
		elec = Escanear("").toUpperCase();
		switch (elec) {
		case "B":
			menuBuscar();
			break;
		case "L":
			System.out.println(usuario.getCesta().toString());
			segundoMenu();
		case "F":

			try {
				usuario.getCesta().comprobarArr();
			} catch (Exception e) {
				System.out.println(errorCadena);
				break;
			}
			menuEnvio();
		case "R":
			String auxID = Miscelaneo.Escanear(id).toUpperCase();
			int auxCantidad = Integer.parseInt(Miscelaneo.Escanear(cantidad).toUpperCase());
			usuario.getCesta().eliminarSeleccionado(auxID, auxCantidad);
			segundoMenu();
		case "V":
			inicialPrograma();
		default:
			System.out.println(errorElec);
		}
		segundoMenu();
	}

	/**
	 * Metodo que muestra el menu de busqueda
	 */
	public static void menuBuscar() {
		imprimirBuscador();
		String elec;
		elec = Escanear("").toUpperCase();
		switch (elec) {
		case "A":
			Producto.imprimirArrAlimentacion();
			menuAcciones();
			break;
		case "L":
			Producto.imprimirArrLibro();
			menuAcciones();
			break;
		case "D":
			Producto.imprimirArrDisco();
			menuAcciones();
			break;
		case "V":
			segundoMenu();
		default:
			System.out.println(errorElec);
		}
		menuBuscar();
	}

	/**
	 * Metodo que muestra el menu de acciones
	 */
	public static void menuAcciones() {
		imprimirAcciones();
		String elec;
		elec = Escanear("").toUpperCase();
		switch (elec) {
		case "A":
			String auxID = Miscelaneo.Escanear(idElim).toUpperCase();
			int auxCantidad = Integer.parseInt(Miscelaneo.Escanear(cantidad).toUpperCase());
			usuario.getCesta().agregarCesta(auxID, auxCantidad);
		case "V":
			menuBuscar();
		default:
			System.out.println(errorElec);
		}
		menuAcciones();
	}

	/**
	 * Metodo que muestra el menu de envio
	 */
	public static void menuEnvio() {
		imprimirEnvio();
		String elec;
		elec = Escanear("").toUpperCase();
		switch (elec) {
		case "1":
			usuario.getCesta().getEnvio().setPrecioEnvio(9.99);
			usuario.getCesta().getEnvio().setTipoEnvio("Mismo dia");
			usuario.setDireccion(Escanear(direccion));
			menuMetodo();
		case "2":
			usuario.getCesta().getEnvio().setPrecioEnvio(5);
			usuario.getCesta().getEnvio().setTipoEnvio("Siguiente dia");
			usuario.setDireccion(Escanear(direccion));
			menuMetodo();
		case "3":
			usuario.getCesta().getEnvio().setPrecioEnvio(3.45);
			usuario.getCesta().getEnvio().setTipoEnvio("3 dias laborales");
			usuario.setDireccion(Escanear(direccion));
			menuMetodo();
		case "4":
			usuario.getCesta().getEnvio().setPrecioEnvio(0);
			usuario.getCesta().getEnvio().setTipoEnvio("5 dias laborales");
			usuario.setDireccion(Escanear(direccion));
			menuMetodo();
		case "V":
			segundoMenu();
		default:
			System.out.println(errorElec);
		}
		menuEnvio();
	}

	/**
	 * Metodo que muestra el menu de metodo de pago
	 */
	public static void menuMetodo() {
		usuario.getCesta().calcularPrecio();
		imprimirMetodo();
		String elec;
		elec = Escanear("").toUpperCase();
		switch (elec) {
		case "P":
			usuario.getCesta().getMetodo().anadirPay();
			System.out.println(usuario.imprimirPedido());
			menuConfirmar();
			break;
		case "T":
			if (usuario.getCesta().getMetodo().anadirTarjeta() == null) {
				System.out.println(errorTar);
				menuMetodo();
			} else {
				System.out.println(usuario.imprimirPedido());
				menuConfirmar();
			}

		case "V":
			segundoMenu();
		default:
			System.out.println(errorElec);
		}
		menuMetodo();
	}

	/**
	 * Metodo que muestra el menu de confirmacion
	 */
	public static void menuConfirmar() {
		imprimirConfirmar();
		String elec;
		elec = Escanear("").toUpperCase();
		switch (elec) {
		case "S":
			usuario.getCesta().anadirHistorial(usuario.getCesta());
			usuario.getCesta().eliminarCesta();
			usuario.setListado(usuario.getListado() + 1);
			menuSeguir();
		case "N":
			System.out.println(cancelao);
			segundoMenu();
		default:
			System.out.println(errorElec);
		}
		menuConfirmar();
	}

	/**
	 * Metodo que muestra el menu de seguir comprando
	 */
	public static void menuSeguir() {
		seguirComprando();
		String elec;
		elec = Escanear("").toUpperCase();
		switch (elec) {
		case "S":
			segundoMenu();
		case "N":
			System.out.println(adios);
			System.exit(0);
		default:
			System.out.println(errorElec);
		}
		menuSeguir();
	}

	/**
	 * Metodos que imprimen los menus
	 */

	public static void imprimirConfirmar() {
		System.out.println("----------------------------------------------------------\n");
		System.out.println("Desea confirmar la compra? S/N\n");
		System.out.println("----------------------------------------------------------\n");
	}

	public static void imprimirMenuPrincipal() {
		System.out.println("----------------------------------------------------------\n");
		System.out.println("-----------Bienvenido a la tienda online de Jose----------\n");
		System.out.println("----------------------------------------------------------\n");
		System.out.println("\n");
	}

	public static void imprimirLinea() {
		System.out.println("Que linea se encuentra el producto que desea agregar a la cesta?\n");
		System.out.println("1)\n");
		System.out.println("2)\n");
	}

	public static void imprimirMenuAcceder() {
		System.out.println("----------------------------------------------------------\n");
		System.out.println("Como desea acceder a la tienda:\n");
		System.out.println("(R) Usuario registrado\n");
		System.out.println("(A) Alta de usuario\n");
		System.out.println("(I) Entrar como invitado\n");
		System.out.println("(S) Salir del programa\n");
		System.out.println("----------------------------------------------------------\n");
	}

	public static void imprimirMenuSecundario() {
		System.out.println("----------------------------------------------------------\n");
		System.out.println("Que desea hacer:\n");
		System.out.println("(B) Buscar producto\n");
		System.out.println("(L) Listar producos seleccionados\n");
		System.out.println("(F) Finalizar compra\n");
		System.out.println("(R) Vaciar productos seleccionados\n");
		System.out.println("(V) Volver al menu anterior\n");
		System.out.println("----------------------------------------------------------\n");
	}

	public static void imprimirMenuListar() {
		System.out.println("----------------------------------------------------------\n");
		System.out.println("Que desea hacer:\n");
		System.out.println("(F) Formalizar compra\n");
		System.out.println("(R) Vaciar los productos seleccionados\n");
		System.out.println("(V) Volver al menu anterior\n");
		System.out.println("----------------------------------------------------------\n");

	}

	public static void imprimirAcciones() {
		System.out.println("----------------------------------------------------------\n");
		System.out.println("Acciones:\n");
		System.out.println("(A) Agregar producto al carrito.\n");
		System.out.println("(V) Volver al menu anterior.\n");
		System.out.println("----------------------------------------------------------\n");
	}

	public static void imprimirBuscador() {
		System.out.println("----------------------------------------------------------\n");
		System.out.println("Listado de categorias:\n");
		System.out.println("(A) Alimentación\n");
		System.out.println("(L) Libros\n");
		System.out.println("(D) Discos\n");
		System.out.println("(V) Volver al menu anterior\n");
		System.out.println("----------------------------------------------------------\n");
	}

	public static void imprimirEnvio() {
		System.out.println("----------------------------------------------------------\n");
		System.out.println("Opciones de envio:\n\n");
		System.out.println("(1) Entrega hoy (9,99€, Mismo dia)\n");
		System.out.println("(2) Envio 1 dia (5€, Al dia siguiente)\n");
		System.out.println("(3) Envio expres (3,45€, 3 dias laborales)\n");
		System.out.println("(4) Envio estandar (gratis, 5 dias laborales)\n");
		System.out.println("(V) Volver al menu anterior\n");
		System.out.println("----------------------------------------------------------\n");
	}

	public static void imprimirMetodo() {
		System.out.println("----------------------------------------------------------\n");
		System.out.println("Escoja el metodo de pago:\n\n");
		System.out.println("(P) Paypal\n");
		System.out.println("(T) Tarjeta de credito\n");
		System.out.println("(V) Volver al menu anterior");
		System.out.println("----------------------------------------------------------\n");
	}

	public static void seguirComprando() {
		System.out.println("----------------------------------------------------------\n");
		System.out.println("Desea seguir comprando? S/N\n");
		System.out.println("----------------------------------------------------------\n");
	}

	/**
	 * Metodo que pide los datos de paypal
	 * 
	 * @return Paypal
	 */
	public static Paypal pedirPaypal() {
		Paypal pay = new Paypal();
		System.out.println("----------------------------------------------------------\n");
		pay.setUsuario(Escanear(usuPay));
		pay.setContrPay(Escanear(contrPay));
		System.out.println("----------------------------------------------------------\n");
		return pay;
	}

	/**
	 * Metodo que pide los datos de la tarjeta
	 * 
	 * @return Tarjeta
	 */
	public static Tarjeta pedirTarjeta() {
		Tarjeta tar = new Tarjeta();
		System.out.println("----------------------------------------------------------\n");
		tar.setTipoTarjeta(Escanear(tipoTar));
		tar.setNumTarjeta(Escanear(numTar));
		tar.setTitular(Escanear(titularTar));
		tar.setCaducidad(Escanear(caduTar));
		tar.setCvc(Integer.parseInt(Escanear(cvcTar)));
		System.out.println("----------------------------------------------------------\n");
		if (tar.comprobarLongitud() == false) {
			return null;
		} else if (tar.comprobarCvc() == false) {
			return null;
		} else {
			return tar;
		}
	}

	/**
	 * Metodo que pide los datos del usuario
	 * 
	 * @return Registrado
	 */
	public static Registrado pedirDatos() {
		Registrado r1 = new Registrado();
		r1.setFechaNac(Escanear(fechaNacimiento));
		r1.setNombre(Escanear(nombre));
		r1.setApellido1(Escanear(primApellido));
		r1.setApellido2(Escanear(segApellido));

		r1.setCorreo(Escanear(correo));
		r1.setContrasena(Escanear(contrasenya));
		return r1;
	}

	/**
	 * Metodo que escanea la entrada
	 * 
	 * @param cadena
	 * @return cadena
	 */
	public static String Escanear(String cadena) {
		System.out.println(cadena);
		return (scanIn.nextLine());
	}
}
