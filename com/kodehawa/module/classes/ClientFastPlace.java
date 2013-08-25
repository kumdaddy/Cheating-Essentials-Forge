package com.kodehawa.module.classes;

import org.lwjgl.input.Keyboard;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.module.ModuleBase;
import com.kodehawa.module.enums.EnumGuiCategory;

public class ClientFastPlace extends ModuleBase{

	public ClientFastPlace( ) {
		super("CFast Place", "Place ALL blocks!", "1.6.2", Keyboard.KEY_K, 
				EnumGuiCategory.WORLD, true);
        super.setTick(true);
	}

	@Override
	public void onEnableModule( ){
	}
	
	@Override 
	public void onDisableModule( ){
	}
	
	@Override
	public void tick( ) {
		//CheatingEssentials.getMinecraftInstance().rightClickDelayTimer = 0;
	}

}
