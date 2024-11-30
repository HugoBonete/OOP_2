package es.poo.simuladorprestamos;

import java.util.Scanner;

public class Main 
{
	private static final Scanner scanIn = new Scanner(System.in);

	public static void main(String[] args) 
	{
		TipoPrestamo tipoPrest = new TipoPrestamo();
		Persona pers = new Persona();
		Prestamo prest = new Prestamo();
		ArrayList<tipoPrest> arrTprest = new ArrayList<tipoPrest>();
		
		
		prest.setPers1(pers);
		Miscelaneo.pedirDatos(pers);
		
		Miscelaneo.pedirPrestamo(tipoPrest);
		TipoPrestamo tprest = new Prestamo(array.get(i))
		
		scanIn.close();
	}
}