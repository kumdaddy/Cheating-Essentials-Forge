package com.kodehawa.ce.vanilla.command;

import com.kodehawa.ce.playerrelations.Friend;
import com.kodehawa.ce.util.Utils;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class CommandFriend extends CommandBase {

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "cfriend";
	}
	
	@Override
    public boolean canCommandSenderUseCommand(ICommandSender icommandsender){
		return true;
    }

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		// TODO Auto-generated method stub
		return "command.ce.friend";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] args) {
		if(args[0].equalsIgnoreCase("add"))
		{
			String name = args[1];
			if(!Friend.friendList.contains(name))
			{
                Friend.friendList.add(name);
				Friend.writeFriendList();
				Utils.getInstance().addChatMessage("Added " + name + " to friend list.");
			}else
			{
				Utils.getInstance().addChatMessage(name + " is already your friend.");
			}
		}
		if(args[0].equalsIgnoreCase("del"))
		{
			String name = args[1];
			if(Friend.friendList.contains(name))
			{
                Friend.friendList.remove(name);
                Friend.writeFriendList();
				Utils.getInstance().addChatMessage("Removed " + name + " from friends.");
			}else
			{
				Utils.getInstance().addChatMessage(name + " is not your friend.");
			}
		}
		if(args[0].equalsIgnoreCase("clear"))
		{
			try
			{
                Friend.friendList.clear();
				Friend.writeFriendList();
				Utils.getInstance().addChatMessage("Cleared friends.");
			}catch(Exception e) {}
		}
	}

}
