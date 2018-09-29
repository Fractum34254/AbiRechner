package gui;
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.net.URI;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;





public class Hauptmenu {

        static final int x = 21; 
        static final int y = 29;
        static JTable table = new JTable(x,y);
       	public static void main(String[] args) {
                //Fenster erschaffen
		final JFrame frame1 = new JFrame("ABI-Rechner");		
		final JFrame frame2 = new JFrame("Sprache");
		final JFrame frame3 = new JFrame("Neu");
		final JFrame frame4 = new JFrame("Direkthilfe");
                
                //Eigenschaften
                //Hauptfenster
		frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame1.setSize(1920, 1080);
		frame1.setLocationRelativeTo(null);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setVisible(true);
                //Sprache
		frame2.setSize(500, 100);
		frame2.setLocationRelativeTo(null);
                //Neu
                frame3.setSize(960, 540); 			
                frame3.setLocationRelativeTo(null);     
                frame3.setVisible(false); 
                //Hilfe
                frame4.setSize(960, 540); 					
    		frame4.setLocationRelativeTo(null);
			
		//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::://
		
                //Tabelle
                frame1.add(table);  
                // frame1.add(table); 
                //-> Auf Startbildschirm wir Tabelle auch angezeigt 
                //-> sonst nur bei Neu frame3.add(table); - Lukas
                
                //Zellschutz fehlt noch!!
            
                
            
	    table.setValueAt("LK / GK", 1,0 );
            table.setValueAt("LK", 2, 0);
            table.setValueAt("LK", 3, 0);
            table.setValueAt("GK", 4, 0);
            table.setValueAt("GK", 5, 0);
            table.setValueAt("GK", 6, 0);
            table.setValueAt("GK", 7, 0);
	    table.setValueAt("Fach", 1,1 );
	    table.setValueAt("PrÃ¼fung?", 1,2 );
            table.setValueAt("\u2713", 2,2 ); //schmales HÃ¤kchen (fettes: \u2714)
	    table.setValueAt("Semester 11/I", 0,3 );
	    table.setValueAt("Semester 11/II", 0,9 );
	    table.setValueAt("Semester 12/I", 0,15 );
	    table.setValueAt("Semester 12/II", 0,21 );
	    table.setValueAt("Klausuren", 1,3 );
	    table.setValueAt("sonstige Noten", 1,5 );
	    table.setValueAt("Klausuren", 1,9 );
	    table.setValueAt("sonstige Noten", 1,11 );
	    table.setValueAt("Klausuren", 1,15 );
	    table.setValueAt("sonstige Noten", 1,17 );
	    table.setValueAt("Klausuren", 1,21 );
	    table.setValueAt("sonstige Noten", 1,23 );
	    table.setValueAt("Fachschnitt", 1, 27);
	    table.setValueAt("Summe der eingebrachten Punkte", 1, 28);
	    table.doLayout(); //warum werden die Spalten nicht angepasst?
                
                //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::://
                
		//MenÃ¼ Grundbausteine
                // MenuBar
	    	JMenuBar menu = new JMenuBar();
	    	
	    	// Menu
	    	JMenu file = new JMenu("Menï¿½");
	    	menu.add(file);		
	    	
	    	// Edit
	    	JMenu edit = new JMenu("Bearbeiten");
	    	menu.add(edit);		
                    
	    	// Help
	    	JMenu help = new JMenu("Hilfe");
	    	menu.add(help);
	    	frame1.setJMenuBar(menu);
                
        //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::://	
	    
	//Items in Menu
	JMenuItem anew = new JMenuItem("Neu");
	file.add(anew);
	JMenuItem open = new JMenuItem("ï¿½ffnen");
	file.add(open);
	JMenuItem print = new JMenuItem("Drucken");
	file.add(print);
	JMenuItem language = new JMenuItem("Sprache");
        file.add(language);
	JMenuItem exit = new JMenuItem("Verlassen");
	file.add(exit);
	    
	//Items in Edit
	JMenuItem rueck = new JMenuItem("Rückgängig");
	edit.add(rueck);
	JMenuItem wied = new JMenuItem("Wiederherstellen");
	edit.add(wied);
	JMenuItem lö = new JMenuItem("Löschen");
	edit.add(lö);
	JMenuItem kop = new JMenuItem("Kopieren");
	edit.add(kop);
	JMenuItem einf = new JMenuItem("Einfügen");
	edit.add(einf);
	JMenuItem ausw = new JMenuItem("Alles auswählen");
	edit.add(ausw);
	  
	//Items in Help
	JMenuItem helping = new JMenuItem("Direkthilfe");
	help.add(helping);
	JMenuItem webseite = new JMenuItem("Webseite");
	help.add(webseite);
	    
	    
	//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::://
	    
	//Klick-Listener fÃ¼r Checkmarks (Spalte 3 bzw 2)
       /*ListSelectionModel newmodel = table.getSelectionModel(); 
        newmodel.addListSelectionListener(new ListSelectionListener() { 
        public void valueChanged(ListSelectionEvent e) { 
            int row = table.getSelectedRow(); 
            int column = table.getSelectedColumn(); 
        int cell = getNewNum(); 
        datefield.setText(String.valueOf(cell)); 
    } 
});
}); */ 
        
        
	// WebseiteItem
	webseite.addActionListener(new ActionListener(){;
            public void actionPerformed(ActionEvent e){
                Desktop desktop = Desktop.getDesktop();
	    	URI uri;
	    	try{
                    uri = new URI("https://www.lgd.de/");
                    desktop.browse(uri);} 
	    		catch (Exception oError) {
                            oError.printStackTrace();} 
	    		}
	    	});
	    
	//DirekthilfeItem
	helping.addActionListener(new ActionListener(){;
            public void actionPerformed(ActionEvent e){    
    	        frame4.setVisible(true);}});
	    
	//ExitItem
	exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);}});
	    
	//Einfï¿½gen
	einf.addActionListener(new ActionListener(){;
    	public void actionPerformed(ActionEvent e){
	    try {
	    	SystemClipboard.paste();} 
	    catch (AWTException e1) {
			e1.printStackTrace();}
            }
    	});
	    
	//Kopieren
	kop.addActionListener(new ActionListener(){;
            public void actionPerformed(ActionEvent e){
                SystemClipboard.copy(null); // statt null -> Zelleninhalt - Lukas
            }
    	});
	    
	//Lï¿½schenItem
	lö.addActionListener(new ActionListener(){;
    	public void actionPerformed(ActionEvent e){
            int i=table.getSelectedRow();
            if(i>=0){
    		table.removeAll(); // kurzzeitig gelöscht aber nach zellenwechsel wieder da -> muss direkt neu überschrieben werden - Lukas
    			//hier überschreiben? - Lukas
            }
            else{
    		System.out.println("Keine vorhandenen Daten, die gelï¿½scht werden kï¿½nnen");
    		}
            }
    	});
	    
	    
	//AllesAuswählenItem
    	ausw.addFocusListener(new FocusListener(){	
            public void focusGained(FocusEvent e) {
		table.selectAll(); // es soll wenn fertig allen Inhalt der Tabelle markieren - Lukas
            }
			
            public void focusLost(FocusEvent e) {	
            }	
    	});
	    
	
	    
	//LanguageFenster Inhalt 
	JList<?> liste; 
	JPanel einPanel; 
	JListModel model = new JListModel(); 
        einPanel = new JPanel(new GridLayout(1, 2));  
        liste = new JList<Object>(model); 
        JScrollPane sp = new JScrollPane(liste); 
        frame2.getContentPane().add(einPanel, BorderLayout.NORTH); 
        frame2.getContentPane().add(sp, BorderLayout.CENTER);  
        frame2.setSize(300, 200); 
        frame2.setVisible(false); 
	    

	//LanguageFenster öffnen (frame 2)
	language.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
            frame2.setVisible(true);
	}});
        
        //Neue Rechnung öffnen (frame 3)
	anew.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent arg0) {
            frame3.setVisible(true);
	}});
		
		
            // ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: //
		
		
            
	    
	    
	    
	}	
}




