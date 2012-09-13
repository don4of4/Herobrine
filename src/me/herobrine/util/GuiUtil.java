package me.herobrine.util;

import java.util.Properties;

import javax.swing.JPopupMenu;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;

public class GuiUtil {

	public static void configureLookAndFeel() {
        try {
			
            Properties props = new Properties();
            
            props.setProperty("controlTextFont", "Dialog 10");
            props.setProperty("systemTextFont", "Dialog 10");
            props.setProperty("userTextFont", "Dialog 10");
            props.setProperty("menuTextFont", "Dialog 10");
            props.setProperty("windowTitleFont", "Dialog bold 10");
            props.setProperty("subTextFont", "Dialog 8");

            props.put("logoString", "Herobrine");
            props.put("textAntiAliasing", "on");
            
            com.jtattoo.plaf.acryl.AcrylLookAndFeel.setCurrentTheme(props);
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
			
			// Fix Leightweight component render issues
			JPopupMenu.setDefaultLightWeightPopupEnabled(false);
			ToolTipManager.sharedInstance().setLightWeightPopupEnabled(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
