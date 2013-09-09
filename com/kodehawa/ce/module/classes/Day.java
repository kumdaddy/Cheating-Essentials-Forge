package com.kodehawa.ce.module.classes;

import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;

public class Day extends CheatingEssentialsModule {

	public Day() {
		super("Set Day", "", "1.6.2", Keyboard.KEY_NONE, EnumGuiCategory.WORLD, true);
	}

	public void onEnableModule(){
		for(WorldServer world : MinecraftServer.getServer().worldServers){
			world.setWorldTime(0);
		}
	}
	
	public void onDisableModule(){}
}
