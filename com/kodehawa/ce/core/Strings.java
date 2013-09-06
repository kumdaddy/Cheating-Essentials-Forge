package com.kodehawa.ce.core;

import net.minecraft.client.Minecraft;

public class Strings {
		
	public static String MOD_VERSION = getModVersion();
	public static String MOD_NAME = "Cheating Essentials";
	public static String MINECRAFT_VERSION = getMCVersionForMod();
	public static String VERSION_FOUND = "";
	public static String THREAD_NAME = "Main Thread";
	
	
	
	/**
	 * Gets the mod version as a string
	 */
	
	public static String getModVersion(){
		return "3.2.0";
		}
	
	/**
	 * Get Minecraft version. A simple string for logs.
	 * @return
	 */
	
    public static String getMCVersionForMod(){
    	return Minecraft.getMinecraft().func_110431_a(Minecraft.getMinecraft());
        }
	
}
