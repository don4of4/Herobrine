package me.herobrine.plugin;

import java.io.File;

public class PluginInvalidException extends PluginException {

	private File file;
	
	public PluginInvalidException(File file, Exception innerException) {
		super(null, innerException);
		this.file = file;
	}

	@Override
	public String getMessage() {
		return file.getName() + " is an invalid plugin: " + super.getMessage();
	}
	
	
	
}
