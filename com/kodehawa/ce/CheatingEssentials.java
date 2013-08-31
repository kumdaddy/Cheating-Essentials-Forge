package com.kodehawa.ce;

import java.util.logging.Level;

import net.minecraft.client.Minecraft;

import com.kodehawa.ce.util.Utils;
import com.kodehawa.ce.util.wrapper.Wrapper;
import com.reeszrbteam.ce.console.CommandManager;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public final class CheatingEssentials {

	//Basic things. I don't delete this class because I'm lazy. And a lot of modules get the shitty instance <3

    public volatile static CheatingEssentials modinstance;
    public int tick = 0;
    //Future hardcore cheating mode. Crafting and stuff like that
    public boolean isHardcoreModeEnabled = false;
    
	public CheatingEssentials( ) {
        modinstance = this;
	}

	public static void onStart(){
        CommandManager.getInstance();
	}

	public static CheatingEssentials getCheatingEssentials(){
		return modinstance;
	}
	
	public static CheatingEssentials instance(){
		return modinstance;
	}

	public Wrapper getModWrapper(){
		return Wrapper.getWInstance();
	}

    public Utils getUtils() {
		return Utils.getInstance();
	}

	public static Minecraft getMinecraftInstance(){
		return Minecraft.getMinecraft();
	}
	
	public static void CELogAgent(String log){
    	FMLLog.log("Cheating Essentials", Level.INFO, log);
	}
	
	public static void CELogErrorAgent(String elog){
    	FMLLog.log("Cheating Essentials", Level.WARNING, elog);
	}
}
