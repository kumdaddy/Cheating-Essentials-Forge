package com.reeszrbteam.ce.console.commands;

import com.kodehawa.CheatingEssentials;
import com.reeszrbteam.ce.console.BaseCommand;
import com.reeszrbteam.ce.console.CommandManager;

public class CommandHelp extends BaseCommand
{
	public CommandHelp()
	{
		super("help", "ReesZRB", "1.6.2");
	}

	@Override
	public void runCommand(String s, String[] args)
	{
		for(BaseCommand cmd: CommandManager.commands)
		{
			if(cmd != this) {
				CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage(cmd.getSyntax().replace("<", "<\247a").replace(">", "\247f>") + " - " + cmd.getDescription());
			}
		}
	}

	@Override
	public String getDescription()
	{
		return "Lists all commands";
	}

	@Override
	public String getSyntax()
	{
		return "help";
	}
}