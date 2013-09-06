package com.kodehawa.ce.forge.tick;

import java.util.EnumSet;

import com.kodehawa.ce.module.handlers.ModuleManager;
import com.kodehawa.ce.util.KeyboardListener;
import com.kodehawa.ce.util.Tickable;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.IScheduledTickHandler;
import cpw.mods.fml.common.TickType;

public class TickHandler implements IScheduledTickHandler {

	volatile static TickHandler instance;
	
	public TickHandler( ){
	}
	
	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		
		if( FMLClientHandler.instance().getClient().theWorld != null ){
		for(Tickable tickable : ModuleManager.getInstance().modInternalTicksArray){
			tickable.tick();
		}
		    KeyboardListener.getInstance().handleKeys();
		}
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {}
		
	@Override
	public EnumSet<TickType> ticks() {
		// TODO Auto-generated method stub
		return EnumSet.of(TickType.CLIENT, TickType.RENDER, TickType.WORLD);
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nextTickSpacing() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static TickHandler instance(){
		if(instance == null){
			instance = new TickHandler();
		}
		return instance;
	}
}
