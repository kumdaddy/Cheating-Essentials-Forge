package com.kodehawa.util;

import com.kodehawa.CheatingEssentials;

public class Utils
{
    private static volatile Utils instance;

	
    public Utils( )
    {
    }

    public void addChatMessage(String message)
    {
        String toSend = message;
        CheatingEssentials.getCheatingEssentials().getMinecraftInstance().thePlayer.addChatMessage(toSend);
    }

    public static Utils getInstance() {
        if (instance == null) {
                instance = new Utils();
        }
        return instance;
}
    
}
