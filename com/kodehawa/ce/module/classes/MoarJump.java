package com.kodehawa.ce.module.classes;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;

public class MoarJump extends CheatingEssentialsModule {

	public MoarJump( ) {
		super("Moar Jump", "", "1.6.2", Keyboard.KEY_NONE, EnumGuiCategory.PLAYER, true);
		super.setTick(true);
	}

	public void onEnableModule(){}
	
	public void onDisableModule(){}
	
	public void tick(){
		if(getMinecraft().gameSettings.keyBindJump.pressed){
			getPlayer().motionY += 0.06D;
			getPlayer().jumpMovementFactor = 0.03F;
		}
	}
}
