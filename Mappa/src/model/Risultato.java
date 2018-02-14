package model;

import java.util.ArrayList;

public class Risultato {
	private ArrayList<Componente_indirizzo> Componenti;
	private Cordinate Cordinate;
	private String Nome;
	private String placeid;
	private ArrayList<String> Tipo;
	private String Icona;
	public Risultato() {
		Componenti=new ArrayList<Componente_indirizzo>();
		Cordinate=new Cordinate();
		Tipo=new ArrayList<String>();
	}
	
	public void AggiungiComponente(Componente_indirizzo cp) {
		Componenti.add(cp);
	}
	
	public void AggiungiTipo(String t[]) {
		for(int i=0;i<t.length;i++)
			Tipo.add(t[i]);
	}

	public ArrayList<Componente_indirizzo> getComponenti() {
		return Componenti;
	}

	public Cordinate getCordinate() {
		return Cordinate;
	}

	public String getNome() {
		return Nome;
	}

	public ArrayList<String> getTipo() {
		return Tipo;
	}

	public void setCordinate(Cordinate cordinate) {
		Cordinate = cordinate;
	}

	public void setNome(String indirizzo) {
		Nome = indirizzo;
	}

	public String getPlaceid() {
		return placeid;
	}

	public void setPlaceid(String placeid) {
		this.placeid = placeid;
	}

	public String getIcona() {
		return Icona;
	}

	public void setIcona(String icona) {
		Icona = icona;
	}



}
