package me.herobrine.gui;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import bsh.util.JConsole;

public class Console extends JConsole {

	@Override
	public void mouseClicked(MouseEvent e) {
		super.requestFocus();
		super.mouseClicked(e);
	}

	@Override
	public void keyPressed(KeyEvent paramKeyEvent) {
		super.keyPressed(paramKeyEvent);
	}

	
	
}
