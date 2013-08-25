package com.kodehawa.module.classes;

import org.lwjgl.input.Keyboard;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.module.ModuleBase;
import com.kodehawa.module.enums.EnumGuiCategory;
import com.kodehawa.util.Tickable;

public class AutoRespawn extends ModuleBase {

	public AutoRespawn( ) {
		super("Auto Respawn", "", "1.6.2", Keyboard.KEY_NUMPAD0, EnumGuiCategory.WORLD, true);
        super.setTick(true);
	}

	@Override
	public void tick() {
		  if(getMinecraft().theWorld != null ){
		if(getPlayer().isDead){
			getPlayer().respawnPlayer();
		} }
	}

	@Override
	public void onEnableModule() {
	}

	@Override
	public void onDisableModule() {
	}

}
