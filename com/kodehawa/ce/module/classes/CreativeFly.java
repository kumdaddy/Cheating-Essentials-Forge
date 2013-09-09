package com.kodehawa.ce.module.classes;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.module.annotations.ModuleLoader;
import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;

public class CreativeFly extends CheatingEssentialsModule {

	@ModuleLoader(type = "Module")
	public CreativeFly( ) {
		super("Creative Fly", "I believe I can fly~", "1.6.2", Keyboard.KEY_NUMPAD5,
				EnumGuiCategory.PLAYER, true);
        super.setTick(true);
	}
	
	@Override
    public void onEnableModule(){
	}
	
	@Override 
	public void onDisableModule(){
		super.setFly(false);
	}
	
	@Override
	public void tick() {
		super.setFly(true); 
		}	
}
