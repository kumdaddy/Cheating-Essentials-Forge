package com.kodehawa.ce.module.classes;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;

public class Waterwalk extends CheatingEssentialsModule {

	public Waterwalk( ) {
		super("Water Walk", "", "1.6.2", Keyboard.KEY_J, EnumGuiCategory.WORLD, true);
        super.setTick(true);
	}
	
	//This crap works like a shit. But works
	@Override
	public void tick() {
		if (getPlayer().isInWater())
        {
			getMinecraft().gameSettings.keyBindJump.pressed = true;
            getPlayer().setSprinting(false);
        } 
		else{
			getMinecraft().gameSettings.keyBindJump.pressed = false;
		}
	}

	@Override
	public void onEnableModule() {
	}

	@Override
	public void onDisableModule() {
	}


}
