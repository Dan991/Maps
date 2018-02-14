package model;

public class Cordinate {
	private double latitudine;
	private double longitudine;
	
	public Cordinate() {
		latitudine=0;
		longitudine=0;
	}

	public double getLatitudine() {
		return latitudine;
	}

	public Cordinate(double latitudine, double longitudine) {
		this.latitudine = latitudine;
		this.longitudine = longitudine;
	}

	public double getLongitudine() {
		return longitudine;
	}

}
