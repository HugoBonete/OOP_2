package es.poo.simuladorprestamos;

public class Cuota {
	private int numero;
	private int importeInteres;
	private int importeAmortizado;
	private int importeCuota;
	private int capitalPendiente;
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getImporteInteres() {
		return importeInteres;
	}
	public void setImporteInteres(int importeInteres) {
		this.importeInteres = importeInteres;
	}
	public int getImporteAmortizado() {
		return importeAmortizado;
	}
	public void setImporteAmortizado(int importeAmortizado) {
		this.importeAmortizado = importeAmortizado;
	}
	public int getImporteCuota() {
		return importeCuota;
	}
	public void setImporteCuota(int importeCuota) {
		this.importeCuota = importeCuota;
	}
	public int getCapitalPendiente() {
		return capitalPendiente;
	}
	public void setCapitalPendiente(int capitalPendiente) {
		this.capitalPendiente = capitalPendiente;
	}

}
