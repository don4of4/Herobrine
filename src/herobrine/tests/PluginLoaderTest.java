package herobrine.tests;

import java.io.File;

import herobrine.plugin.PluginInvalidException;
import herobrine.plugin.PluginLoader;

public class PluginLoaderTest {
	
	public static void main(String[] args) {
		try {
			PluginLoader.loadPlugin(new File("C:\\Users\\Mast3rPlan\\AppData\\Roaming\\.minecraft\\bin\\TestPlugin.jar")).onLoad();
		} catch (PluginInvalidException e) {
			e.printStackTrace();
		}
	}
	
}
