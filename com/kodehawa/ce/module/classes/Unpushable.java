package com.kodehawa.ce.module.classes;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;

public class Unpushable extends CheatingEssentialsModule {

	public Unpushable( ) {
		super("Unpushable", "", "1.6.2", Keyboard.KEY_NUMPAD7, EnumGuiCategory.PLAYER , true );
		// TODO Auto-generated constructor stub
        super.setTick(true);
	}

	@Override
	public void tick() {
       if(getPlayer().hurtTime > 0 && getPlayer().hurtResistantTime > 0){
    	   getPlayer().motionX = 0;
    	   getPlayer().motionZ = 0;
       }
	}

	@Override
	public void onEnableModule() {
	}

	@Override
	public void onDisableModule() {
	}

}
