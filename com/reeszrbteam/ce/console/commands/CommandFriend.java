package com.reeszrbteam.ce.console.commands;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.playerrelations.Friend;
import com.reeszrbteam.ce.console.BaseCommand;

public class CommandFriend extends BaseCommand {

	public CommandFriend( ) {
		super("friend", "Kodehawa", "1.6.2");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void runCommand(String s, String[] args) {
		// TODO Auto-generated method stub
		try
		{
			if(args[0].equalsIgnoreCase("add"))
			{
				String name = args[1];
				if(!Friend.friendList.contains(name))
				{
                    Friend.friendList.add(name);
					Friend.writeFriendList();
					CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Added " + name + " to friend list.");
				}else
				{
					CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage(name + " is already your friend.");
				}
			}
			if(args[0].equalsIgnoreCase("del"))
			{
				String name = args[1];
				if(Friend.friendList.contains(name))
				{
                    Friend.friendList.remove(name);
                    Friend.writeFriendList();
					CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Removed " + name + " from friends.");
				}else
				{
					CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage(name + " is not your friend.");
				}
			}
			if(args[0].equalsIgnoreCase("clear"))
			{
				try
				{
                    Friend.friendList.clear();
					Friend.writeFriendList();
					CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Cleared friends.");
				}catch(Exception e) {}
			}
		}catch(Exception e)
		{
			CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Usage: " + getSyntax());
		}
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Add a friend for show it with green color in radars";
	}

	@Override
	public String getSyntax() {
		// TODO Auto-generated method stub
		return "friend add/del <Username>, friend clear";
	}

}
