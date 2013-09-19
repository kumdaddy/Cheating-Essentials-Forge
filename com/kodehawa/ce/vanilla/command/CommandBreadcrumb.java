package com.kodehawa.ce.vanilla.command;

import com.kodehawa.ce.module.classes.Breadcrumb;
import com.kodehawa.ce.util.Utils;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class CommandBreadcrumb extends CommandBase {

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "cbreadcrumb";
	}
	
	@Override
    public boolean canCommandSenderUseCommand(ICommandSender icommandsender){
		return true;
    }

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		return "command.ce.breadcrumb";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		try {
            if(astring[0].equalsIgnoreCase("clear")) {
                Breadcrumb.positionsList.clear();
                Utils.getInstance().addChatMessage("Cleared breadcrumbs.");
            }
        } catch(Exception e) {}		
	}

}
