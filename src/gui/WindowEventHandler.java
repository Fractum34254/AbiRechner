package gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

class WindowEventHandler extends WindowAdapter {
	private JFrame frame1;
	private JFrame frame2;

	public WindowEventHandler(JFrame frame1, JFrame frame2) {
		this.frame1 = frame1;
		this.frame2 = frame2;
	}

	public void windowClosing(WindowEvent evt) {
		frame1.setVisible(true);
		frame2.setVisible(false);
	}
}
