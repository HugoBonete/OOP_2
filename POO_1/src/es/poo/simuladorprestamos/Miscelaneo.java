package es.poo.simuladorprestamos;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import es.poo.simuladorprestamos.TipoPrestamo.ModoPrestamo;

public class Miscelaneo 
{
	
	private static final Scanner scanIn = new Scanner(System.in);
	/*Creo una funcion que escanea lo que introduce el usuario por pantalla.*/
	private static String Escanear(String cadena)
	{
		System.out.println(cadena);
		return (scanIn.nextLine());
	}
	
	/*Creo una funcion para pedir todos los datos necesarios de la persona por pantalla
	 * y llamo a la funcion validarFecha para que compruebe si la fecha introducida es valida.*/
	public static void pedirDatos(Persona pers)
	{
		pers.setNombre(Escanear("Introduzca su nombre:"));
		pers.setApellido1(Escanear("Introduzca su primer apellido:"));
		pers.setApellido2(Escanear("Introduzca su segundo apellido:"));
		pers.setSueldo(Integer.parseInt(Escanear("Introduzca su sueldo bruto anual:")));
		pers.setFecha(Escanear("Introduzca su fecha de nacimiento en formato 'dd/mm/aaaa':"));
		
		if(validarFecha(pers) == false)/*Preguntar si es mejor crear funcion pedirFecha para asi volver
		 automaticamente a introducir la fecha*/
		{
			System.out.println("Error, la fecha es incorrecta prueba introduciendo otra");
			
		}else {
			System.out.println("La fecha introducida es correcta");
		}
		
		if(Miscelaneo.calcularEdad(pers) == false)
		{
			System.out.println("Lamentamos comunicarle que los menores de edad no pueden solicitar préstamos, disculpe las molestias.");
			System.exit(0);
		}else {
			System.out.println("Eres mayor de edad");
		}
		
	}
	
	//Creo un metodo para pedir los datos del prestamo que se desean por pantalla
	public static void pedirPrestamo(TipoPrestamo tipoPrest)
	{
		int elec = Integer.parseInt(Escanear("¿Que tipo de prestamo desea?:\n" + "(1)Personal\n" + "(2)Hipotecario"));
		if(elec == 1)
		{

			ArrayList<TipoPrestamo> array = TipoPrestamo.obtenerPrestamo(ModoPrestamo.PERSONAL);
			System.out.println("Escoja el tipo de prestamo Hipotecario que desea");
			for (int i = 0; i < array.size(); i++) 
			{
				System.out.println("(" + (i + 1) + ") " + array.get(i).dameCadena());
			}
			elec = Integer.parseInt(Escanear(""));
				if(elec == 1)
				{	
					array.get(elec - 1);
				}else if(elec == 2)
				{
					array.get(elec - 1);
				}else
				{
					System.out.println("El prestamo elegido no existe.");
					System.exit(0);
				}	
		}else if(elec == 2)	{
			
			ArrayList<TipoPrestamo> array = TipoPrestamo.obtenerPrestamo(ModoPrestamo.HIPOTECARIO);
			System.out.println("Escoja el tipo de prestamo Hipotecario que desea\n");
			for (int i = 0; i < array.size(); i++) 
			{
				System.out.println(array.get(i).dameCadena());
			}
			elec = Integer.parseInt(Escanear(""));
			elec = Integer.parseInt(Escanear(""));
				if(elec == 1)
				{
					array.get(elec - 1);
				}else if(elec == 2)
				{
					array.get(elec - 1);
				}else
				{
					System.out.println("El prestamo elegido no existe.");
					System.exit(0);
				}
			
		}else {
			System.out.println("El prestamo elegido no existe.");
			System.exit(0);
		}
	}
	
	public static void calcularPrestamo(Prestamo TipoPrestamo)
	{
		
	}
	
	public static boolean validarFecha(Persona pers)
	{
		try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            formatoFecha.setLenient(false);
            formatoFecha.parse(pers.getFecha());
        } catch (ParseException e) {
            return false;
        }
        return true;
	}
	
	/*Creo una funcion para calcular la edad y posteriormente comprobar si la
	 * persona es mayor o menor de edad*/
	public static boolean calcularEdad(Persona pers)
	{
		DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse(pers.getFecha(), formatoFecha);
		LocalDate ahora = LocalDate.now();
		Period edad = Period.between(fechaNac, ahora);
		if(edad.getYears() < 18)
		{
			return false;
		}else {
			return true;
		}
		
	}	
}



