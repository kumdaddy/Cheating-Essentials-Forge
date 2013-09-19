package com.kodehawa.ce.util;

import net.minecraft.client.Minecraft;
import cpw.mods.fml.client.FMLClientHandler;

public class Utils
{
    private static volatile Utils instance;

    public void addChatMessage(String message)
    {
    	if(Minecraft.getMinecraft().thePlayer != null){
        FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().addTranslatedMessage(message, new Object[0]);
    	}
    }
    
    public static void drawCenteredString(String string, int x, int y, int color)
    {
		Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(string, x - Minecraft.getMinecraft().fontRenderer.getStringWidth(string) / 4, y, color);
    }

    public static Utils getInstance() {
        if (instance == null) {
                instance = new Utils();
        }
        return instance;
}
    
}
