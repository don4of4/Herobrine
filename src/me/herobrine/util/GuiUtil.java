package me.herobrine.util;

import java.util.Properties;

import javax.swing.JPopupMenu;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;

public class GuiUtil {

	public static void configureLookAndFeel() {
        try {
            Properties props = new Properties();
            props.put("logoString", "Herobrine");
            
            com.jtattoo.plaf.acryl.AcrylLookAndFeel.setCurrentTheme(props);
            com.jtattoo.plaf.acryl.AcrylLookAndFeel.setTheme("Small-Font");
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
			
			// Fix Leightweight component render issues
			JPopupMenu.setDefaultLightWeightPopupEnabled(false);
			ToolTipManager.sharedInstance().setLightWeightPopupEnabled(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
