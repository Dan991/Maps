package model;

import java.util.ArrayList;

public class Componente_indirizzo {
	private String NomeCompleto;
	private String NomeAbbreviato;
	private ArrayList<String> Tipo;
	
	public Componente_indirizzo() {
		Tipo=new ArrayList<String>();
	}

	public Componente_indirizzo(String nomeCompleto, String nomeAbbreviato,String t[]) {
		NomeCompleto = nomeCompleto;
		NomeAbbreviato = nomeAbbreviato;
		Tipo=new ArrayList<String>();
		AggiungiTipo(t);
	}

	public void AggiungiTipo(String t[]) {
		for(int i=0;i<t.length;i++)
			Tipo.add(t[i]);
	}

	public String getNomeCompleto() {
		return NomeCompleto;
	}

	public String getNomeAbbreviato() {
		return NomeAbbreviato;
	}

	public ArrayList<String> getTipo() {
		return Tipo;
	}
	
}
