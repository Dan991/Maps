package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.ControllerPannelloDescrittivo;
import control.ControllerPannelloRicerca;
import model.Http;

public class Finestra extends JFrame {

	private PannelloRicerca pR;
	private PannelloDescrittivo pD;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Http r=new Http();
					Finestra frame = new Finestra();		
					frame.setVisible(true);
					ControllerPannelloRicerca cr=new ControllerPannelloRicerca(frame, r);
					ControllerPannelloDescrittivo cd=new ControllerPannelloDescrittivo(frame, r);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Finestra() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 1030, 700);
		pR=new PannelloRicerca();
		pD=new PannelloDescrittivo();
		setContentPane(this.pR);
	}

	public PannelloRicerca getPR() {
		return pR;
	}

	public PannelloDescrittivo getpD() {
		return pD;
	}
	
	public void Contenuto(int i){
		switch (i) {
			case 0:
				setBounds(200, 200, 1030, 700);
				this.setContentPane(this.pR);
				break;
			case 1:
				setBounds(200, 10, 880, 960);
		
				this.setContentPane(this.pD);
				break;
			default:
				break;
		}
			
	}
}
