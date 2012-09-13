package me.herobrine.plugin;

import java.util.HashMap;
import java.util.Map;

public abstract class Plugin {

	private static Map<Plugin, PluginDescription> pluginDescriptions = new HashMap<Plugin, PluginDescription>();
	
	private boolean loaded;
	private boolean enabled;
	
	public Plugin(PluginDescription description) {
		pluginDescriptions.put(this, description);
	}
	
	public final void setLoaded(boolean loaded) {
		if(this.loaded != loaded) {
			this.loaded = loaded;
			
			if(loaded) {
				this.onLoad();
			} else {
				this.onUnload();
			}
		}
	}
	
	public final boolean isLoaded() {
		return loaded;
	}

	public final void setEnabled(boolean enabled) {
		if(this.enabled != enabled) {
			this.enabled = enabled;
			
			if(enabled) {
				this.onEnable();
			} else {
				this.onDisable();
			}
		}
	}
	
	public final boolean isEnabled() {
		return enabled;
	}

	public void onLoad() { }
	
	public void onUnload() { }
	
	public void onEnable() { }
	
	public void onDisable() { }
	
	public final PluginDescription getDescription() {
		return pluginDescriptions.get(this);
	}
	
	public final void checkDependencies() throws PluginDependencyException {
		PluginDescription[] dependencyDescriptions = getDescription().getDependencies();
		
		for(PluginDescription dependencyDescription : dependencyDescriptions) {
			boolean dependencyFound = false;
			for(Plugin plugin : pluginDescriptions.keySet()) {
				PluginDescription pluginDescription = pluginDescriptions.get(plugin);
				if(pluginDescription.getName().equals(dependencyDescription)) {
					if(pluginDescription.getVersion().compareTo(dependencyDescription.getVersion()) == -1) {
						throw new PluginDependencyOutdatedException(this, plugin, dependencyDescription);
					}
					dependencyFound = true;
					break;
				}
			}
			if(!dependencyFound) {
				throw new PluginDependencyNotFoundException(this, dependencyDescription);
			}
		}
	}
	
	public void removeDependency() {
		pluginDescriptions.remove(this);
	}
	
}
