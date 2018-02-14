package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import model.Http;
import model.Risultati;
import model.Risultato;
import view.Finestra;
import view.PannelloDescrittivo;

public class ControllerPannelloDescrittivo implements ActionListener,ItemListener{
	private Http r;
	private Finestra f;
	private PannelloDescrittivo pD;
	private int zoom=12;
	private String tipo="roadmap";
	private Risultati R;
	public ControllerPannelloDescrittivo(Finestra f,Http r) {
		this.f=f;
		this.r=r;
		this.pD=f.getpD();
		this.pD.AscoltaBottoni(this);
		this.pD.Ascoltacb(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==pD.getBtnCercaVicini()){
			R=r.rispostaLuoghiVicini();
			ArrayList<Risultato> ris=R.getRisultati();
			DefaultTableModel tm=(DefaultTableModel) pD.getTable().getModel();
			
			for(int i=tm.getRowCount()-1;i>=0;i--)
				tm.removeRow(i);
			
			for(int i=0;i<ris.size();i++){		
				 URL url;
				 BufferedImage image = null;
				try {
					url = new URL(ris.get(i).getIcona());
					image = ImageIO.read(url);
				} catch (MalformedURLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		 	 
				tm.addRow(new Object[]{ris.get(i).getNome(),new JLabel(new ImageIcon(image))});
			}
		}
		else{
		if(e.getSource()==pD.getBtnM()){
			if(zoom!=7){
				zoom--;
				r.RImmagine(zoom, pD.getLblMappa(),tipo);
			}
		}
		else{
			if(e.getSource()==pD.getBtnP()){
				if(zoom!=20){
					zoom++;
					r.RImmagine(zoom, pD.getLblMappa(),tipo);
				}
			}
		}
		if(e.getSource()==pD.getBtnIndietro()){
			f.Contenuto(0);
		}
		else{
			if(e.getSource()==pD.getBtnPercorso()){
				if(pD.getTable().getSelectedRow()!=-1){
					
				}
			}
		}
		}
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==pD.getCbTipo()){
				switch(pD.getCbTipo().getSelectedItem().toString()){
					case "Satellite":	tipo="satellite"; r.RImmagine(zoom, pD.getLblMappa(),tipo);	
							break;
					case "Ibrido":	tipo="hybrid"; r.RImmagine(zoom, pD.getLblMappa(),tipo); 
							break;
					case "Terreno":	tipo="terrain"; r.RImmagine(zoom, pD.getLblMappa(),tipo);	
							break;
					case "Strada":	tipo="roadmap"; r.RImmagine(zoom, pD.getLblMappa(),tipo);
						break;
				}
		}
	}

	public Risultati getR() {
		return R;
	}


}
