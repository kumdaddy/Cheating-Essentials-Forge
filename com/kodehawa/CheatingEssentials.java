package com.kodehawa;

import java.util.logging.Level;

import net.minecraft.client.Minecraft;

import com.kodehawa.core.Strings;
import com.kodehawa.module.handlers.ModuleManager;
import com.kodehawa.module.loader.BaseLoader;
import com.kodehawa.playerrelations.Enemy;
import com.kodehawa.playerrelations.Friend;
import com.kodehawa.util.FileManager;
import com.kodehawa.util.KeyboardListener;
import com.kodehawa.util.Tickable;
import com.kodehawa.util.Utils;
import com.kodehawa.util.wrapper.Wrapper;
import com.reeszrbteam.ce.console.CommandManager;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public final class CheatingEssentials {

	/**
	 * Basic mod methods.
	 */
	
    public volatile static CheatingEssentials modinstance;
    public int tick = 0;
    
	public CheatingEssentials( ) {
        modinstance = this;
	}

	public static void onStart(){
        CommandManager.getInstance();
	}

	public static CheatingEssentials getCheatingEssentials(){
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

	public void tick() {

		for(Tickable tickable : ModuleManager.getInstance().modInternalTicksArray){
			tickable.tick();
		}

		KeyboardListener.getInstance().handleKeys();
	}
	
	public static void CELogAgent(String log){
    	FMLLog.log("Cheating Essentials", Level.INFO, log);
	}
	
	public static void CELogErrorAgent(String elog){
    	FMLLog.log("Cheating Essentials", Level.WARNING, elog);
	}
}
