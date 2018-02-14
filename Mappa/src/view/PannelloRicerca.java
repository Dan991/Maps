package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionEvent;

public class PannelloRicerca extends JPanel {
	private JLabel lblLuogo;
	private JTextField tfRicerca;
	private JScrollPane scrollPane;
	private JButton btnVai;
	private JTable table;
	private JButton btnCerca;

	public PannelloRicerca() {
		setLayout(null);
		this.lblLuogo = new JLabel("Luogo:");
		this.lblLuogo.setHorizontalAlignment(SwingConstants.CENTER);
		this.lblLuogo.setFont(new Font("Arial", Font.BOLD, 28));
		this.lblLuogo.setBounds(10, 37, 303, 41);
		add(this.lblLuogo);
		this.tfRicerca = new JTextField();
		this.tfRicerca.setFont(new Font("Tahoma", Font.BOLD, 20));
		this.tfRicerca.setBounds(323, 37, 267, 41);
		add(this.tfRicerca);
		this.tfRicerca.setColumns(10);
		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(10, 124, 980, 379);
		add(this.scrollPane);
		this.table = new JTable();
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.table.setShowGrid(false);
		this.table.setFillsViewportHeight(true);
		this.table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Indirizzo", "Nazione"
			}
		));
		this.table.getColumnModel().getColumn(0).setPreferredWidth(500);
		this.table.getColumnModel().getColumn(0).setMinWidth(500);
		this.table.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.scrollPane.setViewportView(this.table);
		this.btnVai = new JButton("Vai alla descrizione");
		this.btnVai.setFont(new Font("Tahoma", Font.BOLD, 22));
		this.btnVai.setBounds(555, 561, 435, 49);
		add(this.btnVai);
		this.btnCerca = new JButton("Cerca");
		this.btnCerca.setFont(new Font("Tahoma", Font.BOLD, 22));
		this.btnCerca.setBounds(632, 37, 320, 41);
		add(this.btnCerca);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		this.table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		this.table.setRowHeight(40);

	}

	public JTextField getTfRicerca() {
		return tfRicerca;
	}


	public JButton getBtnVai() {
		return btnVai;
	}

	public JTable getTable() {
		return table;
	}
	
	public void AscotaComponenti(ActionListener e){
		this.btnVai.addActionListener(e);
		this.btnCerca.addActionListener(e);
	}

	public JButton getBtnCerca() {
		return btnCerca;
	}
}
