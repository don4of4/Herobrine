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

	public static void init(Minecraft mc) {
		Herobrine.mc = mc;
	}
	
	public static void main(String[] args) {
		GuiUtil.configureLookAndFeel();
		
		File minecraftDir = new File(".");
		
		if(!ReflectionHelper.setField(Minecraft.class, null, "am", minecraftDir)) {
			ReflectionHelper.setField(Minecraft.class, null, "minecraftDir", minecraftDir);			
		}
		
		MainFrame mainFrame = new MainFrame();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);

        Runtime.getRuntime().addShutdownHook(new ThreadShutdown());
        
		PluginManager.loadPlugin(new TestPlugin());
		new Thread(new Herobrine()).start();
	}

	@Override
	public void run() {
		while(true) {
			try {
				TaskManager.processTask();
				EventManager.process();
				Thread.sleep(60 / 1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
