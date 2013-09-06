package com.kodehawa.ce.module.classes;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.enums.EnumGuiCategory;
import com.reeszrbteam.ce.console.GuiConsole;

public class Console extends CheatingEssentialsModule {

    private GuiConsole Console;

	public Console(){
		super("Console", "", "1.6.2", Keyboard.KEY_GRAVE, EnumGuiCategory.NONE, true);
	     Console = new GuiConsole();
	}
	
	public void onEnableModule(){
		displayGuiScreen(Console);
	}
	
    public void onDisableModule(){
		
	}
}
