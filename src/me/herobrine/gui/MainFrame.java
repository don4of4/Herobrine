package me.herobrine.gui;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import java.awt.Toolkit;
import javax.swing.KeyStroke;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;


public class MainFrame extends JFrame {

	private Applet minecraftApplet;
	private Console console;
	private JMenuBar menuBar;
	private JProgressBar statusProgressBar;
	private JLabel statusLabel;

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		super("Herobrine");
		super.setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.class.getResource("/me/herobrine/gui/herobrine.png")));
		super.setBounds(100, 100, 524, 324);
		getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel statusPanel = new JPanel();
		statusPanel.setBorder(new EmptyBorder(1, 1, 1, 1));
		super.add(statusPanel, BorderLayout.SOUTH);
		statusPanel.setLayout(new BorderLayout(0, 0));

		statusLabel = new JLabel("Idle...");
		statusLabel.setBorder(new EmptyBorder(0, 2, 0, 0));
		statusPanel.add(statusLabel, BorderLayout.CENTER);

		statusProgressBar = new JProgressBar();
		statusProgressBar.setVisible(false);
		statusPanel.add(statusProgressBar, BorderLayout.WEST);

		super.setMinimumSize(new Dimension(427, 240 + 100));

		menuBar = new JMenuBar();
		super.add(menuBar, BorderLayout.NORTH);

		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');
		menuBar.add(fileMenu);

		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		fileMenu.add(exitMenuItem);
		
		JMenu windowMenu = new JMenu("Window");
		windowMenu.setMnemonic('W');
		menuBar.add(windowMenu);
		
		JMenuItem settingsMenuItem = new JMenuItem("Settings");
		settingsMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				SettingsDialog dialog = new SettingsDialog(MainFrame.this);
				dialog.setVisible(true);
			}
		});
		settingsMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		windowMenu.add(settingsMenuItem);
		
		JMenu helpMenu = new JMenu("Help");
		helpMenu.setMnemonic('H');
		menuBar.add(helpMenu);
		
		JMenuItem aboutMenuItem = new JMenuItem("About");
		aboutMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent paramActionEvent) {
				AboutDialog dialog = new AboutDialog(MainFrame.this);
				dialog.setVisible(true);
			}
		});
		helpMenu.add(aboutMenuItem);

		final JSplitPane splitPane = new JSplitPane();
		splitPane.setResizeWeight(1.0);
		splitPane.setOneTouchExpandable(true);
		splitPane.setContinuousLayout(true);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setBackground(Color.black);

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
		consoleContainer.setBackground(Color.BLACK);
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

	public JLabel getStatusLabel() {
		return statusLabel;
	}

}
