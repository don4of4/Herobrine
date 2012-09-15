package me.herobrine;

import java.io.File;

import me.herobrine.ai.TaskManager;
import me.herobrine.event.EventManager;
import me.herobrine.gui.MainFrame;
import me.herobrine.plugin.PluginManager;
import me.herobrine.plugins.test.TestPlugin;
import me.herobrine.util.GuiUtil;
import me.herobrine.util.ReflectionHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.src.ThreadShutdown;

public class Herobrine implements Runnable {

	public static Minecraft mc;
	
	private static MainFrame mainFrame;
	
	private static boolean running;

	public static void init(Minecraft mc) {
		Herobrine.mc = mc;
	}
	
	public static void setStatus(String status) {
		mainFrame.getStatusLabel().setText(status);
	}
	
	public static void main(String[] args) {
		GuiUtil.configureLookAndFeel();
		
		File minecraftDir = new File(".");
		
		if(!ReflectionHelper.setField(Minecraft.class, null, "am", minecraftDir)) {
			ReflectionHelper.setField(Minecraft.class, null, "minecraftDir", minecraftDir);			
		}

		Herobrine.mainFrame = new MainFrame();
		mainFrame.setVisible(true);

        Runtime.getRuntime().addShutdownHook(new ThreadShutdown());
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

			@Override
			public void run() {
				Herobrine.shutdown();
			}
        	
        }));
        
        Herobrine.running = true;
        
		PluginManager.loadPlugin(new TestPlugin());
		new Thread(new Herobrine()).start();
	}
	
	public static void shutdown() {
		Herobrine.running = false;
		
		// TODO: cleanup
		
		System.exit(0);
	}
	
	@Override
	public void run() {
		while(Herobrine.running) {
			try {
				TaskManager.processTask();
				EventManager.process();
				Thread.sleep(1000 / 20);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
