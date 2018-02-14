package control;
import model.Risultati;
import model.Risultato;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import model.Http;
import view.Finestra;
import view.PannelloDescrittivo;
import view.PannelloRicerca;

public class ControllerPannelloRicerca implements ActionListener{
	private Finestra f;
	private PannelloRicerca pR;
	private Http r;
	private PannelloDescrittivo pD;
	private Risultati R;
	public ControllerPannelloRicerca(Finestra f,Http r) {
		this.f=f;
		this.pR=f.getPR();
		this.r=r;
		this.pD=f.getpD();
		this.pR.AscotaComponenti(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==pR.getBtnCerca()){
			if(!pR.getTfRicerca().getText().equals("")&&!pR.getTfRicerca().getText().equals(null)){
				R = r.rispostaDestinazione(pR.getTfRicerca().getText().replaceAll(" ", "+"));
				ArrayList<Risultato> ris=R.getRisultati();
				DefaultTableModel tm=(DefaultTableModel) pR.getTable().getModel();
				
				for(int i=tm.getRowCount()-1;i>=0;i--)
					tm.removeRow(i);
				
				for(int i=0;i<ris.size();i++){		
					String ind="";
					for(int i2=0;i2<ris.get(i).getComponenti().size();i2++)
						if(ris.get(i).getComponenti().get(i2).getTipo().contains("country"))
							ind=ris.get(i).getComponenti().get(i2).getNomeCompleto();					
					tm.addRow(new Object[]{ris.get(i).getNome(),ind});
				}
			}
		}
		else{
			if(e.getSource()==pR.getBtnVai()){
				if(pR.getTable().getSelectedRow()!=-1){
					Risultato ris=R.getRisultati().get(pR.getTable().getSelectedRow());
					pD.getLblDestinazione().setText(ris.getNome());
					for(int i=0;i<ris.getComponenti().size();i++)
						if(ris.getComponenti().get(i).getTipo().contains("country"))
							pD.getLblNaz().setText(ris.getComponenti().get(i).getNomeCompleto());
					for(int i=0;i<ris.getComponenti().size();i++)
						if(ris.getComponenti().get(i).getTipo().contains("administrative_area_level_1"))
							pD.getLblPrimoAm().setText(ris.getComponenti().get(i).getNomeCompleto());		
					for(int i=0;i<ris.getComponenti().size();i++)
						if(ris.getComponenti().get(i).getTipo().contains("administrative_area_level_2"))
							pD.getLblSecondoAm().setText(ris.getComponenti().get(i).getNomeCompleto());
					this.TipoDD(ris);
					r.Immagine(ris.getCordinate().getLatitudine(),ris.getCordinate().getLongitudine() ,12, pD.getLblMappa(),"roadmap");
					DefaultTableModel tm=(DefaultTableModel) pD.getTable().getModel();
					for(int i=tm.getRowCount()-1;i>=0;i--)
						tm.removeRow(i);
					pD.getTable().setModel(tm);
					f.Contenuto(1);
				}
			}
		}
	}
	
	public void TipoDD(Risultato r){
		pD.getLblTipoD().setText("");
		for(int i=0;i<r.getTipo().size();i++){
			String tipo="";
			switch(r.getTipo().get(i)){
			case "street_address":	tipo="Strada, ";
				break;
			case "intersection":	tipo="Intersezione tra strade, ";
				break;
			case "country":tipo="Stato, ";
				break;
			case "locality":tipo="Località, ";
				break;
			case "ward":tipo="Località giapponese, ";
				break;
			case "premise":tipo="Insieme di costruzioni, ";
				break;
			case "airport":tipo="Aereoporto, ";
				break;
			case "park":tipo="Parco, ";
				break;
			case "point_of_interest":tipo="Punto di intaresse ,";
				break;
			case "parking":tipo="Parcheggio, ";
				break;
			case "bus_station":tipo="Stazione dei bus, ";
				break;
			case "train_station":tipo="Stazione dei treni, ";
				break;
			case "transit_station":tipo="Fermata del trasporto pubblico, ";
				break;
			default:
				break;
			}
			
			
			
			pD.getLblTipoD().setText(pD.getLblTipoD().getText()+tipo);

		}
			
	}

}
