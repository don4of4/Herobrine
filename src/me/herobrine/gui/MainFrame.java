package me.herobrine.gui;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import net.minecraft.client.MinecraftApplet;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class MainFrame extends JFrame {

	private Applet minecraftApplet;
	private Console console;
	private JMenuBar menuBar;
	
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		super("Herobrine");
		
		setBounds(100, 100, 524, 324);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		super.setMinimumSize(new Dimension(427, 240 + 100));
		
		menuBar = new JMenuBar();
		super.add(menuBar, BorderLayout.NORTH);
		
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem_4);
		
		final JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(1.0);
		splitPane.setOneTouchExpandable(true);
		splitPane.setContinuousLayout(true);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		super.add(splitPane, BorderLayout.CENTER);
		
		this.minecraftApplet = this.createMinecraftApplet();
		JPanel minecraftContainer = new JPanel();
		minecraftContainer.setLayout(new BorderLayout());
		minecraftContainer.setMinimumSize(new Dimension(427, 40));
		minecraftContainer.setPreferredSize(new Dimension(854, 480 + 42));
		minecraftContainer.add(minecraftApplet);
		splitPane.setLeftComponent(minecraftContainer);
		
		this.console = this.createConsole();
		JPanel consoleContainer = new JPanel();
		consoleContainer.setLayout(new BorderLayout());
		consoleContainer.setMinimumSize(new Dimension(427, 40));
		consoleContainer.setPreferredSize(new Dimension(427, 80));
		consoleContainer.add(console);
		splitPane.setRightComponent(consoleContainer);
		
		super.validate();
		super.pack();

        minecraftApplet.init();
        minecraftApplet.start();
	}
	
	private Applet createMinecraftApplet() {
		Map<String, String> properties = new HashMap<String, String>();
        properties.put("demo", "false");
        properties.put("stand-alone", "true");
        properties.put("fullscreen", "false");
        
        properties.put("username", "Herobrine");
        properties.put("sessionid", "");
        
        MinecraftApplet mcApplet = new MinecraftApplet();
        mcApplet.setStub(new MinecraftStub(properties));
        
        return mcApplet;
	}
	
	private Console createConsole() {
		Console console = new Console();
		return console;
	}

}
