package com.kodehawa.ce.vanilla.command;

import com.kodehawa.ce.module.core.CheatingEssentialsModule;
import com.kodehawa.ce.module.handlers.ModuleManager;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class CommandModuleEnable extends CommandBase {

	@Override
	public String getCommandName() {
		return "module";
	}

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		// TODO Auto-generated method stub
		return "command.ce.moduletoggle";
	}
	
	@Override
    public boolean canCommandSenderUseCommand(ICommandSender icommandsender){
		return true;
    }

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		if(astring[0].equalsIgnoreCase("t")){
			for(CheatingEssentialsModule module : ModuleManager.getInstance().modules){
				if(module.name.replace(" ", "").equalsIgnoreCase(astring[1])) {
		        module.toggleModule();
		        }
			}
		}
	}

}
