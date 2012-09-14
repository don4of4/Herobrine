package me.herobrine.interfaces;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.src.GuiCrafting;
import net.minecraft.src.GuiScreen;

public abstract class Interface {
	
	private static Map<GuiScreen, Interface> interfaces = new HashMap<GuiScreen, Interface>();
	
	public static Interface getInterface(GuiScreen guiScreen) {
		if(!interfaces.containsKey(guiScreen)) {
			if(guiScreen instanceof GuiCrafting) {
				interfaces.put(guiScreen, new CraftingInterface((GuiCrafting) guiScreen));
			}
		}
		
		return interfaces.get(guiScreen);
	}
}
