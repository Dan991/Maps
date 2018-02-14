package view;

import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class PanelRender extends DefaultTableCellRenderer {

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		if(value instanceof JComponent) {
			return (JComponent)value;
		} 
		else {
			return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		}
	} 
}