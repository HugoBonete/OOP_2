package es.poo.simuladorprestamos;
import java.util.ArrayList;

public class Prestamo {
	private Persona pers1;
	private TipoPrestamo tipo;
	private ArrayList<Cuota> arrCuota;

	private String fecha;
	private int importeSol;
	private int plazoEnMes;
	private int tipoInteres;
	private int importeTotInteres;
	private int importeTot;
	
	
	public TipoPrestamo getTipo() {
		return tipo;
	}
	public void setTipo(TipoPrestamo tipo) {
		this.tipo = tipo;
	}
	public int getImporteSol() {
		return importeSol;
	}
	public void setImporteSol(int importeSol) {
		this.importeSol = importeSol;
	}
	public int getPlazoEnMes() {
		return plazoEnMes;
	}
	public void setPlazoEnMes(int plazoEnMes) {
		this.plazoEnMes = plazoEnMes;
	}
	public int getTipoInteres() {
		return tipoInteres;
	}
	public int getImporteTotInteres() {
		return importeTotInteres;
	}
	public int getImporteTot() {
		return importeTot;
	}
	public Persona getPers1() {
		return pers1;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public void setPers1(Persona pers1) {
		this.pers1 = pers1;
	}
	
	//Comprobar que los datos introducidos cuadren con el prestamo escogido
	private boolean comprobarPrestamo()
	{
		return	true;
	}
	
	private void calcularCuota()
	{
		if(arrCuota == null)
		{
			arrCuota = new ArrayList<Cuota>();
		}
		
	}
	
	private void calcularAmortizacion()
	{
		
		for(int i = 0; i < plazoEnMes; i++)
		{
			arrCuota = new ArrayList<Cuota>();
			Cuota cuota = new Cuota();
			cuota.setNumero(i + 1);
			cuota.setImporteCuota(1000);
			cuota.setImporteInteres(10);
			
			arrCuota.add(cuota);
		}
	}
}
