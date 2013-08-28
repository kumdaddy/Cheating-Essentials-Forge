package com.kodehawa.ce.module.classes;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;

public class AutoRespawn extends CheatingEssentialsModule {

	public AutoRespawn( ) {
		super("Auto Respawn", "", "1.6.2", Keyboard.KEY_NUMPAD0, EnumGuiCategory.WORLD, true);
        super.setTick(true);
	}

	@Override
	public void tick() {
		if(getPlayer().isDead){
			getPlayer().respawnPlayer();
		}
	}

	@Override
	public void onEnableModule() {
	}

	@Override
	public void onDisableModule() {
	}

}
