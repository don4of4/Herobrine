package me.herobrine.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import bsh.util.JConsole;

public class Console extends JConsole {

	public Console() {
		super();
		super.setFont(new Font("Monospaced", 0, 11));
		super.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		
		JTextPane text = (JTextPane)viewport.getView();
		text.setMargin(new Insets(2, 2, 2, 2));
		
		text.setBackground(Color.black);
		text.setForeground(Color.white);
		
		text.setCaretColor(Color.white);
	}
	
}
