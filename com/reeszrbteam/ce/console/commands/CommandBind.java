package com.reeszrbteam.ce.console.commands;

import com.kodehawa.module.ModuleBase;
import com.kodehawa.module.ModuleManager;
import com.kodehawa.util.FileManager;
import org.lwjgl.input.Keyboard;

import com.kodehawa.CheatingEssentials;

import com.reeszrbteam.ce.console.BaseCommand;

public class CommandBind extends BaseCommand{

	public CommandBind() {
		super("bind", "ReesZRB, Kodehawa", "1.6.2");
	}

	@Override
	public void runCommand(String s, String[] args) {
		try {
			if(args[0].equalsIgnoreCase("add")) {
				for(ModuleBase m : ModuleManager.getInstance().modules) {
					if(m.name.replace(" ", "").equalsIgnoreCase(args[1])) {
						if(Keyboard.getKeyIndex(args[2].toUpperCase()) == 0) {
							CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Invalid key.");
							return;
						}
						m.setKeybinding(Keyboard.getKeyIndex(args[2].toUpperCase()));
                        FileManager.saveKeybinding();
                        CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage(m.name + " bound to: " + Keyboard.getKeyName(m.getKeybinding()));
						break;
					}
				}
			}
			if(args[0].equalsIgnoreCase("del")) {
				for(ModuleBase m : ModuleManager.getInstance().modules) {
					if(m.getKeybinding() == Keyboard.getKeyIndex(args[1].toUpperCase())) {
						m.setKeybinding(0);
                        FileManager.saveKeybinding();
                        CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Unbound: " + args[1].toUpperCase());
						break;
					}
				}
			}
			if(args[0].equalsIgnoreCase("clearall")) {
				for(ModuleBase m : ModuleManager.getInstance().modules) {
					m.setKeybinding(0);
                    FileManager.saveKeybinding();
                    CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("All Keys Unbound.");
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Usage: " + getSyntax());
		}
	}

	@Override
	public String getDescription() {
		return "Binds a key to a Module";
	}

	@Override
	public String getSyntax() {
		return "bind add <Module> <Key>, bind del <Key> and bind clearall";
	}

}
