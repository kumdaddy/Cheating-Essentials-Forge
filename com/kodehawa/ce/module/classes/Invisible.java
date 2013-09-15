package com.kodehawa.ce.module.classes;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;

public class Invisible extends CheatingEssentialsModule {

	public Invisible( ) {
		super("Invisible P.", "", "1.6.2", Keyboard.KEY_NONE, EnumGuiCategory.PLAYER, true);
		this.setTick(true);
	}
	
	public void onDisableModule(){
		getPlayer().setInvisible(false);
	}
	
	public void tick(){
		getPlayer().setInvisible(true);
	}
}
