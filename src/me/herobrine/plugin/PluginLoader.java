package me.herobrine.plugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class PluginLoader {

	public static Plugin[] loadPlugins(File directory) {
		Set<Plugin> plugins = new HashSet<Plugin>();
		for(File file : directory.listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File file, String fileName) {
				return fileName.toLowerCase().endsWith(".jar");
			}
			
		})) {
			try {
				plugins.add(loadPlugin(file));
			} catch (PluginInvalidException e) {
				e.printStackTrace();
			}
		}
		return plugins.toArray(new Plugin[0]);
	}
	
	public static Plugin loadPlugin(File file) throws PluginInvalidException {
		try {
			URLClassLoader classLoader = new URLClassLoader(new URL[] { file.toURI().toURL() });
			JarInputStream jarFile = new JarInputStream(new FileInputStream(file));
			JarEntry jarEntry;

			while (true) {
				jarEntry = jarFile.getNextJarEntry();
				if (jarEntry == null) {
					break;
				}
				if (jarEntry.getName().endsWith(".class")) {
					String className = jarEntry.getName().replaceAll("/", "\\.").replace(".class", "");
					Class<?> pluginClass = classLoader.loadClass(className);
					if (Plugin.class.isAssignableFrom(pluginClass)) {
						return pluginClass.asSubclass(Plugin.class).getConstructor().newInstance();
					}
				}
			}
		} catch(Exception e) {
			throw new PluginInvalidException(file, e);
		}
		throw new PluginInvalidException(file, new Exception("No plugin found!"));
	}

}
