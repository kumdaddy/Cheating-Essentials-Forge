package com.kodehawa.ce.vanilla.command;

import com.kodehawa.ce.playerrelations.Enemy;
import com.kodehawa.ce.util.Utils;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public class CommandEnemy extends CommandBase {

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "cenemy";
	}
	
	@Override
    public boolean canCommandSenderUseCommand(ICommandSender icommandsender){
		return true;
    }

	@Override
	public String getCommandUsage(ICommandSender icommandsender) {
		// TODO Auto-generated method stub
		return "command.ce.enemy";
	}

	@Override
	public void processCommand(ICommandSender icommandsender, String[] astring) {
		// TODO Auto-generated method stub
		if(astring[0].equalsIgnoreCase("add"))
		{
			String name = astring[1];
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
		if(astring[0].equalsIgnoreCase("del"))
		{
			String name = astring[1];
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
		if(astring[0].equalsIgnoreCase("clear"))
		{
			try
			{
                Enemy.enemyList.clear();
				Enemy.writeEnemyFile();
				Utils.getInstance().addChatMessage("Cleared friends.");
			}catch(Exception e) {}
		}
	}

}
