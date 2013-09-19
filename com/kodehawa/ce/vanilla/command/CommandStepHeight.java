package com.kodehawa.ce.vanilla.command;

import com.kodehawa.ce.module.classes.Step;
import com.kodehawa.ce.module.handlers.ModuleManager;
import com.kodehawa.ce.util.Utils;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class CommandStepHeight extends CommandBase{

	@Override
	public String getCommandName() {
		return "cstepheight";
	}
	
	@Override
    public boolean canCommandSenderUseCommand(ICommandSender icommandsender){
		return true;
    }

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "/cstepheight <number of blocks>";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		try{
			float result = Float.parseFloat(astring[0]);
			if(result <= 100.0F){
			Step.setStepHeight(result);
			Utils.getInstance().addChatMessage("Step height changed to " + result + "!");
			/* If module is on, off and on it, else
			 * If module is off on and off it c: */
			ModuleManager.getInstance().getModuleByClass(Step.class).toggleModule();
			ModuleManager.getInstance().getModuleByClass(Step.class).toggleModule();
			}
		}catch(Exception e){}
	}
}
