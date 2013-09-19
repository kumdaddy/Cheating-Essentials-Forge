package com.reeszrbteam.ce.console;

import java.util.ArrayList;

import com.kodehawa.ce.util.Utils;
import com.reeszrbteam.ce.console.commands.*;

public class CommandManager
{
	public static ArrayList<BaseCommand> commands = new ArrayList<BaseCommand>();
    private volatile static CommandManager instance;
	
	public static char cmdPrefix = '.';

	public CommandManager()
	{
		addCommands();
	}

	public void addCommands()
	{
		commands.add(new CommandHelp());
		commands.add(new CommandModuleList());
		commands.add(new CommandPlayerView());
		commands.add(new CommandTeleport());
		commands.add(new CommandFriend());
		commands.add(new CommandEnemy());
        commands.add(new CommandFlySpeed());
        commands.add(new CommandStepHeight());
        commands.add(new CommandBlockESP());
        commands.add(new CommandBreadcrumb());
        commands.add(new CommandModuleEnable());
		commands.add(new CommandBind()); 
	}

	public void runCommands(String s)
	{
		String readString = s.trim().substring(Character.toString(cmdPrefix).length()).trim();
		boolean commandResolved = false;
		boolean hasArgs = readString.trim().contains(" ");
		String commandName = hasArgs ? readString.split(" ")[0] : readString.trim();
		String[] args = hasArgs ? readString.substring(commandName.length()).trim().split(" ") : new String[0];

		for(BaseCommand command: commands)
		{	
			if(command.getCommand().trim().equalsIgnoreCase(commandName.trim())) 
			{
				command.runCommand(readString, args);
				commandResolved = true;
				break;
			}
		}
		if(!commandResolved){
			Utils.getInstance().addChatMessage("Cannot resolve internal command: "+commandName);
		}
	}
	
	public static CommandManager getInstance(){
		if(instance == null){
			instance = new CommandManager();
		}
		return instance;
	}
}