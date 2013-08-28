package com.reeszrbteam.ce.console.commands;

import org.lwjgl.input.Keyboard;

import com.kodehawa.ce.CheatingEssentials;
import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.handlers.ModuleManager;
import com.reeszrbteam.ce.console.BaseCommand;

public class CommandModuleList extends BaseCommand{

	public CommandModuleList() {
		super("modulelist", "Kodehawa", "1.6.2");
	}

	@Override
	public void runCommand(String s, String[] args) {
		try{
			for(CheatingEssentialsModule m: ModuleManager.getInstance().modules){
				String derp = m.name + " - " + Keyboard.getKeyName(m.getKeybinding());
				CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage(derp);
			}
		}catch(Exception e){
			
		}
	}

	@Override
	public String getDescription() {
		return "Shows all Modules with Keybind";
	}

	@Override
	public String getSyntax() {
		return "modulelist";
	}

}
