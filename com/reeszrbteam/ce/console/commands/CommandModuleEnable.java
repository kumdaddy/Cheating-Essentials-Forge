package com.reeszrbteam.ce.console.commands;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.handlers.ModuleManager;
import com.kodehawa.ce.util.Utils;
import com.reeszrbteam.ce.console.BaseCommand;

public class CommandModuleEnable extends BaseCommand {
	
	public CommandModuleEnable() {
		super("module", "Kodehawa", "1.6.2");
	}

	@Override
	public void runCommand(String s, String[] args) {
		try{
			if(args[0].equalsIgnoreCase("t")){
			for(CheatingEssentialsModule module : ModuleManager.getInstance().modules){
				if(module.name.replace(" ", "").equalsIgnoreCase(args[1])) {
		        module.toggleModule();
		        }}}
		}
		catch(Exception e){
			e.printStackTrace();
			Utils.getInstance().addChatMessage("Usage: " + getSyntax());
		}
	}

	@Override
	public String getDescription() {
		return "Activate modules in console";
	}

	@Override
	public String getSyntax() {
		return "module t <modulename>";
	}

}
