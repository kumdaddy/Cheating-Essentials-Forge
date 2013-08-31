package com.reeszrbteam.ce.console.commands;

import com.kodehawa.ce.CheatingEssentials;
import com.kodehawa.ce.forge.tick.TickHandler;
import com.kodehawa.ce.module.classes.Gui;
import com.reeszrbteam.ce.console.BaseCommand;

public class CommandGuiMode extends BaseCommand{

	public CommandGuiMode() {
		super("guimode", "ReesZRB", "1.6.2");
	}

	@Override
	public void runCommand(String s, String[] args) {
		try{
			if(args[0].equalsIgnoreCase("ReesZRB")){
                Gui.guimode = 1;
                CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Gui Mode is set to ReesZRB.");
			}
			if(args[0].equalsIgnoreCase("Kodehawa")){
                Gui.guimode = 0;
                CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Gui Mode is set to Kodehawa.");
			}
		}catch(Exception e){
			CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Invalid Usage: " + getSyntax());
		}
	}

	@Override
	public String getDescription() {
		return "Switches Gui";
	}

	@Override
	public String getSyntax() {
		return "guimode <ReesZRB/Kodehawa>";
	}

}
