package es.poo.simuladorprestamos;

import java.util.ArrayList;

public class TipoPrestamo {
	
	private static ModoPrestamo tPrestam;
	private int plazoMax;
	private int importMax;
	private double tipo;
	
	public enum ModoPrestamo
	{
		PERSONAL, HIPOTECARIO;
	}
	
	
	public int getPlazoMax() {
		return plazoMax;
	}
	public void setPlazoMax(int plazoMax) {
		this.plazoMax = plazoMax;
	}
	public int getImportMax() {
		return importMax;
	}
	public void setImportMax(int importMax) {
		this.importMax = importMax;
	}
	public double getTipo() {
		return tipo;
	}
	public void setTipo(double tipo) {
		this.tipo = tipo;
	}
	public ModoPrestamo gettPrestam() {
		return tPrestam;
	}
	public void settPrestam(ModoPrestamo tPrestam) {
		TipoPrestamo.tPrestam = tPrestam;
	}
	
	public static ArrayList<TipoPrestamo> obtenerPrestamo(ModoPrestamo modo)
	{
		ArrayList<TipoPrestamo> array = new ArrayList<TipoPrestamo>();
		if(modo == ModoPrestamo.PERSONAL)
		{
			
			TipoPrestamo tp1 = new TipoPrestamo();
			tp1.settPrestam(ModoPrestamo.PERSONAL);
			tp1.setTipo(5);
			tp1.setPlazoMax(48);
			tp1.setImportMax(15000);
			array.add(tp1);
		
			TipoPrestamo tp2 = new TipoPrestamo();
			tp2.settPrestam(ModoPrestamo.PERSONAL);
			tp2.setTipo(7);
			tp2.setPlazoMax(72);
			tp2.setImportMax(30000);
			array.add(tp2);
		}else {
			TipoPrestamo th1 = new TipoPrestamo();
			th1.settPrestam(ModoPrestamo.HIPOTECARIO);
			th1.setTipo(0.99);
			th1.setPlazoMax(240);
			th1.setImportMax(200000);
			array.add(th1);
			
			TipoPrestamo th2 = new TipoPrestamo();
			th2.settPrestam(ModoPrestamo.HIPOTECARIO);
			th2.setTipo(1.5);
			th2.setPlazoMax(420);
			th2.setImportMax(300000);
			array.add(th2);
			}
		return array;
	}
	public String dameCadena() {
		return "Tipo " +  tipo + ", Plazo maximo " + plazoMax + ", Importe maximo " + importMax;
	}

}
