package model;

import java.util.ArrayList;

public class Risultati {
	private ArrayList<Risultato> Risultati;
	
	public Risultati() {
		Risultati=new ArrayList<Risultato>();
	}

	public ArrayList<Risultato> getRisultati() {
		return Risultati;
	}

	public void AggiungiRisultato(Risultato r){
		Risultati.add(r);
	}
}
