package es.poo.tiendaonline.envio;

public class FormaEnvio {
	private double precioEnvio;
	private String tipoEnvio;

	public void setPrecioEnvio(double precioEnvio) {
		this.precioEnvio = precioEnvio;
	}

	public void setTipoEnvio(String tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}

	public double getPrecioEnvio() {
		return precioEnvio;
	}

	public String getTipoEnvio() {
		return tipoEnvio;
	}

}
