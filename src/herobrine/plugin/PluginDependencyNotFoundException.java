package herobrine.plugin;

public class PluginDependencyNotFoundException extends PluginDependencyException {

	public PluginDependencyNotFoundException(Plugin plugin, PluginDescription dependency) {
		super(plugin, dependency);
	}

	@Override
	public String getMessage() {
		return "Dependency \"" + dependency + "\" for \"" + plugin.getDescription() + "\" was not found.";
	}
	
}
