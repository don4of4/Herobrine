package me.herobrine.gui;

import java.applet.Applet;
import java.applet.AppletStub;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class MinecraftStub extends Applet implements AppletStub {
	
	final Map<String, String> properties;

	public MinecraftStub(Map<String, String> properties) {
		this.properties = properties;
	}

	public void appletResize(int width, int height) {
		
	}

	public boolean isActive() {
		return true;
	}

	public URL getDocumentBase() {
		try {
			return new URL("http://www.minecraft.net/game/");
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public String getParameter(String parameter) {
		if (properties.containsKey(parameter)) {
			return properties.get(parameter);
		}
		
		System.err.println("Client asked for parameter: " + parameter);
		return null;
	}
}
