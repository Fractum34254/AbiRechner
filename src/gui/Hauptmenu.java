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


	public static void main(String[] args) {
		final JFrame frame1 = new JFrame("ABI-Rechner");		
		final JFrame frame2 = new JFrame("Sprache");
		final JFrame frame3 = new JFrame("Rechnung");
		final JFrame frame4 = new JFrame("Direkthilfe");
		
		/*hier nicht gleich alle Fenstergr��en und -positionen einf�gen, 
		um diese nicht bei jedem Klick auf ein Intem neu zu berechnen?
		--> ver�nderbare, im Hintergrund gespeicherte Fenstergr��en! (f�r die Pop-Up-Fenster) - Philipp */
	
		//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::://
		
		//Men�
			// MenuBar
	    	JMenuBar menu = new JMenuBar();
	    	
	    	// Menu
	    	JMenu file = new JMenu("Men�");
	    	menu.add(file);
	    	frame1.setJMenuBar(menu);			//notwendig? - Philipp
	    	
	    	// Edit
	    	JMenu edit = new JMenu("Bearbeiten");
	    	menu.add(edit);
	    	frame1.setJMenuBar(menu);			//notwendig? - Philipp
	    	
	    	// Help
	    	JMenu help = new JMenu("Hilfe");
	    	menu.add(help);
	    	frame1.setJMenuBar(menu);
	    
	    	
	    	
	    //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::://	
	    	
	    	
	    	
	    //Items in Menu
	    JMenuItem anew = new JMenuItem("Neu");
	    file.add(anew);
	    JMenuItem open = new JMenuItem("�ffnen");
	    file.add(open);
	    JMenuItem print = new JMenuItem("Drucken");
	    file.add(print);
	    JMenuItem language = new JMenuItem("Sprache");
	    file.add(language);
	    JMenuItem exit = new JMenuItem("Verlassen");
	    file.add(exit);
	    
	    //Items in Edit
	    JMenuItem rueck = new JMenuItem("R�ckg�ngig");
	    edit.add(rueck);
	    JMenuItem wied = new JMenuItem("Wiederherstellen");
	    edit.add(wied);
	    JMenuItem l� = new JMenuItem("L�schen");
	    edit.add(l�);
	    JMenuItem kop = new JMenuItem("Kopieren");
	    edit.add(kop);
	    JMenuItem einf = new JMenuItem("Einf�gen");
	    edit.add(einf);
	    JMenuItem ausw = new JMenuItem("Alles ausw�hlen");
	    edit.add(ausw);
	    
	    //Items in Help
	    JMenuItem helping = new JMenuItem("Direkthilfe");
	    help.add(helping);
	    JMenuItem webseite = new JMenuItem("Webseite");
	    help.add(webseite);
	    
	    
	    //::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::://
	    
	    
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
    		    frame4.setSize(960, 540); 					
    		    frame4.setLocationRelativeTo(null);
    	        frame4.setVisible(true);}});
	    
	    //ExitItem
	    exit.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		System.exit(0);}});
	    
	    //Neu-Inhalt
	    frame3.setSize(960, 540); 						//die folgenden Zeilen nicht oben deklarieren? 
	    frame3.setLocationRelativeTo(null);				//erh�ht die �bersichtlichkeit - Philipp
        frame3.setVisible(false); 
        int x = 21; int y = 29;
	    JTable table = new JTable(x,y);
	    frame1.add(table);  // frame1.add(table); -> Auf Startbildschirm wir Tabelle auch angezeigt -> sonst nur bei Neu frame3.add(table); - Lukas
	    
	    //TESTCODE-ANFANG - Philipp ================================================================================//
	    
	    //Zellschutz fehlt noch!!
	    table.setValueAt("Fach", 1,0 );
	    table.setValueAt("Leistungskurs?", 1,1 );
	    table.setValueAt("Pr�fung?", 1,2 );
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
	    
	    //TESTCODE-ENDE - Philipp =============================================================================//
	    
	    //Einf�gen
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
	    
	    //L�schenItem
	    l�.addActionListener(new ActionListener(){;
    	public void actionPerformed(ActionEvent e){
    		int i=table.getSelectedRow();
    		if(i>=0){
    			table.removeAll(); // kurzzeitig gel�scht aber nach zellenwechsel wieder da -> muss direkt neu �berschrieben werden - Lukas
    			//hier �berschreiben? - Lukas
    		}
    		else{
    			System.out.println("Keine vorhandenen Daten, die gel�scht werden k�nnen");
    		}
			}
    	});
	    
	    
	    //AllesAusw�hlenItem
    	ausw.addFocusListener(new FocusListener(){	
			public void focusGained(FocusEvent e) {
				table.selectAll(); // es soll wenn fertig allen Inhalt der Tabelle markieren - Lukas
			}
			
			public void focusLost(FocusEvent e) {	
			}	
    	});
	    
	    //Neue Rechnung �ffnen
	  		final WindowEventHandler handler1 = new WindowEventHandler(frame1, frame3);
	  		anew.addActionListener(new ActionListener() {
	  			public void actionPerformed(ActionEvent arg0) {
	  				frame1.setVisible(false); //warum? Finde es besser, wenn Hauptfenster immer ge�ffnet bleibt - Philipp
	  				frame3.setVisible(true);
	  			}});
	    
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
	    

		//LanguageFenster �ffnen
		final WindowEventHandler handler2 = new WindowEventHandler(frame1, frame2);
		language.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame1.setVisible(false);
				frame2.setVisible(true);
			}});
		
		
		
		// ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::: //
		
		

		//Eigenschaften
		frame1.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame1.setSize(1920, 1080);
		frame1.setLocationRelativeTo(null);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setVisible(true);
		frame2.setSize(500, 100);
		frame2.addWindowListener(handler2);
		frame2.setLocationRelativeTo(null);
		frame3.addWindowListener(handler1);
		// f�r frame 4 auch WindowListener? - Lukas
    	

	}	
}




