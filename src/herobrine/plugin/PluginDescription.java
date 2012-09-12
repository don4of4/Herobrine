package herobrine.plugin;

public class PluginDescription {
	
	private String name;
	private PluginVersion version;
	
	private PluginDescription[] dependencies;

	public PluginDescription(String name, PluginVersion version, PluginDescription[] dependencies) {
		this.name = name;
		this.version = version;
		this.dependencies = dependencies;
	}

	public PluginDescription(String name, PluginVersion version) {
		this.name = name;
		this.version = version;
		this.dependencies = new PluginDescription[0];
	}
	
	public String getName() {
		return name;
	}

	public PluginVersion getVersion() {
		return version;
	}

	public PluginDescription[] getDependencies() {
		return dependencies;
	}

	@Override
	public String toString() {
		return name + " v" + version;
	}
}
