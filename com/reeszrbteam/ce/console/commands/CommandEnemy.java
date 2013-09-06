package com.reeszrbteam.ce.console.commands;

import com.kodehawa.ce.playerrelations.Enemy;
import com.kodehawa.ce.util.Utils;
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
					Utils.getInstance().addChatMessage("Enemied " + name + ".");
				}else
				{
					Utils.getInstance().addChatMessage(name + " is already your enemy.");
				}
			}
			if(args[0].equalsIgnoreCase("del"))
			{
				String name = args[1];
				if(Enemy.enemyList.contains(name))
				{
                    Enemy.enemyList.remove(name);
                    Enemy.writeEnemyFile();
					Utils.getInstance().addChatMessage("Removed " + name + " from enemies.");
				}else
				{
					Utils.getInstance().addChatMessage(name + " is not your enemy.");
				}
			}
			if(args[0].equalsIgnoreCase("clear"))
			{
				try
				{
                    Enemy.enemyList.clear();
					Enemy.writeEnemyFile();
					Utils.getInstance().addChatMessage("Cleared friends.");
				}catch(Exception e) {}
			}
		}catch(Exception e)
		{
			Utils.getInstance().addChatMessage("Usage: " + getSyntax());
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
