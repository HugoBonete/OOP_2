package es.poo.simuladorprestamos;

public class Persona 
{
	private String Nombre;
	private String Apellido1;
	private String Apellido2;
	private int Sueldo;
	private String Fecha;
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido1() {
		return Apellido1;
	}
	public void setApellido1(String apellido1) {
		Apellido1 = apellido1;
	}
	public String getApellido2() {
		return Apellido2;
	}
	public void setApellido2(String apellido2) {
		Apellido2 = apellido2;
	}
	public int getSueldo() {
		return Sueldo;
	}
	public void setSueldo(int sueldo) {
		Sueldo = sueldo;
	}
	public String getFecha() {
		return Fecha;
	}
	public void setFecha(String fecha) {
		//todo: Validar la fecha en el setter. 
			Fecha = fecha;
	}
	
	
}
