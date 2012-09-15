package me.herobrine.gui;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JDialog;
import javax.swing.JRootPane;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JList;

import me.herobrine.ai.TaskManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ScrollPaneConstants;

public class TaskStackDialog extends JDialog implements Runnable {
	
	@SuppressWarnings("unused")
	private MainFrame parent;
	
	private JButton attachButton;
	private Thread updateThread;
	private boolean disposed = false;
	private boolean attached = true;
	private JList list;
	
	public TaskStackDialog(final MainFrame parent) {
		super(parent, "Task Stack");
		this.parent = parent;
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		list = new JList();
		list.setSelectionModel(new DefaultListSelectionModel() {
			@Override
			public void clearSelection() {
				// TODO fix out of range
			}
		});
		scrollPane.setViewportView(list);
		
		attachButton = new JButton();
		attachButton.setText("->");
		attachButton.addActionListener(new ActionListener() {
			@Override @SuppressWarnings("synthetic-access")
			public void actionPerformed(ActionEvent e) {
				TaskStackDialog.this.attached = !TaskStackDialog.this.attached;
				TaskStackDialog.this.updateAttachButton();
				
				if(!TaskStackDialog.this.attached) {
					TaskStackDialog.super.setLocation(TaskStackDialog.super.getLocation().x + 8, TaskStackDialog.super.getLocation().y);
				}
			}
		});
		getContentPane().add(attachButton, BorderLayout.SOUTH);
		this.updateAttachButton();
		
		this.updateThread = new Thread(this);
		this.updateThread.start();
		
		super.setMinimumSize(new Dimension(148, 260));
		super.setPreferredSize(super.getMinimumSize());
		super.pack();
	}
	
	private void updateAttachButton() {
		if(attached) {
			attachButton.setText("->");
		} else {
			attachButton.setText("<-");
		}
	}	

	@Override
	public void run() {
		while(!disposed) {
			try {
				if(TaskStackDialog.this.attached) {
					super.setLocation(parent.getLocation().x + parent.getWidth(), parent.getLocation().y);
				}
				list.setListData(TaskManager.tasks);
				Thread.sleep(1000 / 120);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void dispose() {
		super.dispose();
		this.disposed = true;
	}

	
	
}
