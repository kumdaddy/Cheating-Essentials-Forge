package com.reeszrbteam.ce.console;

import java.util.ArrayList;

import com.kodehawa.ce.util.Utils;
import com.reeszrbteam.ce.console.commands.CommandAuraDistance;
import com.reeszrbteam.ce.console.commands.CommandBind;
import com.reeszrbteam.ce.console.commands.CommandBlockESP;
import com.reeszrbteam.ce.console.commands.CommandBreadcrumb;
import com.reeszrbteam.ce.console.commands.CommandEnemy;
import com.reeszrbteam.ce.console.commands.CommandFlySpeed;
import com.reeszrbteam.ce.console.commands.CommandFriend;
import com.reeszrbteam.ce.console.commands.CommandGuiMode;
import com.reeszrbteam.ce.console.commands.CommandHardcoreMode;
import com.reeszrbteam.ce.console.commands.CommandHelp;
import com.reeszrbteam.ce.console.commands.CommandModuleEnable;
import com.reeszrbteam.ce.console.commands.CommandModuleList;
import com.reeszrbteam.ce.console.commands.CommandPlayerView;
import com.reeszrbteam.ce.console.commands.CommandTeleport;

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
		commands.clear();
		commands.add(new CommandEnemy());
		commands.add(new CommandHelp());
		commands.add(new CommandModuleList());
		commands.add(new CommandPlayerView());
		commands.add(new CommandTeleport());
		//commands.add(new CommandXray());
		commands.add(new CommandFriend());
		commands.add(new CommandAuraDistance());
        commands.add(new CommandFlySpeed());
        commands.add(new CommandBlockESP());
        commands.add(new CommandBreadcrumb());
        commands.add(new CommandGuiMode());
        commands.add(new CommandModuleEnable());
        commands.add(new CommandHardcoreMode());
		commands.add(new CommandBind()); 
	}

	public void runCommands(String s)
	{
		/*
		 * Do not Remove Line Below
		 * Used for Chat Commands
		 */
		//if(!s.contains(Character.toString(cmdPrefix)) || !s.startsWith(Character.toString(cmdPrefix))) return;

		boolean commandResolved = false;
		String readString = s.trim().substring(Character.toString(cmdPrefix).length()).trim();
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
		
		
		if(s.equalsIgnoreCase(".reload")) {
			Utils.getInstance().addChatMessage("Initializing...");
	        CommandManager.getInstance();
			Utils.getInstance().addChatMessage("Initialized.");
			return;
		}

		if(!commandResolved)
		{
			Utils.getInstance().addChatMessage("Invalid command. Type help in Console for a list of commands.");
		}
	}
	
	public static CommandManager getInstance(){
		if(instance == null){
			instance = new CommandManager();
		}
		return instance;
	}
}