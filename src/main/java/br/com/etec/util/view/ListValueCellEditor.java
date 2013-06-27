/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.etec.util.view;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.EventObject;
import java.util.List;
import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellEditor;

public abstract class ListValueCellEditor<T> extends AbstractCellEditor implements TableCellEditor {

    private T selectedValue;
    private JComboBox<T> field;
    private ItemListener fieldListener;
    private List<T> values;

    public ListValueCellEditor(List<T> values) {
        super();
        this.values = values;
        
    }

    public T getSelectedValue() {
        return (T) getCellEditorValue();
    }

    private JComboBox<T> getField() {
        if (field == null) {
            field = new JComboBox<>((T[]) values.toArray());
            this.initializeField();
        }
        return field;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        System.out.println("getTableCellEditorComponent. Field: " + getField().getSelectedItem() + ", value: " + value);
        if (value != null) {
            getField().setSelectedItem(value);    
        }
        
        return getField();
    }

    @Override
    public Object getCellEditorValue() {
        this.selectedValue = (T) getField().getSelectedItem();
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

    private void initializeField() {
        field.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fieldItemStateChanged(evt);
            }
        });
        field.setFont(new Font("Arial", Font.ITALIC, 9));
        field.setBorder(null);
    }

    private void fieldItemStateChanged(ItemEvent evt) {
        if(evt.getItem() != null){
            selectedValue = (T)evt.getItem();           
        }
    }
}