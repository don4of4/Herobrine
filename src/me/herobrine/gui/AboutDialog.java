package me.herobrine.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class AboutDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Create the dialog.
	 */
	public AboutDialog(MainFrame parent) {
		super(parent, "About", JDialog.ModalityType.APPLICATION_MODAL);
		
		setBounds(100, 100, 382, 230);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		super.setLocationRelativeTo(parent);
	}

}
