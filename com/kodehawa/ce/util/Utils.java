package com.kodehawa.ce.util;

import cpw.mods.fml.client.FMLClientHandler;

public class Utils
{
    private static volatile Utils instance;

	
    public Utils( )
    {
    }

    public void addChatMessage(String message)
    {
        String toSend = message;
        FMLClientHandler.instance().getClient().ingameGUI.getChatGUI().addTranslatedMessage(toSend, new Object[0]);
    }

    public static Utils getInstance() {
        if (instance == null) {
                instance = new Utils();
        }
        return instance;
}
    
}
