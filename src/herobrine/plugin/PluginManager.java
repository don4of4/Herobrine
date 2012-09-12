package herobrine.plugin;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PluginManager {

	private static List<Plugin> plugins = new ArrayList<Plugin>();

	public static void loadPlugin(Plugin plugin) {
		try {
			plugin.checkDependencies();
			plugin.setLoaded(true);
		} catch (PluginDependencyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void loadPlugins(File directory) {
		List<Plugin> plugins = new ArrayList<Plugin>(Arrays.asList(PluginLoader.loadPlugins(directory)));
		
		if (!plugins.isEmpty()) {
			boolean cleanRun = false;
			while (cleanRun == false) {
				cleanRun = true;
				for (Iterator<Plugin> iterator = plugins.iterator(); iterator.hasNext();) {
					Plugin plugin = iterator.next();
					try {
						plugin.checkDependencies();
					} catch (PluginDependencyException e) {
						e.printStackTrace();
						plugin.removeDependency();
						iterator.remove();
						cleanRun = false;
					}
				}
			}
		}
		List<Plugin> sortedPlugins = new ArrayList<Plugin>();
		while (!plugins.isEmpty()) {
			for (Iterator<Plugin> iterator = plugins.iterator(); iterator.hasNext();) {
				Plugin plugin = iterator.next();
				boolean containsDependency = true;
				for (PluginDescription dependency : plugin.getDescription().getDependencies()) {
					containsDependency = false;
					for (Plugin sortedPlugin : sortedPlugins) {
						if (sortedPlugin.getDescription().getName().equals(dependency.getName())) {
							containsDependency = true;
							break;
						}
					}
					if (!containsDependency) {
						break;
					}
				}
				if (containsDependency) {
					sortedPlugins.add(plugin);
					iterator.remove();
				}
			}
		}
		for (Plugin plugin : sortedPlugins) {
			plugin.setLoaded(true);
		}
		
		PluginManager.plugins.addAll(sortedPlugins);
	}

}