package com.kodehawa.ce.module.classes;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;

public class Sprint extends CheatingEssentialsModule {

	public Sprint( ) {
		super("Sprint", "Without double tapping!", "1.6.2",
				Keyboard.KEY_H, EnumGuiCategory.PLAYER, true);
        super.setTick(true);
	}

	@Override
	public void tick() {
		if(getPlayer().movementInput.moveForward > 0){
			getPlayer().setSprinting(true);
		}
	}

	public void onEnableModule() {}

	public void onDisableModule() {}
}
