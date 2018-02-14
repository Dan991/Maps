package view;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class PanelEditor extends AbstractCellEditor implements TableCellEditor {
	private JComponent panel = null;	

	public Object getCellEditorValue() {
		return panel;
	}

	public Component getTableCellEditorComponent(JTable table, Object value,
		boolean isSelected, int row, int column) {
		panel = (JComponent)value;
		return panel;
	}
}