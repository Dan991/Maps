package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.ItemListener;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;

public class PannelloDescrittivo extends JPanel {
	private JLabel lblMappa;
	private JLabel lblDestinazione;
	private JLabel lblNazione;
	private JLabel lblPrimoLivelloAmministrativo;
	private JLabel lblSecondoLivelloAmministrativo;
	private JLabel lblTipo;
	private JLabel lblTipoD;
	private JLabel lblPrimoAm;
	private JLabel lblSecondoAm;
	private JLabel lblNaz;
	private JScrollPane scrollPane;
	private JButton btnIndietro;
	private JButton btnPercorso;
	private JButton btnP;
	private JButton btnM;
	private JComboBox<String> cbTipo;
	private JTable table;
	private JButton btnCercaVicini;
	public PannelloDescrittivo() {
		setLayout(null);
		this.lblDestinazione = new JLabel("");
		this.lblDestinazione.setFont(new Font("Tahoma", Font.BOLD, 22));
		this.lblDestinazione.setBounds(10, 25, 830, 50);
		add(this.lblDestinazione);
		this.lblNazione = new JLabel("Nazione:");
		this.lblNazione.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.lblNazione.setBounds(10, 112, 91, 33);
		add(this.lblNazione);
		this.lblPrimoLivelloAmministrativo = new JLabel("Primo livello amministrativo:");
		this.lblPrimoLivelloAmministrativo.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.lblPrimoLivelloAmministrativo.setBounds(10, 171, 230, 33);
		add(this.lblPrimoLivelloAmministrativo);
		this.lblSecondoLivelloAmministrativo = new JLabel("Secondo livello amministrativo:");
		this.lblSecondoLivelloAmministrativo.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.lblSecondoLivelloAmministrativo.setBounds(10, 233, 242, 33);
		add(this.lblSecondoLivelloAmministrativo);
		this.lblTipo = new JLabel("Tipo destinazione:");
		this.lblTipo.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.lblTipo.setBounds(10, 300, 151, 33);
		add(this.lblTipo);
		this.lblTipoD = new JLabel("");
		this.lblTipoD.setForeground(Color.BLUE);
		this.lblTipoD.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.lblTipoD.setBounds(10, 344, 459, 33);
		add(this.lblTipoD);
		this.lblPrimoAm = new JLabel("");
		this.lblPrimoAm.setForeground(Color.BLUE);
		this.lblPrimoAm.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.lblPrimoAm.setBounds(236, 171, 219, 33);
		add(this.lblPrimoAm);
		this.lblSecondoAm = new JLabel("");
		this.lblSecondoAm.setForeground(Color.BLUE);
		this.lblSecondoAm.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.lblSecondoAm.setBounds(250, 233, 205, 33);
		add(this.lblSecondoAm);
		this.lblNaz = new JLabel("");
		this.lblNaz.setForeground(Color.BLUE);
		this.lblNaz.setFont(new Font("Tahoma", Font.BOLD, 15));
		this.lblNaz.setBounds(89, 112, 163, 33);
		add(this.lblNaz);
		this.scrollPane = new JScrollPane();
		this.scrollPane.setBounds(10, 486, 830, 355);
		add(this.scrollPane);
		this.table = new JTable();
		
		this.table.setFont(new Font("Tahoma", Font.BOLD, 18));
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Tipo"
			}
		));
		this.table.setFillsViewportHeight(true);
		this.scrollPane.setViewportView(this.table);
		this.btnIndietro = new JButton("Indietro");
		this.btnIndietro.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.btnIndietro.setBounds(10, 870, 230, 39);
		add(this.btnIndietro);
		this.btnPercorso = new JButton("Percorso");
		this.btnPercorso.setEnabled(false);
		this.btnPercorso.setFont(new Font("Tahoma", Font.BOLD, 14));
		this.btnPercorso.setBounds(610, 870, 230, 39);
		add(this.btnPercorso);
		this.btnP = new JButton("+");
		this.btnP.setBounds(788, 86, 41, 23);
		add(this.btnP);
		this.btnM = new JButton("-");
		this.btnM.setBounds(746, 86, 41, 23);
		add(this.btnM);
		this.cbTipo = new JComboBox<String>();
		this.cbTipo.setModel(new DefaultComboBoxModel<String>(new String[] {"Strada", "Satellite", "Terreno", "Ibrido"}));
		this.cbTipo.setSelectedIndex(0);
		this.cbTipo.setFont(new Font("Tahoma", Font.BOLD, 11));
		this.cbTipo.setBounds(479, 86, 100, 20);
		add(this.cbTipo);
		this.lblMappa = new JLabel("");
		this.lblMappa.setBounds(479, 86, 350, 375);
		add(this.lblMappa);
		this.btnCercaVicini = new JButton("Cerca posti vicini");
		this.btnCercaVicini.setFont(new Font("Tahoma", Font.BOLD, 22));
		this.btnCercaVicini.setBounds(10, 403, 320, 41);
		this.table.getColumn("Tipo").setCellRenderer(new PanelRender());
		this.table.getColumn("Tipo").setCellEditor(new PanelEditor());
		this.table.setRowHeight(90);
		this.table.getColumnModel().getColumn(0).setPreferredWidth(500);
		this.table.getColumnModel().getColumn(0).setMinWidth(500);
		
		add(this.btnCercaVicini);

	}
	public JLabel getLblMappa() {
		return lblMappa;
	}
	public JLabel getLblDestinazione() {
		return lblDestinazione;
	}
	public JLabel getLblTipoD() {
		return lblTipoD;
	}
	public JLabel getLblPrimoAm() {
		return lblPrimoAm;
	}
	public JLabel getLblSecondoAm() {
		return lblSecondoAm;
	}
	public JLabel getLblNaz() {
		return lblNaz;
	}
	public JButton getBtnIndietro() {
		return btnIndietro;
	}
	public JButton getBtnPercorso() {
		return btnPercorso;
	}
	
	public void AscoltaBottoni(ActionListener e){
		this.btnIndietro.addActionListener(e);
		this.btnPercorso.addActionListener(e);
		this.btnM.addActionListener(e);
		this.btnP.addActionListener(e);
		this.btnCercaVicini.addActionListener(e);

	}
	public JButton getBtnP() {
		return btnP;
	}
	public JButton getBtnM() {
		return btnM;
	}
	public void Ascoltacb(ItemListener e){
		this.cbTipo.addItemListener(e);
	}
	public JComboBox<String> getCbTipo() {
		return cbTipo;
	}
	public JButton getBtnCercaVicini() {
		return btnCercaVicini;
	}
	public JTable getTable() {
		return table;
	}

}
