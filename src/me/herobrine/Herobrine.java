package me.herobrine;


import me.herobrine.ai.TaskManager;
import me.herobrine.event.EventManager;
import me.herobrine.plugin.PluginManager;
import me.herobrine.plugins.test.TestPlugin;
import net.minecraft.client.Minecraft;

public class Herobrine implements Runnable {

	public static Minecraft mc;

	public static void init(Minecraft mc) {
		Herobrine.mc = mc;
		
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
