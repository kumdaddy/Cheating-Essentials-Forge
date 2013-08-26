package com.kodehawa.module.classes;

import org.lwjgl.input.Keyboard;

import com.kodehawa.module.annotations.ModuleLoader;
import com.kodehawa.module.core.CheatingEssentialsModule;
import com.kodehawa.module.enums.EnumGuiCategory;

public class Sprint extends CheatingEssentialsModule {

	@ModuleLoader(type = "Module")
	public Sprint( ) {
		super("Sprint", "Without double tapping!", "1.6.2",
				Keyboard.KEY_H, EnumGuiCategory.PLAYER, true);
        super.setTick(true);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		if(getPlayer().movementInput.moveForward > 0){
			getPlayer().setSprinting(true);
		}
	}

	@Override
	public void onEnableModule() {
	}

	@Override
	public void onDisableModule() {
	}

}
