package me.herobrine.plugin;

public abstract class PluginDependencyException extends PluginException {
	
	protected PluginDescription dependency;
	
	public PluginDependencyException(Plugin plugin, PluginDescription dependency) {
		super(plugin);
		this.dependency = dependency;
	}
	
}
