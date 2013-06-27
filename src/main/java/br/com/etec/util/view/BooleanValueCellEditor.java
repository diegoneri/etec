/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.util.view;

import java.awt.Component;
import java.util.EventObject;
import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

public class BooleanValueCellEditor extends AbstractCellEditor  implements TableCellEditor {
    private Boolean selectedValue;
    private JCheckBox field;
    
    public BooleanValueCellEditor() {
        super();
    }

    public Boolean getSelectedValue(){
        return (Boolean) getCellEditorValue();
    }
    
    private JCheckBox getField(){
        if (field == null){
            field = new JCheckBox();
        }
        return field;
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        System.out.println("getTableCellEditorComponent. Field: " + getField().toString() + ", value: " + getField().isSelected());
        getField().setSelected((Boolean)value);
        return getField();
    }

    @Override
    public Object getCellEditorValue() {
        this.selectedValue = getField().isSelected();
        return selectedValue;
    }

    @Override
    public boolean isCellEditable(EventObject anEvent) {
        System.out.println("isCellEditable " + anEvent.getSource());
        return super.isCellEditable(anEvent);
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        System.out.println("shouldSelectCell " + anEvent.getSource());
        return super.shouldSelectCell(anEvent);
    }

}