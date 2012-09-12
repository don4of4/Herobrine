package herobrine.plugin;

public abstract class PluginException extends Exception {

	protected Plugin plugin;
	
	public PluginException(Plugin plugin) {
		super();
		this.plugin = plugin;
	}

	public PluginException(Plugin plugin, String message) {
		super(message);
		this.plugin = plugin;
	}

	public PluginException(Plugin plugin, Throwable innerException) {
		super(innerException);
		this.plugin = plugin;
	}
	
}
