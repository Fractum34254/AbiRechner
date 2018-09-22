package gui;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

class JListModel extends AbstractListModel<Object> { 

    private static final long serialVersionUID = 1L; 
    private ArrayList<String> data; 

    public JListModel() { 
        data = new ArrayList<String>(); 
        data.add("Deutsch"); 
        data.add("Englisch"); 
        data.add("Französisch"); 
        data.add("Spanisch"); 

    } 

    public int getSize() { 
        return data.size(); 
    } 

    public Object getElementAt(int index) { 
        return data.get(index); 
    } 

    public Object getIndex(Object o) { 
        return data.indexOf(o); 
    } 
} 

