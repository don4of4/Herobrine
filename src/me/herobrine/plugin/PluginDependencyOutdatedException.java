package me.herobrine.plugin;

public class PluginDependencyOutdatedException extends PluginDependencyException {

	private Plugin matchedDependency;
	
	public PluginDependencyOutdatedException(Plugin plugin, Plugin matchedDependency, PluginDescription dependency) {
		super(plugin, dependency);
		this.matchedDependency = matchedDependency;
	}

	@Override
	public String getMessage() {
		return "Dependency \"" + dependency + "\" for \"" + plugin.getDescription() + "\" was found but is outdated, found version: " + matchedDependency.getDescription().getVersion() + ".";
	}
	
	

}
