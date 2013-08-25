package com.reeszrbteam.ce.console.commands;

import com.kodehawa.CheatingEssentials;
import com.kodehawa.playerrelations.Enemy;

import com.reeszrbteam.ce.console.BaseCommand;

public class CommandEnemy extends BaseCommand{

	public CommandEnemy() {
		super("enemy", "Kodehawa", "1.6.2");
	}

	@Override
	public void runCommand(String s, String[] args) {
		try
		{
			if(args[0].equalsIgnoreCase("add"))
			{
				String name = args[1];
				if(!Enemy.enemyList.contains(name))
				{
                    Enemy.enemyList.add(name);
					Enemy.writeEnemyFile();
					CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Enemied " + name + ".");
				}else
				{
					CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage(name + " is already your enemy.");
				}
			}
			if(args[0].equalsIgnoreCase("del"))
			{
				String name = args[1];
				if(Enemy.enemyList.contains(name))
				{
                    Enemy.enemyList.remove(name);
                    Enemy.writeEnemyFile();
					CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage("Removed " + name + " from enemies.");
				}else
				{
					CheatingEssentials.getCheatingEssentials().getUtils().addChatMessage(name + " is not your enemy.");
				}
			}
			if(args[0].equalsIgnoreCase("clear"))
			{
				try
				{
                    Enemy.enemyList.clear();
					Enemy.writeEnemyFile();
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
		return "Adds and Removes Enemy to Show Red Username in Radar";
	}

	@Override
	public String getSyntax() {
		return "enemy add/del <Username>, enemy clear";
	}

}
