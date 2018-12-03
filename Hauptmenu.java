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
	
		//::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::://
		
		//Menü
			// Menu
	    	JMenuBar menu = new JMenuBar();
	    	JMenu file = new JMenu("Menü");
	    	menu.add(file);
	    	frame1.setJMenuBar(menu);
	    	
	    	// Edit
	    	JMenu edit = new JMenu("Bearbeiten");
	    	menu.add(edit);
	    	frame1.setJMenuBar(menu);
	    	
	    	// Help
	    	JMenu help = new JMenu("Hilfe");
	    	menu.add(help);
	    	frame1.setJMenuBar(menu);
	    
	    	
	    	
	    //:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::://	
	    	
	    	
	    	
	    //Items in Menu
	    JMenuItem anew = new JMenuItem("Neu");
	    file.add(anew);
	    JMenuItem open = new JMenuItem("Öffnen");
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
    	        frame4.setVisible(true); 
    		}
    	});
	    
	    //ExitItem
	    exit.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		System.exit(0);}});
	    
	    //Neu-Inhalt
	    frame3.setSize(960, 540); 
	    frame3.setLocationRelativeTo(null);
        frame3.setVisible(false); 
        int x = 21;
        int y = 7;
	    JTable table = new JTable(x,y);
	    frame1.add(table);  // frame1.add(table); -> Auf Startbildschirm wir Tabelle auch angezeigt
	    
	    //Einfügen
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
    		
			}
    	});
	    
	    //LöschenItem
	    lö.addActionListener(new ActionListener(){;
    	public void actionPerformed(ActionEvent e){
    		int i=table.getSelectedRow();
    		if(i>=0){
    			table.removeAll(); // kurzzeitig gelöscht aber nach zellenwechsel wieder da -> muss direkt neu überschrieben werden
    		}
    		else{
    			System.out.println("Keine vorhandenen Daten, die gelöscht werden können");
    		}
			}
    	});
	    
	    
	    //AllesAuswählenItem
	    //   Adde deinem JTextField einen FocusListener. Und bei FocusGained selektierst du mit selectAll() den kompletten Inhalt.
    	ausw.addFocusListener(new FocusListener(){	
			public void focusGained(FocusEvent e) {
				table.selectAll(); // es sollte eigentlich allen Inhalt der Tabelle markieren
				
			}
			
			public void focusLost(FocusEvent e) {	
			}	
    	});
	    
	    //Neue Rechnung öffnen
	  		final WindowEventHandler handler1 = new WindowEventHandler(frame1, frame3);
	  		anew.addActionListener(new ActionListener() {
	  			public void actionPerformed(ActionEvent arg0) {
	  				frame1.setVisible(false);
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
	    

		//LanguageFenster öffnen
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
		frame2.setSize(400, 100);
		frame2.addWindowListener(handler2);
		frame2.setLocationRelativeTo(null);
		frame3.addWindowListener(handler1);
		// für frame 4 auch WindowListener?
    	

	}	
}




