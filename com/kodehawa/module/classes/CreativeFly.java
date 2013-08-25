package com.kodehawa.module.classes;

import org.lwjgl.input.Keyboard;

import com.kodehawa.module.ModuleBase;
import com.kodehawa.module.annotations.ModuleLoader;
import com.kodehawa.module.enums.EnumGuiCategory;

public class CreativeFly extends ModuleBase {

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
		  if(getMinecraft().theWorld != null ){
		super.setFly(true); }
	}
	

}
